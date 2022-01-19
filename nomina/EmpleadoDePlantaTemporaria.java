package nomina;

public abstract class EmpleadoDePlantaTemporaria extends Empleado {
	
	/**
	 * @param nombre es una cadena de caracteres no nula y no vacia.
	 * @param apellido es una cadena de caracteres no nula y no vacia.
	 * @param tieneConyuge
	 * @param cantidadDeHijos es un entero mayor o igual que cero.
	 */
	public EmpleadoDePlantaTemporaria(String nombre, String apellido, boolean tieneConyuge, int cantidadDeHijos) {
		super(nombre, apellido, tieneConyuge, cantidadDeHijos);
	}
	
	/**
	 * @param nombre es una cadena de caracteres no nula y no vacia.
	 * @param apellido es una cadena de caracteres no nula y no vacia.
	 */
	public EmpleadoDePlantaTemporaria(String nombre, String apellido) {
		super(nombre, apellido);
	}

	public int liquidarSueldo() {
		return super.liquidarSueldo();
	}
	
	@Override
	public String toString() {
		return "Planta transitoria.";
	}
	
}