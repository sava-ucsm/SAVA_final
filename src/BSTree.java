import java.util.ArrayList;
import java.util.List;

public class BSTree<E extends Comparable<E>> {
	class Node{
		protected E data;
		protected Node left,right;

		public Node(E data) {
			this(data,null,null);
		}
		public Node(E data ,Node left, Node right) {
			this.data=data;
			this.left=left;
			this.right=right;
		}
	}
	private Node root;
	
	public BSTree() {
		this.root=null;
	}
	
	public boolean isEmpty() {
		return this.root==null;
	}
	
	// inserta un elemento al arbol
	public void insert(E x)  {
		this.root=insertRec(x, this.root);
	}
	public Node insertRec(E x, Node actual) {
		Node res=actual;
		if(actual==null)
			res=new Node(x);
		else {
			int resC=actual.data.compareTo(x);
			if (resC==0)
				System.out.println("El elemnto "+x+" ya existe en el arbol");
			if (resC<0)
				res.right=insertRec(x,actual.right);
			else 
				res.left=insertRec(x,actual.left);
		}
		return res;
	}
	
	// busca un elemento y retorna su informacion
	public E search(E x) {
		Node res = searchRec(x, this.root);
		if (res==null) {
			return null;
		}
		return res.data;
	}
	protected Node searchRec(E x, Node n){
		if (n == null)
			return null;
		else {
			int resC = n.data.compareTo(x);
			if (resC < 0)
				return searchRec(x, n.right);
			else if (resC > 0)
				return searchRec(x, n.left);
			else
				return n;
		}
	}
	// toString con recorrido InOrden
	public String toString() {
		if (this.root != null)
			return str_inOrden(this.root);
		else
			return "*";
	}
	// devuelve un string
	protected String str_inOrden(Node actual) {
		String res = "";
		if (actual == null)
			res = "";
		else {
			res = res + str_inOrden(actual.left);
			res = res + actual.data.toString() + " ";
			res = res + str_inOrden(actual.right);
		}
		return res;
	}
	
	// devuelve una lista
	public void list_inOrden(ArrayList<E> lista) {
		if (this.root != null)
			list_inOrden(this.root, lista);
		else
			lista = null;
	}
	protected void list_inOrden(Node actual, ArrayList<E> lista) {
		if (actual != null) {
			list_inOrden(actual.left, lista);
			lista.add(actual.data);
			list_inOrden(actual.right, lista);
		}
	}
	// elimina un elemento del arbol 
	public void remove( E x)  {
		this.root = removeRec(x, this.root);
	}
	public Node removeRec( E x, Node actual)  {
		Node res = actual;
		if (actual == null)
			System.out.println(x + "no esta");
		int resC = actual.data.compareTo(x); 
		if (resC < 0)
			res.right = removeRec(x, actual.right);
		else if (resC > 0)
			res.left = removeRec(x, actual.left);
		else if (actual.left != null && actual.right != null) {		// dos hijos
			res.data = minRecover(actual.right);
			res.right = minRemove(actual.right);
		}else {
			res = (actual.left != null) ? actual.left : actual.right;
		}
		return res;
	}
	
	public E minRemove() {
		E min = minRecover();		// recuperar menor del arbol
		this.root = minRemove(this.root);
		return min;
	}
	protected Node minRemove( Node actual){
		if (actual.left != null) {			// buscamos el minimo
			actual.left = minRemove(actual.left);
		}else{
			actual = actual.right;
		}
		return actual;
	}
	// obtenemos el minimo valor
	public E minRecover() {
		return minRecover(this.root);
	}
	protected E minRecover( Node actual){
		E res;
		if (actual.left != null) {			// buscamos el minimo
			res = minRecover(actual.left);
		}else{
			res = actual.data;
		}
		return res;
	}
	
	// recorrido InOrden
	public void inOrden() {
		if (this.root != null)
			inOrden(this.root);
	}
	protected void inOrden(Node actual) {
		if (actual == null)
			return;
		else {
			inOrden(actual.left);
			System.out.print(actual.data.toString() + " ");
			inOrden(actual.right);
		}
	}
}
