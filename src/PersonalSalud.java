
public class PersonalSalud  extends Persona implements Comparable<PersonalSalud>{
			
	private String especialidad;
	private int codUsuario;	//id del personal		
	private String password;		
	private String tipy; //tipo de usuario
	
	public PersonalSalud( String nombre, String apellido, String dni, String especialidad, int codusuario, String password, String tipy) {
		super(nombre, apellido, dni);			
		this.especialidad = especialidad;
		this.codUsuario = codusuario;					
		this.password = password;	
		this.tipy= tipy;
	}
	public PersonalSalud() {
	}
	public String getEspecialidad() {
		return especialidad;
	}
	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}
	public int getUsuario() {
		return codUsuario;
	}
	public void setUsuario(int usuario) {
		this.codUsuario = usuario;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getTipy() {return tipy;	}
	public void setTipy(String tipy) {		this.tipy = tipy;	}
	
    //falta compare to
	public int compareTo(PersonalSalud p) {
		return this.codUsuario-p.getUsuario();
	}
	//equals comparando id personal 
	public boolean equals( Object b) {
		if ( !( b instanceof PersonalSalud))
			return false;
		PersonalSalud p = (PersonalSalud) b;
		return this.codUsuario==p.codUsuario;
	}
	@Override
	public String toString() {
		return "PersonalSalud [idPersonal=" + codUsuario + ", especialidad=" + especialidad + ", " + super.toString() + "]";
	}
	public String validarUsuario(int codUser, String contra) {
		if(this.codUsuario==codUser && this.password.equals(contra)) 
		{
			String a = ("Acceso permitido " + this.nombre);
		return a;
		}
		else {
			String b = "Acceso denegado";
		return b;
		}
	}
	
}
