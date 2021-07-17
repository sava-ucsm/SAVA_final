import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.*;

public class InterfazEnviarVacuna extends JFrame implements ActionListener , ItemListener{
		private Mapa refmapa;
		private ContenedorLocales reflistaLocales;
		private Local reflocalIni;
		private Local reflocalSelec;
		private JLabel label1, label2, label3, label4, label5;
		private JButton BT1,BT2, BT3;
		private JTextField t1,t2;
		private JComboBox CB1, CB2;
		private JScrollPane scrollpane;
		private String seleccion;
		private String seleccion2;
				
		public InterfazEnviarVacuna(ContenedorLocales reflocales,Local localSelec,Mapa refmapa) {
			this.refmapa= refmapa;
			this.getContentPane().setBackground(Color.decode("#d2fdbc"));
			this.setDefaultCloseOperation(EXIT_ON_CLOSE);
			this.setLayout(null);
			this.reflistaLocales=reflocales;
			this.reflocalIni = localSelec;
			this.setTitle("SAVA - Enviar Vacunas");
			this.setLocationRelativeTo(null);
			seleccion="";
			seleccion2="";
			
			label1 = new JLabel("Enviar vacunas");
			label1.setBounds(140,10,200,30);
			label1.setFont(new Font("Helvetica",Font.BOLD, 14));
			add(label1);
			
			
			label2 = new JLabel("Local de Origen: "+this.reflocalIni.getNombre());
			label2.setBounds(30,60,200,30);
			add(label2);
			
			label3 = new JLabel("Local de Destino: ");
			label3.setBounds(30,100,100,30);
			add(label3);
			
			label4 = new JLabel("Vacuna: ");
			label4.setBounds(30,140,100,30);
			add(label4);
			
			label5 = new JLabel("Numero: ");
			label5.setBounds(30,180,100,30);
			add(label5);
			
			t1 = new JTextField("");
			t1.setBounds(150,185,150,20);
			add(t1);
			
			BT1 = new JButton("Enviar");
			BT1.setBounds(80,300,100,30);
			BT1.setForeground(Color.white);
			BT1.setBackground(Color.decode("#418325"));
			add(BT1);
			BT1.addActionListener(this);
			
			BT2 = new JButton("Mostrar ruta minima");
			BT2.setBounds(90,240,200,30);
			BT2.setForeground(Color.white);
			BT2.setBackground(Color.decode("#418325"));
			add(BT2);
			BT2.addActionListener(this);
			
			
			BT3 = new JButton("Retornar");
			BT3.setBounds(200,300,100,30);
			BT3.setForeground(Color.white);
			BT3.setBackground(Color.decode("#418325"));
			add(BT3);
			BT3.addActionListener(this);

			CB1 = new JComboBox();
			CB1.setBounds(150,105,150,20);
			add(CB1);
			
			
			Node <Local> aux=this.reflistaLocales.listaLocales().getFirst();
			CB1.addItem("");
			for(int i =  0 ; aux!=null ; aux = aux.getNext(),i++) {
				if(aux.getData().getNombre()!=this.reflocalIni.getNombre())
					CB1.addItem(aux.getData().getNombre());
			}
			CB1.addItemListener(this);
			
			CB2 = new JComboBox();
			CB2.setBounds(150,145,150,20);
			add(CB2);
			
			Node <Vacuna> aux2=this.reflocalIni.getInventario().getInventarioVacuna().getFirst();
			CB2.addItem("");
			for(int i =  0 ; aux2!=null ; aux2 = aux2.getNext(),i++)
				CB2.addItem(aux2.getData().getMarca());
			CB2.addItemListener(this);
			
		}
		
		
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== BT1) { //enviar
			if (this.verificarSelecion() && this.verificarSelecion2() && this.verificarCantidad(t1.getText())) {
				Vacuna temp= this.reflocalIni.getInventario().getVacuna(this.seleccion2);	
	    		this.reflocalIni.getInventario().disminuirStock(temp, Integer.parseInt(t1.getText()));
	    		this.reflocalSelec.getInventario().aumentarStock(temp,Integer.parseInt(t1.getText()));
	    		JOptionPane.showMessageDialog(null,"Envio exitoso");
	    		t1.setText("");
	    		CB1.setSelectedIndex(0);
	    		CB2.setSelectedIndex(0);
			}
		}
		if(e.getSource()== BT2) { //ruta minima
			if (this.verificarSelecion()) {
	    		this.refmapa.shortPath(this.reflocalIni.getDireccion().getDistrito(), this.reflocalSelec.getDireccion().getDistrito());
			}
		}	
		if(e.getSource()== BT3) { //salir
    		this.setVisible(false);
		}
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if(e.getSource()==CB1) {
			this.seleccion= (String) CB1.getSelectedItem();
			Node <Local> aux=this.reflistaLocales.listaLocales().getFirst();
			for(int i =  0 ; aux!=null ; aux = aux.getNext(),i++) {
				if(aux.getData().getNombre()==this.seleccion) {
					this.reflocalSelec= aux.getData();
					break;
				}
			}
		}
		
		if(e.getSource()==CB2) {
			this.seleccion2= (String) CB2.getSelectedItem();
			
		}
		
	}
	private boolean verificarSelecion() {
		if(this.seleccion=="") {
			JOptionPane.showMessageDialog(null,"Error: No eligio un local");
			return false;
		}
		else
			return true;
	}
	
	private boolean verificarSelecion2() {
		if(this.seleccion2=="") {
			JOptionPane.showMessageDialog(null,"Error: No eligio una vacuna");
			return false;
		}
		else
			return true;
	}
	private boolean verificarCantidad(String cant) {
		if(cant.length()==0) {
			JOptionPane.showMessageDialog(null,"Error Cantidad: No ingreso la cantidad");
			return false;
		}
		for(int i =0;i<cant.length();i++) {
			if((cant.charAt(i)<'0' || cant.charAt(i)>'9')) {
				JOptionPane.showMessageDialog(null,"Error Cantidad: Se ingreso una letra");
				return false;
			}
		}
		return true;
	}
	
	
}
