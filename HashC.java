import java.util.ArrayList;
import java.util.Iterator;

public class HashC<E extends Comparable<E>> {
	protected class Element{
		int mark;
		Register<E> reg;
		ListLinked<Register<E>> areaRebalse;
		public Element(int mark,Register<E> reg) {
			this.mark=mark;
			this.reg=reg;
			this.areaRebalse=new ListLinked<Register<E>>();
		}
	}
	protected ArrayList<Element> table;
	protected int m;
	
	public HashC(int n) {
		this.m=n;
		this.table=new ArrayList<Element>(m);
		for (int i = 0; i < m; i++) {
			this.table.add(new Element(0, null));
		}
	}
	private int functionHash(int key) {
		return key % m;
	}
	private int hashPorPliegue(int key) {
		String keyString = String.valueOf(key);
		char[] digitos = keyString.toCharArray();
		int sumatoriaKey=0;
		for(int i = 0; i < digitos.length; i++) {
            int aux = Character.getNumericValue(digitos[i]);
            sumatoriaKey+=aux;
        }
		return sumatoriaKey % m;
	}
	private int linearProbing(int dressHash,int key,int action) {
		int posInt = dressHash;
		do {
			if(table.get(dressHash).mark==0)
				return dressHash;
			if(table.get(dressHash).mark==1 && table.get(dressHash).reg.getKey()==key)
				if(action==1)
					return -2;
				if(action==2)
					return table.get(dressHash).reg.getKey();
			dressHash=(dressHash+1) % m;
		}while(dressHash!=posInt);
		return -1;
	}
	private int encadenamiento(int dressHash,int key,E reg) {
		if(table.get(dressHash).mark==1) { 
			if (table.get(dressHash).reg.key==key) {
				return -2;
			}else {
				if(table.get(dressHash).areaRebalse.search(new Register<E>(key,reg))!=-1){
					return -2;//Registro ya insertado
				}else {
					table.get(dressHash).areaRebalse.insertLast(new Register<E>(key,reg));
					return -1;
				}
			}
		} else {
			return dressHash;
		}
	}
	public void insert(int key,E reg) {
		int dressHash = functionHash(key);
		//dressHash = linearProbing(dressHash, key,1);
		dressHash = encadenamiento(dressHash,key,reg);
		if(dressHash==-1) {
			return;
		}
//		else if(dressHash==-2){
//			System.out.println("key is duplicated...");
//			return;
//		}
		else{
			Element aux = new Element(1,new Register<E>(key, reg));
			table.set(dressHash, aux);
		}
	}
	
	public E searchRegister(int key) {
		int dressHash=functionHash(key);
		
		Register<E> aux=table.get(dressHash).reg;
		
		if(table.get(dressHash).mark==1) {
			if(aux.key==key) {
				return aux.value;
			}else if(table.get(dressHash).areaRebalse.search(new Register<E>(key))!=-1){
				return table.get(dressHash).areaRebalse.searchData(new Register<E>(key)).value;
			}else {
				return null;
			}
		}else {
			return null;
		}
	}
	public Element remove(int key) {
		int dressHash = functionHash(key);
		dressHash=linearProbing(dressHash, key,2);
		Element aux = table.get(dressHash);
		aux.mark=0;
		
		return aux;
	}
	
	public ArrayList<Element> getTable() {
		return table;
	}
	public String[][] dataString(){
		String[][] data = new String[10][5];
		int i=0;
		int j=0;
		for(Element item: table) {
			if(item.mark==1) {
				data[i][j++]=item.reg.key+" ";
				String splitStr[]=item.reg.value.toString().split(",");
				data[i][j++]=splitStr[0];//Nombre
				data[i][j++]=splitStr[1];//Direccion
				data[i][j++]=splitStr[2];//Stock de vacunas
				data[i][j++]=splitStr[3];//Cantidad de vacunados
				if(item.areaRebalse!=null) {
					Node<Register<E>> aux=item.areaRebalse.getFirst();
					i++;
					j=0;

					while(aux!=null) {
						data[i][j++]=aux.getData().key+" ";
						String spltStr[]=aux.getData().value.toString().split(",");
						data[i][j++]=spltStr[0];
						data[i][j++]=spltStr[1];
						data[i][j++]=spltStr[2];
						data[i][j++]=spltStr[3];
						aux=aux.getNext();
					}
				}
				i++;
				j=0;
			}
			
		}
		return data;
	}
	public String toString() {
		String s="D.Real\tD.Hash\tRegister\t\t\tArea de rebalse\n";
		int i=0;
		for(Element item: table) {
			s+=(i++) + "-->\t";
			if(item.mark == 1)
				s+=functionHash(item.reg.key) +"\t" + item.reg.toString()+"\t| "+item.areaRebalse.toString()+"\n";
			else
				s+="empty\n";
		}
		return s;
	}
}
