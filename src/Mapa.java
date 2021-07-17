import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.Border;

public class Mapa<E> extends JFrame implements ActionListener{
	
	public JLabel label1; //titulo
	public JLabel label2; 
	public JLabel label3; 
	private JButton boton1;
	protected ListLinked<Punto_mapa> listVertex;
	
	public Mapa() {
		listVertex = new ListLinked<Punto_mapa>();
		this.setLayout(null);
		this.setTitle("Ruta optima");
		this.setResizable(false);
		this.getContentPane().setBackground(Color.decode("#d2fdbc"));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBounds(0,0,750,750);

		label1= new JLabel("Ruta optima para el destino");
		label1.setBounds(250,38,300,30);
		label1.setFont(new Font("Helvetica",Font.BOLD, 16));
		add(label1);
		label2= new JLabel("");
		label2.setBounds(570,40,300,30);
		add(label2);
		
		
		
		boton1= new JButton("Salir");
		boton1.setBounds(40,40,120,30);
		boton1.setForeground(Color.white);
		boton1.setBackground(Color.decode("#418325"));
		add(boton1);
		boton1.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== boton1) {
			this.setVisible(false);
		}
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
	
	public void insertEdgeWeight(String verOri, String verDes, float weight) {
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
	
	public void shortPath( String v, String z) { //dijstra
		Punto_mapa temp0;
		for(int i=0;i<this.listVertex.length();i++) {
			temp0 =this.listVertex.searchIndex(i);
			if(i==this.listVertex.search(new Punto_mapa(v)))
				temp0.setDist(0);
				
			else
				temp0.setDist(99999);
			for(int j=0;j<temp0.listAdj.length();j++) {
				temp0.listAdj.searchIndex(j).setColor("negro");
			}
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
		
		for(Punto_mapa primero= vIni;primero!=null;primero=primero.getPath()) {
			if(primero.getPath()!=null)
				this.searchEdgex(primero, primero.getPath()).setColor("rojo");
			
		}
		label2.setText("Distancia: "+vIni.getDist()+" Km");
		Interfaz_mapa p= new Interfaz_mapa(this);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.add(p);
		
	}
	
	
	public String toString() {
		return this.listVertex.toString();
	}
}

