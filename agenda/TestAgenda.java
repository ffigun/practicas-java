package agenda;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestAgenda {
	private final String ln = System.lineSeparator();
	Agenda a;
	String exp;
	
	@Before
	public void inicializarTest() {
		a = new Agenda();
		
		// Nuestro querido Juan Lopez
		a.agregarContacto("Juan", "Lopez", "jlopez@microsoft.com");
		
		// Valor esperado en varias comprobaciones
		exp = "Nombre: Juan" + ln + "Apellido: Lopez" + ln + "Mail: jlopez@microsoft.com";
	}
	
	@Test
	public void NombreInvalidoPorEstarVacio() {
		Assert.assertFalse(a.validarNombre(""));
	}
	
	@Test
	public void NombreInvalidoPorSoloTenerEspacios() {
		Assert.assertFalse(a.validarNombre("  "));
	}
	
	@Test
	public void NombreInvalidoPorSerNulo() {
		Assert.assertFalse(a.validarNombre(null));
	}
	
	@Test
	public void ApellidoInvalidoPorEstarVacio() {
		Assert.assertFalse(a.validarApellido(""));
	}
	
	@Test
	public void ApellidoInvalidoPorSoloTenerEspacios() {
		Assert.assertFalse(a.validarApellido("  "));
	}
	
	@Test
	public void ApellidoInvalidoPorSerNulo() {
		Assert.assertFalse(a.validarApellido(null));
	}

	@Test
	public void MailInvalidoPorEstarVacio() {
		Assert.assertFalse(a.validarMail(""));
	}
	
	@Test
	public void MailInvalidoPorSoloTenerEspacios() {
		Assert.assertFalse(a.validarMail("  "));
	}
	
	@Test
	public void MailInvalidoPorSerNulo() {
		Assert.assertFalse(a.validarMail(null));
	}

	@Test
	public void mailInvalidoPorNoTenerArroba() {
		Assert.assertFalse(a.validarMail("maildominio.com"));
	}
	
	@Test
	public void mailInvalidoPorTenerMasDeUnArroba() {
		Assert.assertFalse(a.validarMail("mail@@dominio.com"));
	}
	
	@Test
	public void mailInvalidoPorNoTenerDominio() {
		Assert.assertFalse(a.validarMail("mail@"));
	}
	
	@Test
	public void mailInvalidoPorNoTenerCuenta() {
		Assert.assertFalse(a.validarMail("@dominio.com"));
	}
	
	@Test
	public void mailInvalidoPorTenerUnEspacioEnElMedio() {
		Assert.assertFalse(a.validarMail("mail@dominio .com"));
	}
	
	@Test
	public void todosLosDatosInvalidos() {
		Assert.assertFalse(a.validarDatos("", null, "mail@@dominio.com"));
	}
	
	@Test
	public void todosLosDatosValidos() {
		Assert.assertTrue(a.validarDatos("Juan", "Lopez", "jlopez@outlook.com"));
	}
	
	@Test
	public void cargarUnArchivoConNombreInvalido() {
		Assert.assertFalse(a.cargarArchivo("???? .t#<"));
	}
	
	@Test
	public void cargarUnArchivoConArgumentoNulo() {
		Assert.assertFalse(a.cargarArchivo(null));
	}
	 
	@Test
	public void guardarUnArchivoConNombreInvalido() {
		Assert.assertFalse(a.guardarAgenda("agen??da.t<>! .txt"));
	}
	
	@Test
	public void guardarUnArchivoConArgumentoNulo() {
		Assert.assertFalse(a.guardarAgenda(null));
	}
	
	@Test
	public void crearUnContactoYMostrarlo() throws ContactoInexistenteEx {
		Assert.assertEquals(exp, a.mostrarContacto("Lopez"));
	}
	
	@Test
	public void crearContactosConMismoApellidoApareceElPrimero() throws ContactoInexistenteEx {
		a.agregarContacto("Marisa", "Lopez", "mlopez@microsoft.com");
		a.agregarContacto("Camila", "Lopez", "clopez@microsoft.com");
		
		Assert.assertEquals(exp, a.mostrarContacto("Lopez"));
	}

	@Test
	public void borrarContactoExistente() throws ContactoInexistenteEx {
		a.borrarContacto("Lopez");
	}
	
	@Test (expected = ContactoInexistenteEx.class)
	public void borrarContactoInexistente() throws ContactoInexistenteEx {
		a.borrarContacto("Apellido Inexistente");
	}
}
