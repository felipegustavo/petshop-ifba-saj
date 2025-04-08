package ifba.saj.demo.petshop.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TB_ESPECIALIDADE")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EspecialidadeEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column private String nome;

  public EspecialidadeEntity(Long id) {
    this.id = id;
  }
}
