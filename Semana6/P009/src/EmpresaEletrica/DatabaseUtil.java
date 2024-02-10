package EmpresaEletrica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtil {
    private static final String URL = "jdbc:mysql://bgsnj8m2ogiqs3y7qkh6-mysql.services.clever-cloud.com:3306/bgsnj8m2ogiqs3y7qkh6\" />";
    private static final String USUARIO = "u52fhk0qucaq6pck";
    private static final String SENHA = "sc2EhrZpVHNR4A46Pk8b";
    
    // Método para obter uma conexão com o banco de dados
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, SENHA);
    }
}
