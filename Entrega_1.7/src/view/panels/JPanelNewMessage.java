package view.panels;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class JPanelNewMessage extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField_CampoFecha;
	private JTextField textField_De;
	private JTextField textField_Para;
	private JTextField textField_Asunto;
	private JTextField textField_Contenido;

	/**
	 * Crea el panel para crear nuevos mensajes.
	 */
	public JPanelNewMessage() {
		setLayout(null);
		
		textField_CampoFecha = new JTextField();
		textField_CampoFecha.setBounds(71, 47, 86, 20);
		add(textField_CampoFecha);
		textField_CampoFecha.setColumns(10);
		
		JLabel lblNewLabel_TextoFecha = new JLabel("Fecha");
		lblNewLabel_TextoFecha.setBounds(33, 50, 46, 14);
		add(lblNewLabel_TextoFecha);
		
		JLabel lblNewLabel_TextoHora = new JLabel("Hora");
		lblNewLabel_TextoHora.setBounds(33, 109, 46, 14);
		add(lblNewLabel_TextoHora);
		
		JLabel lblNewLabel_DosPuntos = new JLabel(":");
		lblNewLabel_DosPuntos.setBounds(156, 109, 46, 14);
		add(lblNewLabel_DosPuntos);
		
		JLabel lblNewLabel_TextoDe = new JLabel("De");
		lblNewLabel_TextoDe.setBounds(33, 199, 46, 14);
		add(lblNewLabel_TextoDe);
		
		JLabel lblNewLabel_TextoPara = new JLabel("Para");
		lblNewLabel_TextoPara.setBounds(33, 230, 46, 14);
		add(lblNewLabel_TextoPara);
		
		JLabel lblNewLabel_TextoAsunto = new JLabel("Asunto");
		lblNewLabel_TextoAsunto.setBounds(33, 261, 46, 14);
		add(lblNewLabel_TextoAsunto);
		
		JLabel lblNewLabel_TextoContenido = new JLabel("Contenido");
		lblNewLabel_TextoContenido.setBounds(33, 302, 113, 14);
		add(lblNewLabel_TextoContenido);
		
		JButton btnNewButton_OK = new JButton("OK");
		btnNewButton_OK.setBounds(524, 500, 89, 23);
		add(btnNewButton_OK);
		
		JButton btnNewButton_Cancel = new JButton("Cancel");
		btnNewButton_Cancel.setBounds(647, 500, 89, 23);
		add(btnNewButton_Cancel);
		
		textField_De = new JTextField();
		textField_De.setBounds(99, 196, 472, 20);
		add(textField_De);
		textField_De.setColumns(10);
		
		textField_Para = new JTextField();
		textField_Para.setBounds(99, 227, 472, 20);
		add(textField_Para);
		textField_Para.setColumns(10);
		
		textField_Asunto = new JTextField();
		textField_Asunto.setBounds(99, 258, 472, 20);
		add(textField_Asunto);
		textField_Asunto.setColumns(10);
		
		textField_Contenido = new JTextField();
		textField_Contenido.setBounds(99, 299, 472, 124);
		add(textField_Contenido);
		textField_Contenido.setColumns(10);
		
		JComboBox comboBox_Mes = new JComboBox();
		comboBox_Mes.setBounds(204, 46, 119, 22);
		add(comboBox_Mes);
		
		JComboBox comboBox_1_Dia = new JComboBox();
		comboBox_1_Dia.setBounds(370, 46, 57, 22);
		add(comboBox_1_Dia);
		
		JComboBox comboBox_2_Minuto = new JComboBox();
		comboBox_2_Minuto.setBounds(166, 105, 57, 22);
		add(comboBox_2_Minuto);
		
		JComboBox comboBox_3_Hora = new JComboBox();
		comboBox_3_Hora.setBounds(71, 105, 75, 22);
		add(comboBox_3_Hora);

	}
}
