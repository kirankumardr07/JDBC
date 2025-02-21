package test;

import java.sql.*;

public class GetNameByCallable {
    public static void main(String[] args) throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url="jdbc:mysql://localhost:3306/new_database";
        String username="root";
        String password="Root@123$";

        String query="{CALL getStudentName(?,?)}";

        try(Connection conn= DriverManager.getConnection(url,username,password);
            CallableStatement cstmt=conn.prepareCall(query)){

            cstmt.setInt(1, 1);
            cstmt.registerOutParameter(2, Types.VARCHAR);

            cstmt.execute();


            String studentName=cstmt.getString(2);

            System.out.println("Student Name:"+ studentName);

        } catch (Exception e) {
            System.out.println("Querying Error:"+ e.getMessage());
        }
    }
}



