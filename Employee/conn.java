package Employee;

import java.sql.*;

public class conn{
    
    public static Connection c;
    public static Statement s;

 
    public conn(){
        try{
            Class.forName("com.mysql.jdbc.Driver");  
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/siddhantpatel?zeroDateTimeBehavior=convertToNull","root","Siddhant01*");
            s = c.createStatement();
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}
 
