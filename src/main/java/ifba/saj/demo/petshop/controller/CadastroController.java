package ifba.saj.demo.petshop.controller;

import ifba.saj.demo.petshop.domain.dto.UsuarioDTO;
import ifba.saj.demo.petshop.exception.RecursoDuplicadoException;
import ifba.saj.demo.petshop.exception.ValidationErrorDTO;
import ifba.saj.demo.petshop.service.UsuarioService;
import ifba.saj.demo.petshop.util.ControllerUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
@Slf4j
public class CadastroController {

    private final UsuarioService service;
    private final PasswordEncoder passwordEncoder;

    @GetMapping("/cadastro")
    public ModelAndView cadastroForm() {
        var model = new ModelAndView();
        model.setViewName("cadastro");
        model.addObject("usuario", new UsuarioDTO());
        return model;
    }

    @PostMapping("/cadastro")
    public ModelAndView cadastro(UsuarioDTO usuario, BindingResult bindingResult) {
        var model = new ModelAndView();
        var errors = ControllerUtils.createValidationErrorResponse(bindingResult);

        model.setViewName("cadastro");
        model.addObject("errors", errors);
        model.addObject("usuario", usuario);

        try {
            usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
            service.save(usuario);
            model.setViewName("redirect:/login");
            return model;
        } catch (RecursoDuplicadoException e) {
            errors.getErrors().add(new ValidationErrorDTO.FieldError("email", e.getMessage()));
        }

        return model;
    }

}
