package com.salesianostriana.dam.estanshop.servicio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import com.salesianostriana.dam.estanshop.modelo.LineaVenta;
import com.salesianostriana.dam.estanshop.modelo.Producto;
import com.salesianostriana.dam.estanshop.modelo.Venta;
import com.salesianostriana.dam.estanshop.repositorio.ProductoRepository;

@Service
@Scope (value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class CarritoServicio {
	
	@Autowired
	private ProductoRepository productoRepository;
	
	@Autowired
	private VentaServicio ventaServicio;
	
	@Autowired
	private LineaVentaServicio lineaVentaServicio;
	
	private Map<Producto, Integer> products = new HashMap <> ();
	
	
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
    
    public void checkoutCarrito(String nombreUsuario) {
    	
    	LineaVenta lv;
    	List<LineaVenta> lista = new ArrayList<LineaVenta>();
    	Venta venta;
    	
    	for (Map.Entry<Producto , Integer> carrito : products.entrySet()) {
    		
    		lv= LineaVenta.builder()
			    		.producto(carrito.getKey())
			    		.cantidad(carrito.getValue())
			    		.build();
    		lista.add(lv);
    		
		}
    	
    	venta = Venta.builder()
    			.precioFinal(ventaServicio.calcularTotalConIva())
    			.fechaVenta(LocalDate.now())
    			.cliente(nombreUsuario)
    			.build();
    	
    	ventaServicio.save(venta);
    	lista.stream()
    	.forEach(linea -> {linea.addToVenta(venta);
    							lineaVentaServicio.save(linea);
    							});
    	productoRepository.flush();
    	products.clear();
    }
  
}
