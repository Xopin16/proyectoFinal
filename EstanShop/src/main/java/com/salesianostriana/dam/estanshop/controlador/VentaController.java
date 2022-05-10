package com.salesianostriana.dam.estanshop.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VentaController {
	
	@GetMapping ("/cesta")
	public String controladorCarrito() {
		return "carrito";
	}
	
}
