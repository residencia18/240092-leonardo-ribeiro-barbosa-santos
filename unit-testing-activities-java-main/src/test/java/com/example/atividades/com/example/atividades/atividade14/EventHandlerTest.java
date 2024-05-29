package com.example.atividades.atividade14;


import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;

public class EventHandlerTest {

    @Test
    public void testHandleEvent() {
        // Arrange
        String event = "Test Event";
        EmailService emailServiceMock = mock(EmailService.class);
        EventHandler eventHandler = new EventHandler(emailServiceMock);

        // Act
        eventHandler.handleEvent(event);

        // Assert
        // Verifica se o método sendEmail do emailServiceMock foi chamado corretamente
        verify(emailServiceMock).sendEmail("test@example.com", "Event Occurred", event);
    }
}
