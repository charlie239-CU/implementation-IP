<%-- 
    Document   : index
    Created on : Nov 20, 2020, 10:07:42 AM
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
        <form action="SessionHandling" method="post">
            <label for="username">username</label>
            <input type="text" name="username" required>
            
            <label for="password">password</label>
            <input type="password" name="password" required>
            <br>
            <input type="submit" name="submit" value="submit">
            <input type="submit" name="submit" value="check">
        </form>
    </body>
</html>
