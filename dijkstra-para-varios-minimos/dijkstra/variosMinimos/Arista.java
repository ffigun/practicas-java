package dijkstra.variosMinimos;

public class Arista {

	private Vertice verticeDestino;
	private double peso;

	public Arista(Vertice destino, double peso) {
		this.verticeDestino = destino;
		this.peso = peso;
	}

	public Vertice getVerticeDestino() {
		return verticeDestino;
	}

	public double getPeso() {
		return peso;
	}

}
