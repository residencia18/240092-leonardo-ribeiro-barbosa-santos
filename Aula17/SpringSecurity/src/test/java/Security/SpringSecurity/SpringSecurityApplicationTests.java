package Security.SpringSecurity;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;

import Security.SpringSecurity.dto.LoginResponse;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
public class SpringSecurityApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void contextLoads() throws Exception {
        Faker faker = new Faker();

        String user = faker.name().username();
        String password = faker.internet().password();
        String email = faker.internet().emailAddress();

        var registerRequest = String.format("""
                {
                    "username":"%s",
                    "password":"%s",
                    "email":"%s"
                }
                """, user, password, email);

        // Register a user
        mockMvc.perform(post("/api/auth/register")
                .contentType("application/json")
                .content(registerRequest))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message", Matchers.is("User registered successfully")));

        var loginRequest = String.format("""
                {
                    "username":"%s",
                    "password":"%s"
                }
                """, user, password);
        // Login with the registered user and get a token
        var responseString = mockMvc.perform(post("/api/auth/login")
                .contentType("application/json")
                .content(loginRequest))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.token", Matchers.notNullValue()))
                .andReturn()
                .getResponse().getContentAsString();

        var loginResponse = new ObjectMapper().readValue(responseString, LoginResponse.class);

        // Use the token to access a protected resource
        mockMvc.perform(get("/api/dashboard")
                .header("Authorization", "Bearer " + loginResponse.token()))
                .andExpect(status().isOk())
                .andExpect(content().string(Matchers.is("Hello " + user)));
    }
}


