package nomina;

import org.junit.Assert;
import org.junit.Test;

public class TestEmpresa {
	private final String ln = System.lineSeparator();
	private Empresa empresa = new Empresa(10);
	private Empleado empleado;

	@Test
	public void crearNominaConUnGerenteYListar() {
		empleado = new Gerente("Ana", "Lopez");
		empresa.agregarEmpleado(empleado);
		
		String exp = "Listado de Empleados:" + ln + ln +
					 "Ana Lopez: Gerente. Planta permanente." + ln + ln +
					 "Total de empleados: 1";
		
		Assert.assertEquals(exp, empresa.listarEmpleados());
	}
	
	@Test
	public void crearNominaConUnGerenteYUnEmpleadoFullTimeYListar() {
		empleado = new Gerente("Ana", "Lopez");
		empresa.agregarEmpleado(empleado);
		
		empleado = new EmpleadoFullTime("Abel", "Garcia");
		empresa.agregarEmpleado(empleado);

		String exp = "Listado de Empleados:" + ln + ln +
					 "Ana Lopez: Gerente. Planta permanente." + ln +
					 "Abel Garcia: Empleado/a a tiempo completo. Planta permanente." + ln + ln +
					 "Total de empleados: 2";
		
		Assert.assertEquals(exp, empresa.listarEmpleados());
	}
	
	@Test
	public void crearNominaConUnGerenteYDosEmpleadosYListar() {
		empleado = new Gerente("Ana", "Lopez");
		empresa.agregarEmpleado(empleado);
		
		empleado = new EmpleadoFullTime("Abel", "Garcia");
		empresa.agregarEmpleado(empleado);

		empleado = new EmpleadoPartTime("Adrian", "Estebanez");
		empresa.agregarEmpleado(empleado);
		
		String exp = "Listado de Empleados:" + ln + ln +
					 "Ana Lopez: Gerente. Planta permanente." + ln +
					 "Abel Garcia: Empleado/a a tiempo completo. Planta permanente." + ln +
					 "Adrian Estebanez: Empleado/a a tiempo parcial. Planta permanente." + ln + ln +
					 "Total de empleados: 3";
		
		Assert.assertEquals(exp, empresa.listarEmpleados());
	}
	
	@Test
	public void crearNominaConUnGerenteDosEmpleadosYUnEmpleadoTemporalFullTimeYListar() {
		empleado = new Gerente("Ana", "Lopez");
		empresa.agregarEmpleado(empleado);
		
		empleado = new EmpleadoFullTime("Abel", "Garcia");
		empresa.agregarEmpleado(empleado);

		empleado = new EmpleadoPartTime("Adrian", "Estebanez");
		empresa.agregarEmpleado(empleado);
		
		empleado = new EmpleadoTemporalFullTime("Florencia Elizabeth", "Gomez");
		empresa.agregarEmpleado(empleado);
		
		String exp = "Listado de Empleados:" + ln + ln +
					 "Ana Lopez: Gerente. Planta permanente." + ln +
					 "Abel Garcia: Empleado/a a tiempo completo. Planta permanente." + ln +
					 "Adrian Estebanez: Empleado/a a tiempo parcial. Planta permanente." + ln +
					 "Florencia Elizabeth Gomez: Empleado/a a tiempo completo. Planta transitoria." + ln + ln +
					 "Total de empleados: 4";
		
		Assert.assertEquals(exp, empresa.listarEmpleados());
	}
	
	@Test
	public void crearNominaConUnGerenteDosEmpleadosYDosEmpleadosTemporalesYListar() {
		empleado = new Gerente("Ana", "Lopez");
		empresa.agregarEmpleado(empleado);
		
		empleado = new EmpleadoFullTime("Abel", "Garcia");
		empresa.agregarEmpleado(empleado);
		
		empleado = new EmpleadoPartTime("Adrian", "Estebanez");
		empresa.agregarEmpleado(empleado);
		
		empleado = new EmpleadoTemporalFullTime("Florencia Elizabeth", "Gomez");
		empresa.agregarEmpleado(empleado);
		
		empleado = new EmpleadoTemporalPartTime("Hernan", "Rodriguez");
		empresa.agregarEmpleado(empleado);
		
		String exp = "Listado de Empleados:" + ln + ln +
					 "Ana Lopez: Gerente. Planta permanente." + ln +
					 "Abel Garcia: Empleado/a a tiempo completo. Planta permanente." + ln +
					 "Adrian Estebanez: Empleado/a a tiempo parcial. Planta permanente." + ln +
					 "Florencia Elizabeth Gomez: Empleado/a a tiempo completo. Planta transitoria." + ln +
					 "Hernan Rodriguez: Empleado/a a tiempo parcial. Planta transitoria." + ln + ln +
					 "Total de empleados: 5";
		
		Assert.assertEquals(exp, empresa.listarEmpleados());
	}
	
	@Test
	public void crearConTodosLosTiposDeEmpleadosYLiquidarSueldos() {
		/*
		 * Este es un caso general, los casos particulares se prueban
		 * en las clases de prueba correspondientes.
		 * El valor por defecto de 1 UR es $10.
		 */
		
		// Gerente permanente con conyuge, 1 hijo, 15 anios de antiguedad
		// 1000 + 100 + 1x200 + 15x100 + 2000 = 4800 UR
		empleado = new Gerente("Ana", "Lopez", true, 1, 15);
		empresa.agregarEmpleado(empleado);
		
		// Full time permanente sin conyuge, 2 hijos, 3 anios de antiguedad
		// 1000 + 2x200 + 3x100 = 1700 UR
		empleado = new EmpleadoFullTime("Abel", "Garcia", false, 2, 3);
		empresa.agregarEmpleado(empleado);
		
		// Papa luchon part time permanente con 3 hijos y 25 anios de antiguedad y 40hs trabajadas
		// 334 + 3x200 + 2000 + 40 x COSTO_HORAS(10) = 3334 UR
		empleado = new EmpleadoPartTime("Adrian", "Estebanez", false, 3, 25, 40);
		empresa.agregarEmpleado(empleado);
		
		// Full time temporal con conyuge y 4 hijos
		// 1000 + 100 + 4x200 = 1900 UR
		empleado = new EmpleadoTemporalFullTime("Florencia Elizabeth", "Gomez", true, 4);
		empresa.agregarEmpleado(empleado);
		
		// Part time temporal sin conyuge, sin hijos y 5 horas trabajadas
		// 334 + 5 x COSTO_HORAS(10) = 384 UR
		empleado = new EmpleadoTemporalPartTime("Hernan", "Rodriguez", false, 0, 5);
		empresa.agregarEmpleado(empleado);
		
		String exp = "Liquidacion de Sueldos:" + ln + ln +
					 "Ana Lopez: $48000.0" + ln +
					 "Abel Garcia: $17000.0" + ln +
					 "Adrian Estebanez: $33340.0" + ln +
					 "Florencia Elizabeth Gomez: $19000.0" + ln +
					 "Hernan Rodriguez: $3840.0";
		
		Assert.assertEquals(exp, empresa.liquidarSueldos());
	}
	
	@Test
	public void cambiarValorDeURYVerificar() {
		// Gerente permanente con conyuge, 1 hijo, 15 anios de antiguedad
		// 1000 + 100 + 1x200 + 15x100 + 2000 = 4800 UR
		empleado = new Gerente("Ana", "Lopez", true, 1, 15);
		empresa.agregarEmpleado(empleado);
		
		// 4800 UR x 10
		String exp = "Liquidacion de Sueldos:" + ln + ln +
				 	 "Ana Lopez: $48000.0";
		
		Assert.assertEquals(exp, empresa.liquidarSueldos());
		
		// 4800 UR x 100
		exp = "Liquidacion de Sueldos:" + ln + ln +
			  "Ana Lopez: $480000.0";
		
		empresa.modificarCotizacionUR(100);
		
		Assert.assertEquals(exp, empresa.liquidarSueldos());
	}
	
	@Test (expected = Error.class)
	public void agregarUnEmpleadoConDatosAlterados() {
		empleado = new Gerente("Gerente", "Uno", false, 0, 0);
		
		// Modificar arbitrariamente los datos
		empleado.nombre = "";
		empleado.apellido = null;
		empleado.cantidadDeHijos = -8;
		
		empresa.agregarEmpleado(empleado);
		Assert.assertFalse(empleado.validarInformacion());
	}
	
	@Test (expected = Error.class)
	public void agregarUnEmpleadoNulo() {
		empresa.agregarEmpleado(null);
		String exp = "Liquidacion de Sueldos:" + ln + ln + "null";
		Assert.assertEquals(exp, empresa.liquidarSueldos());
	}
	
	@Test (expected = Error.class)
	public void asignarUnValorDeURNegativo() {
		empresa.modificarCotizacionUR(-1);
		Assert.assertEquals(-1, empresa.cotizacionUR(), 0.0);
	}
	
	@Test (expected = Error.class)
	public void asignarUnValorDeURCero() {
		empresa.modificarCotizacionUR(0);
		Assert.assertEquals(0, empresa.cotizacionUR(), 0.0);
	}
	
	@Test (expected = Error.class)
	public void crearNominaConMasDe10MilEmpleados() {
		empresa = new Empresa(10_001);
				
		String exp = "Listado de Empleados:" + ln + ln +
					 "Total de empleados: 0";
		
		Assert.assertEquals(exp, empresa.listarEmpleados());
	}
	
	@Test (expected = Error.class)
	public void crearUnGerenteConNombreVacio() {
		empleado = new Gerente("", "Jaramillo");
		empresa.agregarEmpleado(empleado);
		
		String exp = "Listado de Empleados:" + ln + ln +
					 " Jaramillo: Gerente. Planta permanente." + ln + ln +
					 "Total de empleados: 1";
		
		Assert.assertEquals(exp, empresa.listarEmpleados());
	}
	
	@Test (expected = Error.class)
	public void crearUnGerenteConApellidoVacio() {
		empleado = new Gerente("Aurelio", "");
		empresa.agregarEmpleado(empleado);
		
		String exp = "Listado de Empleados:" + ln +
					 "Aurelio : Gerente. Planta permanente." + ln + ln +
					 "Total de empleados: 1";
		
		Assert.assertEquals(exp, empresa.listarEmpleados());
	}
	
	@Test (expected = Error.class)
	public void crearUnEmpleadoDePlantaPermanenteConNombreNulo() {
		empleado = new Gerente(null, "Jaramillo");
		empresa.agregarEmpleado(empleado);
		
		String exp = "Listado de Empleados:" + ln +
					 "null Jaramillo: Gerente. Planta permanente." + ln + ln +
					 "Total de empleados: 1";
		
		Assert.assertEquals(exp, empresa.listarEmpleados());
	}
	
	@Test (expected = Error.class)
	public void crearUnEmpleadoDePlantaPermanenteConApellidoNulo() {
		empleado = new EmpleadoTemporalFullTime("Aurelio", null);
		empresa.agregarEmpleado(empleado);
		
		String exp = "Listado de Empleados:" + ln +
					 "Aurelio null: Empleado/a a tiempo parcial. Planta transitoria." + ln + ln +
					 "Total de empleados: 1";
		
		Assert.assertEquals(exp, empresa.listarEmpleados());
	}

}
