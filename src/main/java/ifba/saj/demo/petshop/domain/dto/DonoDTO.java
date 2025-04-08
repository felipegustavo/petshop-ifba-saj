package ifba.saj.demo.petshop.domain.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DonoDTO {

  private Long id;

  @NotNull private String nome;

  @NotNull private String endereco;

  @CPF private String cpf;

  @NotNull @Email private String email;

  private List<PetDTO> pets;
}
