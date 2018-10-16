package ejercicios;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Ejercicio4 {

	// listas de ejemplo, pueden variarse su contenido, 
	static Integer[] valoresLista1 = {1, 2, 5, 8, 10, 30, 20, 8, 9, 10};
	static Integer[] valoresLista2 = {1, 2, 4, 20, 5, 10, 7, 8, 10, 9};

	/**	 
	 * Para ejecutar el método main se debe hacer boton derecho sobre la clase
	 * "Run As --> Java Application" 
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.println("**** inicializando datos ****");
		
		List<Integer> lista1 = new ArrayList<Integer>(Arrays.asList(valoresLista1));
		List<Integer> lista2 = new ArrayList<Integer>(Arrays.asList(valoresLista2));
	
		System.out.println("**** inicializacion exitosa ****");

		// EJERCICIO 4.1: explicar salidas y sugerir mejoras
		informacion(lista1, 10);
		
		// EJERCICIO 4.2: corregir el metodo
		List<Integer> union = unionListas(lista1, lista2);
		System.out.println("union: " + union.toString());
		
		// EJERCICIO 4.3: implementar
		List<Integer> interseccion = interseccionListas(lista1, lista2);
		System.out.println("interseccion: " + interseccion.toString());
		
		// EJERCICIO 4.4: implementar
		List<Integer> orden1 = ordenaListaAscendente(lista1);
		System.out.println("orden asc: " + orden1);
		
		// EJERCICIO 4.5: implementar
		List<Integer> orden2 = ordenaListaDescendente(lista2);
		System.out.println("orden desc: " + orden2);

		// EJERCICIO 4.6: implementar
		boolean b = tienenMismoContenido(lista1, lista2);
		System.out.println("mismo contenido: " + b);
		
	}

	private static void informacion(List<Integer> lista1, Integer numero) {
		//Dada una lista de numeros enteros, en primer lugar el metodo informa la cantidad de numeros pares que posee 
		//dicha lista (mejora, pares=pares+1 se reemplaza por pares++)
		//Luego, define otra lista en la que agrega los numeros que son impares (mejora, se descarta el 
	    //segundo "for" y la lista de impares se llena con un condicional en el primer "for" de los numeros pares)
		//En tercer lugar muestra la posicion en la lista de enteros del numero que es igual a "tama�o de lista dividio 2", 
		//si no existe ese numero muestra -1
		//En cuarto lugar recorre la lista de numeros y un contador aumenta si el numero de la lista es mayor 
		//al segundo numero pasado como parametro, luego consulta si ese contador es mayor a "tama�o de lista dividido 2" 
		//o si el contador es mayor a cero o si no se dan ninguno de los dos casos muentra por consola tres puntos suspensivos 
		//(como mejora, se reemplaza C=c+1 por c++ y la funcionalidad del contador se agrega al primer "for", luego como los 
		//tres condicionales finales muestran el mismo mensaje, se quita el "if" y solo imprime el mensaje, 
		//al no necsitar mas el "if" tambien se elimina el contador innecesario)
		
		int pares = 0;
		List<Integer> impares = new ArrayList<Integer>();
		int p = lista1.size() / 2;
		
		for (Integer n: lista1) {
			if (n % 2 == 0) {
				pares++;
			}else {
				impares.add(n);
			}
		}
		
		System.out.println("... " + pares);
		
		System.out.println("... " + impares.toString());
		
		System.out.println("..." + lista1.indexOf(p));
		
		System.out.println("...");
	}

	/***
	 * @param lista1
	 * @param lista2
	 * 
	 * retornar una lista que contenga los elementos de ambas listas, sin elementos repetidos 
	 * 
	 */
	private static List<Integer> unionListas(List<Integer> lista1, List<Integer> lista2) {
		Set<Integer> union = new HashSet<Integer>();
		
		union.addAll(lista1);
		union.addAll(lista2);
		
		return new ArrayList<Integer>(union);
	}

	/***
	 * @param lista1
	 * @param lista2
	 * 
	 * retornar una lista que contenga los elementos que estan presentes en ambas listas, sin elementos repetidos 
	 * 
	 */
	private static List<Integer> interseccionListas(List<Integer> lista1, List<Integer> lista2) {
		
		Set<Integer> interseccion = new HashSet<Integer>();
		List<Integer> lista = new ArrayList<Integer>();

        for (Integer l1 : lista1) {
            if(lista2.contains(l1)) {
                lista.add(l1);
            }
        }
        interseccion.addAll(lista);
        
        return new ArrayList<Integer>(interseccion);
	}

	/***
	 * @param lista1
	 * 
	 * retornar la lista recibida, ordenada en forma ascendente
	 * 
	 */
	private static List<Integer> ordenaListaAscendente(List<Integer> lista1) {
		
		lista1.sort(new Comparator<Integer>() {
		    public int compare(Integer o1, Integer o2) {
		        return o1.compareTo(o2);
		    }
		});
		
		return lista1;
	}

	/***
	 * @param lista2
	 * 
	 * retornar la lista recibida, ordenada en forma descendente
	 * 
	 */
	private static List<Integer> ordenaListaDescendente(List<Integer> lista2) {
		
		lista2.sort(new Comparator<Integer>() {
		    public int compare(Integer o1, Integer o2) {
		        return o1.compareTo(o2);
		    }
		});
		
		Collections.reverse(lista2);
		
		return lista2;
	}

	/***
	 * @param lista1
	 * @param lista2
	 * 
	 * devuelve true si contienen los mismos elementos
	 * NO se considera valido que esten en diferente orden
	 * NO se considera valido que la cantidad de repeticiones de los elementos sea diferente
	 * 
	 */
	private static boolean tienenMismoContenido(List<Integer> lista1, List<Integer> lista2) {
		Collections.reverse(lista2);
		return lista1.equals(lista2);
	}

}
