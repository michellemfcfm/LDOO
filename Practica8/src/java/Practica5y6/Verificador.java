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

/**
 *
 * @author michelle
 */
public class Verificador {

    public static boolean isLogin(HttpServletRequest request) {
        HttpSession session = request.getSession(true);

        if (!session.isNew()) {
            Cookie[] cookies = request.getCookies();
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("correo")) {
                    if (cookie.getValue().equals((String)session.getAttribute("correo"))) {
                        for (Cookie cookie2 : cookies) {
                            if (cookie2.getName().equals("JSESSIONID")) {
                                if (cookie2.getValue().equals(session.getId())) {
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public static boolean login(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        if (!isLogin(request)) {
            if (request.getParameter("correo").equals((String)session.getAttribute("correo"))) {
                if (request.getParameter("contrasena").equals((String)session.getAttribute("contrasena"))) {
                    return true;
                }
            }
        }
        return false;
    }
}
