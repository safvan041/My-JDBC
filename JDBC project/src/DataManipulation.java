import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DataManipulation {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/focusprocom";
        String username = "root"; // Replace with your MySQL username
        String password = ""; // Replace with your MySQL password

        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");

            
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);

            if (connection != null) {
                System.out.println("Connected to the database!");

               
                Statement statement = connection.createStatement();

                
                String insertQuery = "INSERT INTO focusprocom.student_data (email) VALUES ('abc@example.com')";
                int rowsAffected = statement.executeUpdate(insertQuery);
                System.out.println(rowsAffected + " row(s) inserted.");

                
                // String updateQuery = "UPDATE focusprocom.student_data SET age = 35 WHERE name = 'abc'";
                // rowsAffected = statement.executeUpdate(updateQuery);
                // System.out.println(rowsAffected + " row(s) updated.");

                
                // String deleteQuery = "DELETE FROM focusprocom.student_data WHERE name = 'abc'";
                // rowsAffected = statement.executeUpdate(deleteQuery);
                // System.out.println(rowsAffected + " row(s) deleted.");

                
                statement.close();
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
