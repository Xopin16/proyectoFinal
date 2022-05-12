package com.salesianostriana.dam.estanshop.controlador;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.salesianostriana.dam.estanshop.modelo.Producto;
import com.salesianostriana.dam.estanshop.servicio.ProductoServicio;
@Controller
public class ProductoController {

	@Autowired
	private ProductoServicio productoServicio;
	
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
	
	
	@GetMapping ("private/index")
	public String controladorCondicionales (Model model){
				
		return "indix";
	}
	
	@GetMapping("private/prod")
	public String controladorProductos(Model model) {

		model.addAttribute("productos", productoServicio.findAll());

		return "productos";
	}

	@GetMapping("admin/form")
	public String controladorFormulario(Model model) {

		Producto prod = new Producto();
		model.addAttribute("producto", prod);
		return "formulario";
	}

	@PostMapping("/form/submit")
	public String procesaFormulario(@ModelAttribute("producto") Producto prod) {
		productoServicio.save(prod);
		return "redirect:/prod";
	}
	
	@GetMapping("admin/editar/{id}")
	public String mostrarFormularioEdicion(@PathVariable("id") long id, Model model) {
		
		Optional<Producto> pEditar= productoServicio.findById(id);
		
		if (pEditar != null) {
			model.addAttribute("producto", pEditar.get());
			return "formulario";
		} else {
			return "redirect:/prod";
		}
	}
	
	@PostMapping("/editar/submit")
	public String procesarFormularioEdicion(@ModelAttribute("producto") Producto prod) {
		productoServicio.edit(prod);
		return "redirect:/prod";
	}
	
	@GetMapping("/borrar/{id}")
	public String borrar(@PathVariable("id") long id) {
		productoServicio.deleteById(id);
		return "redirect:/prod";
	}
	

	@GetMapping("/conocenos")
	public String controladorConocenos() {

		return "conocenos";
	}

}
