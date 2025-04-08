package ifba.saj.demo.petshop.service.impl;

import ifba.saj.demo.petshop.domain.dto.PetDTO;
import ifba.saj.demo.petshop.domain.mapping.PetMapper;
import ifba.saj.demo.petshop.repository.PetRepository;
import ifba.saj.demo.petshop.service.PetService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PetServiceImpl implements PetService {

  private final PetRepository repository;
  private final PetMapper mapper;

  @Override
  public void save(PetDTO pet) {
    repository.save(mapper.toEntity(pet));
  }

  @Override
  public PetDTO getById(Long petId) {
    return mapper.toDto(repository.findById(petId).orElseThrow());
  }

  @Override
  public List<PetDTO> getByDono(Long donoId) {
    return repository.findByDonoId(donoId).stream().map(mapper::toDto).toList();
  }
}
