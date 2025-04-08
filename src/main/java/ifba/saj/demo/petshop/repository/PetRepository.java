package ifba.saj.demo.petshop.repository;

import ifba.saj.demo.petshop.domain.entity.PetEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepository extends JpaRepository<PetEntity, Long> {

  List<PetEntity> findByDonoId(Long donoId);
}
