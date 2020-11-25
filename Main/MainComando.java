package main;

import java.awt.Color;

import janela.JanelaComando;
import objetos.Bola;
import objetos.Forma;
import paineis.CanvasFechado;
import tarefas.Controle;

public class MainComando {

	public static void main(String[] args) {
		// cria as formas
		Forma f1 = new Bola(1, 1, Color.black);
		Forma f2 = new Forma(20, 30);
		
		// configura o incremento das formas (desnecessário)
		f1.setInc(1, 1);
		f2.setInc(2, 1);
		
		//cria o canvas
		CanvasFechado canvas = new CanvasFechado();
		
		// adiciona as formas no canvas
		canvas.addForma(f1);
		canvas.addForma(f2);
		
		// cria um controle que controlará apenas a primeira forma adicionada 
		//com os incrementos passados, os quais sobrescrevem o setInc() dessa forma.
		Controle controle = new Controle(canvas, 10, 10);
		
		// cria uma janela de controle
		new JanelaComando(controle);
	}

}
