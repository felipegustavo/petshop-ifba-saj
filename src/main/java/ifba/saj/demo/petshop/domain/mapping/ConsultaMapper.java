package ifba.saj.demo.petshop.domain.mapping;

import ifba.saj.demo.petshop.domain.dto.ConsultaDTO;
import ifba.saj.demo.petshop.domain.entity.ConsultaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(
    componentModel = "spring",
    uses = {VeterinarioMapper.class, PetMapper.class})
public abstract class ConsultaMapper {

    @Mapping(target = "veterinario", expression = "java(new ifba.saj.demo.petshop.domain.entity.VeterinarioEntity(dto.getVeterinarioId()))")
  @Mapping(target = "pet", expression = "java(new ifba.saj.demo.petshop.domain.entity.PetEntity(dto.getPetId()))")
  public abstract ConsultaEntity toEntity(ConsultaDTO dto);

  @Mapping(target = "petId", source = "entity.pet.id")
  @Mapping(target = "veterinarioId", source = "entity.veterinario.id")
  public abstract ConsultaDTO toDto(ConsultaEntity entity);
}
