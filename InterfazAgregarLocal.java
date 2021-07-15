
import javax.swing.*;
import java.awt.event.*;
public class InterfazAgregarLocal extends JFrame implements ActionListener {
	
	private JLabel lblTitle;
	private JLabel lblNombre;
	private JLabel lblNro;
	private JLabel lblProvincia;
	private JLabel lblDistrito;
	
	private JTextField txtNro;
	private JTextField txtNombre;
	private JTextField txtProvincia;
	private JTextField txtDistrito;
	
	private JButton btnAdd;
	private JButton btnBack;
	
	private InterfazGestionLocales gestionLocales;
	
	public InterfazAgregarLocal(InterfazGestionLocales padre) {
		setLayout(null);
		setTitle("Agregar nuevo local");
		this.gestionLocales=padre;
		
		lblTitle=new JLabel("Agregar nuevo local");
		lblNombre=new JLabel("Nombre: ");
		lblNro=new JLabel("Nro:");
		lblProvincia=new JLabel("Provincia: ");
		lblDistrito=new JLabel("Distrito: ");
		
		txtNro=new JTextField();
		txtNombre=new JTextField();
		txtProvincia=new JTextField();
		txtDistrito=new JTextField();
		
		btnAdd=new JButton("Agregar");
		btnBack=new JButton("<=");
		int largo=150;
		int alto=20;
		
		lblTitle.setBounds(40, 1, 120, alto);
		btnBack.setBounds(20, 20, 50, alto);
		lblNro.setBounds(20, 40,80, alto);
		txtNro.setBounds(20, 60, 60, alto);
		lblNombre.setBounds(20, 80, largo, alto);
		txtNombre.setBounds(20,100,largo,alto);
		
		lblProvincia.setBounds(20, 120, largo, alto);
		txtProvincia.setBounds(20,140,largo,alto);
		lblDistrito.setBounds(20, 160, largo, alto);
		txtDistrito.setBounds(20,180,largo,alto);
		btnAdd.setBounds(20, 210, largo, 30);
		
		add(lblTitle);
		add(btnBack);
		add(lblNro);
		add(txtNro);
		add(lblNombre);
		add(txtNombre);
		//add(lblDireccion);
		add(lblProvincia);
		add(txtProvincia);
		add(lblDistrito);
		add(txtDistrito);
		add(btnAdd);
		
		btnBack.addActionListener(this);
		btnAdd.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {//Para manejar los eventos de botones
		if(e.getSource()==btnBack) {
			this.dispose();
		}
		if(e.getSource()==btnAdd) {
			int nro=Integer.parseInt(txtNro.getText());
			String nombre=txtNombre.getText();
			String provincia=txtNombre.getText();
			String distrito=txtNombre.getText();
			
			Local l1=new Local(new Direccion(distrito,provincia),nombre);
			gestionLocales.getLocales().registrarNuevoLocal(nro, l1);
			gestionLocales.recargarTabla();
			this.dispose();
		}
	}

}
