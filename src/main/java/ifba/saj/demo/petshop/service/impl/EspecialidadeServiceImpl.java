package ifba.saj.demo.petshop.service.impl;

import ifba.saj.demo.petshop.domain.dto.EspecialidadeDTO;
import ifba.saj.demo.petshop.domain.mapping.EspecialidadeMapper;
import ifba.saj.demo.petshop.repository.EspecialidadeRepository;
import ifba.saj.demo.petshop.service.EspecialidadeService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EspecialidadeServiceImpl implements EspecialidadeService {

  private final EspecialidadeRepository repository;
  private final EspecialidadeMapper mapper;

  @Override
  public List<EspecialidadeDTO> getAll() {
    return repository.findAll().stream().map(mapper::toDto).toList();
  }
}
