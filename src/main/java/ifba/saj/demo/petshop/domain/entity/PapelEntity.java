package ifba.saj.demo.petshop.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "TB_PAPEL")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PapelEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true, nullable = false)
    private String papel;

}
