package com.example.atividades.atividade06;



import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

public class PointTest {

	@Test
	public void testDistanceTo() {
	    Point point1 = new Point(0, 0);
	    Point point2 = new Point(3, 4);
	    
	    // Testando a distância entre dois pontos conhecidos
	    assertEquals(5.0, point1.distanceTo(point2), 0.0001, "Distance between (0,0) and (3,4) should be 5.0");
	    
	    // Testando a distância entre pontos em diferentes quadrantes
	    Point point3 = new Point(-3, 4);
	    assertEquals(5.0, point1.distanceTo(point3), 0.0001, "Distance between (0,0) and (-3,4) should be 5.0");
	    
	    // Testando a distância entre pontos com coordenadas negativas
	    Point point4 = new Point(-3, -4);
	    assertEquals(5.0, point1.distanceTo(point4), 0.0001, "Distance between (0,0) and (-3,-4) should be 5.0");
	    
	    // Testando a distância entre pontos com coordenadas fracionárias
	    Point point5 = new Point(1.5, 2.5);
	    assertEquals(2.9154759474226504, point1.distanceTo(point5), 0.0001, "Distance between (0,0) and (1.5,2.5) should be 2.9154759474226504");
	    
	    // Testando a exceção ao passar null como argumento
	    assertThrows(IllegalArgumentException.class, () -> point1.distanceTo(null), "Should throw IllegalArgumentException for null argument");
	    
	    // Testando a distância entre o mesmo ponto (deve retornar 0)
	    assertEquals(0.0, point1.distanceTo(point1), 0.0001, "Distance between the same point should be 0.0");
	}



}



