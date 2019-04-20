/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practica8;

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
public class LoginController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(HttpServletRequest request) {
        if (Verificador.isLogin(request)) {
            return "redirect:usuario.htm";
        } else {
            return "login";
        }
    }

    @RequestMapping(value = "/loginUsuario", method = RequestMethod.POST)
    public String loginUsuario(HttpServletRequest request, HttpServletResponse response) {
        if (Verificador.login(request, response)) {
            
            Usuario usuario = BaseDeDatos.seleccionar(request.getParameter("username"));
            HttpSession session = request.getSession(true);
            session.setAttribute("usuario", usuario);

            Cookie cookie = new Cookie("id", usuario.getId());
            response.addCookie(cookie);
            
            return "redirect:usuario.htm";
        } else {
            return "redirect:login.htm";
        }
    }
}
