package Security.SpringSecurity.service;

import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class TokenService {
    private static final long TOKEN_VALIDITY_DURATION = 30 * 60 * 1000; // 30 minutos em milissegundos
    private final Map<String, TokenData> tokenMap = new HashMap<>();

    public String createToken(String email) {
        String token = UUID.randomUUID().toString(); // Gerar um token único
        tokenMap.put(token, new TokenData(email, System.currentTimeMillis())); // Armazenar com timestamp
        return token;
    }

    public String getEmailByToken(String token) {
        TokenData tokenData = tokenMap.get(token);
        
        if (tokenData == null) {
            return null; // Token não encontrado
        }

        // Verificar se o token ainda é válido com base no tempo decorrido
        long now = System.currentTimeMillis();
        if (now - tokenData.timestamp > TOKEN_VALIDITY_DURATION) {
            tokenMap.remove(token); // Invalida o token se expirado
            return null; // Token expirado
        }

        return tokenData.email; // Retorna o e-mail associado ao token
    }

    public void invalidateToken(String token) {
        tokenMap.remove(token); // Remover o token quando ele é invalidado
    }

    // Classe interna para armazenar dados do token
    private static class TokenData {
        String email;
        long timestamp; // Tempo de criação do token

        TokenData(String email, long timestamp) {
            this.email = email;
            this.timestamp = timestamp;
        }
    }
}
