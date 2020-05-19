package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Data {
    public static void main(String[] args) {
        
        String url = "jdbc:mysql://localhost:3306/learn?useTimezone=true&serverTimezone=UTC";
        String user = "root";
        String pass = "";
        
        System.out.println("stud_id\tstud_name\t\tstud_course");
        
        try {
            Connection conn = DriverManager.getConnection(url, user, pass);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM students");
            
            while(rs.next()) {
                int id = rs.getInt("stud_id");
                String name = rs.getString("stud_name");
                String course = rs.getString("stud_course");
                
                System.out.println(id + "\t" + name + "\t\t" + course);
            }
            conn.close();
    
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
