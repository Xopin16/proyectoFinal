package com.salesianostriana.dam.estanshop.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.salesianostriana.dam.estanshop.model.Producto;


@Controller
public class ProductoController {
	
	@GetMapping ("/")
	public String controladorCondicionales (Model model){
		List<Producto> lista = new ArrayList<Producto>();
		
		lista.add(new Producto("1", "Vaped naranja", "Vaped", 10.50, 10, "1-1-2022",  0.0, "Desc"));
		lista.add(new Producto("1", "Vaped naranja", "Vaped", 10.50, 10, "1-1-2022",  0.0, "Desc"));
		lista.add(new Producto("1", "Vaped naranja", "Vaped", 10.50, 10, "1-1-2022",  0.0, "Desc"));
		lista.add(new Producto("1", "Vaped naranja", "Vaped", 10.50, 10, "1-1-2022",  0.0, "Desc"));
		lista.add(new Producto("1", "Vaped naranja", "Vaped", 10.50, 10, "1-1-2022",  0.0, "Desc"));
		lista.add(new Producto("1", "Vaped naranja", "Vaped", 10.50, 10, "1-1-2022",  0.0, "Desc"));
		lista.add(new Producto("1", "Vaped naranja", "Vaped", 10.50, 10, "1-1-2022",  0.0, "Desc"));
		lista.add(new Producto("1", "Vaped naranja", "Vaped", 10.50, 10, "1-1-2022",  0.0, "Desc"));
		lista.add(new Producto("1", "Vaped naranja", "Vaped", 10.50, 10, "1-1-2022",  0.0, "Desc"));
		lista.add(new Producto("1", "Vaped naranja", "Vaped", 10.50, 10, "1-1-2022",  0.0, "Desc"));
		lista.add(new Producto("1", "Vaped naranja", "Vaped", 10.50, 10, "1-1-2022",  0.0, "Desc"));
		lista.add(new Producto("1", "Vaped naranja", "Vaped", 10.50, 10, "1-1-2022",  0.0, "Desc"));

		model.addAttribute("productList", lista  );
		return "indix";
	}
	
	@GetMapping ("/form")
	public String controladorFormulario(Model model) {
		
		Producto prod = new Producto();
		model.addAttribute("empleadoForm", prod);
		return "formulario";
	}
	
	@PostMapping("/nuevo/submit")
	public String procesaFormulario(@ModelAttribute("producto") Producto prod) {

		
		return "redirect:/";
	}
	
	@GetMapping ("/prod")
	public String controladorProductos(Model model) {
		List<Producto> lista = new ArrayList<Producto>();
		
		lista.add(new Producto("1", "Vaped naranja", "Vaped", 10.50, 10, "1-1-2022",  0.0, "Desc"));
		lista.add(new Producto("1", "Vaped naranja", "Vaped", 10.50, 10, "1-1-2022",  0.0, "Desc"));
		lista.add(new Producto("1", "Vaped naranja", "Vaped", 10.50, 10, "1-1-2022",  0.0, "Desc"));
		lista.add(new Producto("1", "Vaped naranja", "Vaped", 10.50, 10, "1-1-2022",  0.0, "Desc"));
		lista.add(new Producto("1", "Vaped naranja", "Vaped", 10.50, 10, "1-1-2022",  0.0, "Desc"));
		lista.add(new Producto("1", "Vaped naranja", "Vaped", 10.50, 10, "1-1-2022",  0.0, "Desc"));
		lista.add(new Producto("1", "Vaped naranja", "Vaped", 10.50, 10, "1-1-2022",  0.0, "Desc"));
		lista.add(new Producto("1", "Vaped naranja", "Vaped", 10.50, 10, "1-1-2022",  0.0, "Desc"));
		lista.add(new Producto("1", "Vaped naranja", "Vaped", 10.50, 10, "1-1-2022",  0.0, "Desc"));
		lista.add(new Producto("1", "Vaped naranja", "Vaped", 10.50, 10, "1-1-2022",  0.0, "Desc"));
		lista.add(new Producto("1", "Vaped naranja", "Vaped", 10.50, 10, "1-1-2022",  0.0, "Desc"));
		lista.add(new Producto("1", "Vaped naranja", "Vaped", 10.50, 10, "1-1-2022",  0.0, "Desc"));

		model.addAttribute("productList", lista  );
		
		return "productos";
	}
	
}
