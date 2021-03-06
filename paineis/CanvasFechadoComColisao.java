package paineis;

import objetos.Forma;
import objetos.FormaQueColide;
import tarefas.Colisao;

public class CanvasFechadoComColisao extends CanvasFechado {

	private static final long serialVersionUID = -5476902390509805538L;
	Colisao col;
	
	public CanvasFechadoComColisao() {
		super();
		col = new Colisao();
	}

	public CanvasFechadoComColisao(Forma f) {
		super(f);
		col = new Colisao();
	}

	@Override
	public void atualizarAnimado(int i) {
		FormaQueColide forma = (FormaQueColide) getFormaAnimada(i);
		
		if (col.colidiuPorDentroDireita(forma, this) || col.colidiuPorDentroEsquerda(forma, this)) {
			forma.setDx(-1 * forma.getDx());
		}		
		
		if (col.colidiuPorDentroAcima(forma, this) || col.colidiuPorDentroAbaixo(forma, this)) { 
			forma.setDy(-1 * forma.getDy());
		}
		
		for (int j = 0; j < super.qtdeDeFormasAnimadas(); j++) {
			if (j == i) continue; // garante que n�o colidir� uma forma com ela mesma
			
			FormaQueColide alvo = (FormaQueColide) getFormaAnimada(j);
			if (forma.colidiuCom(alvo)) { // trocam velocidades
				int xTemp = forma.getDx();
				int yTemp = forma.getDy();
				forma.setInc(alvo.getDx(), alvo.getDy());
				alvo.setInc(xTemp, yTemp);
			}
		}

		forma.incAnimacao();
	}	
}
