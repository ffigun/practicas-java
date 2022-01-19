package dijkstra.variosMinimos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.List;

public class Grafo {

	private HashMap<String, Vertice> vertices = new HashMap<String, Vertice>();

	public void agregarArista(String inicio, String destino, int peso) {
		if (!vertices.containsKey(inicio)) {
			Vertice nuevoVertice = new Vertice(inicio);
			vertices.put(inicio, nuevoVertice);
		}
		if (!vertices.containsKey(destino)) {
			Vertice nuevoDestino = new Vertice(destino);
			vertices.put(destino, nuevoDestino);
		}
		vertices.get(inicio).agregarArista(new Arista(vertices.get(destino), peso));
	}

	/**
	 * Basado en la implementacion del algoritmo de Dijkstra, devuelve todos los
	 * caminos minimos disponibles para cada vertice.
	 * 
	 * @param inicio el vertice de entrada.
	 * @return un mapa cuyas claves contienen una lista de los caminos mas cortos.
	 */
	public HashMap<String, List<String>> obtenerCaminosMinimos(String inicio) {
		HashMap<String, Boolean> visitados = new HashMap<String, Boolean>();
		HashMap<String, Double> distancias = new HashMap<String, Double>();
		PriorityQueue<Distancia> cola = new PriorityQueue<Distancia>();

		// Modificado: Guardar un List en vez de un unico valor
		HashMap<String, List<String>> camino = new HashMap<String, List<String>>();

		for (String vertice : vertices.keySet()) {
			camino.put(vertice, new ArrayList<String>());
			distancias.put(vertice, Double.MAX_VALUE);
			visitados.put(vertice, Boolean.FALSE);
		}

		distancias.put(inicio, 0.0);
		cola.add(new Distancia(inicio, 0.0));

		while (!cola.isEmpty()) {
			Distancia distancia = cola.poll();
			if (!visitados.get(distancia.getVertice())) {
				visitados.put(distancia.getVertice(), Boolean.TRUE);
				for (Map.Entry<String, Arista> arista : vertices.get(distancia.getVertice()).getListaDeAristas()
						.entrySet()) {
					if (!visitados.get(arista.getKey())) {
						double nuevaDistancia = distancia.getDistancia() + arista.getValue().getPeso();

						// Modificado: evaluar <= en vez de < para considerar los caminos de igual peso
						if (nuevaDistancia <= distancias.get(arista.getKey())) {
							distancias.put(arista.getKey(), nuevaDistancia);

							// Modificado: hacer un add al List en vez de un put al HashMap
							camino.get(arista.getKey()).add(distancia.getVertice());

							cola.add(new Distancia(arista.getKey(), distancias.get(arista.getKey())));
						}
					}
				}
			}
		}

		return camino;
	}

}
