package com.salesianostriana.dam.estanshop.repositorio;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.salesianostriana.dam.estanshop.modelo.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long>{
	
	public List<Producto> findByNombreContainsIgnoreCase(String nombre);
	
	@Query("select p.id from Producto p")
	public List<Long> adquirirIds();
}
