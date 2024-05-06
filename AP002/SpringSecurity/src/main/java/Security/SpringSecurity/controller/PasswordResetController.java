package Security.SpringSecurity.controller;

import java.util.Locale;
import java.util.Optional;
import java.util.UUID;

import javax.security.auth.login.AccountNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.core.env.Environment;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Security.SpringSecurity.dto.GenericResponse;
import Security.SpringSecurity.dto.PasswordDto;
import Security.SpringSecurity.entity.User;
import Security.SpringSecurity.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@RestController
public class PasswordResetController {
	
	
	@Autowired
	private  UserService userService;
	
	@Autowired
    private MailSender mailSender; 
    
    @Autowired
    private MessageSource messages;
    
    @Autowired
    private Environment env; 
	
    @PostMapping("/user/resetPassword")
    public GenericResponse resetPassword(HttpServletRequest request, 
                                        @RequestParam("email") String userEmail) throws AccountNotFoundException {
        User user = userService.findUserByEmail(userEmail); // Retorna null se não encontrado

        if (user == null) { // Verificar se o usuário é nulo
            throw new AccountNotFoundException("User with email " + userEmail + " not found.");
        }
        String token = UUID.randomUUID().toString();
        userService.createPasswordResetTokenForUser(user, token);
        
        // Lógica para enviar e-mail
        mailSender.send(constructResetTokenEmail(getAppUrl(request), 
                                                 request.getLocale(), 
                                                 token, 
                                                 user));
        
        return new GenericResponse("Email de redefinição de senha enviado com sucesso.");
    }
    
    
    private String getAppUrl(HttpServletRequest request) {
        return request.getScheme() + "://" + request.getServerName() + ":" +
               request.getServerPort() + request.getContextPath(); // Construção do URL base
    }
    
    
    public void sendResetPasswordEmail(String contextPath, Locale locale, String token, User user) {
        SimpleMailMessage email = constructResetTokenEmail(contextPath, locale, token, user);
        mailSender.send(email); // Envia o e-mail
    }

    private SimpleMailMessage constructResetTokenEmail(String contextPath, Locale locale, String token, User user) {
        String url = contextPath + "/user/changePassword?token=" + token;
        String message = messages.getMessage("message.resetPassword", null, locale);
        return constructEmail("Reset Password", message + " \r\n" + url, user);
    }

    private SimpleMailMessage constructEmail(String subject, String body, User user) {
        SimpleMailMessage email = new SimpleMailMessage();
        email.setSubject(subject);
        email.setText(body);
        email.setTo(user.getEmail());
        email.setFrom(env.getProperty("support.email")); // Certifique-se de ter esta propriedade
        return email;
    }

    
    
    @GetMapping("/user/changePassword")
    public String showChangePasswordPage(Locale locale, Model model, 
      @RequestParam("token") String token) {
        String result = userService.validatePasswordResetToken(token);
        if(result != null) {
            String message = messages.getMessage("auth.message." + result, null, locale);
            return "redirect:/login.html?lang=" 
                + locale.getLanguage() + "&message=" + message;
        } else {
            model.addAttribute("token", token);
            return "redirect:/updatePassword.html?lang=" + locale.getLanguage();
        }
    }
    
   
}
