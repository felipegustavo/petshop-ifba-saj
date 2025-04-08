package ifba.saj.demo.petshop.domain.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RacaDTO {

  private Long id;

  @NotNull private String nome;
}
