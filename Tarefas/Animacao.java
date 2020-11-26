package tarefas;

import paineis.Canvas;

public class Animacao extends Thread {
	
	private int dt;
	private Canvas canvas;
	
	public Animacao(Canvas c) {
		this(c, 17);
	}
	
	public Animacao(Canvas c, int dt) {
		canvas = c;
		this.dt = dt;
	}
		
	public void setDt(int dt) {
		this.dt = dt;
	}

	public Canvas getCanvas() {
		return canvas;
	}

	@Override
	public void run() {
		while (true) {
			for (int i = 0; i < canvas.qtdeDeFormasAnimadas(); i++) {
				canvas.atualizarAnimado(i);
			}
			canvas.repaint();
			try {
				Thread.sleep(dt);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
}
