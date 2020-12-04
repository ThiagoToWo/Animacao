package main;

import java.awt.Color;
import java.awt.Graphics;

import janela.JanelaAnimacao;
import objetos.Forma;
import paineis.Canvas;
import tarefas.Animacao;
import tarefas.Colisao;

public class MainAnimacao {
		
	public static void main(String[] args) {
		// cria as formas	
		BolaQueColide bolaVermelhaQueColide = new BolaQueColide(10, 200, 20, 20, Color.red);
		BolaQueColide bolaAzulQueColide = new BolaQueColide(200, 10, 20, 20, Color.blue);
		
		
		// configura os movimentos iniciais
		bolaVermelhaQueColide.setInc(2, 1);
		bolaAzulQueColide.setInc(1, 2);		
		
		// cria um canvas
		CanvasFechadoComColisao canvasFechadoComColisao = new CanvasFechadoComColisao();
		
		// adiciona s formas no canvas
		canvasFechadoComColisao.addFormaAnimada(bolaVermelhaQueColide);
		canvasFechadoComColisao.addFormaAnimada(bolaAzulQueColide);
		
		// cria uma animação
		Animacao a = new Animacao(canvasFechadoComColisao);
		
		// cria uma janela de animação e adiciona a animação
		new JanelaAnimacao(a);
	}	
}

class BolaQueColide extends Forma {
	
	int x, y, w, h;
	Color c;
	
	public BolaQueColide(int x, int y, int w, int h, Color c) {
		super(x, y, w, h, c);
	}
	
	Colisao col = new Colisao();
	
	public boolean colidiuCom(Forma f) {
		return col.colidiuPorFora(this, f);
	}
	
	@Override
	public void pintar(Graphics g) {
		g.setColor(super.getColor());
		g.fillOval(super.getX(), super.getY(), super.getWidth(), super.getHeight());
	}
}

class CanvasFechadoComColisao extends Canvas {
	
	Colisao col = new Colisao();
	
	@Override
	public void atualizarAnimado(int i) {
		BolaQueColide forma = (BolaQueColide) getFormaAnimada(i);
		
		if (col.colidiuPorDentroDireita(forma, this) || col.colidiuPorDentroEsquerda(forma, this)) {
			forma.setDx(-1 * forma.getDx());
		}		
		
		if (col.colidiuPorDentroAcima(forma, this) || col.colidiuPorDentroAbaixo(forma, this)) { 
			forma.setDy(-1 * forma.getDy());
		}
		
		for (int j = 0; j < super.qtdeDeFormasAnimadas(); j++) {
			if (j == i) continue; // garante que não colidirá uma forma com ela mesma
			
			Forma alvo = getFormaAnimada(j);
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
