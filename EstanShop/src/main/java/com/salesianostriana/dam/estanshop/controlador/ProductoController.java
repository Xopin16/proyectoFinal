package com.salesianostriana.dam.estanshop.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.salesianostriana.dam.estanshop.modelo.Producto;
import com.salesianostriana.dam.estanshop.servicio.ProductoServicio;

@Controller
public class ProductoController {

	@Autowired
	private ProductoServicio productoServicio;

	@GetMapping ("/")
	public String controladorCondicionales (Model model){
		
		List<Producto> productos =
				List.of(
						Producto.builder()
						.nombre("Vaped 300")
						.tipoProd("Vaped")
						.precio(10.50)
						.cantidadStock(10)
						.build(),
						Producto.builder()
						.nombre("Vaped 300")
						.tipoProd("Vaped")
						.precio(10.50)
						.cantidadStock(10)
						.build(),
						Producto.builder()
						.nombre("Vaped 300")
						.tipoProd("Vaped")
						.precio(10.50)
						.cantidadStock(10)
						.build(),
						Producto.builder()
						.nombre("Vaped 300")
						.tipoProd("Vaped")
						.precio(10.50)
						.cantidadStock(10)
						.build(),
						Producto.builder()
						.nombre("Vaped 300")
						.tipoProd("Vaped")
						.precio(10.50)
						.cantidadStock(10)
						.build()
						);
		
		model.addAttribute("productos", productoServicio.findAll());
				
		return "indix";
	}
	
	@GetMapping("/prod")
	public String controladorProductos(Model model) {

		List<Producto> productos =
				List.of(
						Producto.builder()
						.nombre("Vaped 300")
						.tipoProd("Vaped")
						.precio(10.50)
						.cantidadStock(10)
						.build(),
						Producto.builder()
						.nombre("Vaped 300")
						.tipoProd("Vaped")
						.precio(10.50)
						.cantidadStock(10)
						.build(),
						Producto.builder()
						.nombre("Vaped 300")
						.tipoProd("Vaped")
						.precio(10.50)
						.cantidadStock(10)
						.build(),
						Producto.builder()
						.nombre("Vaped 300")
						.tipoProd("Vaped")
						.precio(10.50)
						.cantidadStock(10)
						.build(),
						Producto.builder()
						.nombre("Vaped 300")
						.tipoProd("Vaped")
						.precio(10.50)
						.cantidadStock(10)
						.build()
						);
		model.addAttribute("productos", productoServicio.findAll());

		return "productos";
	}

	@GetMapping("/form")
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


	@GetMapping("/conocenos")
	public String controladorConocenos() {

		return "conocenos";
	}

}
