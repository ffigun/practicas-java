package nomina;

import org.junit.Assert;
import org.junit.Test;

public class TestEmpleadoFullTime {
	// Empleado permanente full time con conyuge, un hijo y 10 anios de antiguedad
	private Empleado empleado = new EmpleadoFullTime("Nombre", "Apellido", true, 1, 10);
	
	@Test
	public void verificarSueldoCon10AniosDeAntiguedad() {
		// 1000 + 100 + 1x200 + 10x100 = 2300 UR
		Assert.assertEquals(2300, empleado.liquidarSueldo());
	}

	@Test
	public void verificarSueldoCon30AniosDeAntiguedad() {
		// 1000 + 100 + 1x200 + 2000 = 3300 UR
		empleado = new EmpleadoFullTime("Nombre", "Apellido", true, 1, 30);
		Assert.assertEquals(3300, empleado.liquidarSueldo());
	}
	
	@Test
	public void verificarFormatoDeCadenaDeCaracteres() {
		Assert.assertEquals("Nombre Apellido: Empleado/a a tiempo completo. Planta permanente.", empleado.toString());
	}
	
	@Test
	public void editarDatosArbitrariamenteYValidar() {
		empleado.apellido = "";
		empleado.nombre = null;
		empleado.cantidadDeHijos = -3;
		
		Assert.assertFalse(empleado.validarInformacion());
	}
	
	@Test (expected = Error.class)
	public void crearEmpleadoConCantidadDeHijosNegativos() {
		empleado = new EmpleadoFullTime("Nombre", "Apellido", true, -2, 10);
		Assert.assertFalse(empleado.validarInformacion());
	}
	
	@Test (expected = Error.class)
	public void crearEmpleadoConAntiguedadNegativa() {
		empleado = new EmpleadoFullTime("Nombre", "Apellido", true, 0, -10);
		Assert.assertFalse(empleado.validarInformacion());
	}
	
	@Test (expected = Error.class)
	public void crearEmpleadoConNombreVacio() {
		empleado = new EmpleadoFullTime("", "Apellido");
		Assert.assertEquals(" Apellido: Empleado/a a tiempo completo. Planta permanente.", empleado.toString());
	}
	
	@Test (expected = Error.class)
	public void crearEmpleadoConApellidoVacio() {
		empleado = new EmpleadoFullTime("Nombre", "");
		Assert.assertEquals("Nombre : Empleado/a a tiempo completo. Planta permanente.", empleado.toString());
	}
	
	@Test (expected = Error.class)
	public void crearEmpleadoConNombreNulo() {
		empleado = new EmpleadoFullTime(null, "Apellido");
		Assert.assertEquals("null Apellido: Empleado/a a tiempo completo. Planta permanente.", empleado.toString());
	}
	
	@Test (expected = Error.class)
	public void crearEmpleadoConApellidoNulo() {
		empleado = new EmpleadoFullTime("Nombre", null);
		Assert.assertEquals("Nombre null: Empleado/a a tiempo completo. Planta permanente.", empleado.toString());
	}

}
