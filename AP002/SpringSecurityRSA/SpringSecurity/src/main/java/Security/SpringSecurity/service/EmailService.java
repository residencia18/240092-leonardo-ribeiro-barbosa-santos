package Security.SpringSecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

	@Autowired
    private JavaMailSender javaMailSender;

    public void sendPasswordResetEmail(String email, String resetLink) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("Redefinição de Senha");
        message.setText("Clique no link abaixo para redefinir sua senha:\n" + resetLink);

        javaMailSender.send(message);
    }

	


}
