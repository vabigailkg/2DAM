package views;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Color;

public class WelcomePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel panel = null;
	private static final String THE_IMAGE_FILE = new File("").getAbsolutePath() + "\\src\\img\\logo.png";

	public WelcomePanel(ArrayList<JPanel> panels) {
		panel = new JPanel();
		panel.setBackground(new Color(58, 58, 58));
		panel.setBounds(0, 0, 1000, 650);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
						panels.get(0).setVisible(false);
						panels.get(1).setVisible(true);
					}
		});
		
		JLabel lblNewLabel = new JLabel("LOGO");
		lblNewLabel.setBounds(389, 238, 150, 150);
		lblNewLabel.setIcon(new ImageIcon(THE_IMAGE_FILE));
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
						panels.get(0).setVisible(false);
						panels.get(1).setVisible(true);
					}
		});
		panel.add(lblNewLabel);
		
		panel.setLayout(null);
		
		JTextArea txtrLoremIpsumDolor = new JTextArea();
		txtrLoremIpsumDolor.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtrLoremIpsumDolor.setBackground(new Color(58, 58, 58));
		txtrLoremIpsumDolor.setForeground(new Color(62, 202, 27));
		txtrLoremIpsumDolor.setText("   Lorem ipsum dolor sit amet, consectetur adipiscing elit.\r\n Nulla at egestas lectus. Suspendisse aliquam imperdiet eros,\r\n              non luctus metus condimentum aliquet.\r\n\tFusce dignissim est nibh.\r\n");
		txtrLoremIpsumDolor.setBounds(235, 471, 411, 106);
		txtrLoremIpsumDolor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
						panels.get(0).setVisible(false);
						panels.get(1).setVisible(true);
					}
		});
		panel.add(txtrLoremIpsumDolor);
		
		JLabel lblNewLabelWelcome = new JLabel("¡Bienvenido!");
		lblNewLabelWelcome.setFont(new Font("Tahoma", Font.BOLD, 60));
		lblNewLabelWelcome.setForeground(new Color(62, 202, 27));
		lblNewLabelWelcome.setBackground(new Color(58, 58, 58));
		lblNewLabelWelcome.setBounds(298, 29, 420, 167);
		lblNewLabelWelcome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
						panels.get(0).setVisible(false);
						panels.get(1).setVisible(true);
					}
		});
		panel.add(lblNewLabelWelcome);
	}
	
	public JPanel getPanel() {
		return panel;
	}
}
