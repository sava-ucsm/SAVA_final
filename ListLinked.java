
public class ListLinked<T extends Comparable<T>> implements TDAList<T> {
	private Node<T> first;
	private int count;
	
	public ListLinked() {
		this.first = null;
		this.count = 0;
	}
	public boolean isEmptyList() {
		return this.first == null;
	}
	
	public int length() {
		return this.count;
	}
	
	public void destroyList() {
		while(this.first!=null) {
			this.first = this.first.getNext();
		}
	}
	public int search(T x) {
		Node <T> aux = this.first;
		for(int i = 0;aux != null;aux = aux.getNext(),i++)
			if(aux.getData().equals(x))
				return i;				
		return -1;
	}
	
	public T searchT(T x) {
		Node<T> aux = this.first;
		for(int i=0;aux != null; aux=aux.getNext(),i++)
			if(aux.getData().equals(x))
				return aux.getData();
		return null;
		
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
	
	//Precondiciom : Lista no debe estar vacia
	private Node<T> getLastNode(){
		Node<T> aux = this.first;
		while(aux.getNext()!=null) 
			aux=aux.getNext();		
		return aux;
	}
	public void insertFirst(T x) {
		
		this.first = new Node<T>(x,this.first);
		this.count++;
	}
	public void remove(T x) {
		
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

	public Node<T> getFirst() {
		return first;
	}
	public void setFirst(Node<T> first) {
		this.first = first;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	@Override
	public String toString() {
		
		String str="";
		Node<T> aux=this.first;
		for(int i = 0;aux!=null;aux = aux.getNext(),i++) {
			str += "["+ i + "]" + "\t" + aux.getData()+"\n";
		}
		
		return str;
	}
	
}