/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practica8;

import java.io.IOException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author michelle
 */
@Controller
public class RegistroController {

    @RequestMapping(value = "/registro", method = RequestMethod.GET)
    public String registro(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (Verificador.isLogin(request)) {
            return "redirect:usuario.htm";
        } else {
            return "registro";
        }
    }

    @RequestMapping(value = "/registrarUsuario", method = RequestMethod.POST)
    public String registrarUsuario(HttpServletRequest request, HttpServletResponse response) {
        
        Usuario usuario= new Usuario(request.getParameter("nombre"), request.getParameter("correo"), request.getParameter("contrasena"), request.getParameter("fechaDeNacimiento"));
        
        BaseDeDatos.agregar(usuario);
        usuario= BaseDeDatos.seleccionar(request.getParameter("nombre"));
        
        HttpSession session= request.getSession(true);
        session.setAttribute("usuario", usuario);
        
        Cookie cookie= new Cookie("id",usuario.getId());
        response.addCookie(cookie);
        
        return "redirect:usuario.htm";
    }
}
