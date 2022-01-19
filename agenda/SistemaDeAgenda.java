package agenda;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SistemaDeAgenda {
	private final String ln = System.lineSeparator();	// Separador de linea independiente del sistema operativo
	private BufferedReader br;							// Un unico Scanner para toda la clase
	private Agenda agenda;

	public SistemaDeAgenda() {
		agenda = new Agenda();
		br = new BufferedReader(new InputStreamReader(System.in));
	}

	/**
	 * Punto de entrada para la aplicacion.
	 */
	public void iniciar() {
		menuPrincipal();
	}

	/**
	 * Muestra el menu en un bucle infinito. Cada submenu al terminar
	 * retorna al menu principal hasta que se llame a la opcion Salir.
	 */
	private void menuPrincipal() {
		while (true) {
			System.out.print(
					destacar("Agenda de Contactos") + ln +
					"1. Cargar archivo" + ln +
					"2. Guardar agenda" + ln +
					"3. Agregar contacto" + ln +
					"4. Borrar contacto" + ln +
					"5. Mostrar contacto" + ln +
					"6. Mostrar agenda"+ ln +
					"7. Vaciar agenda" + ln + ln +
					"0. Salir" + ln + ln +
					"Seleccione una opcion:" + ln + ">");


			switch (obtenerEntrada()) {
			case "1":
				cargarArchivo();
				break;
			case "2":
				guardarAgenda();
				break;
			case "3":
				agregarContacto();
				break;
			case "4":
				borrarContacto();
				break;
			case "5":
				mostrarContacto();
				break;
			case "6":
				mostrarAgenda();
				break;
			case "7":
				vaciarAgenda();
				break;
			case "0":
				salir();
			}
		}
	}

	/**
	 * Muestra el submenu para cargar los datos de un archivo de texto.
	 */
	private void cargarArchivo() {
		System.out.print(destacar("Cargar archivo") + ln +
				"(Para volver al menu anterior, ingrese *)" + ln + ln + 
				"Ingrese la ruta del archivo a leer, por ejemplo:" + ln +
				"datos/Agenda.txt" + ln + ln + ">");

		String buffer = obtenerEntrada();

		if (seIngresoElDato(buffer, "*")) return;

		// Intenta cargar el archivo, si hay una excepcion se mostrara en pantalla
		if(agenda.cargarArchivo(buffer)) {
			System.out.print(destacar("El archivo <" + buffer + "> se cargo correctamente."));
		} else {
			System.out.print(destacar("No se pudo cargar el archivo."));
		}

		pausa();
	}

	/**
	 * Muestra el submenu para guardar la agenda en un archivo de texto.
	 */
	private void guardarAgenda() {
		System.out.print(destacar("Guardar agenda") + ln +
				"(Para volver al menu anterior, ingrese *)" + ln + ln + 
				"Ingrese la ruta donde desea guardar la agenda, por ejemplo:" + ln +
				"datos/Agenda.txt" + ln + ln + ">");

		String buffer = obtenerEntrada();

		if (seIngresoElDato(buffer, "*")) return;

		// Intenta guardar el archivo, si hay una excepcion se mostrara en pantalla
		if(agenda.guardarAgenda(buffer)) {
			System.out.print(destacar("El archivo <" + buffer + "> se guardo correctamente."));
		} else {
			System.out.print(destacar("No se pudo guardar el archivo."));
		}

		pausa();
	}

	/**
	 * Muestra el submenu para agregar un nuevo contacto.
	 */
	private void agregarContacto() {
		System.out.print(destacar("Agregar contacto") + ln +
				"(Para volver al menu anterior, ingrese *)" + ln);

		System.out.print(ln + "Ingrese el nombre del contacto:" + ln + ">");
		String nombre = obtenerEntrada();
		if (seIngresoElDato(nombre, "*")) return;
		
		System.out.print(ln + "Ingrese el apellido del contacto:" + ln + ">");
		String apellido = obtenerEntrada();
		if (seIngresoElDato(apellido, "*")) return;

		System.out.print(ln+ "Ingrese el mail del contacto:" + ln + ">");
		String mail = obtenerEntrada();
		if (seIngresoElDato(mail, "*")) return;

		if (agenda.validarDatos(nombre, apellido, mail)) {
			agenda.agregarContacto(nombre, apellido, mail);
			System.out.println(destacar("El contacto se agrego correctamente."));
		} else {
			System.out.println(destacar("No se pudo agregar el contacto."));
			System.out.println("* El nombre ingresado es " + (agenda.validarNombre(nombre)? "valido." : "invalido."));
			System.out.println("* El apellido ingresado es " + (agenda.validarApellido(apellido)? "valido." : "invalido."));
			System.out.println("* El mail ingresado es " + (agenda.validarMail(mail)? "valido." : "invalido."));
			System.out.println(destacar("Verifique los datos ingresados e intente nuevamente."));
		}

		pausa();
	}

	/**
	 * Muestra el submenu para borrar un contacto.
	 */
	private void borrarContacto() {
		System.out.print(destacar("Borrar contacto") + ln +
				"(Para volver al menu anterior, ingrese *)" + ln + ln + 
				"> Solo se borrara la primera aparicion del contacto" + ln +
				"Ingrese el apellido del contacto que desea borrar:" + ln + ">");

		boolean borradoOk = true;

		String buffer = obtenerEntrada();

		if (seIngresoElDato(buffer, "*")) return;

		try {
			agenda.borrarContacto(buffer);

		} catch (ContactoInexistenteEx e) {
			borradoOk = false;

		} finally {
			if (borradoOk) {
				System.out.print(destacar("El contacto " + buffer + " se borro correctamente."));
			} else {
				System.out.print(destacar("No se pudo borrar el contacto."));
			}

			pausa();
		}
	}

	/**
	 * Muestra el submenu para mostrar un contacto.
	 */
	private void mostrarContacto() {
		System.out.print(destacar("Mostrar contacto") + ln +
				"(Para volver al menu anterior, ingrese *)" + ln + ln + 
				"> Solo se mostrara la primera aparicion del contacto" + ln +
				"Ingrese el apellido del contacto que desea mostrar:" + ln + ">");

		String buffer = obtenerEntrada();

		if (seIngresoElDato(buffer, "*")) return;

		try {
			System.out.println(destacar("Datos del contacto " + buffer));
			System.out.print(agenda.mostrarContacto(buffer) + ln);
		} catch (ContactoInexistenteEx e) {
			// No es necesario hacer nada si no existe.
		} finally {
			pausa();
		}
	}

	/**
	 * Muestra el submenu para mostrar los contactos almacenados.
	 */
	private void mostrarAgenda() {
		System.out.print(destacar("Mostrar agenda") + ln);

		agenda.mostrarTodosLosContactos();

		pausa();
	}

	/**
	 * Muestra el submenu para borrar todos los contactos.
	 */
	private void vaciarAgenda() {
		System.out.print(destacar("Vaciar agenda") + ln);

		System.out.print("Se borraran todos los contactos. ¿Esta seguro? [s/*]" + ln + ">");

		String buffer = obtenerEntrada();

		if (seIngresoElDato(buffer, "*")) return;

		if (seIngresoElDato(buffer, "s")) {
			agenda.borrarTodosLosContactos();
			System.out.print(destacar("Todos los contactos fueron borrados."));
		} else {
			System.out.print(destacar("La operacion fue cancelada."));
		}

		pausa();
	}

	/**
	 * Despide al usuario, cierra el Scanner y finaliza la ejecucion con codigo 0 (OK)
	 */
	private void salir() {
		try {
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			System.out.print(destacar("¡Gracias por utilizar esta agenda!"));
			System.exit(0);
		}
	}

	/**
	 * Muestra un cuadro en pantalla.
	 * @param menu Es el texto que aparece en el recuadro.
	 * @return Devuelve en consola un titulo recuadrado.
	 */
	private String destacar(String menu) {
		String s = ln +
				"*------------------------------------------------------" + ln +
				"| " + menu + ln +
				"*------------------------------------------------------";

		return s;
	}

	/**
	 * Comprueba si el usuario escribio una cadena de texto especifica.
	 * @param dato La cadena ingresada por consola.
	 * @return devuelve verdadero si es un asterisco.
	 */
	private boolean seIngresoElDato(String entrada, String dato) {
		return (entrada != null) && (!entrada.isBlank()) && (entrada.trim().equals(dato));
	}

	/**
	 * Lee la entrada de la consola.
	 * @return devuelve el valor leido de la consola.
	 */
	private String obtenerEntrada() {
		String in = "";

		try {
			in = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return in;
	}
	
	/**
	 * Muestra un aviso y espera hasta que se presione Enter.
	 */
	private void pausa() {
		System.out.print(ln + "> Presione Enter para volver al menu principal.");
		obtenerEntrada();
	}
	
}
