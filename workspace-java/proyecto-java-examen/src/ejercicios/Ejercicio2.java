package ejercicios;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * A. Crear una clase Persona con los siguientes campos
 * (con sus respectivos getters, setters y constructor)
 * 
 * TipoDocumento - enum (dni/libretacivica) 
 * NroDocumento - Integer
 * Nombre - String
 * Apellido - String
 * FechaNacimiento - Date
 * 
 * B. En el método main de la clase "Ejercicio2" crear una nueva instancia
 * de la clase persona y settearle valores reales con tus datos
 * 
 * 
 * C. En el método main de la clase "Ejercicio 2" imprimir los valores en 
 * consola 
 * (crear método main e imprimir valores) 
 *  
 * @author examen
 *
 */
public class Ejercicio2 {

	/**
	 * 
	 */
	public Ejercicio2() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		SimpleDateFormat formato = new SimpleDateFormat("dd-M-yyyy");
		String fechaNacInString = "04-11-1989";
		Date fechaNac = new Date();
		try {
			fechaNac = formato.parse(fechaNacInString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Persona miPersona = new Persona();
		miPersona.setTipoDocumento(TipoDocumento.DNI);
		miPersona.setNroDocumento(34714285);
		miPersona.setNombre("Jose Ignacio");
		miPersona.setApellido("Prieto");
		miPersona.setFechaNacimineto(fechaNac);
		
		String pattern = "dd-MM-yyyy";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		
		System.out.println("Tipo Documento: "+miPersona.getTipoDocumento()+"\n"+"Nro. Documento: "+
				miPersona.getNroDocumento()+"\n"+"Nombre/s y Apellio/s: "+miPersona.getNombre()+" "+miPersona.getApellido()+"\n"+
				"Fecha De Nacimiento: "+simpleDateFormat.format(miPersona.getFechaNacimineto()));

	}

}
