package com.salesianostriana.dam.estanshop.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import com.salesianostriana.dam.estanshop.modelo.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long>{

}
