package org.sample.demo;

import javax.validation.Valid;

import org.sample.demo.entidades.Cliente;
import org.sample.demo.peticiones.PeticionLogin;
import org.sample.demo.servicios.ClienteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ClienteController {

    @Autowired
    private ClienteServicio clienteServicio;

    @GetMapping(value = "/login")
    public String getLogin(Model modelo) {

        if (!modelo.containsAttribute("peticion"))
            modelo.addAttribute("peticion", new PeticionLogin());

        return "login";
    }

    @PostMapping(value = "/login")
    public String postLogin(@ModelAttribute @Valid PeticionLogin peticion, Model modelo) {

        Cliente autenticado = this.clienteServicio.login(peticion);
        modelo.addAttribute("cliente", autenticado);
        return "redirect:/cliente/perfil";
    }

    @GetMapping(value = "/cliente/perfil")
    public String perfil() {
        return "/cliente/perfil";
    }
}

/*
 * @GetMapping public ModelAndView getTestData() { ModelAndView mv = new
 * ModelAndView(); mv.setViewName("welcome"); mv.getModel().put("data",
 * "Welcome home man");
 * 
 * return mv; }
 */