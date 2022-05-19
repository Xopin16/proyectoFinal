package com.salesianostriana.dam.estanshop.controlador;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
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
	
	@GetMapping("/private")
	public String privateIndex(Model model, @AuthenticationPrincipal UserDetails user) {
		
		model.addAttribute("usuario", user.getUsername());
		
		return "private/index";
	}
}
