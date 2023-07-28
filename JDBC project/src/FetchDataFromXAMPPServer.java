import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FetchDataFromXAMPPServer {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://127.0.0.1:3306/focusprocom?useSSL=false&serverTimezone=UTC";
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

                // Define the SQL query to fetch data from the table
                String query = "SELECT * FROM first_table"; // Replace "your_table_name" with your actual table name

                // Execute the query
                ResultSet resultSet = statement.executeQuery(query);

                // Process the result set
                while (resultSet.next()) {
                    // Retrieve values from each column
                    int id = resultSet.getInt("2"); // Replace "id" with your actual column name
                    String name = resultSet.getString("Jane Smith"); // Replace "name" with your actual column name
                    // ... Retrieve values for other columns

                    // Do something with the retrieved data
                    System.out.println("ID: " + id + ", Name: " + name);
                }

                // Close the result set, statement, and connection
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
