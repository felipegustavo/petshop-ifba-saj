package ifba.saj.demo.petshop.repository;

import ifba.saj.demo.petshop.domain.entity.VeterinarioEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VeterinarioRepository extends JpaRepository<VeterinarioEntity, Long> {

  @Query("select v.id from VeterinarioEntity v where v.crmv = :crmv")
  Optional<Long> findIdByCrmv(Long crmv);
}
