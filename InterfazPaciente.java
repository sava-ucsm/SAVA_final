import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;

public class InterfazPaciente extends JFrame implements ActionListener, ItemListener {
	private Local reflocal;
	private String seleccion;
	
	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	private JButton boton1;
	private JButton boton2;
	private JButton boton3;
	private JButton boton4;
	private JButton boton5;
	private JButton boton6;
	private JButton boton7;
	private JTextField tf1;
	private JTextArea textA1;
	private JScrollPane scrollpane1;
	private JComboBox combo1;
	public InterfazPaciente(Local reflocal) {
		this.reflocal=reflocal;
		this.seleccion= "";
		this.setTitle("SAVA - Mostrar Lista de Pacientes");
		//etiquetas
		setLayout(null);
		
		label1 = new JLabel("¿Que desea mostrar?",SwingConstants.CENTER);// se mostrara centrado
		label1.setBounds(90,5,220,30); 
		this.add(label1);
		
		label2 = new JLabel("Ingrese DNI");// se mostrara centrado
		label2.setBounds(50,30,220,30); 
		this.add(label2);
		
		label3 = new JLabel("Escoja la vacuna");// se mostrara centrado
		label3.setBounds(50,65,220,30); 
		this.add(label3);
		
		//Textfield
		tf1=new JTextField();
		tf1.setBounds(130,35,180,20);
		add(tf1);
		
		//JComboBox
		combo1= new JComboBox ();
		combo1.setBounds(160,70 ,120,20 );
		add(combo1);
		
		//botones
		boton1= new JButton("Vacunados");
		boton1.setBounds(140,70,120,30);
		boton1.setForeground(Color.white);
		boton1.setBackground(Color.decode("#418325"));
		add(boton1);
		boton1.addActionListener(this);

		boton2= new JButton("No vacunados");
		boton2.setBounds(140,140,120,30);
		boton2.setForeground(Color.white);
		boton2.setBackground(Color.decode("#418325"));
		add(boton2);
		boton2.addActionListener(this);
		
		boton3= new JButton("General");
		boton3.setBounds(140,210,120,30);
		boton3.setForeground(Color.white);
		boton3.setBackground(Color.decode("#418325"));
		add(boton3);
		boton3.addActionListener(this);
		
		boton4= new JButton("Retornar"); //regresar 1
		boton4.setBounds(20,290,100,30);
		boton4.setForeground(Color.white);
		boton4.setBackground(Color.decode("#418325"));
		add(boton4);
		boton4.addActionListener(this);
		
		boton5= new JButton("Retornar"); //regresar 2
		boton5.setBounds(20,360,100,30);
		boton5.setForeground(Color.white);
		boton5.setBackground(Color.decode("#418325"));
		add(boton5);
		boton5.addActionListener(this);
		
		boton6= new JButton("Vacunar");
		boton6.setBounds(140,100,120,30);
		boton6.setForeground(Color.white);
		boton6.setBackground(Color.decode("#418325"));
		add(boton6);
		boton6.addActionListener(this);
		
		boton7= new JButton("Regresar"); //regresar 3
		boton7.setBounds(20,360,100,30);
		boton7.setForeground(Color.white);
		boton7.setBackground(Color.decode("#418325"));
		add(boton7);
		boton7.addActionListener(this);
	
		//JTextArea y JScrollPane
		textA1 = new JTextArea();
		textA1.setEditable(false);
		scrollpane1 = new JScrollPane(textA1);
		scrollpane1.setBounds(20,40,340,300);//(x,y,ancho,alto)
		scrollpane1.setVisible(false);
		add(scrollpane1);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== boton1) {
			this.InterVacunados();
		}
		if(e.getSource()== boton2) {
			this.InterNoVacunados();
		}
		if(e.getSource()== boton3) {
			this.InterGeneral();
		}
		if(e.getSource()== boton4) { //retornar 1
			this.setDefaultCloseOperation(EXIT_ON_CLOSE);
			this.setVisible(false);
		}
		if(e.getSource()== boton5) {//regresar 2
			
			this.setBounds(0,0,400,400);
			this.setLocationRelativeTo(null);
			boton1.setVisible(true);
			boton2.setVisible(true);
			boton3.setVisible(true);
			boton4.setVisible(true);
			scrollpane1.setVisible(false);
			label1.setText("¿Que desea mostrar?");
		}
		if(e.getSource()== boton6) { //boton vacunar
			
			String dni= tf1.getText();
			System.out.println(seleccion);
			if(this.verificarDni(dni) && this.existePaciente(dni) && this.verificarSelecion()
			&&this.verficarVacunaPac(this.reflocal.getGestionPacientes().get_paciente(dni),seleccion )
			&& this.verficarDosis(this.reflocal.getGestionPacientes().get_paciente(dni))) {
				
				Vacuna temp= reflocal.getInventario().getVacuna(this.seleccion);			
				Vacuna vac= new Vacuna(this.seleccion,0,temp.getEfectividad(),temp.getTemperaturaPromedio(), temp.getNumDosis());
				reflocal.getInventario().disminuirStock(vac, 1);
				reflocal.getGestionPacientes().get_paciente(dni).setVacuna(vac);
				reflocal.getGestionPacientes().get_paciente(dni).recibir_dosis();
				JOptionPane.showMessageDialog(null,"Registro Exitoso!");
				textA1.setText(this.reflocal.getGestionPacientes().get_paciente(dni).toString());
				tf1.setText("");
			}
		}
		if(e.getSource()== boton7) { //regresar 3
			this.setTitle("SAVA - Mostrar Lista de Pacientes");
			this.setBounds(0,0,400,400);
			this.setLocationRelativeTo(null);
			this.setVisible(false);
			scrollpane1.setVisible(false);
			label1.setText("¿Que desea mostrar?");
		}
	}
	private boolean verficarDosis(Paciente p) {
		if(p.getVacuna().getMarca()=="")
			return true;
		if(p.getDosis_recibidas()<p.getVacuna().getNumDosis()){
			return true;
		}else {
			JOptionPane.showMessageDialog(null,"Error: la persona ya esta en el limite de Vacunas");
			return false;
		}
	}
	private boolean verficarVacunaPac(Paciente p, String marcaVac) {
		if(p.getVacuna().getMarca()=="")
			return true;
		else if(p.getVacuna().getMarca().equals(marcaVac))
			return true;
		else {
			JOptionPane.showMessageDialog(null,"Error: A esta persona no le corresponde esta vacuna, seleccione "+p.getVacuna().getMarca());
			return false;
			}
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		if(e.getSource()==combo1) {
			this.seleccion= (String) combo1.getSelectedItem();
		}
		
	}
	public void menu() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.getContentPane().setBackground(Color.decode("#d2fdbc"));
		this.setBounds(0,0,400,400);
		this.setVisible(true);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		label2.setVisible(false);
		label3.setVisible(false);
		boton6.setVisible(false);
		combo1.setVisible(false);
		tf1.setVisible(false);
	}
	public void InterVacunar() { //mostrara la interfaz para vacunar pacientes
		this.setTitle("SAVA - Vacunar");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.getContentPane().setBackground(Color.decode("#d2fdbc"));
		this.setBounds(0,0,400,450);
		this.setVisible(true);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		scrollpane1.setBounds(20,150,340,200);
		scrollpane1.setVisible(true);
		label1.setText("Vacunar Paciente");
		Node<Vacuna> aux = reflocal.getInventario().getInventarioVacuna().getFirst();
		combo1.addItem("");
		for(int i =  0 ; aux!=null ; aux = aux.getNext(),i++)
			combo1.addItem(aux.getData().getMarca());
		combo1.addItemListener(this);
		this.setLocationRelativeTo(null);
		boton1.setVisible(false);
		boton2.setVisible(false);
		boton3.setVisible(false);
		boton4.setVisible(false);
		boton5.setVisible(false);
	}
	public void InterVacunados() { //mostrara solo los pacientes vacunados
		
		label1.setText("Lista de Vacunados");
		this.setBounds(0,0,400,450);
		this.setLocationRelativeTo(null);
		textA1.setText(this.reflocal.getGestionPacientes().mostrar_pacientes_vacunados());
		scrollpane1.setVisible(true);
		scrollpane1.setBounds(20,40,340,300);
		boton1.setVisible(false);
		boton2.setVisible(false);
		boton3.setVisible(false);
		boton4.setVisible(false);
	}
	public void InterNoVacunados() { //mostrara solo los pacientes no vacunados
		label1.setText("Lista de no Vacunados");
		this.setBounds(0,0,400,450);
		this.setLocationRelativeTo(null);
		textA1.setText(this.reflocal.getGestionPacientes().mostrar_pacientes_no_vacunados());
		scrollpane1.setVisible(true);
		scrollpane1.setBounds(20,40,340,300);
		boton1.setVisible(false);
		boton2.setVisible(false);
		boton3.setVisible(false);
		boton4.setVisible(false);
	}
	public void InterGeneral() { //mostrara todo los pacientes
		label1.setText("Lista General");
		this.setBounds(0,0,400,450);
		this.setLocationRelativeTo(null);
		textA1.setText(this.reflocal.getGestionPacientes().mostrar_pacientes());
		scrollpane1.setVisible(true);
		scrollpane1.setBounds(20,40,340,300);
		boton1.setVisible(false);
		boton2.setVisible(false);
		boton3.setVisible(false);
		boton4.setVisible(false);
	}

	public boolean existePaciente(String dni){
		if(this.reflocal.getGestionPacientes().existe_paciente(dni))
				return true;
		JOptionPane.showMessageDialog(null,"Error: La persona no existe");
		return false;
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
	private boolean verificarSelecion() {
		if(this.seleccion=="") {
			JOptionPane.showMessageDialog(null,"Error: No eligio una vacuna");
			return false;}
		else
			return true;
	}

}

