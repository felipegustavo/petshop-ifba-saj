package ifba.saj.demo.petshop.domain.entity;

import jakarta.persistence.*;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TB_VETERINARIO")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VeterinarioEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column private String nome;

  @Column(unique = true)
  private Long crmv;

  @ManyToMany(fetch = FetchType.EAGER)
  @OrderBy("nome ASC")
  @JoinTable(
      name = "tb_veterinario_especialidade",
      joinColumns = @JoinColumn(name = "veterinario_id"),
      inverseJoinColumns = @JoinColumn(name = "especialidade_id"))
  private Set<EspecialidadeEntity> especialidades;

  public VeterinarioEntity(Long id) {
    this.id = id;
  }
}
