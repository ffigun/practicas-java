package nomina;

import org.junit.Assert;
import org.junit.Test;

public class TestEmpleadoPartTime {
	// Empleado permanente part time con conyuge, un hijo, 5 anios de antiguedad y 40 horas mensuales trabajadas
	private Empleado empleado = new EmpleadoPartTime("Nombre", "Apellido", true, 1, 5, 40);
		
	@Test
	public void verificarSueldoCon5AniosDeAntiguedadY40HorasMensuales() {
		// 334 + 100 + 1x200 + 5x10 + 40x10 = 1534 UR
		Assert.assertEquals(1534, empleado.liquidarSueldo());
	}

	@Test
	public void verificarSueldoCon30AniosDeAntiguedadY40HorasMensuales() {
		// 334 + 100 + 1x200 + 2000 + 40x10 = 3034 UR
		empleado = new EmpleadoPartTime("Nombre", "Apellido", true, 1, 30, 40);
		Assert.assertEquals(3034, empleado.liquidarSueldo());
	}
	
	@Test
	public void verificarSueldoCon5AniosDeAntiguedadY80HorasMensuales() {
		// 1000 + 100 + 1x200 + 5x100 = 1800 UR
		empleado = new EmpleadoPartTime("Nombre", "Apellido", true, 1, 5, 80);
		Assert.assertEquals(1800, empleado.liquidarSueldo());
	}
	
	@Test
	public void verificarSueldoCon30AniosDeAntiguedadY80HorasMensuales() {
		// 1000 + 100 + 1x200 + 2000 = 3300 UR
		empleado = new EmpleadoPartTime("Nombre", "Apellido", true, 1, 30, 80);
		Assert.assertEquals(3300, empleado.liquidarSueldo());
	}
	
	@Test
	public void verificarFormatoDeCadenaDeCaracteres() {
		Assert.assertEquals("Nombre Apellido: Empleado/a a tiempo parcial. Planta permanente.", empleado.toString());
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
		empleado = new EmpleadoPartTime("Nombre", "Apellido", true, -2, 10, 10);
		Assert.assertFalse(empleado.validarInformacion());
	}
	
	@Test (expected = Error.class)
	public void crearEmpleadoConAntiguedadNegativa() {
		empleado = new EmpleadoPartTime("Nombre", "Apellido", true, 2, -10, 12);
		Assert.assertFalse(empleado.validarInformacion());
	}
	
	@Test (expected = Error.class)
	public void crearEmpleadoConHorasTrabajadasNegativas() {
		empleado = new EmpleadoPartTime("Nombre", "Apellido", true, 2, 10, -12);
		Assert.assertFalse(empleado.validarInformacion());
	}
	
	@Test (expected = Error.class)
	public void crearEmpleadoConNombreVacio() {
		empleado = new EmpleadoPartTime("", "Apellido");
		Assert.assertEquals(" Apellido: Empleado/a a tiempo parcial. Planta permanente.", empleado.toString());
	}
	
	@Test (expected = Error.class)
	public void crearEmpleadoConApellidoVacio() {
		empleado = new EmpleadoPartTime("Nombre", "");
		Assert.assertEquals("Nombre : Empleado/a a tiempo parcial. Planta permanente.", empleado.toString());
	}
	
	@Test (expected = Error.class)
	public void crearEmpleadoConNombreNulo() {
		empleado = new EmpleadoPartTime(null, "Apellido");
		Assert.assertEquals("null Apellido: Empleado/a a tiempo parcial. Planta permanente.", empleado.toString());
	}
	
	@Test (expected = Error.class)
	public void crearEmpleadoConApellidoNulo() {
		empleado = new EmpleadoPartTime("Nombre", null);
		Assert.assertEquals("Nombre null: Empleado/a a tiempo parcial. Planta permanente.", empleado.toString());
	}

	@Test (expected = Error.class)
	public void crearEmpleadoConCantidadDeHijosNegativa() {
		// 334 + 100 + -1x200 + 2000 + 40x10 = 2634 UR
		empleado = new EmpleadoPartTime("Nombre", "Apellido", true, -1, 30, 40);
		Assert.assertEquals(-100, empleado.adicionalPorFamilia());
	}
	
}
