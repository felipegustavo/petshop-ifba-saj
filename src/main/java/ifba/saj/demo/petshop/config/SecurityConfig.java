package ifba.saj.demo.petshop.config;

import ifba.saj.demo.petshop.domain.entity.PapelEntity;
import ifba.saj.demo.petshop.repository.PapelRepository;
import ifba.saj.demo.petshop.service.impl.CustomUserDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import java.util.List;

import static ifba.saj.demo.petshop.consts.RequestPathConstants.VETERINARIO;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

    private final CustomUserDetailService userDetailsService;
    private final PapelRepository papelRepository;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        List<String> papeis = papelRepository.findAll().stream().map(PapelEntity::getPapel).toList();

        return http.
                authorizeHttpRequests(auth ->
                    auth.requestMatchers("/", "/img/**", "/js/**", "/css/**", VETERINARIO, "/h2-console/**").permitAll()
                            .anyRequest().hasAnyRole(papeis.toArray(new String[0]))
                            //.anyRequest().authenticated()
                            //.anyRequest().hasRole("ADMIN")
                )
                //.formLogin(AbstractAuthenticationFilterConfigurer::permitAll)
                .formLogin(login -> login.loginPage("/login").permitAll())
                .logout(logout -> logout.logoutSuccessUrl("/login?logout").permitAll())
                .userDetailsService(userDetailsService)
                .build();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Bean
    public AuthenticationManager authManager(HttpSecurity http) throws Exception {
        return http
                .getSharedObject(AuthenticationManagerBuilder.class)
                .authenticationProvider(authenticationProvider())
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
