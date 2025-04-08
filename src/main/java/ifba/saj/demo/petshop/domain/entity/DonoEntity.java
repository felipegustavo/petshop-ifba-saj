package ifba.saj.demo.petshop.domain.entity;

import jakarta.persistence.*;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TB_DONO")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DonoEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column private String nome;

  @Column private String endereco;

  @Column(unique = true)
  private String cpf;

  @Column private String email;

  @OneToMany(mappedBy = "dono")
  private List<PetEntity> pets;

  public DonoEntity(Long id) {
    this.id = id;
  }
}
