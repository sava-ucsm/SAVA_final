import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.*;

public class InterfazEnviarVacuna extends JFrame implements ActionListener {
	
		private Local reflocal;
		private JLabel label1, label2;
		private JButton BT1,BT2;
		private JComboBox CB1, CB2;
		private JTextArea TXTA1;
		private JScrollPane scrollpane;
		
		
		public InterfazEnviarVacuna(Local reflocal) {
			this.reflocal=reflocal;
			
			this.setTitle("SAVA - Enviar Vacunas");
			setLayout(null);
			
			label1 = new JLabel("Local de Origen: ");
			label1.setBounds(10,60,100,30);
			add(label1);
			CB1 = new JComboBox<Local>();
			CB1.setBounds(120,63,150,20);
			add(CB1);
			
			label2 = new JLabel("Local de Destino: ");
			label2.setBounds(10,60,100,30);
			add(label2);
			CB2 = new JComboBox();
			CB2.setBounds(120,63,150,20);
			add(CB2);
			
		 	
			BT1 = new JButton("Enviar");
			BT1.setBounds(10,120,100,30);
			BT1.setForeground(Color.white);
			BT1.setBackground(Color.decode("#418325"));
			add(BT1);
			BT1.addActionListener(this);
			
			BT2 = new JButton("Retornar");
			BT2.setBounds(160,120,100,30);
			BT2.setForeground(Color.white);
			BT2.setBackground(Color.decode("#418325"));
			add(BT2);
			BT2.addActionListener(this);
			
			TXTA1 = new JTextArea();
			TXTA1.setEditable(false);
			scrollpane = new JScrollPane(TXTA1);
			scrollpane.setBounds(20,40,340,300);//(x,y,ancho,alto)
			scrollpane.setVisible(false);
			add(scrollpane);
		}
		
		
		
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
