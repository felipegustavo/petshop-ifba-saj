package ifba.saj.demo.petshop.domain.mapping;

import ifba.saj.demo.petshop.domain.dto.EspecialidadeDTO;
import ifba.saj.demo.petshop.domain.entity.EspecialidadeEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class EspecialidadeMapper {

  public abstract EspecialidadeEntity toEntity(EspecialidadeDTO dto);

  public abstract EspecialidadeDTO toDto(EspecialidadeEntity entity);
}
