
public class PersonalSalud  extends Persona implements Comparable<PersonalSalud>{

	private int idPersonal;			//crear por defecto cada vez que un personal salud
	private String especialidad;
	private String usuario;			//por defecto
	private String password;		//por defecto 
	
	public PersonalSalud(String nombre, String apellido, String dni, String especialidad) {
		super(nombre, apellido, dni);
		this.idPersonal = idPersonal;				// autogenerado
		this.especialidad = especialidad;
		// this.usuario = usuario;					// autogenerado
		// this.password = password;				// autogenerado
	}
	public PersonalSalud() {
	}
	public int getIdPersonal() {
		return idPersonal;
	}
	public void setIdPersonal(int idPersonal) {
		this.idPersonal = idPersonal;
	}
	public String getEspecialidad() {
		return especialidad;
	}
	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
 //falta compare to
	public int compareTo(PersonalSalud p) {
		return this.idPersonal-p.getIdPersonal();
	}
	//equals comparando id personal 
	public boolean equals( Object b) {
		if ( !( b instanceof PersonalSalud))
			return false;
		PersonalSalud p = (PersonalSalud) b;
		return this.idPersonal==p.idPersonal && this.dni == p.dni;
	}
	@Override
	public String toString() {
		return "PersonalSalud [idPersonal=" + idPersonal + ", especialidad=" + especialidad + ", usuario=" + usuario
				+ ", " + super.toString() + "]";
	}
	
}
