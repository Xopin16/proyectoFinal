package com.salesianostriana.dam.estanshop.controlador;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.salesianostriana.dam.estanshop.modelo.Producto;
import com.salesianostriana.dam.estanshop.servicio.CarritoServicio;
import com.salesianostriana.dam.estanshop.servicio.ProductoServicio;

@Controller
public class VentaController {
	
	@Autowired
	private CarritoServicio carritoServicio;
	
	@Autowired
	private ProductoServicio productoServicio;
	
	@GetMapping ("private/cesta")
	public String controladorCarrito(Model model) {
    	if (model.addAttribute("productos",carritoServicio.getProductsInCart()) == null)
    		return "redirect:/";
		return "carrito";
	}
	
	 @GetMapping ("/productoACarrito/{id}")
	    public String productoACarrito (@PathVariable("id") Long id, Model model) {
	    	
	    	carritoServicio.addProducto(productoServicio.findById(id).orElse(null));
	    	    		 	
	    	return "redirect:/private/cesta";
	    }
	    
	    @GetMapping("/borrarProducto/{id}")
	    public String removeProductFromCart(@PathVariable("id") Long id) {
	        
	    	carritoServicio.removeProducto(productoServicio.findById(id).orElse(null));
	        return "redirect:/private/cesta";
	    }
	    
	    @ModelAttribute("total_carrito")
	    public Double totalCarrito () {
	    	
	    	Map <Producto,Integer> carrito=carritoServicio.getProductsInCart();
	    	double total=0.0;
	    	if (carrito !=null) {
	        	for (Producto p: carrito.keySet()) {
	        		total+=p.getPrecio()*carrito.get(p);
	        	}
	        	return total;
	    	}
	    	
	    	return 0.0;
	    }
	
}
