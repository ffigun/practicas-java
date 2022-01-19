package nomina;

public class EmpleadoPartTime extends EmpleadoDePlantaPermanente {
	private int horasMensualesTrabajadas;
	
	/**
	 * @param nombre es una cadena de caracteres no nula y no vacia.
	 * @param apellido es una cadena de caracteres no nula y no vacia.
	 * @param tieneConyuge
	 * @param cantidadDeHijos es un entero mayor o igual que cero.
	 * @param aniosDeAntiguedad es un entero mayor o igual que cero.
	 * @param horasMensualesTrabajadas es un entero mayor o igual que cero.
	 */
	public EmpleadoPartTime(String nombre, String apellido, boolean tieneConyuge, int cantidadDeHijos, int aniosDeAntiguedad, int horasMensualesTrabajadas) {
		super(nombre, apellido, tieneConyuge, cantidadDeHijos, aniosDeAntiguedad);
		
		if (horasMensualesTrabajadas < 0)
			throw new Error("Las horas de trabajo ingresadas son invalidas.");
		
		this.horasMensualesTrabajadas = horasMensualesTrabajadas;
	}
	
	/**
	 * @param nombre es una cadena de caracteres no nula y no vacia.
	 * @param apellido es una cadena de caracteres no nula y no vacia.
	 */	
	public EmpleadoPartTime(String nombre, String apellido) {
		super(nombre, apellido);
		this.horasMensualesTrabajadas = 0;
	}
	
	/**
	 * post: liquida el sueldo del empleado como un tercio del sueldo basico mas un adicional por las horas trabajadas.
	 *       Si el tercio del basico y las horas superan las 1000 unidades retributivas, solo se consideraran 1000
	 *       unidades (sin contar los adicionales por grupo familiar y antiguedad).
	 */
	public int liquidarSueldo() {
		if ((sueldoBasico * 1/3 + (horasMensualesTrabajadas * COSTO_HORA)) > 1000) {
			return super.liquidarSueldo();
		} else {			
			return super.liquidarSueldo() - sueldoBasico * 2/3 + horasMensualesTrabajadas * COSTO_HORA;
		}
	}
	
	@Override
	public boolean validarInformacion() {
		return super.validarInformacion() && (horasMensualesTrabajadas >= 0);
	}
	
	@Override
	public String toString() {
		return nombre + " " + apellido + ": Empleado/a a tiempo parcial. " + super.toString();
	}
	
}