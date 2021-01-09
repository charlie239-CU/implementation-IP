/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author UCHIHA
 */
public class MyJdbc {
    
    static Connection connect=null;
  public static Connection connection(String database,String user,String password) throws ClassNotFoundException
{
      String myDriver = "com.mysql.jdbc.Driver";
      String myUrl = "jdbc:mysql://localhost:3306/"+database;
      
try {
//register the driver
Class.forName(myDriver);
//connecting to database
connect=DriverManager.getConnection(myUrl,user,password);
}
catch (SQLException ex) {
Logger.getLogger(MyJdbc.class.getName()).log(Level.SEVERE, null, ex);
}
return connect;

}
    
    
    public int insertData(Statement stmt,String table,String data) throws SQLException
    {
        int flag=0;
        String []st=data.split(" ");
        String sql="INSERT INTO "+table+"(name,uid,course) VALUES('"+st[0]+"','"+st[1]+"','"+st[2]+"')";
        flag=stmt.executeUpdate(sql);
        System.out.println(flag);
        return flag;
    }
    
    public int updateData(Statement stmt,String table, String column, String newData,String id) throws SQLException
    {
         int flag=0;
         String sql="UPDATE "+table+" SET "+column+"='"+newData+"' WHERE uid='"+id+"'";
         flag=stmt.executeUpdate(sql);
         
         return flag;
    }
    
    public int deleteRow(Statement stmt,String table,String id) throws SQLException
    {
        int flag=0;
        String sql="DELETE FROM "+table+" WHERE id='"+id+"'";
        flag=stmt.executeUpdate(sql);
        return flag;
    }
    
    public void showData(Statement stmt,String table) throws SQLException
    {
        String sql="SELECT * FROM "+table;
         ResultSet rs=stmt.executeQuery(sql);
         while(rs.next())  
        System.out.println(rs.getString(1)+"   "+rs.getString(2)+"   "+rs.getString(3));  
    }
    
}
