<%-- 
    Document   : usuario
    Created on : 23/03/2019, 08:04:09 PM
    Author     : michelle
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
  
    <body>
        <h1>Hello <%=session.getAttribute("nombre")%>!</h1>
        <form action="logoutUsuario.htm" method="POST">
            <input type="submit" value="Cerrar Session">
        </form>
    </body>
</html>
