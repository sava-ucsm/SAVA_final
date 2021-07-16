
public class Register<E> implements Comparable<Register<E>> {
	protected String key;
	protected E value;
	public Register(String key, E value) {
		this.key=key;
		this.value=value;
	}
	public int compareTo(Register<E> r) {
		return this.key.compareTo(r.getKey());
		
	}
	public boolean equals(Object o) {
		if(o instanceof Register) {
			Register<E> r = (Register<E>)o;
			return r.key==this.key;
		}
		return false;
	}
	public String getKey(){return this.key;}
	
	public E getValue(){return this.value;} 
	public String toString() {
		return this.key+":"+this.value.toString();
	}
}
