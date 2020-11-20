package tarefas;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import paineis.Canvas;

public class Controle implements KeyListener {

	private int dx;
	private int dy;
	private Canvas canvas;
	
	public Controle(Canvas c) {
		canvas = c;
		this.dx = 1;
		this.dy = 1;
	}
	
	public Controle(Canvas c, int dx, int dy) {
		canvas = c;
		this.dx = dx;
		this.dy = dy;
	}
	
	public void setDx(int dx) {
		this.dx = dx;
	}


	public void setDy(int dy) {
		this.dy = dy;
	}

	public Canvas getCanvas() {
		return canvas;
	}
	
	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		switch (key) {
		case 38: // cima
			canvas.atualizar(0, -dy);
			canvas.repaint();
			break;
		case 40: // baixo
			canvas.atualizar(0, dy);
			canvas.repaint();
			break;
		case 37: // esquerda
			canvas.atualizar(-dx, 0);
			canvas.repaint();
			break;
		case 39: // direita
			canvas.atualizar(dx, 0);
			canvas.repaint();
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

}
