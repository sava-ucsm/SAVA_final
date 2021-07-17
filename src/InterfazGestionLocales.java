import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.event.*;
import java.util.Arrays;


public class InterfazGestionLocales extends JFrame implements ActionListener {
	private JLabel lblTitulo;
	private JButton btnBack;
	private JButton btnAdd;
	private JTable dataTable;
	private JScrollPane sp;
	DefaultTableModel modelo;
	private ContenedorLocales locales;
	
	public InterfazGestionLocales(ContenedorLocales contenedor) {
		setLayout(null);
		this.getContentPane().setBackground(Color.decode("#d2fdbc"));
		lblTitulo = new JLabel("GESTION DE LOCALES");
		btnBack=new JButton("<=");
		btnAdd=new JButton("Agregar local");		
		locales=contenedor;
		
		String data[][]=locales.localesString();
		String column[]= {"Nro","Nombre","Direccion","Stock vacunas","Cantidad de vacunados"};
		modelo=new DefaultTableModel(data,column);
		dataTable=new JTable(modelo);
		sp=new JScrollPane(dataTable);
		
		lblTitulo.setBounds(230,10,300,30); //setBounds(coorX,coorY,largo,ancho)
		btnBack.setBounds(20, 40, 50, 20);
		btnAdd.setBounds(450, 40, 150, 20);
		sp.setBounds(20, 80, 575, 315);
		
		btnBack.setForeground(Color.white);
		btnAdd.setForeground(Color.white);
		btnBack.setBackground(Color.decode("#418325"));
		btnAdd.setBackground(Color.decode("#418325"));

		
		add(lblTitulo);//Muestra el componente en la interfaz grafica
		add(btnBack);
		add(btnAdd);
		add(sp);
		
		btnBack.addActionListener(this);
		btnAdd.addActionListener(this);
		setTitle("SAVA-Locales");
	}
	
	public void actionPerformed(ActionEvent e) {//Para manejar los eventos de botones
		if(e.getSource()==btnBack) {
			this.setVisible(false);
		}
		if(e.getSource()==btnAdd) {
			InterfazAgregarLocal ventana = new InterfazAgregarLocal(this);
			ventana.setBounds(0, 0, 200, 300);
			ventana.setResizable(false);
			ventana.setVisible(true);
			ventana.setLocationRelativeTo(null);
		}
	}
	public void recargarTabla() {
		String data[][]=locales.localesString();
		String column[]= {"Nro","Nombre","Direccion","Stock vacunas","Cantidad de vacunados"};
		modelo=new DefaultTableModel(data,column);
		dataTable=new JTable(modelo);
		sp=new JScrollPane(dataTable);
		sp.setBounds(20, 80, 575, 315);
		add(sp);
	}
	
	public ContenedorLocales getLocales() {
		return locales;
	}

	public void setLocales(ContenedorLocales locales) {
		this.locales = locales;
	}

//	public static void main(String[] args) {	
//		ContenedorLocales listaLocales=new ContenedorLocales();
//		
//		Local l1=new Local(2,"Sede paucarpata",new Direccion("Paucarpata","Arequipa"));
//		Local l2=new Local(4,"Sede yarabamba",new Direccion("Yarabamba","Arequipa"));
//		Local l3=new Local(13,"Sede yanahuara",new Direccion("Yanahuara","Arequipa"));
//		
//		listaLocales.registrarNuevoLocal(4, l1);
//		listaLocales.registrarNuevoLocal(10, l2);
//		listaLocales.registrarNuevoLocal(20, l3);
//
//		
//		InterfazGestionLocales ventana = new InterfazGestionLocales(listaLocales);
//		ventana.setBounds(0, 0, 630, 480);
//		ventana.setResizable(false);
//		ventana.setVisible(true);
//		ventana.setLocationRelativeTo(null);
//	}
}
