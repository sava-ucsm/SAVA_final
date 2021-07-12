public class Local implements Comparable<Local> {
    private Direccion direccion;
    private String nombre;
    private Inventario almacen;
    private  ListLinked<PersonalSalud> personal;
    private GestionPacientes gp;
    
	public Local(Direccion d,String nombre){
    	gp= new GestionPacientes();
        this.direccion = d;
        this.nombre = nombre;
        this.almacen = new Inventario();
        this.personal = new OrderListLinked<PersonalSalud>();
        Vacuna vac1 = new Vacuna("Fizer", 15000 ,  3 ,75 , 3 );
		Vacuna vac2 = new Vacuna("cura", 150 ,  3 ,75 , 9 );
		Vacuna vac3 = new Vacuna("RC", 1500000 ,  1 ,75 , 2 );
		almacen.insertarVacuna(vac1);
		almacen.insertarVacuna(vac2);
		almacen.insertarVacuna(vac3);
    }
	//////////////////////////////////////////
	public int compareTo(Local l) {
		return l.nombre.compareTo(this.nombre);
	}
	/////////////////////////////////////////
    public void agregarPersonal(PersonalSalud p){

        personal.insertLast(p);
    }

    public void eliminarPersonal(int codigo){
        PersonalSalud p = findByCode(codigo);
        if(p != null)
            personal.remove(p);
        else
            System.out.println("Personal not found...");
    }
    public void mostrarPersonal(){
        System.out.println(personal);
    }
    public Inventario getInventario(){
        return this.almacen;
    }
    public String getNombre(){
        return this.nombre;
    }
    public Direccion getDireccion(){
        return this.direccion;
    }
    public boolean buscarPersonal(PersonalSalud p) {
    	  if(this.personal.search(p)==-1) return false;
          else return true;
    }
    public PersonalSalud getPersonal(int codigo){
        PersonalSalud p = findByCode(codigo);
        System.out.println(this.personal.search(p));
        return null;
    }
    private PersonalSalud findByCode(int codigo){
        Node<PersonalSalud> aux = personal.getFirst();
        for(;aux != null;aux = aux.getNext())
            if(aux.getData().getIdPersonal()==codigo)
                return aux.getData();
        return null;
    }
    public  int getPersonalTotal() {
        return personal.getCount();
    }
    public int validarPersonal(PersonalSalud p){
            return personal.search(p);
    }
    public GestionPacientes getGestionPacientes() {
		return gp;
	}
	@Override
	public String toString() {
		return "Direccion: " + direccion + ", nombre: " + nombre;
	}
    
}
