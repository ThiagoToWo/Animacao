package paineis;

import objetos.Forma;
import objetos.FormaQueColide;
import tarefas.Colisao;

public class CanvasFechadoComColisao extends CanvasFechado {

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
	public void atualizar(int i) {
		FormaQueColide forma = (FormaQueColide) getForma(i);
		
		
		if (col.colidiuPorDentroDirOuEsq(forma, this)) {
			forma.setDx(-1 * forma.getDx());
		}
		
		if (col.colidiuPorDentroCimaOuBaixo(forma, this)) { 
			forma.setDy(-1 * forma.getDy());
		}
		
		for (int j = 0; j < super.quantidadeDeFormas(); j++) {
			if (j == i) continue; // garante que n�o colidir� uma forma com ela mesma
			
			FormaQueColide alvo = (FormaQueColide) getForma(j);
			if (forma.colidiuCom(alvo)) { // trocam velocidades
				int xTemp = forma.getDx();
				int yTemp = forma.getDy();
				forma.setInc(alvo.getDx(), alvo.getDy());
				alvo.setInc(xTemp, yTemp);
			}
		}

		forma.inc();
	}	
}