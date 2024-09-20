package vistas.ventanas.paneles;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Panel Panel Ej3
 */
public class JPanelEj3 {

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
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(10, 11, 46, 14);
		ret.add(lblNewLabel);

		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(10, 36, 46, 14);
		ret.add(lblApellido);

		JLabel lblNewLabel_1 = new JLabel("Apellido 2");
		lblNewLabel_1.setBounds(10, 61, 46, 14);
		ret.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Edad");
		lblNewLabel_2.setBounds(10, 86, 46, 14);
		ret.add(lblNewLabel_2);

		JTextField jTextFieldNombre = new JTextField();
		jTextFieldNombre.setBounds(70, 8, 86, 20);
		ret.add(jTextFieldNombre);
		jTextFieldNombre.setColumns(10);

		JTextField jTextFieldApellido1 = new JTextField();
		jTextFieldApellido1.setBounds(70, 33, 86, 20);
		ret.add(jTextFieldApellido1);
		jTextFieldApellido1.setColumns(10);

		JTextField jTextFieldApellido2 = new JTextField();
		jTextFieldApellido2.setBounds(70, 58, 86, 20);
		ret.add(jTextFieldApellido2);
		jTextFieldApellido2.setColumns(10);

		JTextField jTextFieldEdad = new JTextField();
		jTextFieldEdad.setBounds(70, 83, 86, 20);
		ret.add(jTextFieldEdad);
		jTextFieldEdad.setColumns(10);

		JComboBox<String> jComboBox = new JComboBox<String>();
		jComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		jComboBox.addItem("DNI");
		jComboBox.addItem("NIE");
		jComboBox.setBounds(10, 111, 46, 22);
		ret.add(jComboBox);

		JTextField jTextFieldDNINIE = new JTextField();
		jTextFieldDNINIE.setColumns(10);
		jTextFieldDNINIE.setBounds(70, 112, 86, 20);
		ret.add(jTextFieldDNINIE);

		JTextField jTextFieldResumen = new JTextField();
		jTextFieldResumen.setBounds(232, 11, 171, 130);
		ret.add(jTextFieldResumen);
		jTextFieldResumen.setColumns(10);
		
		JButton jButtonAceptar = new JButton("Aceptar");
		jButtonAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (((String) jComboBox.getSelectedItem()).equals("DNI")) {
					boolean isDNI = validar("[0-9]{8}[a-zA-Z]", jTextFieldDNINIE.getText());
					if (isDNI) {
						jTextFieldResumen.setText(jTextFieldNombre.getText() + jTextFieldApellido1.getText()
								+ jTextFieldApellido2.getText() + jTextFieldEdad.getText() + jTextFieldDNINIE.getText());
					} else {
						JOptionPane.showMessageDialog(null, "No es un DNI", "Error", JOptionPane.ERROR_MESSAGE);
					}
				} else {
					jTextFieldResumen.setText(jTextFieldNombre.getText() + jTextFieldApellido1.getText()
							+ jTextFieldApellido2.getText() + jTextFieldEdad.getText() + jTextFieldDNINIE.getText());
				}
			}
		});
		jButtonAceptar.setBounds(70, 140, 89, 23);
		ret.add(jButtonAceptar);

		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jTextFieldResumen.setText("");
				jTextFieldNombre.setText("");
				jTextFieldApellido1.setText("");
				jTextFieldApellido2.setText("");
				jTextFieldEdad.setText("");
				jTextFieldDNINIE.setText("");
			}
		});
		btnLimpiar.setBounds(280, 172, 89, 23);
		ret.add(btnLimpiar);
		
		return ret;
	}
	
	private static boolean validar(String pattern, String texto) {
		boolean ret = false;
		Pattern patron = Pattern.compile(pattern);
		Matcher mat = patron.matcher(texto);
		if (mat.matches())
			ret = true;
		return ret;
	}
}
