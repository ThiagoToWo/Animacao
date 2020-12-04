package tarefas;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;

import paineis.Canvas;

public class Controle implements KeyListener {

	private Canvas canvas;
	private int key;
	private HashSet<Integer> conjDeTeclas;
	
	public Controle(Canvas c) {
		canvas = c;
		conjDeTeclas = new HashSet<Integer>();
	}
	
	public Canvas getCanvas() {
		return canvas;
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		key = e.getKeyCode();
		conjDeTeclas.add(key);

		for (int i = 0; i < canvas.qtdeDeFormasControladas(); i++) {
			for (int k : conjDeTeclas) {
				canvas.atualizarContolado(i, k);				
			}			
		}
		canvas.repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		key = e.getKeyCode();
		conjDeTeclas.remove(key);
	}

}
