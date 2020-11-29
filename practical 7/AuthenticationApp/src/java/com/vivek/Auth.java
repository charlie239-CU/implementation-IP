/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vivek;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Charlie
 */
public class Auth extends HttpServlet {
PrintWriter out=null;
Connection conn=null;
RequestDispatcher rd=null;
Cookie ck;
Cookie ckArray[]=null;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
@Override
//@WebServlet("/welcome");
   public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException
   {
       try{
           out=response.getWriter();
           Class.forName("com.mysql.jdbc.Driver");
           conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet","root","");
           String type=request.getParameter("submit");      //getting submit button value
           if(type.equals("login"))             //when submit button clicked in index.html 
           {
            String username=request.getParameter("username");       //getting username from form data
            String password=request.getParameter("password");       //getting password from form data
            String query="select username,password from userData";
            Statement stmt=conn.createStatement();
            ResultSet rst=stmt.executeQuery(query);
            int i=0;
        
            while(rst.next())   // if true i will be equals to 1
            {
            
           if(rst.getString(1).equals(username)&&rst.getString(2).equals(password))
           {
        	   i=1;
                   
           }
            }
           if(i==1)             // when succesfull login
           {
                ck=new Cookie("username",username);
                   response.addCookie(ck);
                response.sendRedirect("welcome.jsp");
        	  
           }
           else                 // when unsuccesfull login
           {
               out.println("<script>alert('invalid username & password ')</script>");
               request.getRequestDispatcher("./index.jsp").include(request, response); 
           }
           }
           
            if(type.equals("signUp")) 	// if submit button clicked on signUp.html
		{
			String name=request.getParameter("name");
			String username=request.getParameter("username");
			String password=request.getParameter("password");
			String query = " insert into userData (name,username,password)"
			        + " values (?, ?, ?)";

			   
			      PreparedStatement preparedStmt = conn.prepareStatement(query);
			      preparedStmt.setString (1, name);
			      preparedStmt.setString (2, username);
			      preparedStmt.setString (3, password);
			     
			      if(preparedStmt.executeUpdate()==1)           //when data is succesfully inserted in database
                              {
                                 
                                    out.println("<script>alert('succesfully registered "+username+"')</script>");
                                    request.getRequestDispatcher("./signUp.html").include(request, response); 
                                
                              }
                              else                                          //when data is unable to insert in database
                              {
                                  out.println("<script>alert('error while registration "+username+"')</script>");
                                    request.getRequestDispatcher("./signUp.html").include(request, response); 
                              }
                              
                              
			
			
		}
           if(type.equals("logout"))
           {
                ck=new Cookie("username","false");
                ck.setMaxAge(0);
               response.addCookie(ck);
              request.getRequestDispatcher("index.jsp").include(request, response); 
           }
           
       }
       catch(Exception e)
       {
           System.out.println(e.toString());
       }
       
       finally{
           try {
               conn.close();
               out.close();
           } catch (SQLException ex) {
               Logger.getLogger(Auth.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
   
}
}
