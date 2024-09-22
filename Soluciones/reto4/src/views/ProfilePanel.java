   package views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ProfilePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel panel = null;
	private JTextField textFieldName;
	private JTextField textFieldFirstSurname;
	private JTextField textFieldSecondSurname;
	private JTextField textFieldIDCard;
	private JTextField textFieldBirthday;
	private JTextField textFieldAddress;
	private JTextField textFieldPostalCode;
	private JTextField textFieldCity;
	private JTextField textFieldProvince;
	private JTextField textFieldLogin;
	private JTextField textFieldPassword;
	private JTextField textFieldPassword2;
	private JTextField textFieldCVV;
	private JTextField textFieldCreditCard;
	private JTextField textFieldExpiration;
	private static final String THE_IMAGE_FILE = new File("").getAbsolutePath() + "\\src\\img\\logo.png";
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Create the panel.
	 */
	public ProfilePanel(ArrayList<JPanel> panels) {
		panel = new JPanel();
		panel.setBounds(0, 0, 1000, 650);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		JLabel lblNewLabelName = new JLabel("Nombre");
		lblNewLabelName.setBounds(204, 63, 46, 14);
		panel.add(lblNewLabelName);

		JLabel lblNewLabelFirstSurname = new JLabel("Apellido 1");
		lblNewLabelFirstSurname.setBounds(204, 95, 46, 14);
		panel.add(lblNewLabelFirstSurname);

		JLabel lblNewLabelSecondSurname = new JLabel("Apellido 2");
		lblNewLabelSecondSurname.setBounds(204, 120, 46, 14);
		panel.add(lblNewLabelSecondSurname);

		JLabel lblNewLabelIDCard = new JLabel("DNI");
		lblNewLabelIDCard.setBounds(204, 150, 46, 14);
		panel.add(lblNewLabelIDCard);

		JLabel lblNewLabelBirthday = new JLabel("Fecha de nacimiento");
		lblNewLabelBirthday.setBounds(158, 183, 92, 14);
		panel.add(lblNewLabelBirthday);

		JLabel lblNewLabelAddress = new JLabel("Direccion");
		lblNewLabelAddress.setBounds(204, 207, 46, 14);
		panel.add(lblNewLabelAddress);

		JLabel lblNewLabelPostalCode = new JLabel("Codigo Postal");
		lblNewLabelPostalCode.setBounds(204, 243, 46, 14);
		panel.add(lblNewLabelPostalCode);

		JLabel lblNewLabelCity = new JLabel("Ciudad");
		lblNewLabelCity.setBounds(204, 273, 46, 14);
		panel.add(lblNewLabelCity);

		JLabel lblNewLabelProvince = new JLabel("Provincia");
		lblNewLabelProvince.setBounds(204, 303, 46, 14);
		panel.add(lblNewLabelProvince);

		JLabel lblNewLabelLogin = new JLabel("Login");
		lblNewLabelLogin.setBounds(449, 63, 46, 14);
		panel.add(lblNewLabelLogin);

		JLabel lblNewLabelPassword = new JLabel("Password");
		lblNewLabelPassword.setBounds(449, 95, 46, 14);
		panel.add(lblNewLabelPassword);

		JLabel lblNewLabelPassword2 = new JLabel("Password");
		lblNewLabelPassword2.setBounds(449, 123, 46, 14);
		panel.add(lblNewLabelPassword2);

		JLabel lblNewLabelUserType = new JLabel("Tipo de Usuario");
		lblNewLabelUserType.setBounds(449, 150, 109, 14);
		panel.add(lblNewLabelUserType);

		JLabel lblNewLabelCreditCard = new JLabel("Numero de tarjeta");
		lblNewLabelCreditCard.setBounds(449, 243, 46, 14);
		panel.add(lblNewLabelCreditCard);

		JLabel lblNewLabelExpiration = new JLabel("Caducidad");
		lblNewLabelExpiration.setBounds(449, 273, 46, 14);
		panel.add(lblNewLabelExpiration);

		JLabel lblNewLabelCVV = new JLabel("CVV");
		lblNewLabelCVV.setBounds(449, 303, 46, 14);
		panel.add(lblNewLabelCVV);
		
		JLabel lblNewLabel = new JLabel("LOGO");
		lblNewLabel.setBounds(10, 27, 150, 150);
		lblNewLabel.setIcon(new ImageIcon(THE_IMAGE_FILE));
		panel.add(lblNewLabel);
		
		JRadioButton rdbtnNewRadioButtonFree = new JRadioButton("Libre");
		rdbtnNewRadioButtonFree.setBounds(247, 141, 109, 23);
		panel.add(rdbtnNewRadioButtonFree);
		
		JRadioButton rdbtnNewRadioButtonPremium = new JRadioButton("Premium");
		rdbtnNewRadioButtonPremium.setBounds(247, 166, 109, 23);
		panel.add(rdbtnNewRadioButtonPremium);
		// free by default
				rdbtnNewRadioButtonFree.setSelected(true);
				// Add type of accounts buttons to a group
				buttonGroup.add(rdbtnNewRadioButtonFree);
				buttonGroup.add(rdbtnNewRadioButtonPremium);

				rdbtnNewRadioButtonFree.setBounds(449, 179, 109, 23);
				panel.add(rdbtnNewRadioButtonFree);

				rdbtnNewRadioButtonPremium.setBounds(449, 203, 109, 23);
				panel.add(rdbtnNewRadioButtonPremium);

				textFieldName = new JTextField();
				textFieldName.setBounds(285, 61, 86, 20);
				panel.add(textFieldName);
				textFieldName.setColumns(10);

				textFieldFirstSurname = new JTextField();
				textFieldFirstSurname.setBounds(285, 93, 86, 20);
				panel.add(textFieldFirstSurname);
				textFieldFirstSurname.setColumns(10);

				textFieldSecondSurname = new JTextField();
				textFieldSecondSurname.setColumns(10);
				textFieldSecondSurname.setBounds(285, 121, 86, 20);
				panel.add(textFieldSecondSurname);

				textFieldIDCard = new JTextField();
				textFieldIDCard.setColumns(10);
				textFieldIDCard.setBounds(285, 148, 86, 20);
				panel.add(textFieldIDCard);

				textFieldBirthday = new JTextField();
				textFieldBirthday.setColumns(10);
				textFieldBirthday.setBounds(285, 181, 86, 20);
				panel.add(textFieldBirthday);

				textFieldAddress = new JTextField();
				textFieldAddress.setColumns(10);
				textFieldAddress.setBounds(285, 211, 86, 20);
				panel.add(textFieldAddress);

				textFieldPostalCode = new JTextField();
				textFieldPostalCode.setColumns(10);
				textFieldPostalCode.setBounds(285, 241, 86, 20);
				panel.add(textFieldPostalCode);

				textFieldCity = new JTextField();
				textFieldCity.setColumns(10);
				textFieldCity.setBounds(285, 271, 86, 20);
				panel.add(textFieldCity);

				textFieldProvince = new JTextField();
				textFieldProvince.setColumns(10);
				textFieldProvince.setBounds(285, 301, 86, 20);
				panel.add(textFieldProvince);

				textFieldLogin = new JTextField();
				textFieldLogin.setColumns(10);
				textFieldLogin.setBounds(520, 61, 86, 20);
				panel.add(textFieldLogin);

				textFieldPassword = new JPasswordField();
				textFieldPassword.setColumns(10);
				textFieldPassword.setBounds(520, 93, 86, 20);
				panel.add(textFieldPassword);

				textFieldPassword2 = new JPasswordField();
				textFieldPassword2.setColumns(10);
				textFieldPassword2.setBounds(520, 123, 86, 20);
				panel.add(textFieldPassword2);

				textFieldCVV = new JTextField();
				textFieldCVV.setColumns(10);
				textFieldCVV.setBounds(520, 301, 86, 20);
				panel.add(textFieldCVV);

				textFieldCreditCard = new JTextField();
				textFieldCreditCard.setColumns(10);
				textFieldCreditCard.setBounds(520, 241, 86, 20);
				panel.add(textFieldCreditCard);

				textFieldExpiration = new JTextField();
				textFieldExpiration.setColumns(10);
				textFieldExpiration.setBounds(520, 271, 86, 20);
				panel.add(textFieldExpiration);

		
		JButton btnNewButtonGoBack = new JButton("Volver");
		btnNewButtonGoBack.setBounds(282, 349, 89, 23);
		btnNewButtonGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panels.get(13).setVisible(false);
				panels.get(8).setVisible(true);
			}
		});
		panel.add(btnNewButtonGoBack);
		
		JButton btnNewButtonModifyPassword = new JButton("CambiarContrasenna");
		btnNewButtonModifyPassword.setBounds(449, 349, 89, 23);
		btnNewButtonModifyPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panels.get(13).setVisible(false);
				panels.get(8).setVisible(true);
			}
		});
		panel.add(btnNewButtonModifyPassword);
		
		panel.setLayout(null);

	}
	public JPanel getPanel() {
		return panel;
	}

}