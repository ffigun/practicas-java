package figuras;

/***
 * InvalidREctangleException se lanza cuando un Rectángulo o un Cuadrado tienen algun
 * lado igual a cero o negativo, degenerando la figura y por lo tanto no se puede representar
 * correctamente en el plano.
 * @see Rectangulo
 *
 */
@SuppressWarnings("serial")
public class InvalidRectangleException extends FigurasException {

	public InvalidRectangleException(String s) {
		super(s);
	}

}
