<%-- 
    Document   : display
    Created on : Nov 20, 2020, 10:20:31 AM
    Author     : vivek
--%>

<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>All sessions</title>
    </head>
    <%  HttpSession s=request.getSession(false); 
    boolean flag=true;
    if(null == session.getAttribute("username"))
    {
      flag=false;  
      
    }
System.out.println("flag:"+flag);    %>
    <script>
        
       
        </script>
    <body>
        <%  
           if(flag)
           {
            String username=s.getAttribute("username").toString();
            int count=Integer.parseInt(s.getAttribute(username).toString());
            count++;
            s.setAttribute(username,count);
            long creationTime=s.getCreationTime();
            int timeInterval=s.getMaxInactiveInterval();
            String sessionId=s.getId().toString();
        %>
        <p> session id: <%= sessionId %></p>
        <p> username:<%=username%></p>
        <p> count:<%=count%></p>
        <p>creation time:<%=new Date(creationTime)%></p>
        <p> time interval:<%= timeInterval/60 %>minutes </p>
        
        <form action="SessionHandling" method="post">
          <input type="submit" name="submit" value="close" >
          <button><a href="index.jsp"  >index.jsp</a></button>
        </form>
       <% } else {  %>
       <h3> no Session Created</h3>
       <a href="index.jsp"  >index.jsp</a>
       <% } %>
       
    </body>
</html>
