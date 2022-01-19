package figuras;

/***
 * Clase que representa un círculo, en este modelo Circulo hereda de Elipse,
 *
 * En esta clase solo se garantiza que el invariante de representación
 * "Un Círculo es una elipse con ambos radios iguales"
 * se conserva para todos los círculos independientemente de su estado
 * 
 */
public class Circulo extends Elipse {

	/***
	 * Crea un círculo con centro en un punto dado y un radio mayor que cero
	 * 
	 * @param radio  	Radio del círculo
	 * @param centroX 	Coordenada X del centro del círculo
	 * @param centroY C	oordenada Y del centro del círculo
	 * @throws InvalidRadioException Se lanza si el radio que recibe es menor o igual a 0
	 * @see Elipse
	 * @see InvalidRadioException
	 */

	public Circulo(double centroX, double centroY, double radio) throws InvalidRadioException {

		super(centroX, centroY, radio, radio);

	}

	@Override
	public String toString() {

		return "Círculo: centro = " + centro.toString() + " radio = " + radioX;
	}

}
