package grafo;

import java.util.HashMap;
import java.util.Set;

public class ConjuntoAEM {
	private HashMap<String, String> uf = new HashMap<String, String>();
	private HashMap<String, Integer> rank = new HashMap<String, Integer>();

	public ConjuntoAEM(Set<String> vertices) {
		for (String vertice : vertices) {
			uf.put(vertice, vertice);
			rank.put(vertice, 0);
		}
	}

	public String find(String vertice) {
		if (!uf.get(vertice).equals(uf.get(uf.get(vertice)))) {
			uf.put(vertice, find(uf.get(vertice)));
		}
		return uf.get(vertice);
	}

	public boolean union(String u, String v) {
		String uu = find(u);
		String vv = find(v);
		if (uu.equals(vv)) {
			return false;
		}
		if (rank.get(uu) > rank.get(vv)) {
			String aux = uu;
			uu = vv;
			vv = aux;
		}
		if (rank.get(uu) == rank.get(vv)) {
			rank.put(vv, rank.get(vv) + 1);
		}
		uf.put(uu, vv);
		return true;
	}
}
