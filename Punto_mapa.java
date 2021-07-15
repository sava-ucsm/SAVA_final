
public class Punto_mapa implements Comparable<Punto_mapa>{
	String dir;
	private int x;
	private int  y;
	
	private String label;
	private int dist;
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
	
	public void setDist(int dist) {this.dist=dist;}
	public int getDist() {return this.dist;}
	
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
		return this.dir+" \t--> "+this.listAdj.toString()+"; "+this.dist+"; "+"\n";
	}

	@Override
	public int compareTo(Punto_mapa o) {
		return this.dist-o.dist;
	}
	
}
