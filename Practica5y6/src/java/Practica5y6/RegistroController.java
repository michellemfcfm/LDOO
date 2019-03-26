/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practica5y6;

import java.io.IOException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.portlet.ModelAndView;

/**
 *
 * @author michelle
 */
@Controller
public class RegistroController {

    @RequestMapping(value = "/registro", method = RequestMethod.GET)
    public ModelAndView registro(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (Verificador.isLogin(request)) {
            ModelAndView mav = new ModelAndView();
            response.sendRedirect("usuario.htm");
            return mav;
        } else {
            ModelAndView mav = new ModelAndView("usuario", "command", new Usuario());
            mav.setViewName("registro");
            return mav;
        }
    }

    @RequestMapping(value = "/registrarUsuario", method = RequestMethod.POST)
    public String registrarUsuario(@ModelAttribute("SpringWeb") Usuario usuario, ModelMap model, HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(true);
        session.setAttribute("nombre", usuario.getNombre());
        session.setAttribute("contrasena", usuario.getContrasena());
        session.setAttribute("fechaDeNacimiento", usuario.getFechaDeNacimiento());
        session.setAttribute("correo", usuario.getCorreo());
        
        session.setMaxInactiveInterval(60);

        Cookie cookie = new Cookie("correo", usuario.getCorreo());
        response.addCookie(cookie);

        return "redirect:usuario.htm";
    }
}
