package ifba.saj.demo.petshop.exception;

import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ValidationErrorDTO {

  public static record FieldError(String field, String message) {}

  private List<FieldError> errors = new ArrayList<>();

  public List<FieldError> getErrorsByField(String field) {
    return errors.stream().filter(e -> e.field.equals(field)).toList();
  }

  public boolean hasErrors() {
    return !errors.isEmpty();
  }
}
