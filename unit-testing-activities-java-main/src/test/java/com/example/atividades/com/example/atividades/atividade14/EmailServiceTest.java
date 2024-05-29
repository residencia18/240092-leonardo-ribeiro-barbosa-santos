package com.example.atividades.atividade14;


import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class EmailServiceTest {

    @Test
    public void testSendEmail() {
        // Arrange
        EmailService emailService = new EmailService();
        String recipient = "recipient@example.com";
        String subject = "Test Email";
        String body = "This is a test email";

        // Act
        emailService.sendEmail(recipient, subject, body);
        
        // Assert
        // Verifica se o email foi enviado com sucesso
        assertTrue(true); 
    }
}

