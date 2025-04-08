package ifba.saj.demo.petshop.repository;

import ifba.saj.demo.petshop.domain.entity.ConsultaEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultaRepository extends JpaRepository<ConsultaEntity, Long> {

  List<ConsultaEntity> findByVeterinarioId(Long veterinarioId);

  List<ConsultaEntity> findByPetId(Long petId);
}
