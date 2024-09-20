package vistas.ventanas.paneles;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Panel Ej1
 */
public class JPanelEj1 {

	private static final String USER_ADMIN = "admin";
	private static final String CLAVE_ADMIN = "admin";

	/**
	 * Retorna un nuevo panel en las coordenadas y con las dimensiones indicadas
	 * 
	 * @param x      la nueva coordenada <i>x</i> del panel
	 * @param y      la nueva coordenada <i>y</i> del panel
	 * @param width  la nueva anchura del panel
	 * @param height la nueva altura del panel
	 * @param name   el nombre del panel
	 * @return El panel
	 */
	public JPanel getJPanel(int x, int y, int width, int height, String name) {
		JPanel ret = null;

		ret = new JPanel();
		ret.setBounds(x, y, width, height);
		ret.setLayout(null);
		ret.setName(name);

		JTextField jTextLogin = new JTextField();
		jTextLogin.setBounds(170, 40, 86, 20);
		ret.add(jTextLogin);
		jTextLogin.setColumns(10);

		JTextField jTextPass = new JTextField();
		jTextPass.setColumns(10);
		jTextPass.setBounds(170, 90, 86, 20);
		ret.add(jTextPass);

		JLabel jLabelLogin = new JLabel();
		jLabelLogin.setText("LOGIN");
		jLabelLogin.setBounds(122, 40, 38, 20);
		ret.add(jLabelLogin);

		JLabel jLabelPass = new JLabel();
		jLabelPass.setText("PASSWORD");
		jLabelPass.setBounds(103, 90, 57, 20);
		ret.add(jLabelPass);

		JButton btnNewButton = new JButton("Saludo");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ((null != jTextLogin.getText()) && (!jTextLogin.getText().isEmpty())
						&& (jTextLogin.getText().equalsIgnoreCase(USER_ADMIN)) && (null != jTextPass.getText())
						&& (!jTextPass.getText().isEmpty()) && (jTextPass.getText().equalsIgnoreCase(CLAVE_ADMIN))) {
					JOptionPane.showMessageDialog(null, "Bienvenido a la app...", "Informacion",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "Usuario o pass desconocido", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton.setBounds(170, 130, 89, 23);
		ret.add(btnNewButton);

		return ret;
	}

}
