package paineis;

import objetos.Forma;
import tarefas.Colisao;

public class CanvasFechado extends Canvas {
	
	private Colisao col;

	public CanvasFechado() {
		super();
		col = new Colisao();
	}

	public CanvasFechado(Forma f) {
		super(f);
		col = new Colisao();
	}
	
	/*@Override
	public void atualizarContolavel(int dx, int dy) {
		Forma forma = formaList.get(0);
		boolean embaixo = forma.getY() + forma.getHeight() == super.getHeight();
		boolean emCima = forma.getY() == 0;
		boolean naDireita = forma.getX() == 0;
		boolean naEsquerda = forma.getX() + forma.getWidth() == super.getWidth();
		
		if (forma.getDx() != dx || forma.getDy() != dy ) {
			forma.setInc(dx, dy);
		}
		
		if (!embaixo && !emCima && !naDireita && !naEsquerda) forma.inc();
	}*/
	
	@Override
	public void atualizar(int i) {
		Forma forma = getForma(i);
		if (col.colidiuPorDentroDirOuEsq(forma, this)) {
			forma.setDx(-1 * forma.getDx());
		}
		
		if (col.colidiuPorDentroCimaOuBaixo(forma, this)) { 
			forma.setDy(-1 * forma.getDy());
		}
		
		forma.inc();
	}

}
