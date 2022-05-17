package com.salesianostriana.dam.estanshop.servicio;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.estanshop.modelo.LineaVenta;
import com.salesianostriana.dam.estanshop.modelo.Producto;
import com.salesianostriana.dam.estanshop.modelo.Venta;
import com.salesianostriana.dam.estanshop.repositorio.VentaRepository;
import com.salesianostriana.dam.estanshop.servicio.base.ServicioBaseImpl;

@Service
public class VentaServicio extends 
ServicioBaseImpl<Venta, Long, VentaRepository>{
	
	@Autowired
	private CarritoServicio carritoServicio;
	
	@Autowired
	private VentaRepository ventaRepository;
	
//	public double aplicarDescuento2Iguales() {
//		double total=carritoServicio.totalCarrito();
//		double desc = 10.0;
//		Map <Producto,Integer> carrito=carritoServicio.getProductsInCart();
//		
//		if(carrito!=null) {
//        	for (Producto p: carrito.keySet()) {
//        		if(carrito.get(p)>1)
//        		total+=(p.getPrecio()*carrito.get(p))-desc/100;
//        	}
//        	return total;
//		}
//		
//		return 0.0;
//	}
//	
//	public double aplicarDescuentoCompraGrande() {
//		double total=carritoServicio.totalCarrito();
//		double desc = 30.0;
//		Map <Producto,Integer> carrito=carritoServicio.getProductsInCart();
//		
//		if(carrito!=null) {
//        	for (Producto p: carrito.keySet()) {
//        		if(total>200.0)
//            	total+=(p.getPrecio()*carrito.get(p))-desc/100;
//        	}
//        	return total;
//		}
//		
//		return 0.0;
//	}
	
	//Método que calcula el total aplicando las reglas de negocio
	public double calcularTotalConLogicaNegocio() {
		double total= 0.0;
		double desc = 0.0;
		Map <Producto,Integer> carrito=carritoServicio.getProductsInCart();
		/*Voy a aplicar la lógica de negocio que si compra dos productos iguales 
		 se le aplicará un descuento del 10% y si realiza una compra del más de 100 euros se
		 le aplicará un descuento del 30%*/

        	for (Producto p: carrito.keySet()) {
        		if(carrito.get(p)>1) {
        			desc=10.0;
            		return total+=(p.getPrecio()*carrito.get(p))-desc/100;

        		}else if(total>200) {
        			desc=30.0;
        			return total+=(p.getPrecio()*carrito.get(p))-desc/100;
        		}else {
        			return carritoServicio.totalCarrito();
        		}
        	}
        	
        	return total;
		}
	
	public void comprarCantidadStock() {

		Map <Producto,Integer> carrito=carritoServicio.getProductsInCart();
	
    	for (Producto p: carrito.keySet()) {
    		if(p.getCantidadStock()>carrito.get(p)) {
    			carrito.remove(p, 1);
    		}
    	}
	}
	
	public boolean impedirCompra() {
		boolean stockNegativo = false;
		Map<Producto, Integer> carrito = carritoServicio.getProductsInCart();
		for (Producto p : carrito.keySet()) {
			if(p.getCantidadStock()>carrito.get(p)) {
				stockNegativo = true;
			}
		}
		return stockNegativo;
	}
}
