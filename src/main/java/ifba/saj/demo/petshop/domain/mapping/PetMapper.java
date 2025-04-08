package ifba.saj.demo.petshop.domain.mapping;

import ifba.saj.demo.petshop.domain.dto.PetDTO;
import ifba.saj.demo.petshop.domain.entity.PetEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(
    componentModel = "spring",
    uses = {RacaMapper.class, DonoMapper.class})
public abstract class PetMapper {

  @Mapping(
      target = "raca",
      expression = "java(new ifba.saj.demo.petshop.domain.entity.RacaEntity(dto.getRacaId()))")
  @Mapping(
      target = "dono",
      expression = "java(new ifba.saj.demo.petshop.domain.entity.DonoEntity(dto.getDonoId()))")
  public abstract PetEntity toEntity(PetDTO dto);

  @Mapping(target = "donoId", source = "entity.dono.id")
  @Mapping(target = "racaId", source = "entity.raca.id")
  public abstract PetDTO toDto(PetEntity entity);
}
