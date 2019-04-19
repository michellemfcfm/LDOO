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

/**
 *
 * @author michelle
 */
public class Verificador {

    public static boolean isLogin(HttpServletRequest request) {

        HttpSession session = request.getSession(true);
        if (!session.isNew()) {
            Cookie[] cookies = request.getCookies();
            Usuario usuario = (Usuario) session.getAttribute("usuario");
            if (usuario != null) {
                for (Cookie cookie : cookies) {
                    if ((cookie.getName().equals("JSESSIONID")) && (cookie.getValue().equals(session.getId()))) {
                        for (Cookie cookie2 : cookies) {
                            if ((cookie2.getName().equals("id")) && (cookie2.getValue().equals(usuario.getId()))) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public static boolean login(HttpServletRequest request, HttpServletResponse response) {
        if (!isLogin(request)) {
            Usuario usuario = BaseDeDatos.seleccionar(request.getParameter("username"));
            if (usuario != null) {
                if (request.getParameter("contrasena").equals(usuario.getContrasena())) {
                    return true;
                }
            }
        }
        return false;
    }
}
