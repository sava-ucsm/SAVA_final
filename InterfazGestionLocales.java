import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;


public class InterfazGestionLocales extends JFrame implements ActionListener {
	private JLabel lblTitulo;
	private JButton btnBack;
	private JButton btnAdd;
	private JTable dataTable;
	private JScrollPane sp;
	private ContenedorLocales locales;
	
	public InterfazGestionLocales(ContenedorLocales contenedor) {
		setLayout(null);
		lblTitulo = new JLabel("GESTION DE LOCALES");
		btnBack=new JButton("<=");
		btnAdd=new JButton("Agregar local");		
		locales=contenedor;
		
		String data[][]=locales.localesString();
		String column[]= {"Nro","Nombre","Direccion"};
		DefaultTableModel modelo=new DefaultTableModel(data,column);
		dataTable=new JTable(modelo);
		sp=new JScrollPane(dataTable);
		
		lblTitulo.setBounds(230,10,300,30); //setBounds(coorX,coorY,largo,ancho)
		btnBack.setBounds(20, 40, 50, 20);
		btnAdd.setBounds(450, 40, 150, 20);
		sp.setBounds(20, 80, 575, 315);
		
		add(lblTitulo);//Muestra el componente en la interfaz grafica
		add(btnBack);
		add(btnAdd);
		add(sp);
		
		btnBack.addActionListener(this);
		setTitle("SAVA-Locales");
	}
	
	public void actionPerformed(ActionEvent e) {//Para manejar los eventos de botones
		if(e.getSource()==btnBack) {
			System.exit(0);
		}
	}
	

	
	public static void main(String[] args) {	
		ContenedorLocales listaLocales=new ContenedorLocales();
		
		Local l1=new Local(new Direccion("Paucarpata","Arequipa"),"Sede paucarpata");
		Local l2=new Local(new Direccion("Yanahuara","Arequipa"),"Sede yanahuara");
		Local l3=new Local(new Direccion("Yarabama","Arequipa"),"Sede yarabamba");
		
		listaLocales.registrarNuevoLocal(4, l1);
		listaLocales.registrarNuevoLocal(10, l2);
		listaLocales.registrarNuevoLocal(30, l3);
		
		InterfazGestionLocales ventana = new InterfazGestionLocales(listaLocales);
		ventana.setBounds(0, 0, 630, 460);
		ventana.setResizable(false);
		ventana.setVisible(true);
		ventana.setLocationRelativeTo(null);
	}
}
