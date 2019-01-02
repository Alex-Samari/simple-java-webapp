<%--
  Created by IntelliJ IDEA.
  User: Sev
  Date: 02-Jan-2019
  Time: 11:59 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Date" %>
<html>
  <head>
    <title>Web App Tutorial Page</title>
  </head>
  <body>
  <h1> Hello World!</h1>
  <p>This is my first webapp JSP page</p>

  <%
    Date myDate = new Date();
    out.print("<h2>" + myDate.toString() + "</h2>");
  %>
  </body>
</html>
