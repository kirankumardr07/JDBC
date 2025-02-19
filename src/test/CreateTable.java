package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateTable {
    public static void main(String[] args) throws Exception {
        // Load the JDBC driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Establish the connection
        String url = "jdbc:mysql://localhost:3306/new_database";
        String username = "root";
        String password = "Root@123$";

        // SQL query to create the table
        String createTableSQL = "CREATE TABLE old_table (" +
                "id INT PRIMARY KEY, " +
                "roll_no INT(50), " +
                "name varchar(255), " +
                "place VARCHAR(255))";

        try (Connection conn = DriverManager.getConnection(url, username, password);
             Statement stmt = conn.createStatement()) {

            // Execute the query
            boolean e = stmt.execute(createTableSQL);
            // No need to capture result for DDL statements
            System.out.println("Table Created Successfully!");
            System.out.println(e);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

