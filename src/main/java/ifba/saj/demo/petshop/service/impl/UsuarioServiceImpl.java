package ifba.saj.demo.petshop.service.impl;

import ifba.saj.demo.petshop.domain.dto.UsuarioDTO;
import ifba.saj.demo.petshop.domain.mapping.UsuarioMapper;
import ifba.saj.demo.petshop.exception.RecursoDuplicadoException;
import ifba.saj.demo.petshop.repository.PapelRepository;
import ifba.saj.demo.petshop.repository.UsuarioRepository;
import ifba.saj.demo.petshop.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioMapper mapper;
    private final UsuarioRepository repository;
    private final PapelRepository papelRepository;

    @Override
    public void save(UsuarioDTO usuario) {
        var existeEmail = repository.existsUsuarioEntityByEmail(usuario.getEmail());
        if (existeEmail) {
            throw new RecursoDuplicadoException("Email já cadastrado.");
        }

        var entity = mapper.toEntity(usuario);
        entity.setPapeis(new LinkedHashSet<>(papelRepository.findAll()));

        repository.save(entity);
    }
}
