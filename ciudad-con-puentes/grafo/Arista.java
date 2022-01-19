package grafo;

public class Arista {

	private Vertice verticeDestino;
	private double peso;
	private boolean tienePuente;

	public Arista(Vertice destino, double peso) {

		this.verticeDestino = destino;
		this.peso = peso;

	}

	public Arista(Vertice destino, double peso, boolean tienePuente) {
		this.verticeDestino = destino;
		this.peso = peso;
		this.tienePuente = tienePuente;
	}

	public Vertice getVerticeDestino() {
		return verticeDestino;
	}

	public double getPeso() {
		return peso;
	}

	public boolean tienePuente() {
		return tienePuente;
	}

}
