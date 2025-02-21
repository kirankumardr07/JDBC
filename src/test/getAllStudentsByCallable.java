package test;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class getAllStudentsByCallable {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/new_database";
        String username = "root";
        String password = "Root@123$";

        String query = "{CALL getAllStudents()}";

        try (Connection conn = DriverManager.getConnection(url, username, password);
             CallableStatement cstmt = conn.prepareCall(query)) {
            ResultSet rs= cstmt.executeQuery();

            while(rs.next()){
                int id=rs.getInt("id");
                int age=rs.getInt("age");
                String name=rs.getString("name");

                System.out.println("ID: "+id+" Age: "+age+" Name: "+ name);
            }

        } catch (Exception e) {
           System.out.println("Querying Error:"+ e.getMessage());
        }
    }
}




