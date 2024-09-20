package vistas.ventanas.paneles;

import java.awt.Color;

import javax.swing.JPanel;

/**
 * Panel Azul
 */
public class JPanelBlue {

	/**
	 * Retorna un nuevo panel azul en las coordenadas y con las dimensiones indicadas 
	 * 
	 * @param x la nueva coordenada <i>x</i> del panel
     * @param y la nueva coordenada <i>y</i> del panel
     * @param width la nueva anchura del panel
     * @param height la nueva altura del panel
	 * @return El panel
	 */
	public JPanel getJPanel (int x, int y, int width, int height) {
		JPanel ret = null;
		ret = new JPanel();
		ret.setBounds(x, y, width, height);
		ret.setBackground(Color.blue);
		return ret;
	}
	
}
