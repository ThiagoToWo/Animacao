package tarefas;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import paineis.Canvas;

public class Controle implements KeyListener {

	private Canvas canvas;
	
	public Controle(Canvas c) {
		canvas = c;
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
		
		for (int i = 0; i < canvas.qtdeDeFormasControladas(); i++) {
			canvas.atualizarContolado(i, key);
			canvas.repaint();
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

}
