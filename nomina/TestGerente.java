package nomina;

import org.junit.Assert;
import org.junit.Test;

public class TestGerente {
	// Gerente permanente con conyuge, un hijo y 10 anios de antiguedad
	private Empleado empleado = new Gerente("Nombre", "Apellido", true, 1, 10);
	
	@Test
	public void verificarSueldoCon10AniosDeAntiguedad() {
		// 1000 + 100 + 1x200 + 10x100 + 2000 = 4300 UR
		Assert.assertEquals(4300, empleado.liquidarSueldo());
	}

	@Test
	public void verificarSueldoCon30AniosDeAntiguedad() {
		// 1000 + 100 + 1x200 + 2000 + 2000 = 5300 UR
		empleado = new Gerente("Nombre", "Apellido", true, 1, 30);
		Assert.assertEquals(5300, empleado.liquidarSueldo());
	}
	
	@Test
	public void verificarFormatoDeCadenaDeCaracteres() {
		Assert.assertEquals("Nombre Apellido: Gerente. Planta permanente.", empleado.toString());
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
		empleado = new Gerente("Nombre", "Apellido", true, -2, 10);
		Assert.assertFalse(empleado.validarInformacion());
	}
	
	@Test (expected = Error.class)
	public void crearEmpleadoConAntiguedadNegativa() {
		empleado = new Gerente("Nombre", "Apellido", true, 1, -14);
		Assert.assertFalse(empleado.validarInformacion());
	}
	
	@Test (expected = Error.class)
	public void crearGerenteConNombreVacio() {
		empleado = new Gerente("", "Apellido");
		Assert.assertEquals(" Apellido: Gerente. Planta permanente.", empleado.toString());
	}
	
	@Test (expected = Error.class)
	public void crearGerenteConApellidoVacio() {
		empleado = new Gerente("Nombre", "");
		Assert.assertEquals("Nombre : Gerente. Planta permanente.", empleado.toString());
	}
	
	@Test (expected = Error.class)
	public void crearGerenteConNombreNulo() {
		empleado = new Gerente(null, "Apellido");
		Assert.assertEquals("null Apellido: Gerente. Planta permanente.", empleado.toString());
	}
	
	@Test (expected = Error.class)
	public void crearGerenteoConApellidoNulo() {
		empleado = new Gerente("Nombre", null);
		Assert.assertEquals("Nombre null: Gerente. Planta permanente.", empleado.toString());
	}
	
}
