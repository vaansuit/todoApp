package util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
public class ConnectionFactory {

    public static final String DRIVER = "com.mysql.jdbc.Driver"; //ativando driver jdbc
    public static final String URL = "jdb:mysql://localhost:3306/todoapp"; //url de conexão com o banco
    public static final String USER = "root"; //usuario padrao mysql
    public static final String PASS = ""; //senha padrao mysql

    public static Connection getConnection() {
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (Exception e) {
            throw new RuntimeException("Erro de conexão com o banco de dados. ", e);
        }
    }

    public static void closeConnection(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro ao fechar conexão com o banco de dados. ", e);
        }
    }
}
