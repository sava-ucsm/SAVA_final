

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
		String[][] str=new String[10][5];
		int i=0;
		for(String[] item:contenedor.dataString()) {
			if(item[0]!=null) {
				str[i]=item;
				i++;
			}
		}
		return str;
	}
	@Override
	public String toString() {
		return this.contenedor.toString();
	}
	
}
