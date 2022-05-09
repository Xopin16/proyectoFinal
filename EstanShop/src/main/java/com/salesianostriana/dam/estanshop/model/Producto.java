package com.salesianostriana.dam.estanshop.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class Producto {
	
	private String id;
	private String nombre;
	private String tipoProd;
	private double precio;
	private int cantidadStock;
	private String fechaAgregacion;
	private double descuento;
	private String descripcion;
	
}
