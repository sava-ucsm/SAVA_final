
public class Edge{
	private Punto_mapa refDest;
	private int weight;
	private String label;
	private String color;
	public Edge(Punto_mapa refDest) {
		this(refDest,-1);
	}
	public Edge(Punto_mapa refDest, int weight) {
		this.refDest= refDest;
		this.weight= weight;
	}
	
	
	public String getColor() {return color;}
	public void setColor(String color) {this.color = color;}
	public String getLabel() {return this.label;}
	public void setLabel(String label) {this.label=label;}
	public void setWeight(int weight) {this.weight=weight;}
	public int getWeight() {return this.weight;}
	public Punto_mapa opposite() {return this.refDest;}
	
	public boolean equals(Object o) {
		if(o instanceof Edge) {
			Edge e= (Edge) o;
			return this.refDest.equals(e.refDest);
		}
		return false;
	}
	public String toString() {
		if (this.weight > -1) return refDest.getData()+" ["+this.weight+this.color+"]";
		else return refDest.getData().toString();
	}
}
