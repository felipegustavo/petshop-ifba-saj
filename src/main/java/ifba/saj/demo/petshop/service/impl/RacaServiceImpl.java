package ifba.saj.demo.petshop.service.impl;

import ifba.saj.demo.petshop.domain.dto.RacaDTO;
import ifba.saj.demo.petshop.domain.mapping.RacaMapper;
import ifba.saj.demo.petshop.repository.RacaRepository;
import ifba.saj.demo.petshop.service.RacaService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RacaServiceImpl implements RacaService {

  private final RacaRepository repository;
  private final RacaMapper mapper;

  @Override
  public List<RacaDTO> getAll() {
    return repository.findAll().stream().map(mapper::toDto).toList();
  }
}
