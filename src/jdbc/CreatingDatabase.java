package jdbc;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by One on 17.06.2018.
 */
public class CreatingDatabase {
    // Creating database string
    private final static String createDatabaseQyury =
            "CREATE DATABASE bookstire CHARACTER SET utf8 COLLATE utf8_general_ci";

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("JDBC driver load success");
            String url = "jdbc:mysql://localhost/mysql?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            String name = "root";
            String password = "RootPass";
            connection = DriverManager.getConnection(url, name, password);
            statement = connection.createStatement();
            statement.execute(createDatabaseQyury);
        } catch (Exception  e) {
            e.printStackTrace();
        } finally {
            if (statement != null){
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null)
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }

    }
}
