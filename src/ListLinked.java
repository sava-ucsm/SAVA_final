public class ListLinked <T>{
	
	
	protected Node <T> first;
	protected int count;
	public ListLinked() {
		this.first=null;
	}
	public boolean isEmptyList() {
		if(this.first==null) {
			return true;
		}
		return false;
	}
	public int length() {
		return this.count;
	}
	public void destroyList() {
		while(this.first !=null)
			this.first= this.first.getNext();
		this.count=0;
		
	}
	public int search(T x) {
		Node<T> aux = this.first;
		for(int i=0;aux != null; aux=aux.getNext(),i++)
			if(aux.getData().equals(x))
				return i;
		return -1;
		
	}
	public T searchIndex(int n) { //retorna el elemento segun su posicion en la lista enlazada
		Node<T> aux = this.first;
		for(int i=0;aux != null; aux=aux.getNext(),i++)
			if(i==n)
				return aux.getData();
		return null;
		
	}
	
	public T searchData(T data) {
		Node<T> nodo = this.first;
		while(nodo !=null && !nodo.getData().equals(data))
			nodo=nodo.getNext();
		if(nodo !=null)
			return nodo.getData();
		return null;
	}
	public void insertFirst(T x){
		Node<T> nuevo= new Node<T>(x); 
		nuevo.setNext(this.first);
		this.first= nuevo;
		this.count++;
	}
	public void insertLast(T x) {
		if(this.isEmptyList())
			this.insertFirst(x);
		else {
			Node<T> lastNode = this.getLastNode();
			lastNode.setNext(new Node<T> (x));
			this.count++;
		}
	}
	public Node<T> getFirst() {
		return first;
	}
	public int getCount() {
		return count;
	}
	private Node<T> getLastNode(){
		Node<T> aux = this.first;
		while(aux.getNext()!=null)
			aux=aux.getNext();
		return aux;
	}

	public void removeNode(T x) {
		if(this.isEmptyList())
			System.out.println("Lista vacia");
		else if(this.first.getData().equals(x)){
			this.first= first.getNext();
			this.count--;
		}
		else {
			
			Node <T> nodoAnte=this.first;// guardara el nodo anterior a el nodo a eliminar
			Node <T> aux= nodoAnte.getNext();
			while(aux.getNext() !=null && !(aux.getData().equals(x))) {
				nodoAnte= nodoAnte.getNext();
				aux= aux.getNext();
			}
			nodoAnte.setNext(aux.getNext());
			this.count--;
			
		}
		
	}
	@Override
	
	public String toString() {
		String cadena="[";
		Node <T> nodo=this.first;
		int i =0;
		while (nodo!=null){
			cadena+= nodo.getData();
			nodo=nodo.getNext();
			i++;
			if(i !=count) {
				cadena+= ",";
			}
			
		}
		cadena+= "]";
		return cadena;
	}
	
	
}
