package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by One on 17.06.2018.
 */
public class CreatingTable {
    private final static String createTableQuery = "CREATE TABLE `books` (" +
            "  `id` int(11) NOT NULL auto_increment," +
            "  `title` varchar(50) default NULL," +
            "  `comment` varchar(100) default NULL," +
            "  `price` double default NULL," +
            "  `author` varchar(50) default NULL," +
            "  PRIMARY KEY  (`id`)" +
            ") ENGINE=InnoDB DEFAULT CHARSET=utf8;";

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //System.out.println("JDBC driver load success");
            String url = "jdbc:mysql://localhost/bookstire?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            String name = "root";
            String password = "RootPass";
            connection = DriverManager.getConnection(url, name, password);
            statement = connection.createStatement();
            statement.execute(createTableQuery);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
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
