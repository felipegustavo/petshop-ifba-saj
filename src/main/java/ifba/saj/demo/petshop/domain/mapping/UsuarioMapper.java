package ifba.saj.demo.petshop.domain.mapping;

import ifba.saj.demo.petshop.domain.dto.UsuarioDTO;
import ifba.saj.demo.petshop.domain.entity.UsuarioEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UsuarioMapper {

    UsuarioEntity toEntity(UsuarioDTO dto);

}
