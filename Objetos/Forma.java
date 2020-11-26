package objetos;

import java.awt.Color;
import java.awt.Graphics;

public class Forma implements Modelo {

	private int x;
	private int y;
	private int w;
	private int h;
	private int dx;
	private int dy;	
	private int ctrlL;
	private int ctrlU;
	private int ctrlR;
	private int ctrlD;
	private Color c;
	
	public Forma() {
		this(0, 0, 10, 10);
	}
	
	public Forma(int x, int y) {
		this(x, y, 10, 10);
	}
	
	public Forma(int x, int y, int w, int h) {
		this(x, y, w, h, Color.black);
	}
	
	public Forma(int x, int y, int w, int h, Color c) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.c = c;
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
	
	public void setCtrlL(int ctrlL) {
		this.ctrlL = ctrlL;
	}

	public void setCtrlU(int ctrlU) {
		this.ctrlU = ctrlU;
	}

	public void setCtrlR(int ctrlR) {
		this.ctrlR = ctrlR;
	}

	public void setCtrlD(int ctrlD) {
		this.ctrlD = ctrlD;
	}

	public void setControles(int esquerda, int cima, int direita, int baixo) {
		ctrlL = esquerda;
		ctrlU = cima;
		ctrlR = direita;
		ctrlD = baixo;
	}
	
	public void setColor(Color c) {
		this.c = c;
	}
	
	public void incControle(int key) {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				if (key == ctrlU) { // cima
					y -= dy;
				} else if (key == ctrlD) { // baixo
					y += dy;
				} else if (key == ctrlL) { // esquerda
					x -= dx;
				} else if (key == ctrlR) { // direita
					x += dx;			
				}
			}
		});
		
	}
	
	// os métodos abaixo são chamados de forma automática em canvas quando estão em animação
	public void incAnimacao() {
		x += dx;
		y += dy;
	}
	
	public void pintar(Graphics g) { 
		g.setColor(c);
		g.fillRect(x, y, w, h);
	}

}
