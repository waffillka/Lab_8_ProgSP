package utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtility {
    private static final String jdbcDriver  = "com.mysql.cj.jdbc.Driver";
    private static final String jdbcURL =  "jdbc:mysql://localhost:3306/lab_7_2?useUnicode=true&serverTimezone=UTC&useSSL=false";
    private static final String jdbcUsername = "root";
    private static final String jdbcPassword = "75100";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(jdbcDriver);
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        }
        catch (SQLException | ClassNotFoundException exception) {
            exception.printStackTrace();
        }
        return connection;
    }
}
