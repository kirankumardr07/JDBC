package test;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;


public class UpdateStudentNameByCallable {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/new_database";
        String username = "root";
        String password = "Root@123$";

        String query = "{CALL updateStudent(?,?,?)}";

        try (Connection conn = DriverManager.getConnection(url, username, password);
             CallableStatement cstmt = conn.prepareCall(query)) {

            cstmt.setInt(1,1);
            cstmt.setString(2,"Kiran Kumar DR");
            cstmt.registerOutParameter(3, Types.VARCHAR);
            cstmt.executeQuery();

            String sucess_message=cstmt.getString(3);
            System.out.println(sucess_message);

        } catch (Exception e) {
            System.out.println("Querying Error:"+ e.getMessage());
        }
    }
}




