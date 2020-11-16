package Janela;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

import Objetos.Forma;

public class JanelaComando extends JFrame {
	private Forma forma;
	
	public JanelaComando(Forma f) {
		forma = f;
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
					forma.setLocal(0, -1);
					forma.repaint();
					break;
				case 40: // baixo
					forma.setLocal(0, 1);
					forma.repaint();
					break;
				case 37: // esquerda
					forma.setLocal(-1, 0);
					forma.repaint();
					break;
				case 39: // direita
					forma.setLocal(1, 0);
					forma.repaint();
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
