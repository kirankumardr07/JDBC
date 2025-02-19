package test;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateDatabase {
    public static void main(String[] args) {
        String url="jdbc:mysql://localhost:3306/kiran_database";
        String username="root";
        String password="Root@123$";

        String createDatabaseSQL="Create table  kiran_table (id int(50) primary key, name varchar(50) not null,rollno varchar(100) not null); ";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn= DriverManager.getConnection(url,username,password);
            Statement stmt=conn.createStatement();
            stmt.executeUpdate(createDatabaseSQL);
            System.out.println("Table Created Successfully");
            stmt.close();
            conn.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}


