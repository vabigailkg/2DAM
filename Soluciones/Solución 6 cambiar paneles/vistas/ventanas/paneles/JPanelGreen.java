package vistas.ventanas.paneles;

import java.awt.Color;

import javax.swing.JPanel;

/**
 * Panel Verde
 */
public class JPanelGreen {

	/**
	 * Retorna un nuevo panel verde en las coordenadas y con las dimensiones indicadas 
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
		ret.setBackground(Color.green);
		return ret;
	}
	
}
