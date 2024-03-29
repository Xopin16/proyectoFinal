package com.salesianostriana.dam.estanshop.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "login.html";
    }

    @GetMapping("/login-error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "login.html";
    }
	
	@GetMapping("/")
	public String welcome() {
		return "login";
	}
	
	@GetMapping("/error")
	public String error() {
		return "error";
	}
	
}
