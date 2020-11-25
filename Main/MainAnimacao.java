package main;

import java.awt.Color;

import janela.JanelaAnimacao;
import objetos.Bola;
import objetos.Forma;
import objetos.FormaQueColide;
import paineis.CanvasFechadoComColisao;
import tarefas.Animacao;

public class MainAnimacao {
	
	public static void main(String[] args) {
		// cria as formas
		FormaQueColide f1 = new FormaQueColide(50, 50, 20, 20, Color.green);
		FormaQueColide f2 = new FormaQueColide(200, 30, 20, 20, Color.red);
		FormaQueColide f3 = new FormaQueColide(100, 49, 20, 20, Color.blue);
		FormaQueColide f4 = new FormaQueColide(10, 10, 20, 20, Color.yellow);
		
		// configura os movimentos iniciais
		f1.setInc(2, 1);
		f2.setInc(1, 2);
		f3.setInc(3, 1);
		f4.setInc(-1, 1);
		
		// cria um canvas
		CanvasFechadoComColisao canvas = new CanvasFechadoComColisao();
		
		// adiciona s formas no canvas
		canvas.addForma(f1);
		canvas.addForma(f3);
		canvas.addForma(f2);
		canvas.addForma(f4);
		
		// cria uma animação
		Animacao a = new Animacao(canvas);
		
		new JanelaAnimacao(a);
	}
}
