
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.io.InputStream;
import java.io.IOException;

public class jdbcConnection {

    private static Properties properties = new Properties();


    static {
        try (InputStream input = jdbcConnection.class.getClassLoader().getResourceAsStream("db.properties")) {
            if (input == null) {
                System.out.println(" Unable to find db.properties file");
            } else {
                properties.load(input);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver not found: " + e.getMessage());
        }

        return DriverManager.getConnection(
                properties.getProperty("db.url"),
                properties.getProperty("db.username"),
                properties.getProperty("db.password")
        );
    }


}













//
//import java.sql.DriverManager;
//import java.sql.SQLException;
//import  java.sql.Connection;
//import java.util.Properties;
//
//public class jdbcConnection {
//    static Properties properties = new Properties();
//
//
//
//
//    private static final String  url = "jdbc:mysql://127.0.0.1:3306/libraryDB";
//    private static final String username = "root";
//    private static final String password="Basoli@1313";
//  public static   Connection getConnection() throws SQLException {
//            try {
//        Class.forName("com.mysql.cj.jdbc.Driver");
//            } catch(Exception e) {
//        System.out.println(e.getMessage());
//    }
//    return DriverManager.getConnection(
//                url, username, password);
//
//   }
//}
