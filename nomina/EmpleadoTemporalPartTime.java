package nomina;

public class EmpleadoTemporalPartTime extends EmpleadoDePlantaTemporaria {
	private int horasMensualesTrabajadas = 0;
	
	/**
	 * @param nombre es una cadena de caracteres no nula y no vacia.
	 * @param apellido es una cadena de caracteres no nula y no vacia.
	 * @param cantidadDeHijos es un entero mayor o igual que cero.
	 * @param horasMensualesTrabajadas es un entero mayor o igual que cero.
	 */
	public EmpleadoTemporalPartTime(String nombre, String apellido, boolean tieneConyuge, int cantidadDeHijos, int horasMensualesTrabajadas) {
		super(nombre, apellido, tieneConyuge, cantidadDeHijos);
		
		if (horasMensualesTrabajadas < 0)
			throw new Error("Las horas de trabajo ingresadas son invalidas.");
		
		this.horasMensualesTrabajadas = horasMensualesTrabajadas;
	}

	/**
	 * @param nombre es una cadena de caracteres no nula y no vacia.
	 * @param apellido es una cadena de caracteres no nula y no vacia.
	 */	
	public EmpleadoTemporalPartTime(String nombre, String apellido) {
		super(nombre, apellido);
	}

	/**
	 * @return devuelve la liquidacion del sueldo del empleado como un tercio del sueldo basico mas un adicional
	 * por las horas trabajadas. Si el tercio del basico y las horas superan las 1000 unidades retributivas, solo
	 * se consideraran 1000 unidades (sin contar los adicionales por grupo familiar). 
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