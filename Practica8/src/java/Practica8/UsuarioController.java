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
public class UsuarioController {

    @RequestMapping(value = "/usuario", method = RequestMethod.GET)
    public String usuario(HttpServletRequest request) {
        if (Verificador.isLogin(request)) {
            return "usuario";
        } else {
            return "redirect:index.htm";
        }

    }

    @RequestMapping(value = "/logoutUsuario", method = RequestMethod.GET)
    public String logoutUsuario(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(true);
        session.invalidate();

        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("JSESSIONID")) {
                cookie.setMaxAge(0);
            }
            if (cookie.getName().equals("id")) {
                cookie.setMaxAge(0);
            }
        }
        return "redirect:index.htm";
    }
}
