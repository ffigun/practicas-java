package agenda;

public class Persona {
	
	private String nombre;
	private String apellido;
	private String mail;
		
	public Persona(String pNombre, String pApellido, String pMail) {
		setNombre(pNombre);
		setApellido(pApellido);
		setMail(pMail);
	}

	public String getNombre() {
		return this.nombre;
	}
	
	public String getApellido() {
		return this.apellido;
	}
	
	public String getMail() {
		return mail;
	}

	public void setNombre(String pNombre) {
		this.nombre = pNombre;
	}

	public void setApellido(String pApellido) {
		this.apellido = pApellido;
	}
	
	public void setMail(String pMail) {
		this.mail = pMail;
	}
	
	public String toString() {
		
		String resultado = getNombre() + " " +
		getApellido() + " <" + getMail()+">";
		
		return resultado;
	}

}
