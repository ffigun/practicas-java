package nomina;

import org.junit.Assert;
import org.junit.Test;

public class TestEmpleadoTemporalFullTime {
	// Empleado temporal full time con conyuge y un hijo
	private Empleado empleado = new EmpleadoTemporalFullTime("Nombre", "Apellido", true, 1);
	
	@Test
	public void verificarSueldo() {
		// 1000 + 100 + 1x200 = 1300 UR
		Assert.assertEquals(1300, empleado.liquidarSueldo());
	}
	
	@Test
	public void verificarFormatoDeCadenaDeCaracteres() {
		Assert.assertEquals("Nombre Apellido: Empleado/a a tiempo completo. Planta transitoria.", empleado.toString());
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
		empleado = new EmpleadoTemporalFullTime("Nombre", "Apellido", true, -2);
		Assert.assertFalse(empleado.validarInformacion());
	}
	
	@Test (expected = Error.class)
	public void crearEmpleadoConNombreVacio() {
		empleado = new EmpleadoTemporalFullTime("", "Apellido");
		Assert.assertEquals(" Apellido: Empleado/a a tiempo completo. Planta transitoria.", empleado.toString());
	}
	
	@Test (expected = Error.class)
	public void crearEmpleadoConApellidoVacio() {
		empleado = new EmpleadoTemporalFullTime("Nombre", "");
		Assert.assertEquals("Nombre : Empleado/a a tiempo completo. Planta transitoria.", empleado.toString());
	}
	
	@Test (expected = Error.class)
	public void EmpleadoTemporalFullTime() {
		empleado = new EmpleadoTemporalFullTime(null, "Apellido");
		Assert.assertEquals("null Apellido: Empleado/a a tiempo completo. Planta transitoria.", empleado.toString());
	}
	
	@Test (expected = Error.class)
	public void crearEmpleadoConApellidoNulo() {
		empleado = new EmpleadoTemporalFullTime("Nombre", null);
		Assert.assertEquals("Nombre null: Empleado/a a tiempo completo. Planta transitoria.", empleado.toString());
	}

}
