package ifba.saj.demo.petshop.domain.mapping;

import ifba.saj.demo.petshop.domain.dto.DonoDTO;
import ifba.saj.demo.petshop.domain.entity.DonoEntity;
import org.mapstruct.Mapper;

@Mapper(
    componentModel = "spring",
    uses = {PetMapper.class})
public abstract class DonoMapper {

  public abstract DonoEntity toEntity(DonoDTO dto);

  public abstract DonoDTO toDto(DonoEntity entity);
}
