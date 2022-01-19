package nomina;

public class Empresa {
	private Empleado [] empleado;
	private double valorDeUR = 10;
	private int indice;
	
	/**
	 * post: Crea la lista de empleados de la empresa con un total de [cantidadDeEmpleados] empleados. El primer empleado estara en la posicion cero.
	 * @param cantidadDeEmpleados es un entero entre 1 y 10000 que determina el tamaño de la lista de empleados
	 */
	public Empresa (int cantidadDeEmpleados) {
		if(cantidadDeEmpleados < 1 || cantidadDeEmpleados > 10000) {
			throw new Error("La cantidad de empleados de la nomina debe estar comprendida entre 1 y 10000.");
		}
		empleado = new Empleado[cantidadDeEmpleados];
		indice = 0;
	}
	
	/**
	 * post: Añade el empleado e a la siguiente posicion vacia de la lista de empleados.
	 */
	public void agregarEmpleado(Empleado e) {
		if (e == null)
			throw new Error("No se puede agregar el empleado. Se requiere un objeto de tipo Empleado.");
		if (e.validarInformacion() == false)
			throw new Error("El empleado que desea ingresar en la nomina contiene datos que no son validos.");
		
		empleado[indice++] = e;							// Postincremento: agrega el empleado en la pos. indice, luego incrementa 1
	}

	/**
	 * @return devuelve una cadena de caracteres con la informacion y categoria de cada empleado.
	 */
	public String listarEmpleados() {
		String ln = System.lineSeparator();				// Salto de linea
		String datos = "Listado de Empleados:" + ln;
		
		int i = 0;
		while (empleado[i] != null) {
			datos += ln + empleado[i++].toString();		// Postincremento: agrega el empleado en la pos. indice, luego incrementa 1
		}
		
		datos += ln + ln + "Total de empleados: " + this.indice;
		return datos;
	}
	
	/**
	 * @return devuelve una cadena de caracteres con la lista de empleados y la liquidacion de sus sueldos.
	 */
	public String liquidarSueldos() {
		String ln = System.lineSeparator();				// Salto de linea
		String datos = "Liquidacion de Sueldos:" + ln;
		
		int i = 0;
		while (empleado[i] != null) {
			datos += ln + empleado[i].obtenerNombreCompleto() + ": $" + empleado[i].liquidarSueldo() * cotizacionUR();
			i++;
		}
		return datos;
	}
	
	/**
	 * @param nuevoValor es un numero de punto flotante mayor que cero.
	 */
	public void modificarCotizacionUR(double nuevoValor) {
		if (!(nuevoValor > 0)) {
			throw new Error("La cotizacion de la Unidad Retributiva debe ser un valor superior a cero.");
		}
		this.valorDeUR = nuevoValor;
	}
	
	/**
	 * @return devuelve el valor de una unidad retributiva (UR).
	 */
	public double cotizacionUR() {
		return this.valorDeUR;		
	}
	
}