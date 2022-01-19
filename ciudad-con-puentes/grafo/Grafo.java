package grafo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class Grafo {

	private HashMap<String, Vertice> vertices = new HashMap<String, Vertice>();

	public void agregarArista(String inicio, String destino, int peso, boolean tienePuente) {
		if (!vertices.containsKey(inicio)) {
			Vertice nuevoVertice = new Vertice(inicio);
			vertices.put(inicio, nuevoVertice);
		}
		if (!vertices.containsKey(destino)) {
			Vertice nuevoDestino = new Vertice(destino);
			vertices.put(destino, nuevoDestino);
		}
		vertices.get(inicio).agregarArista(new Arista(vertices.get(destino), peso, tienePuente));
	}

	public Map<String, Set<String>> kruskalCiudad() {
		Map<String, Set<String>> arbolMinimo = new HashMap<String, Set<String>>();
		ConjuntoAEM conjuntoAEM = new ConjuntoAEM(vertices.keySet());
		PriorityQueue<AristaAEM> cola = new PriorityQueue<AristaAEM>();
		for (String vertice : vertices.keySet()) {
			for (Map.Entry<String, Arista> arista : vertices.get(vertice).getListaDeAristas().entrySet()) {
				if (!arista.getValue().tienePuente()) {
					cola.add(new AristaAEM(vertice, arista.getKey(), arista.getValue().getPeso(),
							arista.getValue().tienePuente()));
				}
			}
		}
		while (!cola.isEmpty() && arbolMinimo.size() < vertices.size() - 1) {
			AristaAEM aristaAEM = cola.poll();
			if (!conjuntoAEM.find(aristaAEM.getOrigen()).equals(conjuntoAEM.find(aristaAEM.getDestino()))) {
				Set<String> set = new HashSet<String>();
				if (arbolMinimo.containsKey(aristaAEM.getOrigen())) {
					set = arbolMinimo.get(aristaAEM.getOrigen());
				}
				set.add(aristaAEM.getDestino());
				arbolMinimo.put(aristaAEM.getOrigen(), set);
				conjuntoAEM.union(aristaAEM.getOrigen(), aristaAEM.getDestino());
			}
		}
		return arbolMinimo;
	}

	@Override
	public String toString() {
		String respuesta = vertices.keySet().toString() + "\n";
		for (Map.Entry<String, Vertice> vertice : vertices.entrySet()) {
			respuesta += vertice.getKey() + " : ";
			respuesta += vertice.getValue().toString() + "\n";
		}
		return respuesta;
	}

}
