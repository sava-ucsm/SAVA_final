import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class RegistroPersonalSalud extends JFrame implements Registro, ActionListener {
	//labels
		private Local ref;
		private JLabel label1;
		private JLabel label2;
		private JLabel label3;
		private JLabel label4;
		private JLabel label5;
		//botones
		private JButton boton1;
		private JButton boton2;
		//TextField
		private JTextField tf1,tf2,tf3,tf4;
		
		public RegistroPersonalSalud(Local ref) {
			this.ref= ref;
			
			this.setTitle("SAVA - Registro Personal de Salud");
			//etiquetas
			setLayout(null);
			
			label1 = new JLabel("Registro Personal de Salud");
			label1.setBounds(120,5,300,30); // al centro
			this.add(label1);
			
			label2 = new JLabel("Nombre:");
			label2.setBounds(30,40,100,30);
			//label2.setBackground(new Color(255,255,255));
			//label2.setForeground(new Color(255,255,255));
			this.add(label2);

			label3 = new JLabel("Apellido:");
			label3.setBounds(30,80,100,30);
			this.add(label3);
			
			label4 = new JLabel("Dni:");
			label4.setBounds(30,120,100,30);
			this.add(label4);
			
			label5 = new JLabel("Especialidad:");
			label5.setBounds(30,160,100,30);
			this.add(label5);
			
			
			//botones
			boton1= new JButton("Regresar");
			boton1.setBounds(70,290,100,30);
			boton1.setForeground(Color.white);
			boton1.setBackground(Color.decode("#418325"));
			add(boton1);
			boton1.addActionListener(this);

			boton2= new JButton("Registrar");
			boton2.setBounds(220,290,100,30);
			boton2.setForeground(Color.white);
			boton2.setBackground(Color.decode("#418325"));
			add(boton2);
			boton2.addActionListener(this);
			
			tf1=new JTextField();
			tf1.setBounds(90,45,250,20);
			add(tf1);
			tf2=new JTextField();
			tf2.setBounds(90,85,250,20);
			add(tf2);
			tf3=new JTextField();
			tf3.setBounds(90,125,250,20);
			add(tf3);
			tf4=new JTextField();
			tf4.setBounds(120,165,220,20);
			add(tf4);
			
		}
		
		public void actionPerformed(ActionEvent e) { 
			if(e.getSource()== boton1) { //si el boton 1 se presiona hace
				this.setVisible(false);
			}
			if(e.getSource()== boton2) {
				String nombre=tf1.getText();
				String apellido=tf2.getText();
				String dni=tf3.getText();
				String especialidad=tf4.getText();
				
				if(this.verificarNom(nombre) && this.verificarApellido(apellido)
			    && this.verificarDni(dni) && verificarEspecialidad(especialidad)) {
					PersonalSalud ps=new PersonalSalud(nombre,apellido,dni,especialidad);
					if(!this.existeRegistro(ps)) {
						JOptionPane.showMessageDialog(null,"Registro con Exito");
						ref.agregarPersonal(ps);
						tf1.setText("");
						tf2.setText("");
						tf3.setText("");
						tf4.setText("");
						}
					else {
						
						JOptionPane.showMessageDialog(null,"Error: la persona ya esta registrada");
						
					}
				}
			}
		}
	

	public void registrar() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.getContentPane().setBackground(Color.decode("#d2fdbc"));
		this.setBounds(0,0,400,400);
		this.setVisible(true);
		this.setResizable(false); // deja o no que el ususario modifique la ventana
		this.setLocationRelativeTo(null);
			
	}
	
	public boolean existeRegistro(Persona p) {
		if(ref.buscarPersonal((PersonalSalud)p))
			return true;
		return false;
	}
	private boolean verificarNom(String nombre) {
		if(!verificarText(nombre,"Nombre"))
			return false;
		return true;
	}
	
	//verificaciones de datos
	private boolean verificarApellido(String apellido) {
		int opc=0;
		int contPal=0; //cuenta palabras
		if(!verificarText(apellido,"Apellido"))
			return false;
		for(int i =0;i<apellido.length();i++) {	
			if(apellido.charAt(i)==' ') 
				contPal++;
			if(i==apellido.length()-1)
				contPal++;
		}
		if(contPal<=0 || contPal>=3) {
			JOptionPane.showMessageDialog(null,"Error: se ingreso 0 o mas de 2 apellidos");
			return false;
		}
		return true;
	}
		
	
	private boolean verificarDni(String dni) {
		if(dni.length()==0) {
			JOptionPane.showMessageDialog(null,"Error DNI: campo vacio");
			return false;
		}
		for(int i =0;i<dni.length();i++) {
			if((dni.charAt(i)<'0' || dni.charAt(i)>'9')) {
				JOptionPane.showMessageDialog(null,"Error DNI: No se ingreso un numero");
				return false;
			}
		}
		if(dni.length()!=8) {
			JOptionPane.showMessageDialog(null,"Error: Dni no igual a 8 digitos");
			return false;
		}
		
		return true;
	}
	private boolean verificarEspecialidad(String especialidad) {
		if(!verificarText(especialidad,"Especialidad"))
			return false;
		return true;
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
}
