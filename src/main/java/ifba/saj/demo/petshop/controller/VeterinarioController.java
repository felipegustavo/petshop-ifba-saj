package ifba.saj.demo.petshop.controller;

import static ifba.saj.demo.petshop.consts.RequestPathConstants.VETERINARIO;

import ifba.saj.demo.petshop.domain.dto.VeterinarioDTO;
import ifba.saj.demo.petshop.exception.RecursoDuplicadoException;
import ifba.saj.demo.petshop.exception.ValidationErrorDTO;
import ifba.saj.demo.petshop.service.EspecialidadeService;
import ifba.saj.demo.petshop.service.VeterinarioService;
import ifba.saj.demo.petshop.util.ControllerUtils;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(VETERINARIO)
@Slf4j
@RequiredArgsConstructor
@Secured("ADMIN")
public class VeterinarioController {

  private static final String VIEWS_FOLDER = "veterinario/";

  private final VeterinarioService veterinarioService;
  private final EspecialidadeService especialidadeService;

  @GetMapping
  public ModelAndView listAll() {
    var model = new ModelAndView();
    model.setViewName(VIEWS_FOLDER + "lista_veterinarios");

    model.addObject("veterinarios", veterinarioService.getAll());
    return model;
  }

  @GetMapping("/editar/{id}")
  public ModelAndView editarForm(
      @PathVariable(name = "id") Long id, @RequestParam(required = false) boolean edicao) {
    var model = new ModelAndView();
    model.setViewName(VIEWS_FOLDER + "form_cadastro_veterinario");
    model.addObject("veterinario", veterinarioService.getById(id));
    model.addObject("especialidades", especialidadeService.getAll());
    model.addObject("edicao", edicao);
    return model;
  }

  @GetMapping("/cadastrar")
  public ModelAndView saveForm(@RequestParam(required = false) boolean cadastro) {
    var model = new ModelAndView();
    model.setViewName(VIEWS_FOLDER + "form_cadastro_veterinario");
    model.addObject("cadastro", cadastro);
    model.addObject("especialidades", especialidadeService.getAll());
    return model;
  }

  @PostMapping("/cadastrar")
  public ModelAndView save(@Valid VeterinarioDTO veterinario, BindingResult bindingResult) {
    var model = new ModelAndView();
    var errors = ControllerUtils.createValidationErrorResponse(bindingResult);

    try {
      if (!errors.hasErrors()) {
        veterinarioService.save(veterinario);

        if (veterinario.getId() == null) {
          model.setViewName("redirect:" + VETERINARIO + "/cadastrar?cadastro=true");
        } else {
          model.setViewName(
              "redirect:" + VETERINARIO + "/editar/" + veterinario.getId() + "?edicao=true");
        }

        return model;
      }
    } catch (RecursoDuplicadoException e) {
      errors.getErrors().add(new ValidationErrorDTO.FieldError("crmv", e.getMessage()));
    }

    model.addObject("errors", errors);
    model.addObject("veterinario", veterinario);
    model.addObject("especialidades", especialidadeService.getAll());
    model.setViewName(VIEWS_FOLDER + "form_cadastro_veterinario");

    return model;
  }
}
