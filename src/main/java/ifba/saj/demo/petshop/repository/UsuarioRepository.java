package ifba.saj.demo.petshop.repository;

import ifba.saj.demo.petshop.domain.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {

    boolean existsUsuarioEntityByEmail(String email);

    Optional<UsuarioEntity> findByEmail(String email);

}
