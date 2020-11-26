package main;

import java.awt.Color;

import janela.JanelaAnimacao;
import objetos.FormaQueColide;
import paineis.CanvasFechadoComColisao;
import tarefas.Animacao;

public class MainAnimacao {
	
	public static void main(String[] args) {
		// cria as formas
		FormaQueColide f1 = new FormaQueColide(50, 50, 20, 20, Color.green);
		FormaQueColide f2 = new FormaQueColide(200, 30, 20, 20, Color.red);
		FormaQueColide f3 = new FormaQueColide(100, 49, 20, 20, Color.blue);
		FormaQueColide f4 = new FormaQueColide(10, 100, 20, 20, Color.yellow);
		FormaQueColide f5 = new FormaQueColide(104, 210, 20, 20, Color.gray);
		FormaQueColide f6 = new FormaQueColide(110, 110, 20, 20, Color.black);
		FormaQueColide f7 = new FormaQueColide(210, 210, 20, 20, Color.cyan);
		FormaQueColide f8 = new FormaQueColide(150, 310, 20, 20, Color.magenta);
		FormaQueColide f9 = new FormaQueColide(10, 310, 20, 20, Color.orange);
		FormaQueColide f10 = new FormaQueColide(210, 130, 20, 20, Color.pink);
		
		// configura os movimentos iniciais
		f1.setInc(2, 1);
		f2.setInc(1, 2);
		f3.setInc(3, 1);
		f4.setInc(-1, 1);
		f5.setInc(9, 3);
		f6.setInc(-1, -2);
		f7.setInc(-3, 0);
		f8.setInc(0, -6);
		f9.setInc(-1, -6);
		f10.setInc(1, 6);
		
		// cria um canvas
		CanvasFechadoComColisao canvas = new CanvasFechadoComColisao();
		
		// adiciona s formas no canvas
		canvas.addFormaAnimada(f1);
		canvas.addFormaAnimada(f3);
		canvas.addFormaAnimada(f2);
		canvas.addFormaAnimada(f4);
		canvas.addFormaAnimada(f5);
		canvas.addFormaAnimada(f6);
		canvas.addFormaAnimada(f7);
		canvas.addFormaAnimada(f8);
		canvas.addFormaAnimada(f9);
		canvas.addFormaAnimada(f10);
		
		// cria uma animação
		Animacao a = new Animacao(canvas);
		
		new JanelaAnimacao(a);
	}
}
