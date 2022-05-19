document.getElementById("nombre").addEventListener("blur",convertirMayusculas);
document.getElementById("precio").addEventListener("blur",comprobarPrecio);
document.getElementById("fechaAgregacion").addEventListener("blur",comprobarFecha);
document.getElementById("stock").addEventListener("blur",comprobarCantidad);
document.getElementById("descripcion").addEventListener("blur",comprobarDescripcion);

function comprobarFormulario(){
    let resultado = false;
             
        resultado =  convertirMayusculas()&& 
                comprobarPrecio()&&
                comprobarFecha()&&
                comprobarDescripcion()&&
                comprobarCantidad();

    formulario.enviar.className = resultado?"btn bg-success w-100 fs-5 text-white":"btn bg-danger w-100 fs-5 text-white";

    return resultado;
}

//function comprobarRutaImg(){
//	let ruta = formulario.imagen;
//	let resultado = ruta.value!=="";
//
//	if(resultado){
//		let partesruta = ruta.value.split('https://');
//		resultado = partesruta.length==2;	
//	}
//	modificarApariencia(ruta,resultado);
//	return resultado;
//}

function convertirMayusculas(){
    let campoNombre = formulario.nombre;

    let resultado = campoNombre.value!=="";
    if(resultado){		
		campoNombre.value = campoNombre.value.toUpperCase();	
	}

    modificarApariencia(campoNombre,resultado);

    return resultado;
}

function comprobarPrecio(){
    let precioCampo = formulario.precio;

    let resultado = precioCampo.value!=="";

    if(resultado){
        resultado = !isNaN(precioCampo.value)&&precioCampo.value>0;
    }

    modificarApariencia(precioCampo, resultado);

    return resultado;
}   

function comprobarCantidad(){
    let cantidad = formulario.stock;

    let resultado = cantidad.value!=="";

    if(resultado){
        resultado = cantidad.value>=0;
    }

    modificarApariencia(cantidad, resultado);

    return resultado;
}

function comprobarFecha(){
    let fecha = formulario.fechaAgregacion;

    let resultado = fecha.value!="";

    if(resultado){
	
        resultado = Date.parse(fecha.value) >= Date.now();
      
    }

    modificarApariencia(fecha, resultado);

    return resultado;
}

function comprobarDescripcion(){
    let desc = formulario.descripcion;
    let resultado = desc.value!=="";

    if(resultado){
       resultado = desc.value.length<140;
    }

    modificarApariencia(desc, resultado);

    return resultado;

}

function modificarApariencia(campo, estado){	
	if(estado){
		campo.classList.remove("border-danger");
		campo.classList.add("border-success");
		campo.parentNode.previousElementSibling.style.visibility = 'hidden';
	}
	else{
		campo.classList.remove("border-success");
		campo.classList.add("border-danger");
		campo.parentNode.previousElementSibling.style.visibility = 'visible';
	}
		
}
