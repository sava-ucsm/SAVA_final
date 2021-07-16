import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class Inventario extends JFrame implements ActionListener{
	
	private  ListLinked<Vacuna> inventarioVacuna;
	
	

	public Inventario() {
		this.interfazRegistrarVacuna();
		this.inventarioVacuna = new OrderListLinked<Vacuna>();
	}
	
	public ListLinked<Vacuna> getInventarioVacuna() {
		return inventarioVacuna;
	}
	
	public void muestraSalidaEntradasGeneral() {
		
		System.out.println(toString());
	}
	public void muestrarVacuna(Vacuna x) {
		Node<Vacuna> aux = inventarioVacuna.getFirst();
		int busqueda = inventarioVacuna.search(x);
		if (busqueda != -1) {
			for(int i = 0 ;aux != null ; aux =aux.getNext(),i++) 
				if (aux.getData().equals(x)) {
					System.out.println(x);
				}
		}
		else {
			System.out.println("No se encontro");
		}
		
	}
	
	public Vacuna getVacuna(String marca) {
		Node<Vacuna> aux = inventarioVacuna.getFirst();
		for(int i = 0 ;aux != null ; aux =aux.getNext(),i++) 
			if (aux.getData().getMarca().equals(marca)) {
				return aux.getData();
			}
		return null;
	}
	
	public void aumentarStock(Vacuna x, int cant) {
		Node<Vacuna> aux = inventarioVacuna.getFirst();
		int busqueda = inventarioVacuna.search(x);
		if (busqueda != -1) {
			for(int i = 0 ;aux != null ; aux =aux.getNext(),i++) {
				if (aux.getData().equals(x)) {
					x.aumentarStockVacuna(cant);
				}
			}	
		}
		else {
			System.out.println("No se encontro");
		}
	}
	
	public void disminuirStock(Vacuna x, int cant) {
		Node<Vacuna> aux = inventarioVacuna.getFirst();
		int busqueda = inventarioVacuna.search(x);
		if (busqueda != -1) {
			for(int i = 0 ;aux != null ; aux =aux.getNext(),i++) 
				if (aux.getData().equals(x)) {
					aux.getData().disminuirStockVacuna(cant);
				}
		}
		else {
			System.out.println("No se encontro");
		}	
	}
	
	public void insertarVacuna(Vacuna x) {
		this.inventarioVacuna.insertLast(x);
	}
	
	public void borrarVacuna(Vacuna x) {
		inventarioVacuna.remove(x);
	}
	
	public void reporteGeneral() {
		toString();
	
	}
	// 
	public int buscarVacuna(Vacuna x) {
		int contador  = inventarioVacuna.search(x);
		if (contador != -1) {
			return contador;
		}
		else {
			System.out.println("No se encontro");
			return -1;
		}
	}
	
	public boolean isEmptyList() {
		return inventarioVacuna.isEmptyList();
	}
	
	public int cantidadVacunas(){
		return inventarioVacuna.length();
	}
	
	public String toString() {
		String str="";
		Node<Vacuna> aux = inventarioVacuna.getFirst();
		
		str += String.format("----------------------------------------------------------------------------------------\n");
		str += String.format("   Marca        Cantidad    Efectividad  Temperatura  Numero de Dosis\n");
		str += String.format("----------------------------------------------------------------------------------------\n");
		for(int i =  0 ; aux!=null ; aux = aux.getNext(),i++)
			str += aux.toString();
		return str;
	}
	
	//METODOS DE APOYO AL INVENTARIO
	public boolean verificadorSiExisteVacuna(String NombreVacuna) {
		Node<Vacuna> aux = this.inventarioVacuna.getFirst();
		for(int i = 0 ;aux != null ; aux =aux.getNext(),i++) {
			if (NombreVacuna.equals(aux.getData().getMarca())) {
				return true; 
			}
		}
		return false;
	}
		
	private boolean verificarText(String text,String campo) { //verfica que en el texto enviado no tenga carateres especiales o numeros ignorando los espacios
		if(text.length()==0) {
			JOptionPane.showMessageDialog(null,"Error "+campo +": campo vacio");
			return false;
		}
			//
		for(int i =0;i<text.length();i++) {
			if(text.charAt(i)!=' ') {
				if((text.charAt(i)<'a' || text.charAt(i)>'z'&& (text.charAt(i)<'A' || text.charAt(i)>'Z') ) ) {
					JOptionPane.showMessageDialog(null,"Error "+campo +": Se ingreso un numero o caracter especial");
					return false;
				}
			}
		}
		return true;
			
	}
	
	public void llamarARegistrar() {
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.getContentPane().setBackground(Color.decode("#d2fdbc"));
		this.setBounds(0,0,400,350);
		this.setVisible(true);
		this.setResizable(false); // deja o no que el ususario modifique la ventana
		this.setLocationRelativeTo(null);
	}
	
	private JLabel label1, label2,label3,label4,label5;
	private JTextField t1, t2,t3,t4,t5;
	private JButton BT1, BT2;
	String a,b;
		
	
	public void interfazRegistrarVacuna() {
		this.setTitle("SAVA - Registro Vacunas");
		setLayout(null);
		label1 = new JLabel("Marca: ");
		label1.setBounds(60,10,100,30);
		add(label1);
		t1 = new JTextField();
		t1.setBounds(150,17,150,20);
		add(t1);
		
		label2 = new JLabel("Cantidad: ");
		label2.setBounds(60,45,100,30);
		add(label2);
		t2 = new JTextField();
		t2.setBounds(150,50,150,20);
		add(t2);
			
		setLayout(null);
		label3 = new JLabel("Efectividad: ");
		label3.setBounds(60,77,100,30);
		add(label3);
		t3 = new JTextField();
		t3.setBounds(150,83,150,20);
		add(t3);
		
		label4 = new JLabel("Temperatura:");
		label4.setBounds(60,110,100,30);
		add(label4);
		t4 = new JTextField();
		t4.setBounds(150,116,150,20);
		add(t4);
			
		label5 = new JLabel("Dosis: ");
		label5.setBounds(60,143,100,30);
		add(label5);
		t5 = new JTextField();
		t5.setBounds(150,149,150,20);
		add(t5);
			
			
		BT1 = new JButton("Registrar");
		BT1.setBounds(70,195,100,30);
		add(BT1);
		BT1.addActionListener(this);
		BT1.setForeground(Color.white);
		BT1.setBackground(Color.decode("#418325"));
		
		BT2 = new JButton("Regresar");
		BT2.setBounds(210,195,100,30);
		add(BT2);
		BT2.addActionListener(this);
		BT2.setForeground(Color.white);
		BT2.setBackground(Color.decode("#418325"));
		
	
		}
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == BT1) {
				String can,efec,temp,dosis;		
				String marcaS = t1.getText();
				can = t2.getText();
				efec = t3.getText();
				temp = t4.getText();
				dosis = t5.getText();
				if(verificarNum(can,"Cantidad") && verificarNum(efec,"Efecto") && verificarNum(temp,"Temperatura") && verificarNum(dosis,"Dosis")) {
					int canInt = Integer.parseInt(can);
					int efecInt = Integer.parseInt(efec);
					int tempInt = Integer.parseInt(temp);
					int dosisInt = Integer.parseInt(dosis);
					
					boolean vrificador = this.verificadorSiExisteVacuna(marcaS);
	
					if (vrificador == true) {  
						JOptionPane.showMessageDialog(null,"Vuelve a ingresar la Vacuna , ya que la que ingresaste ya existe");
						t1.setText("");
						t2.setText("");
						t3.setText("");
						t4.setText("");
						t5.setText("");
					}
					else{
						this.insertarVacuna( new Vacuna(marcaS,canInt, efecInt,tempInt,dosisInt));
						JOptionPane.showMessageDialog(null,"Registro con Exito!");
						t1.setText("");
						t2.setText("");
						t3.setText("");
						t4.setText("");
						t5.setText("");
					}
				}
			}
	
			if(e.getSource()==BT2) {
				this.setVisible(false);
			}
			
		}
		private boolean verificarNum(String num, String campo) {
			if(num.length()==0) {
				JOptionPane.showMessageDialog(null,"Error "+campo+": campo vacio");
				return false;
			}
			for(int i =0;i<num.length();i++) {
				if((num.charAt(i)<'0' || num.charAt(i)>'9')) {
					JOptionPane.showMessageDialog(null,"Error "+campo+" No se ingreso un numero");
					return false;
				}
			}
			return true;
		}
		
}

