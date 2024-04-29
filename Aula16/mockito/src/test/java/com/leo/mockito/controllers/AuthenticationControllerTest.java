package com.leo.mockito.controllers;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class AuthenticationControllerTest {

    @Autowired
    private MockMvc mockMvc;
    
    
    private final Faker faker = new Faker();


    @Test
    void testRegisterUser() throws Exception {
        // Gerar dados para o registro
        String uniqueUsername = faker.name().username();
        String password = "Password123";
        String registerRequest = """
            {
                "login": "%s",
                "password": "%s",
                "role": "USER"
            }
        """.formatted(uniqueUsername, password);

        mockMvc.perform(post("/auth/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(registerRequest))
                .andExpect(status().isOk()); // Espera-se sucesso ao registrar
    }

    @Test
    void testLoginUser() throws Exception {
        // Gerar um novo usuário para registro e login
        String uniqueUsername = faker.name().username();
        String password = "Password123";

        // Registrar o novo usuário
        String registerRequest = """
            {
                "login": "%s",
                "password": "%s",
                "role": "USER"
            }
        """.formatted(uniqueUsername, password);

        mockMvc.perform(post("/auth/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(registerRequest))
                .andExpect(status().isOk()); // Verificar se o registro foi bem-sucedido

        // Criar a requisição para login
        String loginRequest = """
            {
                "login": "%s",
                "password": "%s"
            }
        """.formatted(uniqueUsername, password);

        // Testar login com o novo usuário
        var loginResponse = mockMvc.perform(post("/auth/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(loginRequest))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.token").isNotEmpty()) // Esperar que um token seja retornado
                .andReturn();

        var objectMapper = new ObjectMapper();
        var responseString = loginResponse.getResponse().getContentAsString();
        var token = objectMapper.readTree(responseString).get("token").asText();

        assertNotNull(token, "Token não deve ser nulo após login bem-sucedido");
    }



    @Test
    void testLoginWithInvalidCredentials() throws Exception {
        // Dados inválidos para login
        var invalidLoginRequest = """
            {
                "login": "invalid_user",
                "password": "InvalidPassword"
            }
        """;

        // Solicitação para login com credenciais inválidas
        mockMvc.perform(post("/auth/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(invalidLoginRequest))
                .andExpect(status().isUnauthorized()); // Espera-se um status 401
    }


    @Test
    void testRegisterUserWithDuplicateLogin() throws Exception {
        // Primeiro, registrar um usuário
        var registerRequest = """
            {
                "login": "test_user_duplicate",
                "password": "Password123",
                "role": "USER"
            }
        """;

        mockMvc.perform(post("/auth/register")
                .contentType("application/json")
                .content(registerRequest))
                .andExpect(status().isOk());

        // Tentar registrar com o mesmo login
        mockMvc.perform(post("/auth/register")
                .contentType("application/json")
                .content(registerRequest))
                .andExpect(status().isBadRequest()); // Deve ser rejeitado por duplicidade
        		
    }
}
