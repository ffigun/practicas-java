package nomina;

public class Demo {
	public static void main (String[] args) {
		Empresa emp = new Empresa(10);

		Empleado e1 = new Gerente("Karina", "Lopez", true, 2, 10);
		Empleado e2 = new EmpleadoPartTime("Empleada", "Explotada", false, 1, 1, 220);
		Empleado e3 = new EmpleadoPartTime("Empleado", "Relajado", false, 1, 1, 62);
		Empleado e4 = new EmpleadoFullTime("Juan", "Gomez", false, 3, 35);
		Empleado e5 = new EmpleadoTemporalPartTime("Ignacio", "Rodriguez", true, 0, 75);
		Empleado e6 = new EmpleadoTemporalPartTime("Luis", "Wedge", false, 2, 20);
		Empleado e7 = new EmpleadoTemporalFullTime("Florencia Elizabeth", "Gomez", true, 12);
		Empleado e8 = new EmpleadoTemporalFullTime("Sandra", "Marconi", true, 2);

		emp.agregarEmpleado(e1);
		emp.agregarEmpleado(e2);
		emp.agregarEmpleado(e3);
		emp.agregarEmpleado(e4);
		emp.agregarEmpleado(e5);
		emp.agregarEmpleado(e6);
		emp.agregarEmpleado(e7);
		emp.agregarEmpleado(e8);
		
		/* Listar informacion de empleados */
		System.out.println(emp.listarEmpleados());
		System.out.println();
		
		/* Lista de empleados con cotizacion 1 UR = $10 */
		emp.modificarCotizacionUR(10);
		System.out.println("---------- Cotizacion: 1 UR = $10,00 ----------");
		System.out.println(emp.liquidarSueldos());
		System.out.println();
		
		
		/* Lista de empleados con cotizacion 1 UR = $148,50 */
		emp.modificarCotizacionUR(76.50);
		System.out.println("---------- Cotizacion: 1 UR = $76,50 ----------");
		System.out.println(emp.liquidarSueldos());
		System.out.println();
	}
	
}