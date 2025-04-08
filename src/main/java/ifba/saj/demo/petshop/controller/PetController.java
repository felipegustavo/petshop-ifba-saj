package ifba.saj.demo.petshop.controller;

import static ifba.saj.demo.petshop.consts.RequestPathConstants.PET;

import ifba.saj.demo.petshop.domain.dto.PetDTO;
import ifba.saj.demo.petshop.service.PetService;
import ifba.saj.demo.petshop.service.RacaService;
import ifba.saj.demo.petshop.util.ControllerUtils;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(PET)
@RequiredArgsConstructor
public class PetController {

  private static final String VIEWS_FOLDER = "pet/";

  private final PetService petService;
  private final RacaService racaService;

  @GetMapping("/cadastrar/{donoId}")
  public ModelAndView saveForm(
      @RequestParam(required = false) boolean cadastro, @PathVariable Long donoId) {
    var model = new ModelAndView();
    model.setViewName(VIEWS_FOLDER + "form_cadastro_pet");
    model.addObject("cadastro", cadastro);
    model.addObject("donoId", donoId);
    model.addObject("racas", racaService.getAll());
    return model;
  }

  @GetMapping("/editar/{id}")
  public ModelAndView editarForm(
      @PathVariable(name = "id") Long id, @RequestParam(required = false) boolean edicao) {
    var model = new ModelAndView();
    model.setViewName(VIEWS_FOLDER + "form_cadastro_pet");
    model.addObject("pet", petService.getById(id));
    model.addObject("racas", racaService.getAll());
    model.addObject("edicao", edicao);
    return model;
  }

  @PostMapping("/cadastrar")
  public ModelAndView save(@Valid PetDTO pet, BindingResult bindingResult) {
    var model = new ModelAndView();
    var errors = ControllerUtils.createValidationErrorResponse(bindingResult);

    if (!errors.hasErrors()) {
      petService.save(pet);

      if (pet.getId() == null) {
        model.setViewName("redirect:" + PET + "/cadastrar/" + pet.getDonoId() + "?cadastro=true");
      } else {
        model.setViewName("redirect:" + PET + "/editar/" + pet.getId() + "?edicao=true");
      }

      return model;
    }

    model.addObject("errors", errors);
    model.addObject("pet", pet);
    model.addObject("racas", racaService.getAll());
    model.setViewName(VIEWS_FOLDER + "form_cadastro_pet");

    return model;
  }
}
