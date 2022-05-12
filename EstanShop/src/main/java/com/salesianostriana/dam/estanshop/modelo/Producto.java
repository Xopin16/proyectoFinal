package com.salesianostriana.dam.estanshop.modelo;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data 
@NoArgsConstructor 
@AllArgsConstructor
@Builder
public class Producto {
	
	@Id @GeneratedValue
	private long id;
	
	private String nombre;
	
	private String tipoProd;
	
	private double precio;
	
	private String rutaImg;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaAgregacion;
	
	private int cantidadStock;
	
	private String descripcion;
	
}
