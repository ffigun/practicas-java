package grafo;

public class AristaAEM implements Comparable<AristaAEM> {
	private String origen;
	private String destino;
	private double peso;
	private boolean tienePuente;

	public AristaAEM(String origen, String destino, double peso, boolean TienePuente) {
		this.origen = origen;
		this.destino = destino;
		this.peso = peso;
		this.tienePuente = tienePuente;
	}

	public boolean tienePuente() {
		return tienePuente;
	}

	public String getOrigen() {
		return origen;
	}

	public String getDestino() {
		return destino;
	}

	@Override
	public int compareTo(AristaAEM arista) {
		return (Double.compare(this.peso, arista.peso) * -1);
	}
}
