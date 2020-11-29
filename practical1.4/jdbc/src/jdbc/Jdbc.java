/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc;

import java.sql.Connection;
import java.sql.*;
import java.util.Scanner;

/**
 *
 * @author UCHIHA
 */
public class Jdbc {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        MyJdbc link=new MyJdbc();
        String uid=null;
        String data=null;
        String column=null;
        Scanner scan=new Scanner(System.in);
        // TODO code application logic here
       
        Connection conn=link.connection("practical","root","");
        
        //insert employee record into database
        Statement stmt = conn.createStatement();
        
        boolean flag=true;
        while(flag)
        {
            System.out.println("1.insert\n2.update\n3.delete\n4.display\n5.exit");
            System.out.println("===================");
        System.out.println("enter choice");
        int choice=scan.nextInt();
        switch(choice)
        {
            case 1: System.out.println("enter name uid course ");
            scan.nextLine();
            data=scan.nextLine();
            System.out.println("data"+data);
            link.insertData(stmt, "detail", data);
            break;
            case 2: System.out.println("enter column name");
                 column=scan.next();
                System.out.println("enter new data");
                 data=scan.next();
                System.out.println("enter uid");
                 uid=scan.next();
                if(link.updateData(stmt, "detail", column, data, uid)==1)
                {
                    System.out.println("data inserted");
                }
                else
                {
                    System.out.println("data insertion failed");
                }
                
                break;
            case 3:
                    System.out.println("enter uid to delete");
                     uid=scan.next();
                    link.deleteRow(stmt, "detail", uid);
                 
                    break;
            case 4:
                    System.out.println("name\tuid\tcourse");
                    link.showData(stmt, "detail");
                    
                    break;
            case 5: 
                    flag=false;
                    break;
                    
            default:   
                    System.out.println("invalid choice");
                    
                   
        }
        }
        
        
    }
    
}
