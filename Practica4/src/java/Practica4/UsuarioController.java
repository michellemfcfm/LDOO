/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practica4;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author michelle
 */
@Controller
public class UsuarioController {

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView usuario() {
        ModelAndView mav = new ModelAndView("usuario", "command", new Usuario());
        mav.setViewName("index");
        return mav;
    }

    @RequestMapping(value = "/agregarUsuario", method = RequestMethod.POST)
    public String agregarUsuario(@ModelAttribute("SpringWeb") Usuario usuario, ModelMap model) {
        model.addAttribute("nombre", usuario.getNombre());
        model.addAttribute("contrasena", usuario.getContrasena());
        model.addAttribute("correo", usuario.getCorreo());
        model.addAttribute("fechaDeNacimiento", usuario.getFechaDeNacimiento());
        return "usuario";
    }
    //@RequestMapping(value = "/login", method = RequestMethod.POST)
    //public String login(HttpServletRequest request, HttpServletResponse response) {
    //    return "redirect:index.htm";
    //}
}
