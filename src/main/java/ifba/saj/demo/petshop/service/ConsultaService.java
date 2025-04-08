package ifba.saj.demo.petshop.service;

import ifba.saj.demo.petshop.domain.dto.ConsultaDTO;
import java.util.List;

public interface ConsultaService {

  ConsultaDTO getById(Long consultaId);

  List<ConsultaDTO> getByVeterinario(Long veterinarioId);

  List<ConsultaDTO> getByPet(Long petId);

  void save(ConsultaDTO consulta);

  void remove(Long consultaId);
}
