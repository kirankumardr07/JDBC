package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class UpdateTable {
    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url="jdbc:mysql://localhost:3306/hectronic_india";
            String username="root";
            String password="Root@123$";
            String updateQuery="Update astrology" +
                    " set name='ShreeKrishna', problem='hare krishna'," +
                    "consulting_time='at 12 0 clock',astrologer_name='sam' " +
                    "where id=1;";

               try(Connection conn= DriverManager.getConnection(url,username,password);
                   Statement stmt=conn.createStatement()
                       ){
                  int rowsAffected =stmt.executeUpdate(updateQuery);
                  System.out.println("Data Updated Successfully  and The rows affected is:"+ rowsAffected);
               }catch (Exception e){
                 System.out.println("Error While Updating Data:"+ e.getMessage());
               }

        } catch (Exception e) {
            System.out.println("Driver not found or Connection Error:"+ e.getMessage());
        }
    }
}





