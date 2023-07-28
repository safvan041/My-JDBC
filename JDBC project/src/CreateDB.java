import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateDB {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/?useSSL=false&serverTimezone=UTC";
        String username = "root"; // Replace with your MySQL username
        String password = ""; // Replace with your MySQL password

        try {
            // Register the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Create a connection to the database
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);

            if (connection != null) {
                System.out.println("Connected to the database!");

                // Create a SQL statement
                Statement statement = connection.createStatement();

                // Define the SQL query to create a database
                String query = "CREATE DATABASE mydb"; // Replace "your_database_name" with your desired database name

                // Execute the query
                statement.executeUpdate(query);

                System.out.println("Database created successfully!");

                // Close the statement and connection
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
