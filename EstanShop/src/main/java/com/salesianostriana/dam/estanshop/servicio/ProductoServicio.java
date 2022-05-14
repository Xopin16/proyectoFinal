package com.salesianostriana.dam.estanshop.servicio;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.estanshop.modelo.Producto;
import com.salesianostriana.dam.estanshop.repositorio.ProductoRepository;
import com.salesianostriana.dam.estanshop.servicio.base.ServicioBaseImpl;

@Service
public class ProductoServicio extends 
		ServicioBaseImpl<Producto, Long, ProductoRepository>{
	
	public List<Producto> buscarPorNombre(String nombre) {
		return repositorio.findByNombreContainsIgnoreCase(nombre);
	}
	
	public List<Producto> mostrarProductosAleatorios(int numero) {
		List<Long> listaIds = repositorio.adquirirIds();
		Collections.shuffle(listaIds);
		
		
		listaIds = listaIds
				.stream()
				.limit(numero)
				.collect(Collectors.toList());
		return repositorio.findAllById(listaIds);

	}
	
}
