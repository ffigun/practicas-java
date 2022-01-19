package figuras;

/***
 * Clase que representa un rectángulo en el plano cartesiano
 * Almacena la base y la altura del rectángulo el vértice inferior izquierdo
 * 
 * @implNote Solo nos permite representar rectángulos cuyos lados son paralelos a los ejes. Si a futuro
 * el rectángulo puede girar en el plano habrá que modificar la representación para usar por ejemplo dos puntos
 *
 * @see FiguraLegacy
 */
public class Rectangulo extends FiguraLegacy {

	protected double base, altura;
	protected Punto inferiorIzquierdo;

	/***
	 * Crea un Rectangulo a partir de las coordenadas del vértice inferior izquierdo y la longitud de los lados
	 * 
	 * @param ptoX						 Coordenada X del punto inferior izquierdo del rectangulo
	 * @param ptoY						 Coordenada Y del punto inferior izquierdo del rectangulo
	 * @param base						 longitud de la base
	 * @param altura					 altura del rectangulo
	 * @throws InvalidRectangleException Se lanza si la altura o la base es cero o negativo
	 * 
	 * @see InvalidRectangleException
	 * @see Punto
	 */
	public Rectangulo(double ptoX, double ptoY, double base, double altura) throws InvalidRectangleException {

		if ((base <= 0) || (altura <= 0))
			throw new InvalidRectangleException("Ni la base ni la altura puede ser 0");
		this.inferiorIzquierdo = new Punto(ptoX, ptoY);
		this.base = base;
		this.altura = altura;
	}

	/***
	 * Implementa la interfaz Movible
	 */
	@Override
	public void mover(Double incrementoX, Double incrementoY) {
		this.inferiorIzquierdo.mover(incrementoX, incrementoY);

	}

	/***
	 * Implementación del método abstracto de la clase FiguraLegacy que permite 
	 * calcular el área de un Rectangulo
	 */
	@Override
	public double obtenerArea() {
		return base * altura;
	}

	public double getBase() {
		return base;
	}

	public double getAltura() {
		return altura;
	}

	public Punto getInferiorIzquierdo() {
		return inferiorIzquierdo;
	}

	@Override
	public String toString() {
		return "Rectángulo: Vértice Inferior Izquierdo = " + inferiorIzquierdo.toString() + " base = " + base
				+ " altura = " + altura;

	}
}
