
public class Usuario implements Comparable<Usuario>{
	private String keyUsuario;
	private String contrasena;
	private String tipy;

		
	public Usuario(String keyUsuario,String  contra ,String type ) {
		this.keyUsuario = keyUsuario;
		this.contrasena = contra;
		this.tipy = type;
	}
		
	public String getKeyUsuario() {		return keyUsuario;	}

	public void setKeyUsuario(String keyUsuario) {		this.keyUsuario = keyUsuario;	}

	public String getContrasena() {		return contrasena;	}

	public void setContrasena(String contrasena) {		this.contrasena = contrasena;	}

	public String getTipy() {		return tipy;	}

	public void setTipy(String tipy) {		this.tipy = tipy;	}

	public int compareTo(Usuario r) {		
		return this.keyUsuario.compareTo(r.getKeyUsuario());
	}
	
	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (contrasena == null) {
			if (other.contrasena != null)
				return false;
		} else if (!contrasena.equals(other.contrasena))
			return false;
		if (keyUsuario == null) {
			if (other.keyUsuario != null)
				return false;
		} else if (!keyUsuario.equals(other.keyUsuario))
			return false;
		if (tipy == null) {
			if (other.tipy != null)
				return false;
		} else if (!tipy.equals(other.tipy))
			return false;
		return true;
	}

	public String toString() {
		return this.keyUsuario+":"+this.contrasena + " Range : " +  this.tipy;
	}
	
	
	
}
	
	/*
	  public String validarUsuario(String usuario, String contrasena)
	{
		if(usuario.equals("Pablo") & contrasena.equals("Pablo123")) 
		{
			String a = ("Acceso permitido " + usuario);
		return a;
		}
		else {
			String b = "Acceso denegado";
		return b;
		}
	}*/

