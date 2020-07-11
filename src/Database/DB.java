package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {
    private static final String url = "jdbc:mysql://localhost:3306/dormitory_manage?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC";
    private static final String user = "root";
    private static final String password = "db17875612798";

    private static Connection conn = null;
    
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        return conn;
    }
}