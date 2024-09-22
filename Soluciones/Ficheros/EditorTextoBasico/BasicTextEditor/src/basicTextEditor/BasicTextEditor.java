package basicTextEditor;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import basicTextEditor.file.BasicFileManager;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

/**
 * Una clase que crea una ventana sencilla para abrir y editar ficheros. Si
 * quieress abrir un ficheo de otro nombre o de otra ruta, tendras que cambiar
 * el valor de la variable THE_FILE_NAME_AND_PATH
 */
public class BasicTextEditor {

	private static final String THE_FILE_NAME_AND_PATH = "C:\\Trastero\\Text.txt";

	private JFrame frmBasicTetEditor;
	private JTextArea jTextArea;
	private BasicFileManager basicFileManager;
	private JMenuItem jMenuItemOpen;
	private JMenuItem jMenuItemSave;
	private JMenuItem jMenuItemAppend;
	private JMenuItem jMenuItemClose;

	/**
	 * Main de la clase
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BasicTextEditor window = new BasicTextEditor();
					window.frmBasicTetEditor.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Constructor
	 */
	public BasicTextEditor() {
		initialize();
	}

	/**
	 * Inicializa y construye la ventana
	 */
	private void initialize() {
		frmBasicTetEditor = new JFrame();
		frmBasicTetEditor.setTitle("Basic Tet Editor");
		frmBasicTetEditor.setBounds(100, 100, 450, 300);
		frmBasicTetEditor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBasicTetEditor.getContentPane().setLayout(null);

		basicFileManager = new BasicFileManager(THE_FILE_NAME_AND_PATH);

		jTextArea = new JTextArea();
		jTextArea.setBounds(10, 33, 414, 217);
		frmBasicTetEditor.getContentPane().add(jTextArea);

		JMenuBar jMenuBar = new JMenuBar();
		jMenuBar.setBounds(0, 0, 434, 22);
		frmBasicTetEditor.getContentPane().add(jMenuBar);

		JMenu jMenuFile = new JMenu("File");
		jMenuBar.add(jMenuFile);

		jMenuItemOpen = new JMenuItem("Open");
		jMenuItemOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String text = basicFileManager.read();
					jTextArea.setText(text);

					// Habilitamos opciones del menu...
					jMenuItemSave.setEnabled(true);
					jMenuItemAppend.setEnabled(true);
					jMenuItemClose.setEnabled(true);
					jTextArea.setEnabled(true);

				} catch (IOException e1) {
					JOptionPane.showMessageDialog(new JFrame(), "No se puede abrir el fichero. " + e);
					jMenuItemSave.setEnabled(false);
					jMenuItemAppend.setEnabled(false);
					jMenuItemClose.setEnabled(false);
					jTextArea.setText("");
					jTextArea.setEnabled(false);
				}
			}
		});
		jMenuFile.add(jMenuItemOpen);

		jMenuItemSave = new JMenuItem("Save");
		jMenuItemSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String text = jTextArea.getText();
					basicFileManager.write(text);
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(new JFrame(), "No se puede abrir el fichero. " + e);
				}
			}
		});
		jMenuFile.add(jMenuItemSave);

		jMenuItemAppend = new JMenuItem("Append");
		jMenuItemAppend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String text = jTextArea.getText();
					basicFileManager.append(text);
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(new JFrame(), "No se puede abrir el fichero. " + e1);
				}
			}
		});
		jMenuFile.add(jMenuItemAppend);

		jMenuItemClose = new JMenuItem("Close");
		jMenuItemClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jMenuItemSave.setEnabled(false);
				jMenuItemAppend.setEnabled(false);
				jMenuItemClose.setEnabled(false);
				jTextArea.setText("");
				jTextArea.setEnabled(false);
			}
		});
		jMenuFile.add(jMenuItemClose);
	}
}
