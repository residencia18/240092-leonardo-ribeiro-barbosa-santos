package Security.SpringSecurity.service;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import Security.SpringSecurity.entity.User;
import Security.SpringSecurity.repository.UserRepository;
import Security.SpringSecurity.service.UserDetailsServiceImpl;

import java.util.Optional;

public class UserDetailsServiceImplTest {

	@Test
    public void testLoadUserByUsername_UserFound() {
        // Configuração do mock do UserRepository
        UserRepository userRepository = mock(UserRepository.class);

        // Criação de um usuário fictício
        User fakeUser = new User();
        fakeUser.setUsername("fakeuser");
        fakeUser.setPassword("fakepassword");
        fakeUser.setRole("ROLE_USER");
        fakeUser.setAccountNonExpired(true);
        fakeUser.setAccountNonLocked(true);
        fakeUser.setCredentialsNonExpired(true);
        fakeUser.setEnabled(true);

        // Configura o mock do UserRepository para retornar o usuário fictício quando chamado com o nome "fakeuser"
        when(userRepository.findByUsername("fakeuser")).thenReturn(Optional.of(fakeUser));

        // Cria o UserDetailsServiceImpl com o UserRepository mockado
        UserDetailsServiceImpl userDetailsService = new UserDetailsServiceImpl(userRepository);

        // Testa se o UserDetails é carregado corretamente quando o usuário é encontrado
        UserDetails userDetails = userDetailsService.loadUserByUsername("fakeuser");

        assertNotNull(userDetails);
        assertEquals("fakeuser", userDetails.getUsername());
        assertEquals("fakepassword", userDetails.getPassword());
        assertTrue(userDetails.isEnabled());
        assertTrue(userDetails.isAccountNonExpired());
        assertTrue(userDetails.isAccountNonLocked());
        assertTrue(userDetails.isCredentialsNonExpired());
        assertEquals(1, userDetails.getAuthorities().size());
        assertEquals("ROLE_USER", userDetails.getAuthorities().iterator().next().getAuthority());
    }

    @Test
    public void testLoadUserByUsername_UserNotFound() {
        // Configuração do mock do UserRepository
        UserRepository userRepository = mock(UserRepository.class);

        // Configura o mock do UserRepository para não encontrar o usuário
        when(userRepository.findByUsername("nonexistentuser")).thenReturn(Optional.empty());

        // Cria o UserDetailsServiceImpl com o UserRepository mockado
        UserDetailsServiceImpl userDetailsService = new UserDetailsServiceImpl(userRepository);

        // Testa se uma exceção é lançada quando o usuário não é encontrado
        UsernameNotFoundException exception = assertThrows(UsernameNotFoundException.class, () -> {
            userDetailsService.loadUserByUsername("nonexistentuser");
        });

        assertEquals("User not found", exception.getMessage());
    }
}

