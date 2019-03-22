<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Practica 4</title>
    </head>

    <body style="background-color: purple;text-align: center">
        <h1>Crear Usuario</h1>
        <form action="/Practica4/agregarUsuario.htm" method="POST">  
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
