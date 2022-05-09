package com.salesianostriana.dam.estanshop.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.salesianostriana.dam.estanshop.model.Producto;

@Controller
public class ProductoController {
	
	@GetMapping ("/productos")
	public String controladorCondicionales (Model model){
		//Para simplificar el ejemplo, se ha instanciado la lista y se han agregado
		//algunos productos directamente dentro del método pero esto nunca se hace, solo es para el ejemplo
		//Poco a poco veremos que el uso de servicios y repositorios traerán los datos de la base de datos
		//en lugar de crear la lista de productos aquí
		
		List<Producto> lista = new ArrayList<Producto>();
		
		/*lista.add(new Product (1, "Botijo", "Enfría agua hasta menos 10 grados", 20.5055, true, Calendar.getInstance()) );
		lista.add(new Product (1, "BotijoExtra", "Enfría agua hasta menos 200 grados", 200.50, true, Calendar.getInstance()) );*/
		lista.add(new Producto("1", "Vaped naranja", "Vaped", 10.50, true, false, 0.0));
		lista.add(new Producto("2", "Vaped naranja", "Vaped", 10.50, true, false, 5.0));
		lista.add(new Producto("3", "Vaped naranja", "Vaped", 10.50, true, false, 5.0));
		lista.add(new Producto("4", "Vaped naranja", "Vaped", 10.50, true, false, 5.0));
		lista.add(new Producto("5", "Vaped naranja", "Vaped", 10.50, true, false, 0.0));
		lista.add(new Producto("6", "Vaped naranja", "Vaped", 10.50, true, false, 0.0));
		lista.add(new Producto("7", "Vaped naranja", "Vaped", 10.50, true, false, 0.0));
		lista.add(new Producto("8", "Vaped naranja", "Vaped", 10.50, true, false, 0.0));
		lista.add(new Producto("9", "Vaped naranja", "Vaped", 10.50, true, false, 0.0));
		lista.add(new Producto("10", "Vaped naranja", "Vaped", 10.50, true, false, 0.0));
		lista.add(new Producto("11", "Vaped naranja", "Vaped", 10.50, true, false, 0.0));
		lista.add(new Producto("12", "Vaped naranja", "Vaped", 10.50, true, false, 0.0));
		
		//Añadimos la lista al model con el nombre "productList" y será el usado en la plantilla HTML para acceder
		//a los datos que se han agregado al modelo (lista)
		model.addAttribute("productList", lista  );
		return "indix";//Se devuelve la plantilla en HTML
	}
	
}
