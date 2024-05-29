package com.example.atividades.atividade14;
	
public class EmailService {
    public void sendEmail(String recipient, String subject, String body) {
        System.out.println("Enviando email para: " + recipient);
        System.out.println("Assunto: " + subject);
        System.out.println("Corpo: " + body);
        System.out.println("Email enviado com sucesso!");
    }
}
