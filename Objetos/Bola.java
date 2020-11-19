package objetos;

import java.awt.Color;
import java.awt.Graphics;

public class Bola extends Forma {
	private Color cor;

	public Bola(int x, int y, Color cor) {
		super(x, y, 10, 10);
		this.cor = cor;
	}

	public void pintar(Graphics g) {
		g.setColor(cor);
		g.fillOval(super.x, super.y, super.w, super.h);
	}
}
