<%-- 
    Document   : welcome
    Created on : Nov 19, 2020, 11:29:35 PM
    Author     : vivek
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome User</title>
    </head>
    <body>
        <%
            Cookie ck[]=request.getCookies();
            Cookie cookie=null;
            String username=null;
            String check=null;
            System.out.println(ck.length);
            for (int i = 0; i < ck.length; i++) 
            {
                cookie = ck[i];
                if(cookie.getName().equals("username"))
                {
                check=cookie.getName();
                username=cookie.getValue();
                }
            }
         if(username.equals("false") && check.equals("username"))
            {
                
               response.sendRedirect("index.jsp");
            }
            %>
        <br>
        <h3 align="center">Welcome <%= username %></h3>
    <center><p > This page is processed after successful login of user:<%=username%> & will be logged in till user logout</p>
        <form method="post" action="Auth">
            <input type="submit" value="logout" name="submit">
            
        </form>
        </center>
    </body>
</html>
