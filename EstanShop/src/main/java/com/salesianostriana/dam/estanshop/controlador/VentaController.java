package com.salesianostriana.dam.estanshop.controlador;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.salesianostriana.dam.estanshop.modelo.Producto;
import com.salesianostriana.dam.estanshop.servicio.CarritoServicio;
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
	    public String guardarVenta(@AuthenticationPrincipal UserDetails user) {
	    	carritoServicio.checkoutCarrito(user.getUsername());
	    	
	    	return "redirect:/private/cesta";
	    }
	    
	    @GetMapping ("admin/historico")
	    public String mostrarHistorico(Model model) {
	    	model.addAttribute("historico", ventaServicio.findAll());
	    	return "historico";
	    }
	    
	    @GetMapping ("private/historico")
	    public String mostrarVentasUsuario(@AuthenticationPrincipal UserDetails user, Model model) {
	    	model.addAttribute("historico", ventaServicio.mostrarVentaUsuario(user.getUsername()));
	    	return "historico";
	    }
}
