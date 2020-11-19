package paineis;

import java.awt.Graphics;

import javax.swing.JPanel;

import objetos.Forma;

public class Canvas extends JPanel {
	
	private Forma forma;
	private Forma[] formas;
	
	public Canvas(Forma f) {
		forma = f;
	}
	
	public Canvas(Forma[] fs) {
		formas = fs;
	}
	
	public void atualizar(int dx, int dy) {
		forma.incX(dx);
		forma.incY(dy);
	}
		
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		forma.pintar(g);
	}
	
}
