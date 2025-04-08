package ifba.saj.demo.petshop.domain.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PetDTO {

  private Long id;

  @NotNull private String nome;

  @NotNull private Long donoId;

  @NotNull private Long racaId;

  private RacaDTO raca;
}
