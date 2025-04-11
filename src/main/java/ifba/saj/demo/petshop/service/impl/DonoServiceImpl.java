package ifba.saj.demo.petshop.service.impl;

import ifba.saj.demo.petshop.domain.dto.DonoDTO;
import ifba.saj.demo.petshop.domain.mapping.DonoMapper;
import ifba.saj.demo.petshop.exception.RecursoDuplicadoException;
import ifba.saj.demo.petshop.repository.DonoRepository;
import ifba.saj.demo.petshop.service.DonoService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DonoServiceImpl implements DonoService {

  private final DonoRepository repository;
  private final DonoMapper mapper;

  @Override
  public void save(DonoDTO dono) {
    var optId = repository.findIdByCpf(dono.getCpf());

    if ((dono.getId() != null && !optId.isEmpty() && !optId.get().equals(dono.getId()))
        || (dono.getId() == null && !optId.isEmpty())) {
      throw new RecursoDuplicadoException("CPF duplicado.");
    }

    repository.save(mapper.toEntity(dono));
  }

  @Override
  public DonoDTO getByCpf(String cpf) {
    return mapper.toDto(repository.findByCpf(cpf).orElse(null));
  }

  @Override
  public DonoDTO getById(Long donoId) {
    return mapper.toDto(repository.findById(donoId).orElseThrow());
  }

  @Override
  public List<DonoDTO> getAll() {
    return repository.findAll().stream().map(mapper::toDto).toList();
  }
}
