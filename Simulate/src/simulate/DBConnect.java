package simulate;


import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect
{
    //static Connection conn = null;
    
    public static Connection getSQLConnection()
    {
        Connection conn = null;
        String url = "jdbc:mysql://localhost:3306/";
        String dbName = "simulate";
        String driver = "com.mysql.jdbc.Driver";
        String userName = "root";//"db_rpicm";
        String password = "";//"rpicm";
        try
        {
            Class.forName(driver).newInstance();
            conn = DriverManager.getConnection(url+dbName,userName,password);
        }
        catch (Exception e)
        {
            System.out.println("SQL Exception: "+ e.toString());
        }
        return conn;
    }
    
}