public class OrderListLinked <T extends Comparable<T>> extends ListLinked<T> {
	
	public int search(T x) { 
		Node<T> aux = this.first;
		int pos=0;
		while(aux!=null && aux.getData().compareTo(x)<0) { //buscara de forma ascendente
			aux = aux.getNext();
			pos++;
		}
		if(aux !=null)
			if(aux.getData().equals(x))
				return pos;
			else
				return -1;
		return -1;
	}
	public void insert(T x) {
		if(this.isEmptyList() || this.first.getData().compareTo(x)>0)
			this.insertFirst(x);
		else {
			Node <T> aux= this.first;
			while(aux.getNext() !=null && aux.getNext().getData().compareTo(x)<0)
				aux= aux.getNext();
			aux.setNext(new Node<T>(x,aux.getNext()));
			this.count++;
			
		}
	}
	public T removeMin() {
		Node<T> aux = this.first;
		this.first=first.getNext();
		this.count--;
		return aux.getData();
		
	}
	public void actualizar(T x) {
		this.removeNode(x);
		this.insert(x);
	}
}

