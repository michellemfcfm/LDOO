<%-- 
    Document   : registro
    Created on : 23/03/2019, 06:36:30 PM
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
        <h1>Crear Usuario</h1>
        <form action="registrarUsuario.htm" method="POST">  
            <p>Ingresa nombre</p>
            <input type="text" name="nombre">
            <p>Ingresa correo</p>
            <input type="email" name="correo">
            <p>Ingresa contraseña</p>
            <input type="password" name="contrasena">
            <p>Ingresa fecha de nacimineto</p>
            <input type="date" name="fechaDeNacimiento"> <br>
            <input type="submit" value="enviar">
        </form>
    </body>

</html>
