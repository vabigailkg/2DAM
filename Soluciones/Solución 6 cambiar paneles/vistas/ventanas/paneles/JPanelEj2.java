package vistas.ventanas.paneles;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 * Panel Panel Ej2
 */
public class JPanelEj2 {

	/**
	 * Retorna un nuevo panel en las coordenadas y con las dimensiones
	 * indicadas
	 * 
	 * @param x      la nueva coordenada <i>x</i> del panel
	 * @param y      la nueva coordenada <i>y</i> del panel
	 * @param width  la nueva anchura del panel
	 * @param height la nueva altura del panel
	 * @param name 	 el nombre del panel
	 * @return El panel
	 */
	public JPanel getJPanel(int x, int y, int width, int height, String name) {
		JPanel ret = null;

		ret = new JPanel();
		ret.setBounds(x, y, width, height);
		ret.setLayout(null);
		ret.setName(name);
		
		JTextField jTextField = new JTextField();
		jTextField.setBounds(10, 11, 149, 20);
		jTextField.setColumns(10);
		ret.add(jTextField);
		
		JLabel jLabel = new JLabel("¿Cuál es el mejor juego?");
		jLabel.setBounds(10, 11, 149, 31);
		
		JRadioButton jRadioButton1 = new JRadioButton("Fallout 3");
		JRadioButton jRadioButton2 = new JRadioButton("Fallout New Vegas");		
		JRadioButton jRadioButton3 = new JRadioButton("Fallout 4");
		JRadioButton jRadioButton4 = new JRadioButton("Fallout 76");
		
		jRadioButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jTextField.setText("Fallout 3");
				jRadioButton2.setSelected(false);
				jRadioButton3.setSelected(false);
				jRadioButton4.setSelected(false);
			}
		});
		jRadioButton1.setBounds(10, 49, 149, 23);
		ret.add(jRadioButton1);

		jRadioButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jTextField.setText("Fallout New Vegas");
				jRadioButton1.setSelected(false);
				jRadioButton3.setSelected(false);
				jRadioButton4.setSelected(false);
			}
		});
		jRadioButton2.setBounds(10, 74, 149, 23);
		ret.add(jRadioButton2);

		jRadioButton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jTextField.setText("Fallout 4");
				jRadioButton1.setSelected(false);
				jRadioButton2.setSelected(false);
				jRadioButton4.setSelected(false);
			}
		});
		jRadioButton3.setBounds(10, 100, 149, 23);
		ret.add(jRadioButton3);

		jRadioButton4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jTextField.setText("Buen intento...");
				jRadioButton1.setSelected(false);
				jRadioButton2.setSelected(false);
				jRadioButton3.setSelected(false);
			}
		});
		jRadioButton4.setBounds(10, 126, 149, 23);
		ret.add(jRadioButton4);

		ImageIcon imageIcon = new ImageIcon(this.getClass().getResource("Fallout.jpg"));
		JLabel jLabelImage = new JLabel("", imageIcon, JLabel.CENTER);

		JPanel jPanelImage = new JPanel();
		jPanelImage.setBounds(167, 11, 257, 239);
		jPanelImage.add(jLabelImage, JPanel.CENTER_ALIGNMENT);
		ret.add(jPanelImage);
		
		return ret;
	}	
}
