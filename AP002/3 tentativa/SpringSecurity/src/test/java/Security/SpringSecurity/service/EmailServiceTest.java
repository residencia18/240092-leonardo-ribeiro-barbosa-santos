package Security.SpringSecurity.service;




import com.github.javafaker.Faker;

import Security.SpringSecurity.service.EmailService;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class EmailServiceTest {

    @Mock
    private JavaMailSender mailSender;

    @InjectMocks
    private EmailService emailService;

    private final Faker faker = new Faker();

    @Test
    public void testSendSimpleEmail() {
  
        String from = faker.internet().emailAddress();
        String to = faker.internet().emailAddress();
        String subject = faker.lorem().sentence();
        String text = faker.lorem().paragraph();

        emailService.sendSimpleEmail(from, to, subject, text);

        verify(mailSender, times(1)).send(argThat((SimpleMailMessage message) ->
                message.getFrom().equals(from) &&
                        message.getTo()[0].equals(to) &&
                        message.getSubject().equals(subject) &&
                        message.getText().equals(text)));
    }
    @Test
    public void testSendSimpleEmail_ErrorHandling() {
        String from = faker.internet().emailAddress();
        String to = faker.internet().emailAddress();
        String subject = faker.lorem().sentence();
        String text = faker.lorem().paragraph();

        // Simular uma exceção ao enviar e-mail configurando o mock para lançar uma exceção
        doThrow(new RuntimeException("Erro ao enviar e-mail")).when(mailSender).send(any(SimpleMailMessage.class));

        // Testar se o serviço trata corretamente a exceção ao enviar e-mail
        Assertions.assertDoesNotThrow(() -> emailService.sendSimpleEmail(from, to, subject, text));

        // Verificar se o método send foi chamado uma vez
        verify(mailSender, times(1)).send(any(SimpleMailMessage.class));
    }

    
}
