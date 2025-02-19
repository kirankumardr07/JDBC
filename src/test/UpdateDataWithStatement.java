package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class UpdateDataWithStatement {

    public static void main(String[] args) {
        // Load the JDBC driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Database connection details
            String url = "jdbc:mysql://localhost:3306/new_database";
            String username = "root";
            String password = "Root@123$";

            // SQL query for updating data
            String updateSQL = "UPDATE new_table SET roll_no=121, name = 'Cristiano', place = 'Portugal' WHERE id = 1";

            try (Connection conn = DriverManager.getConnection(url, username, password);
                 Statement stmt = conn.createStatement()) {

                // Execute the update query
                int rowsAffected = stmt.executeUpdate(updateSQL);
                System.out.println("Data Updated Successfully! Rows affected: " + rowsAffected);

            } catch (Exception e) {
                System.err.println("Error while updating data: " + e.getMessage());
            }
        } catch (Exception e) {
            System.err.println("Driver not found or connection issue: " + e.getMessage());
        }
    }
}



