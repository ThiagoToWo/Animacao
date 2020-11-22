package objetos;

import java.awt.Color;
import java.awt.Graphics;

public class Forma {

	protected int x;
	protected int y;
	protected int w;
	protected int h;
	protected int dx;
	protected int dy;
	
	public Forma() {
		x = 0;
		y = 0;
		w = 10;
		h = 10;
	}
	
	public Forma(int x, int y) {
		this.x = x;
		this.y = y;
		w = 10;
		h = 10;
	}
	
	public Forma(int x, int y, int w, int h) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
	}

	public int getDx() {
		return dx;
	}

	public int getDy() {
		return dy;
	}

	public void setInc(int dx, int dy) {
		this.dx = dx;
		this.dy = dy;
	}
	
	// os métodos abaixo são chamados de forma automática em canvas quando estão em animação
	public void inc() {
		x += dx;
		y += dy;
	}
	
	public void pintar(Graphics g) { 
		g.fillRect(x, y, w, h);
	}
	
	public void pintar(Graphics g, Color c) {
		g.setColor(c);
		g.fillRect(x, y, w, h);		
	}
	
}
