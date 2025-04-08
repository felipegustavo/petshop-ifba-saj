package ifba.saj.demo.petshop.controller;

import static ifba.saj.demo.petshop.consts.RequestPathConstants.HOME;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(HOME)
public class HomeController {

  @GetMapping
  public String index() {
    return "index";
  }
}
