package nomina;

public class Gerente extends EmpleadoDePlantaPermanente {
	
	/**
	 * @param nombre es una cadena de caracteres no nula y no vacia.
	 * @param apellido es una cadena de caracteres no nula y no vacia.
	 * @param cantidadDeHijos es un entero mayor o igual que cero.
	 * @param aniosDeAntiguedad es un entero mayor o igual que cero.
	 */
	public Gerente(String nombre, String apellido, boolean tieneConyuge, int cantidadDeHijos, int aniosDeAntiguedad) {
		super(nombre, apellido, tieneConyuge, cantidadDeHijos, aniosDeAntiguedad);
	}
	
	/**
	 * @param nombre es una cadena de caracteres no nula y no vacia.
	 * @param apellido es una cadena de caracteres no nula y no vacia.
	 */
	public Gerente(String nombre, String apellido) {
		super(nombre, apellido);
	}
	
	/**
	 * @return devuelve la liquidacion del sueldo del empleado considerando un bono de 2000 unidades retributivas
	 * en concepto de personal a cargo.
	 */
	public int liquidarSueldo() {
		return super.liquidarSueldo() + 2000; 
	}
	
	@Override
	public String toString() {
		return nombre + " " + apellido + ": Gerente. " + super.toString();
	}
	
}