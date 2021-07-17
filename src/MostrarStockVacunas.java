import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MostrarStockVacunas extends JFrame implements ActionListener{
	private Local reflocal;
	private JLabel labelVacuna;
	private JTextArea txtArea;
	private JButton BT1;
	private JScrollPane scrollpane1;
	public MostrarStockVacunas(Local reflocal) {
		this.reflocal=reflocal;
		this.getContentPane().setBackground(Color.decode("#d2fdbc"));
		setLayout(null);
		labelVacuna = new JLabel("Stock Vacunas");
		labelVacuna.setBounds(120,0,500,50);
		labelVacuna.setFont(new Font("Helvetica",Font.BOLD, 20));
		add(labelVacuna);
		
		setLayout(null);
		BT1 = new JButton("Retornar");
		BT1.setBounds(35,42,100,30);
		add(BT1);
		BT1.addActionListener(this);
		
		setLayout(null);
		
		txtArea = new JTextArea();
		txtArea.setText(reflocal.getInventario().toString());
	    txtArea.setEditable(false);
	    scrollpane1 = new JScrollPane(txtArea);
		scrollpane1.setBounds(35,80,300,230);//(x,y,ancho,alto)
		add(scrollpane1);
	}
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==BT1) {
			this.setDefaultCloseOperation(EXIT_ON_CLOSE);
			//Principal principal1 = new Principal(reflocal);
			//principal1.setBounds(0,0,400,500);
			//principal1.setVisible(true);
			//principal1.setLocationRelativeTo(null);
			this.setVisible(false);

		}
		
	}
}
