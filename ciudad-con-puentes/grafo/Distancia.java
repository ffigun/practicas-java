package grafo;

public class Distancia implements Comparable<Distancia> {
	private String vertice;
	private Double distancia;

	public Distancia(String vertice, Double distancia) {
		this.vertice = vertice;
		this.distancia = distancia;
	}

	public Double getDistancia() {
		return distancia;
	}

	public String getVertice() {
		return vertice;
	}

	@Override
	public int compareTo(Distancia otraDistancia) {
		return this.distancia.compareTo(otraDistancia.distancia);

	}

}
