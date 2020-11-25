package objetos;

import java.awt.Color;

import tarefas.Colisao;

public class FormaQueColide extends Forma {

	Colisao col;
	
	public FormaQueColide() {
		super();
		col = new Colisao();
	}

	public FormaQueColide(int x, int y, Color c) {
		super(x, y);
		col = new Colisao();
		setColor(c);
	}

	public FormaQueColide(int x, int y, int w, int h, Color c) {
		super(x, y, w, h);
		col = new Colisao();
		setColor(c);
	}
	
	public boolean colidiuCom(Forma f) {
		return col.colidiuPorFora(this, f);
	}

}
