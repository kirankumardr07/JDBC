package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class FetchDataByIdWithStatement {

    public static void main(String[] args) {
        // Load the JDBC driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Database connection details
            String url = "jdbc:mysql://localhost:3306/new_database";
            String username = "root";
            String password = "Root@123$";

            // ID to fetch data
            int id = 1;

            // SQL query to fetch data by ID
            String selectSQL = "SELECT * FROM new_table WHERE id = " + id;

            try (Connection conn = DriverManager.getConnection(url, username, password);
                 Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(selectSQL)) {

                // Process the ResultSet
                System.out.println("Fetching Data for ID = " + id + ":");
                if (rs.next()) {
                    int rollNo = rs.getInt("roll_no");
                    String name = rs.getString("name");
                    String place = rs.getString("place");

                    // Print the fetched data
                    System.out.println("ID: " + id + ", Roll No: " + rollNo +
                            ", Name: " + name + ", Place: " + place);
                } else {
                    System.out.println("No data found for ID = " + id);
                }

            } catch (Exception e) {
                System.err.println("Error while fetching data: " + e.getMessage());
            }
        } catch (Exception e) {
            System.err.println("Driver not found or connection issue: " + e.getMessage());
        }
    }
}

