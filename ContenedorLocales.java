

public class ContenedorLocales {
	private HashC<Local> contenedor;
	
	public ContenedorLocales() {
		this.contenedor=new HashC<Local>(10);
	}
	
	public void registrarNuevoLocal(int key,Local l) {
		this.contenedor.insert(key, l);
	}
	
	public Local getLocal(int key) {
		Local l=this.contenedor.searchRegister(key);
		if(l!=null) {
			return l;
		}else {
			return null;
		}
	}
	public String[][] localesString() {
		return contenedor.dataString();
	}
	@Override
	public String toString() {
		return this.contenedor.toString();
	}
	
}
