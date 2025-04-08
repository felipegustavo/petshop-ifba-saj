package ifba.saj.demo.petshop.domain.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TB_CONSULTA")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConsultaEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "pet_id")
  private PetEntity pet;

  @ManyToOne
  @JoinColumn(name = "veterinario_id")
  private VeterinarioEntity veterinario;

  @Column private LocalDate agendamento;
}
