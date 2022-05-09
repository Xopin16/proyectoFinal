package com.salesianostriana.dam.estanshop.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class LineaVenta {
	
	private String id;
	private String idProd;
	private int cantidad;
	private double precioFinal; 
}
