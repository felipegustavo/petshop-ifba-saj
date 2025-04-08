package ifba.saj.demo.petshop.domain.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VeterinarioDTO {

  private Long id;

  private Set<Long> especialidadeIds = new HashSet<>();

  @NotEmpty private String nome;

  @NotNull
  @Min(value = 1)
  private Long crmv;

  private Set<EspecialidadeDTO> especialidades = new LinkedHashSet<>();

  public String getNomesEspecialidades() {
    return especialidades.stream().map(EspecialidadeDTO::getNome).collect(Collectors.joining(","));
  }
}
