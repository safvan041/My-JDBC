import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnectionExample {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/mydb?useSSL=false&serverTimezone=UTC"; 
        String username = "root"; 
        String password = "";

        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");

            
            Connection connection = DriverManager.getConnection( jdbcUrl,username,password);

            if (connection != null) {
                System.out.println("Connected to the database!");
               
                connection.close();
            }
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC driver not found!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Failed to connect to the database!");
            e.printStackTrace();
        }
    }
}
