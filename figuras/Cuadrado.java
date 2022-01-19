package figuras;

/***
 * 
 * Clase que representa un cuadrado, en este modelo Cuadrado hereda de Rectangulo,
 *
 * En esta clase solo se garantiza que el invariante de representación
 * "Un cuadrado es un rectangulo con todos los lados iguales"
 * se conserva para todos los cuadrados independientemente de su estado
 * @see Rectangulo
 * 
 */

public class Cuadrado extends Rectangulo {

	/***
	 * Crea un Cuadrado a partir de las coordenadas el punto inferior izquierdo y la longitud del lado
	 * 
	 * @param ptoX						 Coordenada X del punto inferior izquierdo del cuadrado
	 * @param ptoY						 Coordenada Y del punto inferior izquierdo del cuadrado
	 * @param lado						 longitud del lado del cuadrado
	 * @throws InvalidRectangleException Se lanza si el lado del cuadrado es cero o negativo
	 * 
	 * @see InvalidRectangleException
	 */

	public Cuadrado(double ptoX, double ptoY, double lado) throws InvalidRectangleException {

		super(ptoX, ptoY, lado, lado);

	}

	@Override
	public String toString() {

		return "Cuadrado: Vértice Inferior Izquierdo = " + inferiorIzquierdo.toString() + " lado = " + base;
	}
}
