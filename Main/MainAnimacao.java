package main;

import java.awt.Color;

import janela.JanelaAnimacao;
import objetos.Bola;
import objetos.Forma;
import paineis.Canvas;
import tarefas.Animacao;

public class MainAnimacao {
	
	public static void main(String[] args) {
		// cria as formas
		Forma f1 = new Bola(50, 50, Color.green);
		Forma f2 = new Forma(200, 30);
		Forma f3 = new Forma(0, 49);
		
		// configura os movimentos iniciais
		f1.setInc(1, 1);
		f2.setInc(-1, 2);
		f3.setInc(3, 2);
		
		// cria um canvas
		Canvas canvas = new Canvas();
		
		// adiciona s formas no canvas
		canvas.addForma(f1);
		canvas.addForma(f2);
		canvas.addForma(f3);
		
		// cria uma animação
		Animacao a = new Animacao(canvas);
		
		new JanelaAnimacao(a);
	}
}
