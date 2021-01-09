/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Charlie
 */
public class InsertData extends HttpServlet {

    PrintWriter out=null;
Connection conn=null;
RequestDispatcher rd=null;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
            out=response.getWriter();
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet","root","");
            String type=request.getParameter("submit");
            if(type.equals("insert"))
            {
                String uid=request.getParameter("uid");
                String name=request.getParameter("name");
                String classData=request.getParameter("class");
                String age=request.getParameter("age");
                String query="insert into multiData(uid,name,class,age) values(?,?,?,?)";
                PreparedStatement preparedStmt = conn.prepareStatement(query);
                preparedStmt.setString(1,uid);
                preparedStmt.setString(2,name);
                preparedStmt.setString(3,classData);
                preparedStmt.setInt(4,Integer.parseInt(age));
                int i=0;
                try{
                 i=preparedStmt.executeUpdate();
                }
                catch(Exception e)
                {
                    System.out.println(e.toString());
                }
                System.out.println("result"+i);
                if(i==0)
                {
                out.println("<script>alert('data insertion failed')</script>");
                request.getRequestDispatcher("./index.html").include(request, response);
                }
                else
                {
                    out.println("<script>alert('data insertion successful')</script>");
                request.getRequestDispatcher("./index.html").include(request, response);
                }
            }
            else if(type.equals("display"))
            {
            String query="select * from multidata";
            Statement stmt=conn.createStatement();
            ResultSet rst=stmt.executeQuery(query);
            response.setContentType("text/html;charset=UTF-8");
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Welcome</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h4 align='center'>Display Data</h4>");
            out.println("<center>");
            out.println("<table border='1'>");
            out.println("<tr><th>serial no</th><th>uid</th><th>name</th><th>class</th><th>age</th></tr>");
            
            int i=0;
            while(rst.next())
            {
                i++;
                out.println("<tr>");
                out.println("<td>"+i+"</td>");
                out.println("<td>"+rst.getString(1)+"</td>");
                out.println("<td>"+rst.getString(2)+"</td>");
                out.println("<td>"+rst.getString(3)+"</td>");
                out.println("<td>"+rst.getInt(4)+"</td>");
                out.println("</tr>");
                 
           
            }
            out.println("</center>");
            out.println("<br><button type=\"submit\"><a href=\"./index.html\" style=\"text-decoration: none; color: black;\"  >insertData</a></button>");
            System.out.println("count"+i);
            out.println("</body>");
            out.println("</html>");
            }
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

  


}
