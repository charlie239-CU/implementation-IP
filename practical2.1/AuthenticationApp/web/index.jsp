<%-- 
    Document   : index
    Created on : Nov 19, 2020, 11:43:22 PM
    Author     : vivek
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>
        <%
            Cookie ck[]=request.getCookies();
            Cookie cookie=null;
            String username=null;
            String name=null;
            for (int i = 0; i < ck.length; i++) 
            {
                cookie = ck[i];
                username=cookie.getValue();
                name=cookie.getName();
            }
            System.out.println(username);
            if(!username.equals("false") && name.equals("username"))
            {
                
               response.sendRedirect("welcome.jsp");
            }
            %>
         <h3 align="center">Login</h3>       
<form action="Auth" method="post" id="authentication"></form>
    <table width="650" height="70" border="0" align="center">
        <tr>
            <td>
<label for="username" form="authentication">Username</label>
<input type="text" name="username" placeholder="enter username" form="authentication">
<label for="apssword" form="authentication">Password</label>
<input type="password" name="password" placeholder="enter password" form="authentication">
<button type="submit" name="submit" value="login" form="authentication" >login</button>
            </td>
        </tr>
        <tr>
            <td>
<label for="textDislay" form="authentication">Not Registered</label> <button type="submit"><a href="./signUp.html" style="text-decoration: none; color: black;"  >sign up</a></button>
            </td>
        </tr>
  </table>
    

<br>
    </body>
</html>
