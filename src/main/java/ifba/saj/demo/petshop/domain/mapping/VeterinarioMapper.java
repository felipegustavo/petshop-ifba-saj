package ifba.saj.demo.petshop.domain.mapping;

import ifba.saj.demo.petshop.domain.dto.VeterinarioDTO;
import ifba.saj.demo.petshop.domain.entity.EspecialidadeEntity;
import ifba.saj.demo.petshop.domain.entity.VeterinarioEntity;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(
    componentModel = "spring",
    uses = {EspecialidadeMapper.class})
public abstract class VeterinarioMapper {

  @Mapping(target = "especialidades", expression = "java(mapEspecialidadesEntity(dto))")
  public abstract VeterinarioEntity toEntity(VeterinarioDTO dto);

  @Mapping(target = "especialidadeIds", expression = "java(mapEspecialidadesIds(entity))")
  public abstract VeterinarioDTO toDto(VeterinarioEntity entity);

  protected Set<EspecialidadeEntity> mapEspecialidadesEntity(VeterinarioDTO dto) {
    if (dto.getEspecialidadeIds() == null) {
      return new HashSet<>();
    }
    return dto.getEspecialidadeIds().stream()
        .map(EspecialidadeEntity::new)
        .collect(Collectors.toSet());
  }

  protected Set<Long> mapEspecialidadesIds(VeterinarioEntity entity) {
    if (entity.getEspecialidades() == null) {
      return new HashSet<>();
    }
    return entity.getEspecialidades().stream()
        .map(EspecialidadeEntity::getId)
        .collect(Collectors.toSet());
  }
}
