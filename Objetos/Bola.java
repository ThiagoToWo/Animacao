package objetos;

import java.awt.Color;
import java.awt.Graphics;

public class Bola extends Forma {
	
	public Bola(int x, int y, Color cor) {
		super(x, y, 10, 10);
		setColor(cor);
	}
	
	public Bola(int x, int y, int w, int h, Color cor) {
		super(x, y, w, h);
		setColor(cor);
	}

	public void pintar(Graphics g) {
		g.setColor(getColor());
		g.fillOval(super.getX(), super.getY(), super.getWidth(), super.getHeight());
	}
}
