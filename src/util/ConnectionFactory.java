package util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ConnectionFactory {

    public static final String DRIVER = "com.mysql.cj.jdbc.Driver"; //ativando driver jdbc
    public static final String URL = "jdbc:mysql://localhost:3306/todoapp"; //url de conexão com o banco
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
    public static void closeConnection(Connection connection, PreparedStatement statement) {
        try {
            if (connection != null) {
                connection.close();
            }

            if (statement != null) {
                statement.close();
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro ao fechar conexão com o banco de dados. ", e);
        }
    }

    public static void closeConnection(Connection connection, PreparedStatement statement, ResultSet rset) {
        try {
            if (connection != null) {
                connection.close();
            }

            if (statement != null) {
                statement.close();
            }

            if (rset != null) {
                rset.close();
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro ao fechar conexão com o banco de dados. ", e);
        }
    }
}
