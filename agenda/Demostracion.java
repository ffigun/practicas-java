package demo;
import agenda.*;

public class Demostracion {

	public static void main(String[] args) {

		/**
		 * Pruebas sugeridas para probar las funcionalidades:
		 *
		 * Se recomienda:
		 * 	+ Maximizar la ventana de la consola
		 * 	+ Leer previamente el archivo datos/datos.txt
		 * 	+ Seguir el orden de pasos sugerido
		 * 
		 * a. Agregar y mostrar contacto
 		 * 		Usar la opcion 3 para agregar un nuevo contacto
		 * 		Usar la opcion 5 para verificar que se haya cargado
		 * 
		 * b. Cargar archivo y mostrar agenda
		 * 		Usar la opcion 1 para cargar el archivo datos/datos.txt
		 * 		Usar la opcion 6 para verificar que se hayan cargado
		 * 
		 * c. Borrar contacto
		 * 		Usar la opcion 4 para borrar un contacto a eleccion
		 * 		Usar la opcion 6 para verificar que se haya borrado
		 * 
		 * d. Guardar archivo
		 * 		Usar la opcion 2 para guardar el archivo datos/agenda.txt
		 * 	
		 * e. Vaciar agenda
		 *		Usar la opcion 7 para borrar todos los contactos
		 * 		Usar la opcion 6 para verificar que se hayan borrado
		 * 
		 * f. Cargar backup
		 * 		Usar la opcion 1 para cargar el archivo guardado en (d.)
		 *		Usar la opcion 6 para verificar que se haya cargado
		 *
		 * g. Salir
		 * 		Usar la opcion 0 para salir. Es importante salir de esta
		 * 		manera porque asi se cierra correctamente el BufferedReader.
		 */

		SistemaDeAgenda sda = new SistemaDeAgenda();

		sda.iniciar();
	}
}