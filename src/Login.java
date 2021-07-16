import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.*;
public class Login extends JFrame implements ActionListener, ItemListener {
	private Local reflocal;
	private JLabel label1, label2, label3, LBI1, LBI2, LBI3;
	private JTextField t1;
	private JPasswordField t2;
	private JButton BT1, BT2;
	private JComboBox CB1;
	private String seleccion;
	private ImageIcon image1, image2, image3;
	
	String a,b;
	
	
	public Login(Local reflocal) {
		this.reflocal=reflocal;
		this.seleccion="Seleccione";
		
		this.getContentPane().setBackground(Color.decode("#d2fdbc"));
		setLayout(null);
		
		
		label1 = new JLabel("Usuario: ");
		label1.setBounds(60,75,100,30);
		add(label1);
		t1 = new JTextField();
		t1.setBounds(150,80,150,20);
		add(t1);
		
		label2 = new JLabel("Contraseña: ");
		label2.setBounds(60,100,100,30);
		add(label2);
		t2 = new JPasswordField();
		t2.setBounds(150,105,150,20);
		add(t2);
		
		label3 = new JLabel("Local: ");
		label3.setBounds(45,125,100,30);
		add(label3);
		CB1 = new JComboBox();
		CB1.setBounds(150,130,150,20);
		CB1.addItem("Item 1");
		CB1.addItem("Item 2");
		CB1.addItem("Item 3");
		CB1.addItem("Item 4");
		add(CB1);
		
		 	
		BT1 = new JButton("Ingresar");
		BT1.setBounds(45,175,100,30);
		BT1.setForeground(Color.white);
		BT1.setBackground(Color.decode("#418325"));
		add(BT1);
		BT1.addActionListener(this);
		
		BT2 = new JButton("Salir");
		BT2.setBounds(200,175,100,30);
		BT2.setForeground(Color.white);
		BT2.setBackground(Color.decode("#418325"));
		add(BT2);
		BT2.addActionListener(this);
		
		getContentPane().setBackground(new Color(200,255,200));
		setIconImage(new ImageIcon(getClass().getResource("imagenes/IconUser.png")).getImage());
		ImageIcon image1 = new ImageIcon(getClass().getResource("imagenes/IconPass.png"));
		Image conversion = image1.getImage();
		Image tamaño = conversion.getScaledInstance(14, 14, Image.SCALE_SMOOTH);
		ImageIcon fin = new ImageIcon(tamaño);
		
		ImageIcon image2 = new ImageIcon(getClass().getResource("imagenes/IconUser.png"));
		Image conversion1 = image2.getImage();
		Image tamaño1 = conversion1.getScaledInstance(14, 14, Image.SCALE_SMOOTH);
		ImageIcon fin1 = new ImageIcon(tamaño1);
		
		ImageIcon image3 = new ImageIcon(getClass().getResource("imagenes/LOGO_SAVA_PROTOTIPO_4.JPG"));
		Image conversion2 = image3.getImage();
		Image tamaño2 = conversion2.getScaledInstance(100, 60, Image.SCALE_SMOOTH);
		ImageIcon fin2 = new ImageIcon(tamaño2);
		
		
		
		LBI1 = new JLabel(fin);
		LBI1.setBounds(45,108,15,15);
		add(LBI1);
		
		LBI2 = new JLabel(fin1);
		LBI2.setBounds(45,83,15,15);
		add(LBI2);
		
		LBI3 = new JLabel(fin2);
		LBI3.setBounds(115,15,100,60);
		add(LBI3);
		
		
		
	}
	
	
	public void actionPerformed(ActionEvent e) {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		if(e.getSource() == BT1) {
			String nombre="", contra="";
			Usuario Us = new Usuario();
			nombre = t1.getText().trim();
			contra = t2.getText().trim();
			String resul = Us.validarUsuario(nombre, contra);
			JOptionPane.showMessageDialog(BT1,resul);
			if(resul.equals("Acceso denegado"))
			{
				
				JOptionPane.showMessageDialog(null,"vuelve a logearte");
				t1.setText(null);
				t2.setText(null);
			}
			else {
				Principal principal1 = new Principal(reflocal);
				principal1.setTitle("Menu Principal");
				principal1.setBounds(0,0,400,500);
				principal1.setVisible(true);
				principal1.setLocationRelativeTo(null);
				principal1.setDefaultCloseOperation(EXIT_ON_CLOSE);
				this.setVisible(false);
				
			}
		}
		
		if(e.getSource()==BT2) {
			t1.setText(null);
			t2.setText(null);
		}
	}
	public void mostrar_interfaz() {
		this.setTitle("Inicio de Sesion");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBounds(0,0,340,280);
		this.setResizable(true);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}
	public void itemStateChanged(ItemEvent e) {
		if(e.getSource()==CB1) {
			this.seleccion= (String) CB1.getSelectedItem();
		}
		
		CB1.addItem("Seleccione");
		CB1.setVisible(true);
	}

	
}
