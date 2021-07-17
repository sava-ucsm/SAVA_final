
public class Vacuna implements Comparable <Vacuna> {
	String marca;
	int efectividad, temperaturaPromedio;
	int cantidad, numDosis;
	Fecha fechaES;

	public Vacuna(String marca, int cantidad,int efectividad, int temperaturaPromedio, int numDosis) {
		super();
		this.marca = marca;
		this.efectividad = efectividad;
		this.cantidad = cantidad;
		this.temperaturaPromedio = temperaturaPromedio;
		this.numDosis = numDosis;
	}
	
	public String getMarca() {		return marca;	}
	public void setMarca(String marca) {	this.marca = marca; 	}
	public int getEfectividad() {	return efectividad; 	}
	public void setEfectividad(int efectividad) { 	this.efectividad = efectividad; 	}
	public int getCantidad() { 	return cantidad;	}
	public void setCantidad(int cantidad) {	this.cantidad = cantidad;	}
	public int getTemperaturaPromedio() {	return temperaturaPromedio; 	}
	public void setTemperaturaPromedio(int temperaturaPromedio) {this.temperaturaPromedio = temperaturaPromedio; }
	public int getNumDosis() {	return numDosis; 	}
	public void setNumDosis(int numDosis) {	this.numDosis = numDosis;	}
		
	public void aumentarStockVacuna(int cant ) {		
		this.cantidad = this.cantidad + cant;
		//fechaES.modificarFechaEntrada();
	}
	
	public void disminuirStockVacuna(int cant) {
		this.cantidad = cantidad - cant;
		if( this.cantidad <= 0) {
			this.cantidad = 0;
			System.out.println("Se agoto el stock de la Vacuna "+ marca);
		}
		/*
		else 
			fechaES.modificarFechaSalida();*/
	}
	
	public int compareTo(Vacuna vac2) {
		int verificador = this.getMarca().compareTo(vac2.getMarca());
		if(verificador >  0) {
			return 1;
		}else {
			if ( verificador <  0)
				return -1;
			return 0;	
		}
	}
	public boolean equals( Object b) {
		if ( !( b instanceof Vacuna))
			return false;
		Vacuna p = (Vacuna) b;
		return this.marca.equals(p.marca);
	}
	
	public String toString() {
		String str="";
		str += String.format("    %-15s %-14d    %-4d                  %-3d                         %-1d\n", this.marca,this.cantidad,this.efectividad,this.temperaturaPromedio, this.numDosis);
		return str;
	}
	
	
}

