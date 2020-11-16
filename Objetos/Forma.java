package Objetos;

import java.awt.Graphics;
import java.awt.LayoutManager;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class Forma extends JPanel {
	private int x;
	private int y;
	
	public Forma(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void atualizar() {
		x += 1;
		y += 1;
	}
	
	public void setLocal(int dx, int dy) {
		x += dx;
		y += dy;
	}
	
	@Override
	public void paint(Graphics g) {
		//g.clearRect(0, 0, getWidth(), getHeight());
		g.fillRect(x, y, 10, 10);
	}

}
