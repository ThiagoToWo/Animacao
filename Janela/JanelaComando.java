package janela;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

import paineis.Canvas;

public class JanelaComando extends JFrame {
	
	public JanelaComando(Canvas f) {
		Canvas canvas = f;
		add(f);
		addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode();
				
				switch (key) {
				case 38: // cima
					canvas.atualizar(0, -1);
					canvas.repaint();
					break;
				case 40: // baixo
					canvas.atualizar(0, 1);
					canvas.repaint();
					break;
				case 37: // esquerda
					canvas.atualizar(-1, 0);
					canvas.repaint();
					break;
				case 39: // direita
					canvas.atualizar(1, 0);
					canvas.repaint();
					break;
				}
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(500, 100);
		setSize(500, 500);
		setVisible(true);
	}
	
}
