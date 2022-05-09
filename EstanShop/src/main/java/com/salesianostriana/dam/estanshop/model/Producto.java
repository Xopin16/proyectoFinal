package com.salesianostriana.dam.estanshop.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class Producto {
	
	private String id;
	private String nombre;
	private String tipoProd;
	private double precio;
	private boolean inStock;
	private boolean ofertado;
	private double descuento;
	
}
