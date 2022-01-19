package nomina;

import org.junit.Assert;
import org.junit.Test;

public class TestEmpleadoTemporalPartTime {
	// Empleado temporal part time con conyuge, un hijo y 40 horas mensuales trabajadas
	private Empleado empleado = new EmpleadoTemporalPartTime("Nombre", "Apellido", true, 1, 40);
		
	@Test
	public void verificarSueldoCon40HorasMensuales() {
		// 334 + 100 + 1x200 + 40x10 + 40x10 = 1034 UR
		Assert.assertEquals(1034, empleado.liquidarSueldo());
	}

	@Test
	public void verificarSueldoCon80HorasMensuales() {
		// 1000 + 100 + 1x200 = 1300 UR
		empleado = new EmpleadoTemporalPartTime("Nombre", "Apellido", true, 1, 80);
		Assert.assertEquals(1300, empleado.liquidarSueldo());
	}
	
	@Test
	public void verificarFormatoDeCadenaDeCaracteres() {
		Assert.assertEquals("Nombre Apellido: Empleado/a a tiempo parcial. Planta transitoria.", empleado.toString());
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
		empleado = new EmpleadoTemporalPartTime("Nombre", "Apellido", true, -2, 10);
		Assert.assertFalse(empleado.validarInformacion());
	}
	
	@Test (expected = Error.class)
	public void crearEmpleadoConHorasTrabajadasNegativas() {
		empleado = new EmpleadoTemporalPartTime("Nombre", "Apellido", true, 2, -10);
		Assert.assertFalse(empleado.validarInformacion());
	}
	
	@Test (expected = Error.class)
	public void crearEmpleadoConNombreVacio() {
		empleado = new EmpleadoTemporalPartTime("", "Apellido");
		Assert.assertEquals(" Apellido: Empleado/a a tiempo parcial. Planta transitoria.", empleado.toString());
	}
	
	@Test (expected = Error.class)
	public void crearEmpleadoConApellidoVacio() {
		empleado = new EmpleadoTemporalPartTime("Nombre", "");
		Assert.assertEquals("Nombre : Empleado/a a tiempo parcial. Planta transitoria.", empleado.toString());
	}
	
	@Test (expected = Error.class)
	public void EmpleadoTemporalFullTime() {
		empleado = new EmpleadoTemporalPartTime(null, "Apellido");
		Assert.assertEquals("null Apellido: Empleado/a a tiempo parcial. Planta transitoria.", empleado.toString());
	}
	
	@Test (expected = Error.class)
	public void crearEmpleadoConApellidoNulo() {
		empleado = new EmpleadoTemporalPartTime("Nombre", null);
		Assert.assertEquals("Nombre null: Empleado/a a tiempo parcial. Planta transitoria.", empleado.toString());
	}

}
