package ifba.saj.demo.petshop.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TB_RACA")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RacaEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column private String nome;

  public RacaEntity(Long id) {
    this.id = id;
  }
}
