package com.salesianostriana.dam.estanshop.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class Venta {
	
	private String id;
	private LocalDate fechaVenta;
	private String nombreCliente;
	
}
