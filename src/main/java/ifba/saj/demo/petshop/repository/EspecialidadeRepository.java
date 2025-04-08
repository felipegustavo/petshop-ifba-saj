package ifba.saj.demo.petshop.repository;

import ifba.saj.demo.petshop.domain.entity.EspecialidadeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EspecialidadeRepository extends JpaRepository<EspecialidadeEntity, Long> {}
