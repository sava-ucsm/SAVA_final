import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

import javax.swing.JPanel;

public class Interfaz_mapa extends JPanel{
	
	protected Mapa mapa;
	
	public Interfaz_mapa(Mapa aux) {
		this.mapa=aux;
	}
	public void paint(Graphics g) {
		int radio=10;
		 ListLinked<Punto_mapa> listpuntos=this.mapa.listVertex;
		
		
		for(int i=0;i<listpuntos.length();i++) {
			g.setColor(Color.black);
			Punto_mapa aux=listpuntos.searchIndex(i);
			g.drawOval(aux.getX(),aux.getY(), radio*2, radio*2);
			ListLinked<Edge> edges=aux.listAdj;
			//g.setColor(Color.white);
			for(int j=0;j<edges.length();j++) {
				g.setColor(Color.black);
				Edge e=edges.searchIndex(j);
				
				if(e!=null) {
					Punto_mapa w= e.opposite();	
					if(e.getLabel()!="pintado") {
						Line2D l = new Line2D.Float(aux.getX()+radio, aux.getY()+radio,w.getX()+radio,w.getY()+radio);
						e.setLabel("pintado");
						mapa.searchEdgex(w,aux).setLabel("pintado");
						
						if(e.getColor()=="rojo") {
							g.setColor(Color.red);
						}
						((Graphics2D) g).draw(l);
					}
				}
			}
		}
	}
}
