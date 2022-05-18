package com.salesianostriana.dam.estanshop.controlador;

import java.time.LocalDate;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.salesianostriana.dam.estanshop.modelo.LineaVenta;
import com.salesianostriana.dam.estanshop.modelo.Producto;
import com.salesianostriana.dam.estanshop.modelo.Venta;
import com.salesianostriana.dam.estanshop.servicio.CarritoServicio;
import com.salesianostriana.dam.estanshop.servicio.LineaVentaServicio;
import com.salesianostriana.dam.estanshop.servicio.ProductoServicio;
import com.salesianostriana.dam.estanshop.servicio.VentaServicio;

@Controller
public class VentaController {
	
	@Autowired
	private CarritoServicio carritoServicio;
	
	@Autowired
	private VentaServicio ventaServicio;
	
	@Autowired
	private ProductoServicio productoServicio;
		
	@GetMapping ("private/cesta")
	public String controladorCarrito(Model model) {
    	if (model.addAttribute("productos",carritoServicio.getProductsInCart()) == null)
    		return "redirect:/";
		return "carrito";
	}
	
	 @GetMapping ("/productoACarrito/{id}")
	    public String productoACarrito (@PathVariable("id") long id, Model model) {
				 
		 	Optional<Producto> aCarrito = productoServicio.findById(id);
		 	
		 	if(aCarrito != null) {
		 		carritoServicio.addProducto(aCarrito.get());
		 		return "redirect:/private/cesta";
		 	}else {
		    	return "productos";
		 	}		 	

	    }
	    
	    @GetMapping("/borrarProducto/{id}")
	    public String removeProductFromCart(@PathVariable("id") long id) {
	        	    	
	    	Optional<Producto> borrarProd = productoServicio.findById(id);
	    	
	    	if(borrarProd != null) {
	    		carritoServicio.removeProducto(borrarProd.get());
	    		return "redirect:/private/cesta";
	    	}else {
		        return "carrito";

	    	}
	    }
	    
	    @ModelAttribute ("total_carrito")
	    public Double calcularPrecioFinal() {
	    	return ventaServicio.calcularTotalConIva();
	    	
	    }

	    @GetMapping ("/checkout")
	    public String guardarVenta(Model model) {
	    	carritoServicio.checkoutCarrito();
	    	
	    	return "redirect:/private/cesta";
	    }
	    
	
}
