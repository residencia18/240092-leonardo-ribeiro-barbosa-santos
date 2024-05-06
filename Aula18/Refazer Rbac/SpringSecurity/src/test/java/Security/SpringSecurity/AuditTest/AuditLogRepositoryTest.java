package Security.SpringSecurity.AuditTest;





import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;



import Security.SpringSecurity.entity.AuditLog;
import Security.SpringSecurity.repository.AuditLogRepository;
import Security.SpringSecurity.service.AuditService;

@ExtendWith(MockitoExtension.class) // Usa Mockito para estender o teste
public class AuditLogRepositoryTest {

    @Mock
    private AuditLogRepository mockRepository; // Simulação do repositório

    @InjectMocks
    private AuditService auditService; // A classe que queremos testar

    @Test
    public void testLogEvent() {
        // Dados para o evento de auditoria
        String eventName = "LoginAttempt";
        String description = "User login attempt";
        String userId = "user1";
        String resource = "LoginService";
        String origin = "127.0.0.1";

        // Chama o método a ser testado
        auditService.logEvent(eventName, description, userId, resource, origin);

        // Verifica se o repositório foi chamado com um objeto AuditLog
        verify(mockRepository, times(1)).save(any(AuditLog.class));
    }
}



