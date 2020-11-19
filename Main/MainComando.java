package main;

import java.awt.Color;

import janela.JanelaComando;
import objetos.Bola;
import objetos.Forma;
import paineis.Canvas;

public class MainComando {

	public static void main(String[] args) {
		Forma forma = new Bola(0, 0, Color.green);
		Canvas canvas = new Canvas(forma);
		new JanelaComando(canvas);
	}

}
