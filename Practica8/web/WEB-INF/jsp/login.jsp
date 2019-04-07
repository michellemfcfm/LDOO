<%-- 
    Document   : login
    Created on : 23/03/2019, 07:13:26 PM
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
        <h1>Iniciar Sesión</h1>
        <form action="loginUsuario.htm" method="POST">
            <p>Ingresa correo</p>
            <input type="email" name="correo">
            <p>Ingresa contraseña</p>
            <input type="password" name="contrasena"><br>
            <input type="submit" value="enviar">
        </form>
    </body>
</html>
