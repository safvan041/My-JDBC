import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FetchDataFromMySQLTable {
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

               
                String query = "SELECT * FROM focusprocom.student_data"; 

               
                ResultSet resultSet = statement.executeQuery(query);

                
                while (resultSet.next()) {
                    
                    int id = resultSet.getInt(1); 
                    String name = resultSet.getString(2); 
                    
                    System.out.println("ID: " + id + ", Name: " + name);
                }

                
                resultSet.close();
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