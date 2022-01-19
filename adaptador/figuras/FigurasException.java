package figuras;

/***
 * 
 * Clase base para las excepciones del paquete figuraLegacies
 * Como estas excepciones serán lanzadas por en general por los constructores, 
 * se elige como clase base RuntimeException, es decir trabajar con Excepciones
 * no chequeadas.
 * La justificación de esta decisión se basa en que es responsabilidad del que usa el paquete figura
 * de asegurarse que los parámetros pasados a los constructores son válidos y por lo tanto si se 
 * llega a lanzar algunas de estas excepciones debería ser porque no se pudo prevenir y por lo tanto
 * dificilmente sea posible recuperarse de la situación excepcional.
 *
 */
@SuppressWarnings("serial")
public class FigurasException extends RuntimeException {

	public FigurasException(String string) {
		super(string);
	}

}
