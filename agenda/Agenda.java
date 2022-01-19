package agenda;

import java.util.ArrayList;
import java.util.Iterator;
import java.io.*;

public class Agenda {	
	private ArrayList<Persona> contactos;

	public Agenda() {
		contactos = new ArrayList<Persona>();
	}

	/**
	 * Agrega un contacto a la agenda.
	 * @param pNombre Nombre del contacto a agregar.
	 * @param pApellido Apellido del contacto a agregar.
	 * @param pMail Mail del contacto a agregar.
	 */
	public void agregarContacto(String pNombre, String pApellido, String pMail) {

		Persona contacto = new Persona(pNombre, pApellido, pMail);
		contactos.add(contacto);
	}

	/**
	 * Borra un contacto de la agenda.
	 * @param pApellido Apellido del contacto a borrar.
	 * @throws ContactoInexistenteEx si no se encuentra el apellido buscado.
	 */
	public void borrarContacto(String pApellido) throws ContactoInexistenteEx {
		int indice;

		indice = this.buscarContacto(pApellido);
		contactos.remove(indice);
	}

	/**
	 * Busca un contacto por apellido.
	 * @param pApellido apellido del contacto buscado.
	 * @return devuelve la primera aparicion del apellido buscado.
	 * @throws ContactoInexistenteEx si no existe ningun contacto con el apellido buscado.
	 */
	private int buscarContacto(String pApellido) throws ContactoInexistenteEx {
		int i = 0;
		for (Persona contacto: contactos) {
			if (contacto.getApellido().equals(pApellido)) {
				return i;
			}
			i++;
		}

		throw new ContactoInexistenteEx(pApellido);
	}

	/**
	 * Muestra por pantalla todos los contactos de la Agenda
	 * Nota: no esta bueno que un metodo muestre por pantalla los datos
	 * pero por ahora hasta que tengamos iteradores elegimos hacerlo de esta
	 * manera para no devolver todo el arreglo de contactos.
	 */
	public void mostrarTodosLosContactos() {
		int i = 0;
		for(Persona contacto : contactos) {
			System.out.println(i+":\t"+contacto);
			i++;
		}
		System.out.println("\nTotal: "+i+" contactos\n");
	}

	/**
	 * Borra todos los contactos.
	 */
	public void borrarTodosLosContactos() {
		contactos.removeAll(contactos);
	}

	/**
	 * Muestra un contacto buscandolo por apellido.
	 * @param pApellido apellido del contacto buscado.
	 * @return devuelve los datos de la primera aparicion del apellido buscado.
	 * @throws ContactoInexistenteEx si no existe ningun contacto con el apellido buscado.
	 */
	public String mostrarContacto(String pApellido) throws ContactoInexistenteEx {
		int indice;

		indice = this.buscarContacto(pApellido);
		
		return "Nombre: " + contactos.get(indice).getNombre() + System.lineSeparator() +
				"Apellido: " + contactos.get(indice).getApellido() + System.lineSeparator() +
				"Mail: " + contactos.get(indice).getMail();
	}

	/**
	 * Carga todos los contactos que puede en la agenda.
	 * El formato del archivo de entrada es el siguiente:
	 * Una linea por cada contacto, y en cada linea separado por coma
	 * y etiquetados los datos del contacto. Ej
	 * nombre: Juan, apellido: Perez, mail: jperez@gmail.com
	 * @param pArchivo nombre del archivo (path absoluto o
	 * relativo a la carpeta src del proyecto
	 */
	public boolean cargarArchivo(String pArchivo){
		FileReader input = null;
		BufferedReader buffer = null;
		boolean cargadoOk = true;

		try {
			input = new FileReader(pArchivo);
			buffer = new BufferedReader(input);

			String linea = buffer.readLine();

			while (linea != null) {
				agregarContactoDesdeLineaSerializada(linea);
				linea = buffer.readLine();
			}

		} catch(FileNotFoundException e) {
			System.out.println("Error al leer el archivo. El archivo especificado no existe o no se tiene acceso a el.");
			cargadoOk = false;

		} catch (NullPointerException e) {
			System.out.println("Error al leer el archivo. Se esperaba un objeto pero no se recibio ninguno.");
			cargadoOk = false;

		} catch (IOException e) {
			System.out.println("Ocurrio un error de E/S mientras se intentaba abrir el archivo.");
			cargadoOk = false;

		} finally {
			try {
				if (buffer != null) {
					buffer.close();
				}
			} catch (IOException e) {
				System.out.println("Ocurrio un error de E/S mientras se intentaba cerrar el archivo.");
				cargadoOk = false;
			}
		}
		return cargadoOk;
	}

	/**
	 * Guarda la agenda completa en disco, en el archivo especificado como parametro
	 * Con el siguiente formato. Una linea por contacto, con los 
	 * datos etiquetados.
	 * nombre: Juan, apellido: Perez, mail: jperez@gmail.com
	 * @param pArchivo nombre del archivo (path absoluto o relativo
	 * a la carpeta src del proyecto
	 */
	public boolean guardarAgenda(String pArchivo) {
		Iterator<Persona> iPersona = contactos.listIterator();
		FileWriter salida = null;
		boolean guardadoOk = true;

		try {
			salida = new FileWriter(pArchivo);

			while(iPersona.hasNext()) {
				salida.write(serializar(iPersona.next()) + System.lineSeparator());
			}

		} catch (IOException e){
			System.out.println("Ocurrio un error de E/S mientras se intentaba escribir el archivo.");
			guardadoOk = false;

		} catch (NullPointerException e) {
			System.out.println("Error al guardar el archivo. Se esperaba un objeto pero no se recibio ninguno.");
			guardadoOk = false;

		} finally {
			try {
				if (salida != null) {
					salida.close();
				}
			} catch (IOException e) {
				System.out.println("Ocurrio un error de E/S mientras se intentaba cerrar el archivo.");
				guardadoOk = false;
			}
		}
		return guardadoOk;
	}

	/**
	 * Verifica que la informacion extraida de un contacto es valida.
	 * @param nombre Nombre del contacto
	 * @param apellido Apellido del contacto
	 * @param mail Mail del contacto
	 * @return devuelve verdadero si se cumple que todos los datos son validos.
	 */
	protected boolean validarDatos(String nombre, String apellido, String mail) {
		return (validarNombre(nombre) && validarApellido(apellido) && validarMail(mail));
	}
	
	/**
	 * Valida un nombre.
	 * @param nombre Nombre a validar.
	 * @return Devuelve verdadero si el nombre no es nulo ni esta vacio.
	 */
	protected boolean validarNombre(String nombre) {
		return (nombre != null) && !(nombre.isBlank());
	}
	
	/**
	 * Valida un apellido.
	 * @param apellido Apellido a validar.
	 * @return Devuelve verdadero si el apellido no es nulo ni esta vacio.
	 */
	protected boolean validarApellido(String apellido) {
		return (apellido != null) && !(apellido.isBlank());
	}
	
	/**
	 * Valida un mail.
	 * @param mail Mail a validar.
	 * @return Devuelve verdadero si el mail no es nulo ni esta vacio,
	 * si no contiene espacios, si solo contiene 1 caracter arroba y
	 * contiene al menos 1 caracter punto en su dominio.
	 */
	protected boolean validarMail(String mail) {
		if (mail == null || mail.isBlank())	return false;
		if (mail.contains(" ")) 			return false;

		String[] aux = mail.split("@");
		
		// Si hay solo 1 arroba, el mail tendra 2 partes
		if (aux.length == 2) {
			if (aux[0].isBlank()) 			return false;
			if (aux[1].isBlank()) 			return false;
			if (!aux[1].contains("."))		return false;
		} else {
			return false;
		}
		
		return true;
	}

	/**
	 * Extrae el dato que contiene un determinado campo.
	 * @param datos Una linea de la lista de contactos ya separada mediante split.
	 * @param campo El campo del que se obtendra el dato solicitado.
	 * @return Devuelve el dato de un 'campoABuscar', o null si no existe el campo.
	 * Nota: Este metodo no valida si el dato esta vacio.
	 */
	private String obtenerDato(String[] datos, String campoABuscar) {
		for(String  campo: datos) {
			String aux = campo.replaceAll("\\s", "").toLowerCase();		// Para comparar sin espacios y en minusculas

			if (aux.contains(campoABuscar + ":")) {
				String[] datosExtraidos = campo.split(":");

				// Se devuelve siempre el dato que le sigue al campo y se descartan los demas
				if(datosExtraidos.length > 1) return datosExtraidos[1].trim();
			}
		}

		return null;
	}

	/**
	 * Cuenta la cantidad de ocurrencias de un campo en una linea.
	 * @param datos Una linea de la lista de contactos ya separada mediante split.
	 * @param campoABuscar El campo que se desea buscar en la cadena de texto.
	 * @return Devuelve la cantidad de ocurrencias de 'campoABuscar' en 'linea'.
	 */
	private boolean validarUnicidadDeCampos(String[] datos) {
		int ocurrenciasNombre = 0;
		int ocurrenciasApellido = 0;
		int ocurrenciasMail = 0;

		for (String campo: datos) {
			String aux = campo.replaceAll("\\s", "").toLowerCase();		// Para comparar sin espacios y en minusculas

			if(aux.contains("nombre:"))		ocurrenciasNombre++;
			if(aux.contains("apellido:"))	ocurrenciasApellido++;
			if(aux.contains("mail:"))		ocurrenciasMail++;
		}

		return (ocurrenciasNombre == 1) && (ocurrenciasApellido == 1) && (ocurrenciasMail == 1);
	}

	/**
	 * Prepara una linea para escribir en un archivo de texto plano.
	 * @param p Es la persona cuyos datos se desea convertir a linea
	 * @return Devuelve un String formateado para guardar.
	 */
	private String serializar(Persona p) {
		return	"nombre: " + p.getNombre() + ", " +
				"apellido: " + p.getApellido() + ", " +
				"mail: " + p.getMail();
	}

	/**
	 * Valida los datos y agrega un contacto desde la linea de un archivo.
	 * @param linea La linea de datos de un archivo que contenga contactos.
	 */
	private void agregarContactoDesdeLineaSerializada(String linea) {
		String [] datos = linea.split(",");

		if (validarUnicidadDeCampos(datos)) {
			String nombre = obtenerDato(datos, "nombre");
			String apellido = obtenerDato(datos, "apellido");
			String mail = obtenerDato(datos, "mail");

			if (validarDatos(nombre, apellido, mail)) {
				agregarContacto(nombre, apellido, mail);
			}
		}
	}

}