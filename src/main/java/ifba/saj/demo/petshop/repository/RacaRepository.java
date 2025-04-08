package ifba.saj.demo.petshop.repository;

import ifba.saj.demo.petshop.domain.entity.RacaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RacaRepository extends JpaRepository<RacaEntity, Long> {}
