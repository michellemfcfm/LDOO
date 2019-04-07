/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practica5y6;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
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

    @RequestMapping(value = "/logoutUsuario", method = RequestMethod.POST)
    public String logoutUsuario(HttpServletRequest request, HttpServletResponse response) {
        if (Verificador.isLogin(request)) {
            Cookie[] cookies = request.getCookies();
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("correo")) {
                    cookie.setMaxAge(0);
                    response.addCookie(cookie);
                } /*else if (cookie.getName().equals("JSESSIONID")) {
                    cookie.setMaxAge(0);
                    response.addCookie(cookie);
                }*/
            }
            return "redirect:index.htm";
        }
        return "redirect:usuario.htm";
    }

}
