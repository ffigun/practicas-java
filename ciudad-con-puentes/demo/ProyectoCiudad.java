package demo;

import grafo.Grafo;

public class ProyectoCiudad {
	public static void main(String[] args) {
		Grafo ciudad = new Grafo();

		/**
		 * Diagrama de intersecciones de la ciudad
		 * 
		 * En - hay puentes
		 * 
		 *		A   B   C   D
		 * 
		 *		E---F---G   H
		 *	 	-       -
		 * 		I	J	K	L
		 * 		
		 * 		M	N	O	P
		 * 
		 */

		// false: A la arista no la interrumpe un puente
		// true: A la arista la interrumpe un puente

		// Horizontales

		ciudad.agregarArista("A", "B", 10, false);
		ciudad.agregarArista("B", "C", 10, false);
		ciudad.agregarArista("C", "D", 10, false);

		ciudad.agregarArista("E", "F", 10, true);
		ciudad.agregarArista("F", "G", 25, true);
		ciudad.agregarArista("G", "H", 25, false);

		ciudad.agregarArista("I", "J", 5, false);
		ciudad.agregarArista("J", "K", 5, false);
		ciudad.agregarArista("K", "L", 5, false);

		ciudad.agregarArista("M", "N", 15, false);
		ciudad.agregarArista("N", "O", 25, false);
		ciudad.agregarArista("O", "P", 25, false);

		// Verticales

		ciudad.agregarArista("A", "E", 25, false);
		ciudad.agregarArista("B", "F", 15, true);
		ciudad.agregarArista("C", "G", 15, false);
		ciudad.agregarArista("D", "H", 15, false);

		ciudad.agregarArista("E", "I", 5, true);
		ciudad.agregarArista("F", "J", 15, false);
		ciudad.agregarArista("G", "K", 25, true);
		ciudad.agregarArista("H", "L", 25, false);

		ciudad.agregarArista("I", "M", 15, false);
		ciudad.agregarArista("J", "N", 25, false);
		ciudad.agregarArista("K", "O", 25, false);
		ciudad.agregarArista("L", "P", 25, false);

		System.out.println(
				"El recorrido para maximizar el flujo de vehiculos en la ciudad sin usar las rutas con puentes es:");
		System.out.println(ciudad.kruskalCiudad().entrySet());
	}
}
