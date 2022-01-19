package demo;

import dijkstra.variosMinimos.Grafo;

/**
 * @author Fernando Figun
 */

public class Main {
	public static void main(String[] args) {
		Grafo grafo = new Grafo();

		grafo.agregarArista("A", "B", 1);
		grafo.agregarArista("B", "C", 1);
		grafo.agregarArista("A", "C", 2);

		System.out.println("Los caminos minimos para llegar desde A a cada vertice se conforman por los siguientes vertices:\n");
		System.out.println(grafo.obtenerCaminosMinimos("A"));
		System.out.println("\nEn formato DESTINO=[VERTICES PREVIOS]");
	}
}
