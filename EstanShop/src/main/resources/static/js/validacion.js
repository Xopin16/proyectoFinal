document.getElementById("nombre").addEventListener("blur",convertirMayusculas);
document.getElementById("precio").addEventListener("blur",comprobarPrecio);
document.getElementById("fechaAgregacion").addEventListener("blur",comprobarFecha);
document.getElementById("descripcion").addEventListener("blur",comprobarDescripcion);

function comprobarFormulario(){
    let resultado = false;
             
        resultado =  convertirMayusculas()&& 
                comprobarPrecio()&&
                comprobarFecha()&&
                comprobarDescripcion();


    formulario.enviar.className = resultado?"btn bg-success w-100 fs-5 text-white":"btn bg-danger w-100 fs-5 text-white";

    return resultado;
}


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


function comprobarFecha(){
    let campoFecha = formulario.fechaAgregacion;

    let resultado = campoFecha.value!="";

    if(resultado){
	let fechaDate= campoFecha.valueAsDate; 
	let hoy = new Date();
	
	resultado = fechaDate.getYear()>=hoy.getYear() && fechaDate.getMonth()>=hoy.getMonth() && fechaDate.getDate() >= hoy.getDate() ||
	fechaDate.getYear()>hoy.getYear() && fechaDate.getMonth()<=hoy.getMonth() && fechaDate.getDate() <= hoy.getDate() ||
	fechaDate.getYear()>=hoy.getYear() && fechaDate.getMonth()>hoy.getMonth() && fechaDate.getDate() <= hoy.getDate();

    }

    modificarApariencia(campoFecha, resultado);

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
