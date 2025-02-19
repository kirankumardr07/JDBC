package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateNewTable {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url="jdbc:mysql://localhost:3306/hectronic_india";
        String username="root";
        String password="Root@123$";

        String query= "create table astrology(" +
                "id int primary key," +
                "name varchar(50)," +
                "problem varchar(255)," +
                "consulting_time varchar(255)," +
                "astrologer_name varchar(100)" +
                ");";

        String insertQuery="insert into astrology" +
                "(id, name,problem,consulting_time, astrologer_name)" +
                " values (1,'KiranKumarDR','no problem','at 11 o clock', 'naveen')";


        try(Connection conn= DriverManager.getConnection(url,username,password);
            Statement stmt=conn.createStatement()){

            Boolean e=stmt.execute(insertQuery);
            System.out.println("Data Inserted Successfully");
            System.out.println(e);

        } catch (Exception e) {
           e.printStackTrace();
        }
    }
}





