package tarefas;

import paineis.Canvas;

public class Animacao extends Thread {
	private int dx;
	private int dy;
	private int dt;
	private Canvas canvas;
	
	public Animacao(Canvas c) {
		canvas = c;
		this.dx = 1;
		this.dy = 1;
		this.dt = 17;
	}
	
	public Animacao(Canvas c, int dx, int dy) {
		canvas = c;
		this.dx = dx;
		this.dy = dy;
		this.dt = 17;
	}
	
	public Animacao(Canvas c, int dx, int dy, int dt) {
		canvas = c;
		this.dx = dx;
		this.dy = dy;
		this.dt = dt;
	}
	
	public void setDx(int dx) {
		this.dx = dx;
	}


	public void setDy(int dy) {
		this.dy = dy;
	}


	public void setDt(int dt) {
		this.dt = dt;
	}


	protected int getDx() {
		return dx;
	}

	protected int getDy() {
		return dy;
	}

	protected int getDt() {
		return dt;
	}

	public Canvas getCanvas() {
		return canvas;
	}

	@Override
	public void run() {
		while (true) {
			canvas.atualizar(dx,dy);
			canvas.repaint();
			try {
				Thread.sleep(dt);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
}
