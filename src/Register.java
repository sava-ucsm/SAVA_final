
public class Register<E> implements Comparable<Register<E>> {
	protected int key;
	protected E value;
	public Register(int key, E value) {
		super();
		this.key = key;
		this.value = value;
	}
	public Register(int key) {
		this.key = key;
		this.value = null;
	}
	
	public int compareTo(Register<E> r) {
		return this.key - r.key;
	}
	public boolean equals(Object o) {
		if(o instanceof Register) {
			Register<E> r = (Register<E>)o;
			return r.key==this.key;
		}
		return false;
	}
	public int getKey() {return this.key;}
		
	public E getValue() {
		return value;
	}
	public String toString() {
		return this.key+"=>"+this.value.toString();
	}
	
}
