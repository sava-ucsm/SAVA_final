
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
	public T searchData(T x) {
		Node <T> aux = this.first;
		for(int i = 0;aux != null;aux = aux.getNext(),i++)
			if(aux.getData().equals(x))
				return aux.getData();				
		return null;
	}
	public void insertLast(T x) {
		
		if(this.isEmptyList()) {
			this.insertFirst(x);
		}else {
			Node<T> last = getLastNode();
			last.setNext(new Node<T>(x));
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
		
		Node<T> aux = this.first;
		Node<T> temp = null;
		
		if(this.first.getData().equals(x)) {
			temp = this.first;
			this.first = this.first.getNext();
			temp = null;
		}else {
			while(aux.getNext()!=null && (!aux.getNext().getData().equals(x)))
				aux = aux.getNext();
			
			if(aux.getNext()==null)
				System.out.println("No se encontro el elemento");
			else {
			temp = aux.getNext();
			aux.setNext(temp.getNext());
			temp = null;
			}
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
			str += aux.getData()+"->";
		}
		
		return str;
	}
	
}
