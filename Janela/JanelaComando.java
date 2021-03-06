package janela;

import javax.swing.JFrame;

import paineis.Canvas;
import tarefas.Controle;

public class JanelaComando extends JFrame {
	
	private static final long serialVersionUID = -4399294485834430861L;

	public JanelaComando(Controle c) {
		Canvas canvas = c.getCanvas();
		add(canvas);
		addKeyListener(c);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(500, 100);
		setSize(500, 500);
		setVisible(true);
	}
	
}
