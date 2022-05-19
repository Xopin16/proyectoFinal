package com.salesianostriana.dam.estanshop.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.salesianostriana.dam.estanshop.modelo.Venta;

public interface VentaRepository extends JpaRepository<Venta, Long>{
	
	@Query("select v from Venta v where v.cliente = ?1")
	public List<Venta> obtenerVentas(String cliente);
}
