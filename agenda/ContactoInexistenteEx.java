package agenda;

public class ContactoInexistenteEx extends Exception{

	private static final long serialVersionUID = 1L;

	public ContactoInexistenteEx(String apellido) {
		super(apellido);
		System.out.println("No existe ningun contacto de apellido <" + apellido + ">.");
	}

}
