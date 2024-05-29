package Security.SpringSecurity.service;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import Security.SpringSecurity.entity.User;
import Security.SpringSecurity.repository.UserRepository;
import lombok.RequiredArgsConstructor;

import java.util.Collection;
import java.util.Collections;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Encontra o usuário pelo nome de usuário ou lança uma exceção se não encontrar
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        // Retorna um objeto UserDetails que o Spring Security pode usar para autenticação e autorização
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                user.isAccountNonExpired(), // Configurações de conta
                user.isAccountNonLocked(),
                user.isCredentialsNonExpired(),
                user.isEnabled(),
                getAuthorities(user) // Autoridades do usuário
        );
    }

    private Collection<? extends GrantedAuthority> getAuthorities(User user) {
        // Retorna as autoridades para este usuário (baseado no seu papel, role, etc.)
        return Collections.singletonList(new SimpleGrantedAuthority(user.getRole()));
    }
}

