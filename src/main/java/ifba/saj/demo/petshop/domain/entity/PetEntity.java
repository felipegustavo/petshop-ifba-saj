package ifba.saj.demo.petshop.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TB_PET")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PetEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column private String nome;

  @ManyToOne
  @JoinColumn(name = "raca_id")
  private RacaEntity raca;

  @ManyToOne
  @JoinColumn(name = "dono_id")
  private DonoEntity dono;

  public PetEntity(Long id) {
    this.id = id;
  }
}
