package ifba.saj.demo.petshop.controller;

import static ifba.saj.demo.petshop.consts.RequestPathConstants.CONSULTA;

import ifba.saj.demo.petshop.domain.dto.ConsultaDTO;
import ifba.saj.demo.petshop.service.ConsultaService;
import ifba.saj.demo.petshop.service.VeterinarioService;
import ifba.saj.demo.petshop.util.ControllerUtils;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
@RequestMapping(CONSULTA)
@RequiredArgsConstructor
public class ConsultaController {

  private static final String VIEWS_FOLDER = "consulta/";

  private final ConsultaService consultaService;
  private final VeterinarioService veterinarioService;

  @GetMapping("/cadastrar/{petId}")
  public ModelAndView saveForm(@PathVariable Long petId) {
    var model = new ModelAndView();
    model.setViewName(VIEWS_FOLDER + "form_cadastro_consulta");
    model.addObject("petId", petId);
    model.addObject("veterinarios", veterinarioService.getAll());
    return model;
  }

  @PostMapping("/cadastrar")
  public ModelAndView save(@Valid ConsultaDTO consulta, BindingResult bindingResult) {
    var model = new ModelAndView();
    var errors = ControllerUtils.createValidationErrorResponse(bindingResult);

    if (!errors.hasErrors()) {
      consultaService.save(consulta);
      model.setViewName("redirect:%s/%s".formatted(CONSULTA, consulta.getPetId()));
    } else {
      model.setViewName(VIEWS_FOLDER + "form_cadastro_consulta");
      model.addObject("petId", consulta.getPetId());
      model.addObject("veterinarios", veterinarioService.getAll());
      model.addObject("consulta", consulta);
      model.addObject("errors", errors);
    }

    return model;
  }

  @GetMapping("/{petId}")
  public ModelAndView listAll(@PathVariable Long petId) {
    var model = new ModelAndView();
    model.setViewName(VIEWS_FOLDER + "lista_consultas");
    model.addObject("consultas", consultaService.getByPet(petId));
    return model;
  }

  @GetMapping("/remover/{consultaId}/{petId}")
  public ModelAndView remover(@PathVariable Long consultaId, @PathVariable Long petId) {
    var model = new ModelAndView();
    consultaService.remove(consultaId);
    model.setViewName("redirect:%s/%s".formatted(CONSULTA, petId));
    return model;
  }
}
