package objetos;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

public class Forma implements Modelo {

	private int x;
	private int y;
	private int w;
	private int h;
	private int dx;
	private int dy;
	private Color c;
	
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

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public int getWidth() {
		return w;
	}

	public int getHeight() {
		return h;
	}

	public int getDx() {
		return dx;
	}

	public int getDy() {
		return dy;
	}

	public Color getColor() {
		return c;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setWidth(int w) {
		this.w = w;
	}

	public void setHeight(int h) {
		this.h = h;
	}

	public void setDx(int dx) {
		this.dx = dx;
	}

	public void setDy(int dy) {
		this.dy = dy;
	}

	public void setInc(int dx, int dy) {
		this.dx = dx;
		this.dy = dy;
	}
	
	public void setColor(Color c) {
		this.c = c;
	}
	
	// os métodos abaixo são chamados de forma automática em canvas quando estão em animação
	public void inc() {
		x += dx;
		y += dy;
	}
	
	public void pintar(Graphics g) { 
		g.setColor(c);
		g.fillRect(x, y, w, h);
	}

}
