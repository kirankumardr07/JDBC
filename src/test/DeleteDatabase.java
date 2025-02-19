package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DeleteDatabase {
    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/";
            String username="root";
            String password="Root@123$";

            String databaseName="kiran_database";
            String tableName="kiran_table";
            String deleteTable="drop table if exists "+databaseName+"."+tableName;
            String deleteDatabase="drop database if exists "+databaseName;

            try(Connection conn= DriverManager.getConnection(url,username,password);
                Statement stmt=conn.createStatement()){
                int rowsAffectedByTable= stmt.executeUpdate(deleteTable);
                int rowsAffectedByDatabase= stmt.executeUpdate(deleteDatabase);

                if (rowsAffectedByTable >= 0){
                    System.out.println("The table "+ tableName+ " has been deleted");
                }else{
                    System.out.println("No such table "+tableName+ " Found");
                }

                if (rowsAffectedByDatabase >= 0){
                    System.out.println("The Database "+ databaseName+ " has been deleted");
                }else{
                    System.out.println("No such Database "+databaseName+ " Found");
                }


            } catch (Exception e) {
                System.out.println("Error while deleting database or table: "+ e.getMessage());
            }

        } catch (Exception e) {
            System.out.println("Driver not Found or Connection error: "+ e.getMessage());
        }
    }
}



