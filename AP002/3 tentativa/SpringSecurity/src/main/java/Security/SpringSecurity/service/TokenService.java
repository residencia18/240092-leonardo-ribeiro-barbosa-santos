package Security.SpringSecurity.service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class TokenService {

    private final Map<String, String> tokens = new HashMap<>();

    public String generateToken(String email) {
        String token = UUID.randomUUID().toString();
        tokens.put(token, email);
        return token;
    }
    
    
    
    


    public String getEmailByToken(String token) {
        return tokens.get(token);
    }

    public void invalidateToken(String token) {
        tokens.remove(token);
    }
}
