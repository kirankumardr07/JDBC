package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class UpdateDataByPrepStmt {
    public static void main(String[] args) throws  Exception {
        Scanner sc=new Scanner(System.in);
         Class.forName("com.mysql.cj.jdbc.Driver");
         String url="jdbc:mysql://localhost:3306/new_database";
         String username="root";
         String password="Root@123$";

         String fetchQuery="delete from new_table where id=? ";

         try(Connection conn= DriverManager.getConnection(url,username,password);
             PreparedStatement pstmt=conn.prepareStatement(fetchQuery)){

             System.out.print("Enter ID:");
             int id=sc.nextInt();

             pstmt.setInt(1,id);

             int rowsAffected= pstmt.executeUpdate();
             System.out.println("Record Deleted Successfully with an ID:"+id);

         } catch (Exception e) {
             System.out.println("Error while Updating the data:"+ e.getMessage());
         }

    }
}
