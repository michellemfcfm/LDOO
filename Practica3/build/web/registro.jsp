<%-- 
    Document   : registro
    Created on : 26/02/2019, 02:39:53 PM
    Author     : michelle
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="registro.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%
            String correo= request.getParameter("correo");
            String password= request.getParameter("password");
            String date= request.getParameter("date");
         %>
        <p> correo:<%=correo%></p>
        <p> password: <%=password%></p>
        <p> date: <%=date%></p> 
    </body>
</html>
