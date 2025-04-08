package ifba.saj.demo.petshop.service;

import ifba.saj.demo.petshop.domain.dto.DonoDTO;
import java.util.List;

public interface DonoService {

  void save(DonoDTO dono);

  DonoDTO getByCpf(String cpf);

  DonoDTO getById(Long donoId);

  List<DonoDTO> getAll();
}
