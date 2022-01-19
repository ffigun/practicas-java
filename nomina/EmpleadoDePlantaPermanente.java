package nomina;

public abstract class EmpleadoDePlantaPermanente extends Empleado {
	protected int aniosDeAntiguedad = 0;

	/**
	 * @param nombre es una cadena de caracteres no nula y no vacia.
	 * @param apellido es una cadena de caracteres no nula y no vacia.
	 * @param tieneConyuge
	 * @param cantidadDeHijos es un entero mayor o igual que cero.
	 * @param aniosDeAntiguedad es un entero mayor o igual que cero.
	 */
	public EmpleadoDePlantaPermanente(String nombre, String apellido, boolean tieneConyuge, int cantidadDeHijos, int aniosDeAntiguedad) {
		super(nombre, apellido, tieneConyuge, cantidadDeHijos);
		
		if (aniosDeAntiguedad < 0)
			throw new Error ("Debe especificar una fecha valida.");
		
		this.aniosDeAntiguedad = aniosDeAntiguedad;
	}
	
	/**
	 * @param nombre es una cadena de caracteres no nula y no vacia.
	 * @param apellido es una cadena de caracteres no nula y no vacia.
	 */
	public EmpleadoDePlantaPermanente(String nombre, String apellido) {
		super(nombre, apellido);
	}
	
	/**
	 * @return devuelve la liquidacion del sueldo del empleado considerando el adicional por antiguedad
	 * que les corresponde a los empleados de planta permanente. 
	 */
	public int liquidarSueldo() {
		return super.liquidarSueldo() + adicionalPorAntiguedad();
	}
	
	/**	
	 * @return devuelve 100 URs por cada anio de antiguedad, hasta un maximo de 2000 UR.
	 */
	protected int adicionalPorAntiguedad() {
		return (aniosDeAntiguedad <= 20) ? (100 * aniosDeAntiguedad) : 2000;
	}
	
	@Override
	public boolean validarInformacion() {
		return super.validarInformacion() && (aniosDeAntiguedad >= 0);
	}
	
	@Override
	public String toString() {
		return "Planta permanente.";
	}
	
}