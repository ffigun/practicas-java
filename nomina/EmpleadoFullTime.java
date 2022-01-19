package nomina;

public class EmpleadoFullTime extends EmpleadoDePlantaPermanente {
	
	/**
	 * @param nombre es una cadena de caracteres no nula y no vacia.
	 * @param apellido es una cadena de caracteres no nula y no vacia.
	 * @param cantidadDeHijos es un entero mayor o igual que cero.
	 * @param aniosDeAntiguedad es un entero mayor o igual que cero.
	 */
	public EmpleadoFullTime(String nombre, String apellido, boolean tieneConyuge, int cantidadDeHijos, int aniosDeAntiguedad) {
		super(nombre, apellido, tieneConyuge, cantidadDeHijos, aniosDeAntiguedad);
	}
	
	/**
	 * @param nombre es una cadena de caracteres no nula y no vacia.
	 * @param apellido es una cadena de caracteres no nula y no vacia.
	 */
	public EmpleadoFullTime(String nombre, String apellido) {
		super(nombre, apellido);
	}
	
	public int liquidarSueldo() {
		return super.liquidarSueldo();
	}
	
	@Override
	public String toString() {
		return nombre + " " + apellido + ": Empleado/a a tiempo completo. " + super.toString();
	}
	
}