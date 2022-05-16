package com.salesianostriana.dam.estanshop.servicio;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import com.salesianostriana.dam.estanshop.modelo.Producto;
import com.salesianostriana.dam.estanshop.repositorio.ProductoRepository;

@Service
@Scope (value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class CarritoServicio {

	private ProductoRepository productoRepository;
	
	private Map<Producto, Integer> products = new HashMap <> ();
	
	@Autowired
	
	public CarritoServicio (ProductoRepository productorepository) {
		this.productoRepository=productorepository;
	}
	
	public void addProducto (Producto p) {
		if (products.containsKey(p)) {
			products.replace(p, products.get(p)+1);
		}else {
			products.put(p, 1);
		}
	}
	
	
	public void removeProducto (Producto p) {
        if (products.containsKey(p)) {
            if (products.get(p) > 1)
                products.replace(p, products.get(p) - 1);
            else if (products.get(p) == 1) {
                products.remove(p);
            }
        }
	}
	

    public Map<Producto, Integer> getProductsInCart() {
        return Collections.unmodifiableMap(products);
    }
	
    
}
