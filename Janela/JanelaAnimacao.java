package janela;

import javax.swing.JFrame;

import paineis.Canvas;
import tarefas.Animacao;

public class JanelaAnimacao extends JFrame {
	
	private static final long serialVersionUID = -5127892650379647651L;

	public JanelaAnimacao(Animacao a) {
		Canvas canvas = a.getCanvas();
		add(canvas);
		a.start();		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(500, 100);
		setSize(500, 500);
		setVisible(true);
	}
	
}
