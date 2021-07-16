import java.math.BigInteger;
import java.util.*;

public class HashA <E extends Comparable<E>>{ 
		
	protected ArrayList<ListLinked<Register<E>>> table;
	protected int espacios;
	protected int primo;
	protected int cantEnLaTabla;
	
	
	public HashA() {
		this.table = new ArrayList<ListLinked<Register<E>>>(espacios);
		for(int i=0;i<espacios;i++) {
			this.table.add(new ListLinked<Register<E>>());
		}
		this.espacios = 13;
		this.primo = 11;
	}
	
	private int functionHash(int auxIntKey) {
		return auxIntKey % primo;
		
	}
	
	private int wordAscci(String abc) {
		String str = abc;  
	    StringBuilder sb = new StringBuilder();
	    for (char c : str.toCharArray())
	    sb.append((int)c);
	    BigInteger mInt = new BigInteger(sb.toString());
	    int auxIntKey = mInt.intValue();
	    return auxIntKey;
	}
	
	private boolean repetido(int dressHash, String key) {
		
		if(table.get(dressHash).searchT(new Register<E>(key,null))==null) {
			return false;
		}
		else
			return true;
	}
	
	
	public void insert(String key, E reg) {
		int auxKey;
		auxKey  = wordAscci(key);
		int dressHash = functionHash(auxKey);
		if(this.repetido(dressHash, key)) {
			System.out.println("key "+ key+" is duplicated... ");
			return;
		}
		else {
			Register aux = new Register<E> (key, reg);
			table.get(dressHash).insertLast(aux);
			cantEnLaTabla++;
			
		}
		
	}
	
	public E search(String key) {
		int auxKey;
		auxKey  = wordAscci(key);
		int dressHash = functionHash(auxKey);
		Register<E> aux= table.get(dressHash).searchT(new Register<E>(key,null));
		if(aux!=null)
			return (E) aux.getValue();
		else 
			return null;
	}
	
	public void delete(String key)	{
		int auxKey;
		auxKey  = wordAscci(key);
		int dressHash = functionHash(auxKey);
		table.get(dressHash).removeNode(new Register<E>(key,null));
	}
	
	public String toString() {
		String s="dir.Hash  Area de rebalse \n";
		int i=0;
		for(ListLinked<Register<E>> item : table) {
			s+=(i++)+"-->\t  ";
			s+= item.toString()+"\n";
		}
		return s;
	}
}

