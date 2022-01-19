package dijkstra.variosMinimos;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Vertice {
	private HashMap<String, Arista> aristas = new HashMap<String, Arista>();
	private String nombre;

	public Vertice(String nombre) {
		this.nombre = nombre;
	}

	public void agregarArista(Arista arista) {
		aristas.put(arista.getVerticeDestino().nombre, arista);
	}

	public Map<String, Arista> getListaDeAristas() {
		return Collections.unmodifiableMap(aristas);
	}

	public String getNombre() {
		return this.nombre;
	}

}
