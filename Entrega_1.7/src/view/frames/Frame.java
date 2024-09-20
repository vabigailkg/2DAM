package view.frames;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import view.panels.JPanelMenu;
import view.panels.JPanelNewMessage;
import view.panels.JPanelPrintMessage;

import javax.swing.JButton;

public class Frame extends JFrame {

	//Ventana
	private JFrame frame = null;
	
	//Medidas de ventana
	private static final int FRAME_X = 100;
	private static final int FRAME_Y = 100;
	private static final int FRAME_WIDTH = 450;
	private static final int FRAME_HEIGHT = 300;
	
	//Medidas de paneles
	private static final int PANEL_X = 26;
	private static final int PANEL_Y = 21;
	private static final int PANEL_WIDTH = 356;
	private static final int PANEL_HEIGHT = 156;
	
	//Constructor
		public Frame() {
			frame = new JFrame();
		}
		
	//Ejecutar ventana con paneles
		public void initialize() {
			
			//Parametros de ventana
			frame.setBounds(FRAME_X, FRAME_Y, FRAME_WIDTH, FRAME_HEIGHT);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().setLayout(null);
			
			//Crear los paneles según su clase
			JPanelMenu menu = new JPanelMenu();
			JPanelNewMessage newMessage = new JPanelNewMessage();			
			JPanelPrintMessage printMessage = new JPanelPrintMessage();			
			
			//Aplicar medidas de paneles
			JPanel panelMenu = menu.getJPanel(PANEL_X, PANEL_Y, PANEL_WIDTH, PANEL_HEIGHT, "panelMenu");
			JPanel panelNewMessage = newMessage.getJPanel(PANEL_X, PANEL_Y, PANEL_WIDTH, PANEL_HEIGHT, "panelNuevoMensaje");
			JPanel panelPrintMessage = printMessage.getJPanel(PANEL_X, PANEL_Y, PANEL_WIDTH, PANEL_HEIGHT, "panelImprimirMensaje");
			
			//Instanciar los paneles creados
			frame.getContentPane().add(panelMenu);
			frame.getContentPane().add(panelNewMessage);
			frame.getContentPane().add(panelPrintMessage);
			
			//Ocultar todos excepto inicial
			panelMenu.setVisible(true);
			panelNewMessage.setVisible(false);
			panelPrintMessage.setVisible(false);

			//Mostrar ventana
			frame.setVisible(true);
		}
		
		
		
		
		
		
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public xd() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 815, 564);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
	}

}
