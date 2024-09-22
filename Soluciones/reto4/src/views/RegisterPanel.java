package views;

import javax.swing.JPanel;

import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import db.management.PremiumUserManager;
import db.management.UserManager;
import db.pojos.FreeUser;
import db.pojos.PremiumUser;
import panelControllers.RegisterPanelController;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;

public class RegisterPanel extends JPanel {

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
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private String accountType = "free";
	private static final String THE_IMAGE_FILE = new File("").getAbsolutePath() + "\\src\\img\\logo.png";

	/**
	 * Create the panel.
	 */
	public RegisterPanel(ArrayList<JPanel> panels) {

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
		rdbtnNewRadioButtonFree.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				accountType = "free";
				lblNewLabelCreditCard.setVisible(false);
				lblNewLabelExpiration.setVisible(false);
				lblNewLabelCVV.setVisible(false);
				textFieldCVV.setVisible(false);
				textFieldCreditCard.setVisible(false);
				textFieldExpiration.setVisible(false);
			}
		});

		JRadioButton rdbtnNewRadioButtonPremium = new JRadioButton("Premium");
		rdbtnNewRadioButtonPremium.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				accountType = "premium";
				lblNewLabelCreditCard.setVisible(true);
				lblNewLabelExpiration.setVisible(true);
				lblNewLabelCVV.setVisible(true);
				textFieldCVV.setVisible(true);
				textFieldCreditCard.setVisible(true);
				textFieldExpiration.setVisible(true);
			}
		});

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

		lblNewLabelCreditCard.setVisible(false);
		lblNewLabelExpiration.setVisible(false);
		lblNewLabelCVV.setVisible(false);
		textFieldCVV.setVisible(false);
		textFieldCreditCard.setVisible(false);
		textFieldExpiration.setVisible(false);

		JButton btnNewButtonCancel = new JButton("Cancelar");
		btnNewButtonCancel.setBounds(305, 360, 89, 23);
		btnNewButtonCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// If data its correct TO-DO
				panels.get(14).setVisible(false);
				panels.get(1).setVisible(true);
			}
		});
		panel.add(btnNewButtonCancel);

		JButton btnNewButtonRegister = new JButton("Registro");
		btnNewButtonRegister.setBounds(445, 360, 89, 23);
		btnNewButtonRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (true == checkAccountDataRegister()) {
					RegisterPanelController registerPanelController = new RegisterPanelController();
					if (accountType.equals("premium")) {
						try {
							registerPanelController.registerPremiumAccount(setDataNewPremiumUser());
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					} else {
						try {
							registerPanelController.registerFreeAccount(setDataNewFreeUser());
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
				rdbtnNewRadioButtonFree.setSelected(true); // Reset user to free after an attempt

				panels.get(14).setVisible(false);
				panels.get(8).setVisible(true);
			}
		});
		panel.add(btnNewButtonRegister);

		panel.setLayout(null);

	}

	PremiumUserManager registerPremiumAcount = new PremiumUserManager();

	private boolean checkAccountDataRegister() {
		boolean ret = false;
		if (accountType.equals("premium")) { // checking necessary data for premium acount
			if (checkCommonAcountDataRegister() && checkPremiumlAcountDataRegister()
					&& checkFreelAcountDataRegister()) {
				ret = true;
			} else {
				// mensaje --> no se ha podido registrar al usuario
				JOptionPane.showMessageDialog(null, "No ha podido ser registrado el usuario premium.");
			}
		} else { // checking necessary data for free acount
			if (checkCommonAcountDataRegister() && checkFreelAcountDataRegister()) {
				// if data is correct
				ret = true;
			} else {
				// mensaje --> no se ha podido registrar al usuario
				JOptionPane.showMessageDialog(null, "No ha podido ser registrado el usuario libre.");
			}
		}

		// After check data, set data to null
		
		//Desactivo esto para hacer pruebas, reactivar despues.
		//setCommonlDataNull();
		//setFreeDataNull();
		//setPremiumDataNull();

		return ret;
	}

	private FreeUser setDataNewFreeUser() throws ParseException {
		FreeUser freeUser = new FreeUser();
		RegisterPanelController registerPanel = new RegisterPanelController();

		freeUser.setName(textFieldName.getText());
		freeUser.setFirstSurname(textFieldFirstSurname.getText());
		freeUser.setSecondSurname(textFieldSecondSurname.getText()); // not mandatory
		freeUser.setIdCard(textFieldIDCard.getText()); // 8 numbers with 1 letter
		freeUser.setBirthday(registerPanel.convertStringToDate(textFieldBirthday.getText()));
		freeUser.setAddress(textFieldAddress.getText());
		freeUser.setPostalCode(textFieldPostalCode.getText()); // valid in spain
		freeUser.setCity(textFieldCity.getText());
		freeUser.setProvince(textFieldProvince.getText()); // valid in spain
		freeUser.setLogin(textFieldLogin.getText()); // at least 3 char, unique
		freeUser.setPassword(textFieldPassword.getText());
		freeUser.setUserType(registerPanel.obtainTypeUserInSpanish(accountType));

		freeUser.setRegisterDate(new Date());

		return freeUser;

	}

	private PremiumUser setDataNewPremiumUser() throws ParseException {
		PremiumUser premiumUser = new PremiumUser();
		RegisterPanelController registerPanel = new RegisterPanelController();

		premiumUser.setName(textFieldName.getText());
		premiumUser.setFirstSurname(textFieldFirstSurname.getText());
		premiumUser.setSecondSurname(textFieldSecondSurname.getText()); // not mandatory
		premiumUser.setIdCard(textFieldIDCard.getText()); // 8 numbers with 1 letter
		premiumUser.setBirthday(registerPanel.convertStringToDate(textFieldBirthday.getText()));
		premiumUser.setAddress(textFieldAddress.getText());
		premiumUser.setPostalCode(textFieldPostalCode.getText()); // valid in spain
		premiumUser.setCity(textFieldCity.getText());
		premiumUser.setProvince(textFieldProvince.getText()); // valid in spain
		premiumUser.setLogin(textFieldLogin.getText()); // at least 3 char, unique
		premiumUser.setPassword(textFieldPassword.getText());
		premiumUser.setUserType(registerPanel.obtainTypeUserInSpanish(accountType));

		premiumUser.setCardNumber(Long.parseLong(textFieldCreditCard.getText()));
		premiumUser.setExpirationDate(textFieldExpiration.getText());
		premiumUser.setCvv(Integer.parseInt(textFieldCVV.getText()));

		premiumUser.setRegisterDate(new Date());

		return premiumUser;
	}

	private boolean checkCommonAcountDataRegister() {
		PremiumUserManager premiumUserManager = new PremiumUserManager();
		UserManager userManager = new UserManager();
		boolean ret = false;

		List<String> spanishProvinces = Arrays.asList("alava", "albacete", "alicante", "almeria", "asturias", "avila",
				"badajoz", "baleares", "barcelona", "burgos", "caceres", "cadiz", "cantabria", "castellon",
				"ciudad real", "cordoba", "cuenca", "girona", "granada", "guadalajara", "guipuzcoa", "huelva", "huesca",
				"jaen", "la coruna", "la rioja", "las palmas", "leon", "lerida", "lugo", "madrid", "malaga", "murcia",
				"navarra", "orense", "palencia", "pontevedra", "salamanca", "segovia", "sevilla", "soria", "tarragona",
				"santa cruz de tenerife", "teruel", "toledo", "valencia", "valladolid", "vizcaya", "zamora", "zaragoza",
				"ceuta", "melilla");

		if (textFieldName.getText().isEmpty() || textFieldFirstSurname.getText().isEmpty()
				|| textFieldIDCard.getText().isEmpty() || textFieldBirthday.getText().isEmpty()
				|| textFieldAddress.getText().isEmpty() || textFieldPostalCode.getText().isEmpty()
				|| textFieldCity.getText().isEmpty() || textFieldProvince.getText().isEmpty()
				|| textFieldLogin.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Debe completar todos los campos");
		} else if (!textFieldIDCard.getText().trim().matches("^[0-9]{8}[A-Za-z]$")) {
			JOptionPane.showMessageDialog(null, "El DNI no es correcto");
		} else if (!textFieldPostalCode.getText().matches("^(?:0[1-9]\\d{3}|[1-4]\\d{4}|5[0-2]\\d{3})$")) {
			JOptionPane.showMessageDialog(null, "Código postal no es valido");
		} else if (!spanishProvinces.contains(textFieldProvince.getText().trim().toLowerCase())) {
			JOptionPane.showMessageDialog(null,
					"La provincia '" + textFieldProvince.getText() + "' no existe en España");
		} else
			try {
				
				if (userManager.checkIfUserExists(textFieldLogin.getText().trim())) {
					JOptionPane.showMessageDialog(null, "Ya hay un usuario con ese login");
				} else {
					ret = true;
				}
			} catch (HeadlessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		return ret;
	}

	private boolean checkFreelAcountDataRegister() {
		boolean ret = false;
		// TypeOfUser: global variable

		// password at least 6 chars, combination of at least one uppercase, lowercase
		// and one number
		// password2 need to be equal to password
		// user free by default

		if (textFieldPassword.getText().isEmpty() || textFieldPassword2.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Debe completar todos los campos");
		} else if (!(String.valueOf(((JPasswordField) textFieldPassword).getPassword())
				.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9]).{6,}$"))) {
			JOptionPane.showMessageDialog(null, "Formato no valido");
		} else if (!(String.valueOf(((JPasswordField) textFieldPassword).getPassword())
				.equals(String.valueOf(((JPasswordField) textFieldPassword2).getPassword())))) {
			JOptionPane.showMessageDialog(null, "Las contrasennias no coinciden");
		} else {
			ret = true;
		}

		return ret;
	}

	private boolean checkPremiumlAcountDataRegister() {
		boolean ret = false;

		if (textFieldCreditCard.getText().isEmpty() || textFieldExpiration.getText().isEmpty()
				|| textFieldCVV.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Debe completar todos los campos");
		} else if (!(textFieldCreditCard.getText().length() == 18)) {
			JOptionPane.showMessageDialog(null, "La tarjeta de credito tiene que tener 18 digitos");
		} else if (!textFieldExpiration.getText().matches("^(0[1-9]|1[0-2])/\\d{2}$")) {	// format 10/25 -> month 10 year 25 
			JOptionPane.showMessageDialog(null, "Fecha de no es valido la fecha de expiracion");
		} else if (!(textFieldCVV.getText().length() == 4)) {
			JOptionPane.showMessageDialog(null, "El CVV tiene que tener 4 digitoss");
		} else {
			ret = true;
		}
		return ret;

	}

	/*
	 * private void registerCommonAcount() { // Como mando el tipo de cuenta a la
	 * BD? //Que no me olvide de la fecha de LocalDate currentDate =
	 * LocalDate.now(); String registerDate = currentDate.toString(); String
	 * accesDate = currentDate.toString(); PremiumUserManager premiumUserManager =
	 * new PremiumUserManager(); // registro, esa seguramente la hare desde java con
	 * SQL. premiumUserManager.registerCommonAcount(textFieldName.getText().trim(),
	 * textFieldFirstSurname.getText().trim(),
	 * textFieldSecondSurname.getText().trim(), textFieldIDCard.getText().trim(),
	 * textFieldBirthday.getText().trim(), textFieldAddress.getText().trim(),
	 * textFieldPostalCode.getText().trim(), textFieldCity.getText().trim(),
	 * textFieldProvince.getText().trim(), textFieldLogin.getText().trim(),
	 * textFieldPassword.getText().trim(), accountType, accesDate, registerDate); }
	 */
	/*
	 * private void registerPremiumlAcount() {
	 * 
	 * PremiumUserManager premiumUserManager = new PremiumUserManager();
	 * premiumUserManager.registerPremiumAcount(textFieldIDCard.getText().trim(),
	 * textFieldCreditCard.getText().trim(), textFieldExpiration.getText().trim(),
	 * textFieldCVV.getText().trim()); }
	 */
	private void setCommonlDataNull() {
		textFieldName.setText(null);
		textFieldFirstSurname.setText(null);
		textFieldSecondSurname.setText(null);
		textFieldPassword.setText(null);
		textFieldIDCard.setText(null);
		textFieldBirthday.setText(null);
		textFieldAddress.setText(null);
		textFieldPostalCode.setText(null);
		textFieldCity.setText(null);
		textFieldProvince.setText(null);
		textFieldLogin.setText(null);
	}

	private void setFreeDataNull() {
		textFieldPassword.setText(null);
		textFieldPassword2.setText(null);
	}

	private void setPremiumDataNull() {
		textFieldCreditCard.setText(null);
		textFieldExpiration.setText(null);
		textFieldCVV.setText(null);
	}

	public JPanel getPanel() {
		return panel;
	}
}
