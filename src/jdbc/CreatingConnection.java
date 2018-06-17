package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CreatingConnection {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("JDBC driver load success");
            String url = "jdbc:mysql://localhost/mysql?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            String name = "root";
            String password = "RootPass";
            try {
                Connection con = DriverManager.getConnection(url, name, password);
                System.out.println("Connected.");
                con.close();
                System.out.println("Disconnected.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
