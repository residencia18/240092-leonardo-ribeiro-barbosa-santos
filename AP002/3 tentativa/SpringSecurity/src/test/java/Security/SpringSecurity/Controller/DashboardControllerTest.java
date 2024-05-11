package Security.SpringSecurity.Controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import Security.SpringSecurity.controller.DashboardController;

public class DashboardControllerTest {

    private DashboardController dashboardController;

    @Mock
    private SecurityContext securityContext;



    @BeforeEach
    public void setUp() {
        dashboardController = new DashboardController();
    }

    @Test
    public void testDashboard_AuthenticatedUser() {
      
        String username = "Guest";
        System.out.println("Generated username: " + username);

  
        Authentication authentication	 = new UsernamePasswordAuthenticationToken(username, null);

   
        SecurityContext context = SecurityContextHolder.createEmptyContext();
        context.setAuthentication(authentication);
        SecurityContextHolder.setContext(context);

    
        String result = dashboardController.dashboard();
        System.out.println("Dashboard result: " + result);

   
        assertTrue(result.contains(username), "Expected result to contain username: " + username);
    }

    @Test
    public void testDashboard_UnauthenticatedUser() {
        // Simulando um contexto de segurança sem autenticação
        SecurityContext context = SecurityContextHolder.createEmptyContext();
        SecurityContextHolder.setContext(context);

        // Chamando o método dashboard no controlador
        String result = dashboardController.dashboard();

        // Verificando se a saída é "Hello Guest"
        assertEquals("Hello Guest", result);
    }



}

