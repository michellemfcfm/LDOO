<%-- 
    Document   : usuario
    Created on : 23/03/2019, 08:04:09 PM
    Author     : michelle
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Practica8.*"%> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
  
    <body>
        <%
            Usuario usuario= (Usuario)(session.getAttribute("usuario"));
        %>
        <h1>Hello <%=usuario.getNombre()%>!</h1>
        <p>Información { <%=usuario%> }</p>
        <form action="logoutUsuario.htm" method="GET">
            <input type="submit" value="Cerrar Session">
        </form>
    </body>
</html>
