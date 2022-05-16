package com.salesianostriana.dam.estanshop.servicio;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.salesianostriana.dam.estanshop.controlador.VentaController;
import com.salesianostriana.dam.estanshop.modelo.Producto;
import com.salesianostriana.dam.estanshop.modelo.Venta;
import com.salesianostriana.dam.estanshop.repositorio.VentaRepository;
import com.salesianostriana.dam.estanshop.servicio.base.ServicioBaseImpl;

public class VentaServicio extends 
ServicioBaseImpl<Venta, Long, VentaRepository>{
	
	@Autowired
	private CarritoServicio carritoServicio;
	
	@Autowired
	private VentaController ventaController;
	
	public double aplicarDescuento2Iguales() {
		double total=ventaController.totalCarrito();
		double desc = 10.0;
		Map <Producto,Integer> carrito=carritoServicio.getProductsInCart();
		
		if(carrito!=null) {
        	for (Producto p: carrito.keySet()) {
        		if(carrito.get(p)>1)
        		total+=(p.getPrecio()*carrito.get(p))-desc/100;
        	}
        	return total;
		}
		
		return 0.0;
	}
	
	public double aplicarDescuentoCompraGrande() {
		double total=ventaController.totalCarrito();
		double desc = 30.0;
		Map <Producto,Integer> carrito=carritoServicio.getProductsInCart();
		
		if(carrito!=null) {
        	for (Producto p: carrito.keySet()) {
        		if(total>200.0)
            	total+=(p.getPrecio()*carrito.get(p))-desc/100;
        	}
        	return total;
		}
		
		return 0.0;
	}
	
	public void comprarCantidadStock() {

		Map <Producto,Integer> carrito=carritoServicio.getProductsInCart();
	
    	for (Producto p: carrito.keySet()) {
    		if(p.getCantidadStock()>carrito.get(p)) {
    			carrito.remove(p, 1);
    		}
    	}
	}
	
}
