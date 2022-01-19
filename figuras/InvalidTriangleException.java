package figuras;

/***
 * InvalidTriangleException se lanza cuando se intenta construir un triángulo con tres 
 * puntos que o bien están alineados y por lo tanto alguno de los lados es 0 degenerando 
 * la figura o porque no se cumple la propiedad triangular.
 * @see Triangulo
 *
 */
@SuppressWarnings("serial")
public class InvalidTriangleException extends FigurasException {
	public InvalidTriangleException(String s) {
		super(s);
	}

}
