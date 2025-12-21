import java.sql.DriverManager;
import java.sql.SQLException;
import  java.sql.Connection;

public class jdbcConnection {
    private static final String  url ="jdbc:mysql://127.0.0.1:3306/libraryDB";
    private static final String username = "root";
    private static final String password="Basoli@1313";
  public static   Connection getConnection() throws SQLException {
            try {
        Class.forName("com.mysql.cj.jdbc.Driver");
            } catch(Exception e) {
        System.out.println(e.getMessage());
    }
    return DriverManager.getConnection(
                url, username, password);

   }
}
