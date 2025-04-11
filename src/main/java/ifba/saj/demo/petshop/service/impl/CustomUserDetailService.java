package ifba.saj.demo.petshop.service.impl;

import ifba.saj.demo.petshop.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomUserDetailService implements UserDetailsService {

    private final UsuarioRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var usuario = repository
                .findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado."));

        List<SimpleGrantedAuthority> authorities = usuario
                .getPapeis()
                .stream()
                .map(p -> new SimpleGrantedAuthority(p.getPapel()))
                .toList();

        log.info("Papeis: {}", authorities);
        return new User(usuario.getEmail(), usuario.getSenha(), authorities);

        //return new User(usuario.getEmail(), usuario.getSenha(), List.of(new SimpleGrantedAuthority("USER")));
    }
}
