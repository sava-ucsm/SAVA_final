import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Mapa<E> extends JFrame {
	
	public JLabel label1;
	protected ListLinked<Punto_mapa> listVertex;
	
	
	
	public Mapa() {
		listVertex = new ListLinked<Punto_mapa>();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBounds(0,0,750,750);
		
		
		
		
	}
	public void insertVertex(String dir,int x, int y) {
		Punto_mapa nuevo = new Punto_mapa(dir,x,y);
		if(listVertex.search(nuevo) !=-1) {
			System.out.println("vertex already exist...");
			return;
		}
		listVertex.insertFirst(nuevo);
	}
	public boolean searchVertex(String v) {
		if(this.listVertex.search(new Punto_mapa(v))!=-1) 
			return true;
		else
			return false;
		
	}
	public Edge searchEdgex(Punto_mapa v, Punto_mapa z ) {
		ListLinked<Edge> aux=this.listVertex.searchData(v).listAdj;
		for(int i=0;i<aux.length();i++) {
			if(aux.searchIndex(i).opposite().equals(z)) {
				return aux.searchIndex(i);
			}
		}
		return null;
	}
	
	public void insertEdgeWeight(String verOri, String verDes, int weight) {
		Punto_mapa rOri=listVertex.searchData(new Punto_mapa(verOri));
		Punto_mapa rDes=listVertex.searchData(new Punto_mapa(verDes));
		if(rOri==null || rDes == null) {
			System.out.println("alguna de las vertices(origen, destino) no existe...");
			return;
		}
		if(rOri.listAdj.search(new Edge(rDes))!=-1) { //si la arista ya existe, se inserta el nuevo peso en la arista existente
			System.out.println("La arista ya existe, actualizando peso ...");
			rOri.listAdj.searchData(new Edge(rDes)).setWeight(weight);
		}
		rOri.listAdj.insertFirst(new Edge(rDes,weight));// grafico dirigido
		rDes.listAdj.insertFirst(new Edge(rOri,weight));// grafico no dirigido
	}
	
	public ArrayList<Punto_mapa> shortPath( String v, String z) { //dijstra
		for(int i=0;i<this.listVertex.length();i++) {
			if(i==this.listVertex.search(new Punto_mapa(v)))
				this.listVertex.searchIndex(i).setDist(0);
				
			else
				this.listVertex.searchIndex(i).setDist(99999);
		}
		OrderListLinked<Punto_mapa> colaPri =new OrderListLinked<Punto_mapa>(); //cola de prioridad
		for (int i=0;i<this.listVertex.length();i++) {
			colaPri.insert(this.listVertex.searchIndex(i));
		}		
		
		Punto_mapa vIni= new Punto_mapa(v);

		while(!colaPri.isEmptyList() && !vIni.equals(new Punto_mapa(z))) {
			
			vIni= colaPri.removeMin();//vertice menor distancia

			ListLinked<Edge> edges=vIni.listAdj;
			for(int i=0;i<edges.length();i++) {
				Edge e=edges.searchIndex(i);
				Punto_mapa w= e.opposite();	
				if(colaPri.searchData(w)!=null) {
					if(w.getDist()>vIni.getDist()+e.getWeight()) {
						w.setDist(vIni.getDist()+e.getWeight());
						w.setPath(vIni);
						colaPri.actualizar(w);
						
					}
				}
			}
		}
		ArrayList<Punto_mapa> aux= new ArrayList<Punto_mapa>();
		ListLinked<Punto_mapa> temp= new ListLinked<Punto_mapa>();//guardara los nodos de la ruta
		for(Punto_mapa primero= vIni;primero!=null;primero=primero.getPath()) {
			temp.insertFirst(primero);
			if(primero.getPath()!=null)
				this.searchEdgex(primero, primero.getPath()).setColor("rojo");
			
		}
		for(int i=0;i<temp.length();i++) {
			aux.add(temp.searchIndex(i));
		}
		
		
		/*
		for(int i=20;i<200;i=i+100) {
			label1 = new JLabel("¿Que desea mostrar?");// se mostrara centrado
			label1.setBounds(70,i,220,30);
			this.add(label1);
		}*/
		
		Interfaz_mapa p= new Interfaz_mapa(this);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.add(p);
		
		System.out.print("ruta minima:" );
		return aux;
		
	}
	
	
	public String toString() {
		return this.listVertex.toString();
	}
}

