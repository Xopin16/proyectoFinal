package com.salesianostriana.dam.estanshop.controlador;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.salesianostriana.dam.estanshop.modelo.Producto;
import com.salesianostriana.dam.estanshop.servicio.ProductoServicio;
@Controller
public class ProductoController {

	private static final int productosAleatorios = 12;
	
	@Autowired
	private ProductoServicio productoServicio;

	@GetMapping("/buscar")
	public String buscar(Model model, @RequestParam String nombre) {
		model.addAttribute("productos", productoServicio.buscarPorNombre(nombre));
		return "productos";
	}
	
	@GetMapping("private/index")
	public String index(Model model) {

		model.addAttribute("productos", productoServicio.findAll());

		List<Producto> productos;

		productos = productoServicio.mostrarProductosAleatorios(productosAleatorios);

		model.addAttribute("productos", productos);

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
		return "redirect:/private/prod";
	}
	
	@GetMapping("/editar/{id}")
	public String mostrarFormularioEdicion(@PathVariable("id") long id, Model model) {
		
		Optional<Producto> pEditar= productoServicio.findById(id);
		
		if (pEditar != null) {
			model.addAttribute("producto", pEditar.get());
			return "formulario";
		} else {
			return "redirect:/private/prod";
		}
	}
	
	@PostMapping("/editar/submit")
	public String procesarFormularioEdicion(@ModelAttribute("producto") Producto prod) {
		productoServicio.edit(prod);
		return "redirect:/private/prod";
	}
	
	@GetMapping("/borrar/{id}")
	public String borrar(@PathVariable("id") long id) {
		productoServicio.deleteById(id);
		return "redirect:/private/prod";
	}

	@GetMapping("/conocenos")
	public String controladorConocenos() {

		return "conocenos";
	}

}
