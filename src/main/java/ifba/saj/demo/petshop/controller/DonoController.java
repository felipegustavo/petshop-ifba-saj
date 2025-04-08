package ifba.saj.demo.petshop.controller;

import static ifba.saj.demo.petshop.consts.RequestPathConstants.DONO;

import ifba.saj.demo.petshop.domain.dto.DonoDTO;
import ifba.saj.demo.petshop.exception.CPFDuplicadoException;
import ifba.saj.demo.petshop.exception.ValidationErrorDTO;
import ifba.saj.demo.petshop.service.DonoService;
import ifba.saj.demo.petshop.service.PetService;
import ifba.saj.demo.petshop.util.ControllerUtils;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(DONO)
@Slf4j
@RequiredArgsConstructor
public class DonoController {

  private static final String VIEWS_FOLDER = "dono/";

  private final DonoService donoService;
  private final PetService petService;

  @GetMapping
  public ModelAndView listAll(@RequestParam(required = false) String cpf) {
    var model = new ModelAndView();
    model.setViewName(VIEWS_FOLDER + "lista_donos");

    List<DonoDTO> donos = null;
    log.info("CPF: {}", cpf);
    if (cpf == null) {
      donos = donoService.getAll();
    } else {
      donos = List.of(donoService.getByCpf(cpf));
    }

    model.addObject("donos", donos);
    return model;
  }

  @GetMapping("/editar/{id}")
  public ModelAndView editarForm(
      @PathVariable(name = "id") Long id, @RequestParam(required = false) boolean edicao) {
    var model = new ModelAndView();
    model.setViewName(VIEWS_FOLDER + "form_cadastro_dono");
    model.addObject("dono", donoService.getById(id));
    model.addObject("edicao", edicao);
    return model;
  }

  @GetMapping("/ver/{id}")
  public ModelAndView editarForm(@PathVariable(name = "id") Long id) {
    var model = new ModelAndView();
    model.setViewName(VIEWS_FOLDER + "form_cadastro_dono");
    model.addObject("dono", donoService.getById(id));
    model.addObject("pets", petService.getByDono(id));
    model.addObject("visualizacao", true);
    return model;
  }

  @GetMapping("/cadastrar")
  public ModelAndView saveForm(@RequestParam(required = false) boolean cadastro) {
    var model = new ModelAndView();
    model.setViewName(VIEWS_FOLDER + "form_cadastro_dono");
    model.addObject("cadastro", cadastro);
    return model;
  }

  @PostMapping("/cadastrar")
  public ModelAndView save(@Valid DonoDTO dono, BindingResult bindingResult) {
    var model = new ModelAndView();
    var errors = ControllerUtils.createValidationErrorResponse(bindingResult);

    try {
      if (!errors.hasErrors()) {
        donoService.save(dono);

        if (dono.getId() == null) {
          model.setViewName("redirect:" + DONO + "/cadastrar?cadastro=true");
        } else {
          model.setViewName("redirect:" + DONO + "/editar/" + dono.getId() + "?edicao=true");
        }

        return model;
      }
    } catch (CPFDuplicadoException e) {
      errors.getErrors().add(new ValidationErrorDTO.FieldError("cpf", e.getMessage()));
    }

    model.addObject("errors", errors);
    model.addObject("dono", dono);
    model.setViewName(VIEWS_FOLDER + "form_cadastro_dono");

    return model;
  }
}
