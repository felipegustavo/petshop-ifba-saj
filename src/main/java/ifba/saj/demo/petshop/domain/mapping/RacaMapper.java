package ifba.saj.demo.petshop.domain.mapping;

import ifba.saj.demo.petshop.domain.dto.RacaDTO;
import ifba.saj.demo.petshop.domain.entity.RacaEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class RacaMapper {

  public abstract RacaEntity toEntity(RacaDTO dto);

  public abstract RacaDTO toDto(RacaEntity entity);
}
