/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Mr. Savagery
 */
public class ConnectionFactory {
    
    
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/escola";
    private static final String USER = "root";
    private static final String PASS = "!Osvaldo12@";
    
    public static Connection getConnection() throws ClassNotFoundException, SQLException{
        
        Class.forName(DRIVER);
        return DriverManager.getConnection(URL, USER, PASS);
    }
    
    public static void closeConnection(Connection con ) throws SQLException{
        
        if(con != null){
            con.close();
        }
    }
    
    public static void closeConnection(Connection con, PreparedStatement stat) throws SQLException{
        
        if(stat != null){
            stat.close();
        }
        closeConnection(con);
    }
    
    public static void closeConnection(Connection con, PreparedStatement stat, ResultSet result) throws SQLException{
        
        if(result != null){
            result.close();
        }
        closeConnection(con, stat);
    }
}
