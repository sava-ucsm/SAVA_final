
public class OrderListLinked<T extends Comparable<T>> extends ListLinked<T> {
	
	
	public OrderListLinked() {
		super();
		
	}
	public int search(T x) {
		Node<T> aux = this.getFirst();
		int contador= 0;
		while(aux != null && aux.getData().compareTo(x) < 0) {
			aux = aux.getNext();
			contador++;//Contador se incrementa hasta encontrar el elemento buscado 
		}
		
		if(aux!=null) {
			if (aux.getData().equals(x))  return contador;//Retorna la posicion del elemento
			return -1;//Si no lo encuentre devuelve -1
		}	
		return -1;
	}
	public void insertLast(T x) {
		Node<T> aux = this.getFirst();
		Node<T> temp = null;
		
		if(this.isEmptyList()) {
			this.insertFirst(x);
			
		}else if(aux.getData().compareTo(x) > 0) {//Inserta el elemento al comienzo si es menor al primer elemento de la lista enlazada
			this.insertFirst(x);
		}else {
			while(aux != null && aux.getData().compareTo(x) < 0) {
				temp = aux;//Elemento menor a x
				aux = aux.getNext();//Elemento mayor a x
			}
			if(aux != null && (temp.getData().compareTo(x) < 0 && aux.getData().compareTo(x)>0))
				temp.setNext(new Node<T>(x,aux));//Insertamos el elemento entre su menor y su mayor de acuerdo al orden de la lista
			
			if(temp.getData().compareTo(x) < 0 && aux==null)//Para insertar el elemento al final de la lista
				temp.setNext(new Node<T>(x));
			this.setCount(this.getCount()+1);
		}
	}
	public void remove(T x) {
		Node<T> aux = this.getFirst();
		Node<T> temp = null;
		
		if(this.getFirst().getData().equals(x)) {
			temp = this.getFirst();
			this.setFirst(this.getFirst().getNext());
			temp = null;
		}else {
			while(aux.getNext()!=null && (aux.getNext().getData().compareTo(x)<0))
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
}
