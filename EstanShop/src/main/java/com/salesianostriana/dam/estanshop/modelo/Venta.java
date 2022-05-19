package com.salesianostriana.dam.estanshop.modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data 
@NoArgsConstructor 
@AllArgsConstructor
@Builder
public class Venta {
	
	@Id @GeneratedValue
	private long id;
	
	private double precioFinal;
	
	private LocalDate fechaVenta;
	
	private String cliente;
	
	@Builder.Default
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@OneToMany(mappedBy="venta", fetch = FetchType.EAGER)
	private List<LineaVenta> lista = new ArrayList<>();
	
}
