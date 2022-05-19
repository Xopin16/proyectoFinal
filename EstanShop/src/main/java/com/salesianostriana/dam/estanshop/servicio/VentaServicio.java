package com.salesianostriana.dam.estanshop.servicio;

import java.util.List;
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
		
	
	public List<Venta> mostrarVentaUsuario(String nombre){
		return repositorio.obtenerVentas(nombre);
	}
	
	public List<LineaVenta> obtenerLista(Venta venta){
		return venta.getLista();
	}
	
	/*LÓGICAS DE NEGOCIO*/
	
	//Metodo que calcular el precio del carrito.
	public double calcularTotalCarrito() {
    	
    	Map <Producto,Integer> carrito= carritoServicio.getProductsInCart();
    	double total=0.0;
    	if (carrito != null) {
        	for (Producto p: carrito.keySet()) {
        		total+=p.getPrecio()*carrito.get(p);
        	}
        	
        	return total;
    	}
    	
    	return 0.0;
    }
	
	//Método que calcula el total aplicando el descuento por una compra superior a 200 euros.
	public double calcularTotalCarritoCompraGrande() {
		
		double total= calcularTotalCarrito();
		double desc = 25.0;
		Map <Producto,Integer> carrito=carritoServicio.getProductsInCart();

		if(carrito != null) {
			if(total>200)
			return total-(total*desc/100);
		}
		
		return total;
	}
	
	//Método que aplica el iva al precio final y es el que pasaremos en el controller.
	public double calcularTotalConIva() {
		double iva = 21.0;
		return calcularTotalCarritoCompraGrande()+calcularTotalCarritoCompraGrande()*iva/100;
				
	}
	
	
}
