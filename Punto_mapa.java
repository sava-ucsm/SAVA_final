
public class Punto_mapa implements Comparable<Punto_mapa>{
	String dir;
	private int x;
	private int  y;

	private String label;
	private float dist;
	private Punto_mapa path;
	protected ListLinked<Edge> listAdj;
	public Punto_mapa(String dir) {
		this.dir=dir;
		this.listAdj= new ListLinked<Edge>();
		this.path =null;
	}
	public Punto_mapa(String dir, int x, int y) {
		this.dir=dir;
		this.listAdj= new ListLinked<Edge>();
		this.x=x;
		this.y=y;
	}
	public String getData() {return dir;}
	
	public Punto_mapa getPath() {return path;}
	public void setPath(Punto_mapa path) {this.path = path;}
	
	public String getLabel() {return this.label;}
	public void setLabel(String label) {this.label=label;}
	
	public void setDist(float dist) {this.dist=dist;}
	public float getDist() {return this.dist;}
	
	public int getX() {	return x;}
	public int getY() {	return y;}
	

	
	public boolean equals(Object o) {
		if(o instanceof Punto_mapa) {
			Punto_mapa v=(Punto_mapa)o;
			return this.dir.equals(v.dir);
		}
		return false;
	}
	
	public String toString() {
		return this.dir+" \t--> "+this.dist+"{ "+this.x+","+this.y+"};\n";
	}
//this.listAdj.toString()+
	@Override
	public int compareTo(Punto_mapa o) {
		if(this.dist<o.dist) return -1;
		else if(this.dist>o.dist) return 1;
		else return 0;
	}
	
}
