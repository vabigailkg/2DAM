package ventana.paneles;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

public class GestorPanel1 {

	private JPanel panel = null;
	private JButton jButtonPanel = null;
	
	public GestorPanel1 (ArrayList<JPanel> paneles) {
		
		panel = new JPanel();
		panel.setBounds(26, 21, 356, 156);
		panel.setBackground(Color.red);
		
		jButtonPanel = new JButton("Panel 1");
		jButtonPanel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("GoTO -> Panel 2");
				panel.setVisible(false);
				
				// Me falta la referencia panel2
				paneles.get(0).setVisible(false);
				paneles.get(1).setVisible(true);
				paneles.get(2).setVisible(false);
			}
		});
		jButtonPanel.setBounds(60, 60, 89, 23);
		panel.add(jButtonPanel);
		
		panel.setLayout(null);
	}

	public JPanel getPanel() {
		return panel;
	}
}
