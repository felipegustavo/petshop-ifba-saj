package ifba.saj.demo.petshop.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalControllerAdvice {

  @ExceptionHandler({Exception.class})
  public ModelAndView error() {
    var model = new ModelAndView();
    model.setViewName("error");
    model.addObject("serverError", true);
    return model;
  }

}
