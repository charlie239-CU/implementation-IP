/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vivek;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author vivek
 */
public class SessionHandling extends HttpServlet {
    HttpSession session=null;
    PrintWriter out;
   protected void service(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException
   {
       out=response.getWriter();
       String type=request.getParameter("submit");
       session=request.getSession();
       
       if(type.equals("submit"))
       {
       String username=request.getParameter("username");
       
       session.setAttribute("username",username);
       int count=0;
       if(null!=session.getAttribute(username))
       {
           count=Integer.parseInt(session.getAttribute(username).toString()); 
       }
       session.setAttribute(username,count++);
       request.getRequestDispatcher("display.jsp").include(request, response);
       }
       if(type.equals("check"))
       {
           request.getRequestDispatcher("display.jsp").include(request, response);
       }
       if(type.equals("close"))
       {
          
           session.invalidate();
           response.sendRedirect("index.jsp");
       }
   }
}
