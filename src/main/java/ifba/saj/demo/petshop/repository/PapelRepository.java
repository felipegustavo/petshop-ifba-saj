package ifba.saj.demo.petshop.repository;

import ifba.saj.demo.petshop.domain.entity.PapelEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PapelRepository extends JpaRepository<PapelEntity, Long> {

    Optional<PapelEntity> findByPapel(String papel);

}
