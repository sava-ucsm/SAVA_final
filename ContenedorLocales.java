import java.util.Arrays;

public class ContenedorLocales {
	private HashC<Local> contenedor;
	
	public ContenedorLocales() {
		this.contenedor=new HashC<Local>(20);
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
		String[][] data = new String[contenedor.m][5];
		int i=0;
		int j=0;
		Node<String> aux=contenedor.dataString().getFirst();
		while(aux!=null) {
				j=0;
				String []splitStr=aux.getData().split(",");

				data[i][j++]=splitStr[0];
				data[i][j++]=splitStr[1];
				data[i][j++]=splitStr[2];
				data[i][j++]=splitStr[3];
				data[i][j++]=splitStr[4];
				i++;
				aux=aux.getNext();
		}
		listaLocales();
		return data;
	}
	public ListLinked<Local> listaLocales() {
		return contenedor.listData();
	}
	@Override
	public String toString() {
		return this.contenedor.toString();
	}
	
}
