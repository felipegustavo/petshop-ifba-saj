package ifba.saj.demo.petshop.service;

import ifba.saj.demo.petshop.domain.dto.VeterinarioDTO;
import java.util.List;

public interface VeterinarioService {

  void save(VeterinarioDTO veterinario);

  List<VeterinarioDTO> getAll();

  VeterinarioDTO getById(Long veterinarioId);
}
