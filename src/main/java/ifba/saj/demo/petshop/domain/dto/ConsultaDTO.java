package ifba.saj.demo.petshop.domain.dto;

import static ifba.saj.demo.petshop.util.DateTimeFormatterUtils.FORMATO_DATA_BRASIL;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConsultaDTO {

  private Long id;

  @NotNull private Long petId;

  @NotNull private Long veterinarioId;

  private PetDTO pet;
  private VeterinarioDTO veterinario;

  @NotNull @Future private LocalDate agendamento;

  public String getAgendamentoFormatado() {
    return agendamento.format(FORMATO_DATA_BRASIL);
  }
}
