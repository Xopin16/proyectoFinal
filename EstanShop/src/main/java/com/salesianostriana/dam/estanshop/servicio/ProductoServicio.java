package com.salesianostriana.dam.estanshop.servicio;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.estanshop.modelo.Producto;
import com.salesianostriana.dam.estanshop.repositorio.ProductoRepository;
import com.salesianostriana.dam.estanshop.servicio.base.ServicioBaseImpl;

@Service
public class ProductoServicio extends 
		ServicioBaseImpl<Producto, Long, ProductoRepository>{
	
}
