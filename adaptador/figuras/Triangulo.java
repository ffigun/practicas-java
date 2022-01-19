package figuras;

/***
 * Clase que representa un Triangulo, se representa con tres puntos en el plano
 *
 */
public class Triangulo extends FiguraLegacy {

	private Punto verticeA;
	private Punto verticeB;
	private Punto verticeC;

	public double[] getLados() {
		double[] lados = new double[3];

		lados[0] = Math.sqrt(
				Math.pow((verticeB.getX() - verticeA.getX()), 2) + Math.pow((verticeB.getY() - verticeA.getY()), 2));
		lados[1] = Math.sqrt(
				Math.pow((verticeC.getX() - verticeB.getX()), 2) + Math.pow((verticeC.getY() - verticeB.getY()), 2));
		lados[2] = Math.sqrt(
				Math.pow((verticeC.getX() - verticeA.getX()), 2) + Math.pow((verticeC.getY() - verticeA.getY()), 2));

		return lados;
	}

	public Punto[] getVertices() {
		Punto[] vertices = new Punto[3];
		vertices[0] = verticeA;
		vertices[1] = verticeB;
		vertices[2] = verticeC;

		return vertices;
	}

	public Triangulo(double Ax, double Ay, double Bx, double By, double Cx, double Cy) throws InvalidTriangleException {

		double[] lados;
		this.verticeA = new Punto(Ax, Ay);
		this.verticeB = new Punto(Bx, By);
		this.verticeC = new Punto(Cx, Cy);

		lados = getLados();
		// Si algunos de los lados tiene longitud 0 los puntos están alineados, no es un
		// triangulo válido
		boolean alineados = (lados[0] == 0) || (lados[1] == 0) || (lados[2] == 0);

		// Propiedad triangular: La suma de dos de dos lados cualquiera siempre debe ser
		// mayor que el lado
		// restante. Caso contrario no se puede formar un triángulo con esos lados
		boolean propiedadTriangular = ((lados[0] + lados[1] > lados[2]) && (lados[1] + lados[2] > lados[0])
				&& (lados[0] + lados[2] > lados[1]));
		if (alineados || !propiedadTriangular)
			throw new InvalidTriangleException("Los puntos ingresados no definen un triángulo");
	}

	@Override
	public void mover(Double incrementoX, Double incrementoY) {
		verticeA.mover(incrementoX, incrementoY);
		verticeB.mover(incrementoX, incrementoY);
		verticeC.mover(incrementoX, incrementoY);

	}

	/***
	 * Implementación del método abstracto de la clase FiguraLegacy que permite
	 * calcular el área del triángulo.
	 * Implementa la Fórmula del área de Gauss
	 * @see https://es.wikipedia.org/wiki/F%C3%B3rmula_del_%C3%A1rea_de_Gauss
	 * 
	 */
	
	@Override
	public double obtenerArea() {
		return Math.abs(((verticeA.getX() * (verticeB.getY() - verticeC.getY()))
				+ (verticeB.getX() * (verticeC.getY() - verticeA.getY()))
				+ (verticeC.getX() * (verticeA.getY() - verticeB.getY()))) / 2);
	}

	@Override
	public String toString() {

		double[] lados = getLados();
		return "Triángulo Vertices= " + verticeA.toString() + ", " + verticeB.toString() + ", " + verticeC.toString()
				+ " lados = " + lados[0] + ", " + lados[1] + ", " + lados[2];

	}

}
