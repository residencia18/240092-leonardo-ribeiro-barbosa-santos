package com.example.atividades.atividade15;


import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;

import org.junit.jupiter.api.Test;

import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.rekognition.RekognitionClient;

public class DetectTextImageTest {

    @Test
    public void testDetectTextLabels() {
        // Caminho da imagem de teste
        String imagePath = "caminho/para/sua/imagem.jpg";
        
        // Caminho para salvar os resultados do teste
        String resultFilePath = "caminho/para/resultados.txt";
        
        // Instanciar a classe DetectTextImage com injeção de dependência
        RekognitionClient rekClient = RekognitionClient.builder()
                                    .region(Region.US_WEST_2)
                                    .build();
        DetectTextImage detectTextImage = new DetectTextImage(imagePath, rekClient);

        // Testar a detecção de texto na imagem
        detectTextImage.detectTextLabels(resultFilePath);

        // Verificar se o arquivo de resultados foi criado
        File resultFile = new File(resultFilePath);
        assertTrue(resultFile.exists());
    }
}
