package ifba.saj.demo.petshop.service.impl;

import ifba.saj.demo.petshop.domain.dto.VeterinarioDTO;
import ifba.saj.demo.petshop.domain.mapping.VeterinarioMapper;
import ifba.saj.demo.petshop.exception.RecursoDuplicadoException;
import ifba.saj.demo.petshop.repository.VeterinarioRepository;
import ifba.saj.demo.petshop.service.VeterinarioService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VeterinarioServiceImpl implements VeterinarioService {

  private final VeterinarioRepository repository;
  private final VeterinarioMapper mapper;

  @Override
  public void save(VeterinarioDTO veterinario) {

    var optId = repository.findIdByCrmv(veterinario.getCrmv());
    if ((veterinario.getId() != null
            && !optId.isEmpty()
            && !optId.get().equals(veterinario.getId()))
        || (veterinario.getId() == null && !optId.isEmpty())) {
      throw new RecursoDuplicadoException("CRMV duplicado.");
    }

    repository.save(mapper.toEntity(veterinario));
  }

  @Override
  public List<VeterinarioDTO> getAll() {
    return repository.findAll().stream().map(mapper::toDto).toList();
  }

  @Override
  public VeterinarioDTO getById(Long veterinarioId) {
    return mapper.toDto(repository.findById(veterinarioId).orElseThrow());
  }
}
