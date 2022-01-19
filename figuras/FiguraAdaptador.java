package figuras;

public class FiguraAdaptador implements Figura, Comparable<FiguraAdaptador> {
	
	private FiguraLegacy figura;
	
	public FiguraAdaptador(FiguraLegacy f) {
		figura = f;
	}
	
	@Override
	public double getArea() {
		return figura.obtenerArea();
	}

	@Override
	public int compareTo(FiguraAdaptador otraFigura) {
		if (getArea() > otraFigura.getArea()) {
			return 1;
		} else if (getArea() < otraFigura.getArea()) {
			return -1;
		} else {
			return 0;
		}
	}
}
