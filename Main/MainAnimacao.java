package main;

import java.awt.Color;

import janela.JanelaAnimacao;
import objetos.Bola;
import objetos.Forma;
import paineis.Canvas;
import tarefas.Animacao;

public class MainAnimacao {
	
	public static void main(String[] args) {
		Forma forma = new Bola(50, 50, Color.green);
		Canvas canvas = new Canvas(forma);
		Animacao a = new Animacao(canvas);
		new JanelaAnimacao(a);
	}
}
