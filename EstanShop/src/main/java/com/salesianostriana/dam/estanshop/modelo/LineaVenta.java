package com.salesianostriana.dam.estanshop.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data 
@NoArgsConstructor 
@AllArgsConstructor
@Builder
public class LineaVenta {
	
	@Id @GeneratedValue
	private long id;
	
	@ManyToOne
	private Producto producto;
	
	private int cantidad;
	
	private double precioFinal; 
	
	private double descuento;
	
	@ManyToOne
	private Venta venta;
	
	public void addToVenta(Venta venta) {
		this.venta = venta;
		venta.getLista().add(this);
	}
	
	public void removeFromVenta(Venta venta) {
		venta.getLista().remove(this);
		this.venta = null;
	}
}
