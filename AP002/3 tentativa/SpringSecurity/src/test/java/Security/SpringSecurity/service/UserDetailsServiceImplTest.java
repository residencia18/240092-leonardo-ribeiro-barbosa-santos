package Security.SpringSecurity.service;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import Security.SpringSecurity.entity.User;
import Security.SpringSecurity.repository.UserRepository;

import java.util.Optional;

public class UserDetailsServiceImplTest {

	@Test
    public void testLoadUserByUsername_UserFound() {
        UserRepository userRepository = mock(UserRepository.class);

        User fakeUser = new User();
        fakeUser.setUsername("fakeuser");
        fakeUser.setPassword("fakepassword");
        fakeUser.setRole("ROLE_USER");
        fakeUser.setAccountNonExpired(true);
        fakeUser.setAccountNonLocked(true);
        fakeUser.setCredentialsNonExpired(true);
        fakeUser.setEnabled(true);

        when(userRepository.findByUsername("fakeuser")).thenReturn(Optional.of(fakeUser));

        UserDetailsServiceImpl userDetailsService = new UserDetailsServiceImpl(userRepository);

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
        UserRepository userRepository = mock(UserRepository.class);

        when(userRepository.findByUsername("nonexistentuser")).thenReturn(Optional.empty());

        UserDetailsServiceImpl userDetailsService = new UserDetailsServiceImpl(userRepository);

        UsernameNotFoundException exception = assertThrows(UsernameNotFoundException.class, () -> {
            userDetailsService.loadUserByUsername("nonexistentuser");
        });

        assertEquals("User not found", exception.getMessage());
    }
}

