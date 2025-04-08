package ifba.saj.demo.petshop.service;

import ifba.saj.demo.petshop.domain.dto.PetDTO;
import java.util.List;

public interface PetService {

  void save(PetDTO pet);

  PetDTO getById(Long petId);

  List<PetDTO> getByDono(Long donoId);
}
