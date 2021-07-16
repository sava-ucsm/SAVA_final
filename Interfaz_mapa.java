import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Interfaz_mapa extends JPanel{
	
	protected Mapa mapa;
	
	public Interfaz_mapa(Mapa aux) {
		this.mapa=aux;
		this.setBounds(40,100, 660, 580);
	}
	public void paint(Graphics g) {
		Dimension tam=getSize();
		ImageIcon img= new ImageIcon(new ImageIcon(getClass().getResource("mapa6.PNG")).getImage());
		g.drawImage(img.getImage(),0, 0,tam.width,tam.height,this);
        
		int radio=10;
		ListLinked<Punto_mapa> listpuntos=this.mapa.listVertex;
		Punto_mapa temp;
		for(int i=0;i<listpuntos.length();i++) {
			temp =listpuntos.searchIndex(i);
			for(int j=0;j<temp.listAdj.length();j++) {
				temp.listAdj.searchIndex(j).setLabel("no pintado");
			}
		} 
		for(int i=0;i<listpuntos.length();i++) {
			g.setColor(Color.black);
			Punto_mapa aux=listpuntos.searchIndex(i);
			g.drawOval(aux.getX(),aux.getY(), radio*2, radio*2);
			
			ListLinked<Edge> edges=aux.listAdj;
			for(int j=0;j<edges.length();j++) {
				g.setColor(Color.black);
				Edge e=edges.searchIndex(j);
				
				if(e!=null) {
					Punto_mapa w= e.opposite();	
					if(e.getLabel()!="pintado") {
						if(e.getColor()=="rojo") {
							
							g.setColor(Color.red);
						}
						g.drawLine((aux.getX()+radio), aux.getY()+radio,w.getX()+radio,w.getY()+radio);
						
						e.setLabel("pintado");
						mapa.searchEdgex(w,aux).setLabel("pintado");
					}
				}
			}
		}
	}
}
