package ifba.saj.demo.petshop.repository;

import ifba.saj.demo.petshop.domain.entity.DonoEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DonoRepository extends JpaRepository<DonoEntity, Long> {

  Optional<DonoEntity> findByCpf(String cpf);

  @Query("select d.id from DonoEntity d where d.cpf = :cpf")
  Optional<Long> findIdByCpf(String cpf);
}
