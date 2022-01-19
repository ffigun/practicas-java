package nomina;

public abstract class Empleado {
	protected String nombre;
	protected String apellido;
	protected boolean tieneConyuge;
	protected int cantidadDeHijos = 0;
	protected final int sueldoBasico = 1000;	
	protected static final int COSTO_HORA = 10;
	
	/**
	 * @param nombre es una cadena de caracteres no nula y no vacia.
	 * @param apellido es una cadena de caracteres no nula y no vacia.
	 * @param cantidadDeHijos es un entero mayor o igual que cero.
	 */
	public Empleado(String nombre, String apellido, boolean tieneConyuge, int cantidadDeHijos) {		
		if (validarCadenaDeCaracteres(nombre) == false || validarCadenaDeCaracteres(apellido) == false)
			throw new Error("Los campos ingresados no pueden estar vacios.");
		
		if (cantidadDeHijos < 0)
			throw new Error("La cantidad de hijos ingresada no es valida.");
		
		this.nombre = nombre;
		this.apellido = apellido;
		this.tieneConyuge = tieneConyuge;
		this.cantidadDeHijos = cantidadDeHijos;
	}
	
	/**
	 * @param nombre es una cadena de caracteres no nula y no vacia.
	 * @param apellido es una cadena de caracteres no nula y no vacia.
	 */
	public Empleado(String nombre, String apellido) {		
		if (validarCadenaDeCaracteres(nombre) == false || validarCadenaDeCaracteres(apellido) == false)
			throw new Error("Los campos ingresados no pueden estar vacios.");

		this.nombre = nombre;
		this.apellido = apellido;
	}
	
	/**
	 * @return devuelve el salario comun a todos los empleados en unidades retributivas,
	 * compuesto por el sueldo basico y un adicional por grupo familiar.  
	 */
	public int liquidarSueldo() {
		return sueldoBasico + adicionalPorFamilia();
	}
	
	/**
	 * @return devuelve 200 UR por cada hijo y 100 UR adicionales si el empleado tiene conyuge.
	 */
	protected int adicionalPorFamilia() { 
		return 200 * cantidadDeHijos + (tieneConyuge? 100 : 0);
	}
	
	/**
	 * @return devuelve una cadena de caracteres en formato: <br>
	 *         Nombre Apellido
	 */
	public String obtenerNombreCompleto() {
		return nombre + " " + apellido;
	}
	
	/**
	 * @return devuelve verdadero si la cadena de caracteres no es nula ni esta vacia.
	 */
	private boolean validarCadenaDeCaracteres(String s) {
		return (s != null) && (s.trim() != "");
	}
	
	/**
	 * @return devuelve verdadero si los datos del empleado son validos.
	 * Cada subclase contendra validaciones adicionales para sus atributos.
	 */
	public boolean validarInformacion() {
		if (!validarCadenaDeCaracteres(nombre)) 	return false;
		if (!validarCadenaDeCaracteres(apellido)) return false;
		if (cantidadDeHijos < 0) 	return false;
		
		return true;
	}
	
}