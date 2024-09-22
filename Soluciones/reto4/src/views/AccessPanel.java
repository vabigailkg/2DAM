package views;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

public class AccessPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel panel = null;
	private static final String THE_IMAGE_FILE = new File("").getAbsolutePath() + "\\src\\img\\logo.png";

	public AccessPanel(ArrayList<JPanel> panels) {
		panel = new JPanel();
		panel.setBounds(0, 0, 1000, 650);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));

		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(62, 202, 27));
		panel_1.setBounds(0, 0, 500, 650);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JButton btnNewButtonLogin = new JButton("Login");
		btnNewButtonLogin.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButtonLogin.setForeground(new Color(62, 202, 27));
		btnNewButtonLogin.setBackground(new Color(58, 58, 58));
		btnNewButtonLogin.setBounds(180, 320, 150, 50);
		panel_1.add(btnNewButtonLogin);

		JLabel lblNewLabel = new JLabel("¿Ya tienes \r\nuna cuenta?");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setForeground(new Color(58, 58, 58));
		lblNewLabel.setBounds(135, 193, 213, 111);
		panel_1.add(lblNewLabel);

		JLabel lblNewLabel2 = new JLabel("LOGO");
		lblNewLabel2.setBounds(32, 33, 150, 150);
		panel_1.add(lblNewLabel2);
		lblNewLabel2.setIcon(new ImageIcon(THE_IMAGE_FILE));

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(58, 58, 58));
		panel_2.setBounds(500, 0, 500, 650);
		panel.add(panel_2);
		panel_2.setLayout(null);

		JButton btnNewButtonRegister = new JButton("Registrarse");
		btnNewButtonRegister.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButtonRegister.setForeground(new Color(58, 58, 58));
		btnNewButtonRegister.setBackground(new Color(62, 202, 27));
		btnNewButtonRegister.setBounds(180, 320, 150, 50);
		panel_2.add(btnNewButtonRegister);

		JLabel lblAccedePorPrimera = new JLabel("Accede por primera vez:");
		lblAccedePorPrimera.setForeground(new Color(62, 202, 27));
		lblAccedePorPrimera.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAccedePorPrimera.setBounds(135, 193, 230, 111);
		panel_2.add(lblAccedePorPrimera);
		btnNewButtonRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panels.get(1).setVisible(false);
				panels.get(14).setVisible(true);
			}
		});
		btnNewButtonLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panels.get(1).setVisible(false);
				panels.get(7).setVisible(true);
			}
		});

	}

	public JPanel getPanel() {
		return panel;
	}
}
