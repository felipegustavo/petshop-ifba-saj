package ifba.saj.demo.petshop.util;

import ifba.saj.demo.petshop.exception.ValidationErrorDTO;
import org.springframework.validation.BindingResult;

public final class ControllerUtils {

  private ControllerUtils() {}

  public static ValidationErrorDTO createValidationErrorResponse(BindingResult bindingResult) {
    var errors = new ValidationErrorDTO();
    if (bindingResult.hasErrors()) {
      bindingResult
          .getFieldErrors()
          .forEach(
              e ->
                  errors
                      .getErrors()
                      .add(new ValidationErrorDTO.FieldError(e.getField(), e.getDefaultMessage())));
    }
    return errors;
  }
}
