package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DeleteData {
    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/hectronic_india";
            String username="root";
            String password="Root@123$";

            int ID=1;
            String DeleteQuery="delete from astrology where id="+ ID;
             try(Connection conn= DriverManager.getConnection(url,username,password);
                 Statement stmt=conn.createStatement()){
                 int rowaffected=stmt.executeUpdate(DeleteQuery);
                 if(rowaffected >0){
                     System.out.println("The Record with ID:"+ID+"has been deleted");
                 }else {
                     System.out.println("No such Data with ID:" + ID + " has been deleted");
                 }
                 stmt.close();
                 conn.close();

             } catch (Exception e) {
                 System.out.println("Error while Delete the Records"+ e.getMessage());
             }

        } catch (Exception e) {
            System.out.println("Error while Loading the Driver Or Connection Error:"+ e.getMessage());
        }
    }
}


