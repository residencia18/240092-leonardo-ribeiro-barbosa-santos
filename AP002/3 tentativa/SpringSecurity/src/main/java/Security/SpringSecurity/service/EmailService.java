package Security.SpringSecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class EmailService {
    private final JavaMailSender mailSender;
    private final Logger logger = LoggerFactory.getLogger(EmailService.class);

    @Autowired
    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendSimpleEmail(String from, String to, String subject, String text) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(from); // Remetente do e-mail
            message.setTo(to); // Destinatário
            message.setSubject(subject); // Assunto
            message.setText(text); // Conteúdo do e-mail

            mailSender.send(message); // Enviar e-mail
        } catch (Exception e) {
            // Logar o erro
            logger.error("Erro ao enviar e-mail para {}: {}", to, e.getMessage());
            // Dependendo do seu caso de uso, você pode re-throw a exceção ou tratar de outra forma
        }
    }
}
