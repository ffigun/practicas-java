package figuras;

/***
 * Clase que representa un punto en el plano como un par ordenado, donde el primer 
 * elemento es la abscisa y el segundo la ordenada
 * @author martin
 *
 */
public class Punto implements Movible {

	private double posicionX;
	private double posicionY;

	public Punto() {
		posicionX = 0;
		posicionY = 0;

	}

	public Punto(double x, double y) {
		posicionX = x;
		posicionY = y;
	}

	public void setX(Double posicionX) {

		this.posicionX = posicionX;
	}

	public double getX() {
		return posicionX;
	}

	public void setY(Double posicionY) {

		this.posicionY = posicionY;
	}

	public double getY() {

		return posicionY;
	}

	/***
	 * Implementación de la interfaz Movible que permite desplazar un Punto en el plano
	 */
	@Override
	public void mover(Double incrementoX, Double incrementoY) {
		posicionX += incrementoX;
		posicionY += incrementoY;

	}

	/***
	 * Con puntos en el plano no podemos tener orden total pero si comparar si dos
	 * puntos tienen las mismas coordenadas en X e Y Orden total quiere decir poder
	 * determinar si un elemento es mayor, menor o igual que otro
	 */
	@Override
	public boolean equals(Object o) {

		// Si el objeto es si mismo, devolver true
		if (o == this) {
			return true;
		}

		/* Si el objeto no es de la clase Punto devolver false */
		if (!(o instanceof Punto)) {
			return false;
		}

		// Castear objeto a Punto y comparar las coordenadas
		Punto c = (Punto) o;

		// Comparar las coordendadas
		return Double.compare(this.posicionX, c.posicionX) == 0 && Double.compare(this.posicionY, c.posicionY) == 0;

	}

	@Override
	public String toString() {
		return "(" + posicionX + ", " + posicionY + ")";
	}

}
