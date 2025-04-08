package ifba.saj.demo.petshop.service.impl;

import ifba.saj.demo.petshop.domain.dto.ConsultaDTO;
import ifba.saj.demo.petshop.domain.mapping.ConsultaMapper;
import ifba.saj.demo.petshop.repository.ConsultaRepository;
import ifba.saj.demo.petshop.service.ConsultaService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ConsultaServiceImpl implements ConsultaService {

  private final ConsultaRepository repository;
  private final ConsultaMapper mapper;

  @Override
  public ConsultaDTO getById(Long consultaId) {
    return mapper.toDto(repository.findById(consultaId).orElseThrow());
  }

  @Override
  public List<ConsultaDTO> getByVeterinario(Long veterinarioId) {
    return repository.findByVeterinarioId(veterinarioId).stream().map(mapper::toDto).toList();
  }

  @Override
  public List<ConsultaDTO> getByPet(Long petId) {
    return repository.findByPetId(petId).stream().map(mapper::toDto).toList();
  }

  @Override
  public void save(ConsultaDTO consulta) {
    repository.save(mapper.toEntity(consulta));
  }

  @Override
  public void remove(Long consultaId) {
    repository.deleteById(consultaId);
  }
}
