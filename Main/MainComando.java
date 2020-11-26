package main;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import janela.JanelaComando;
import objetos.Bola;
import objetos.Forma;
import paineis.CanvasFechado;
import tarefas.Controle;

public class MainComando {

	public static void main(String[] args) {
		// cria as formas
		Forma f1 = new Bola(1, 1, 20, 20, Color.black);
		Forma f2 = new Forma(20, 30, 20, 20, Color.red);
		
		// configura o incremento das formas
		f1.setInc(30, 30);
		f2.setInc(10, 10);
		
		// configura as chaves de controle para as forma.
		// Exemplo 1: 37 = seta esquerda, 38 seta para cima, 
		// 39 = seta direita e 40 = seta para baixo.
		// Exemplo 2: 65 = 'a', 87 = 'w', 68 = 'd' e 83 = 's'.
		// Exemplo 3: KeyEvent.VK_A = 'a', KeyEvent.VK_W = 'w',
		// KeyEvent.VK_D = 'd' e KeyEvent.VK_S = 's'.
		f1.setControles(37, 38, 39, 40);
		//f2.setControles(KeyEvent.VK_A, KeyEvent.VK_W, KeyEvent.VK_D, KeyEvent.VK_S);
		f2.setControles(65, 87, 68, 83);
		//cria o canvas
		CanvasFechado canvas = new CanvasFechado();
		
		// adiciona as formas no canvas
		canvas.addFormaControlada(f1);
		canvas.addFormaControlada(f2);
		
		// cria um controle que controlará apenas a primeira forma adicionada 
		//com os incrementos passados, os quais sobrescrevem o setInc() dessa forma.
		Controle controle = new Controle(canvas);
		
		// cria uma janela de controle
		new JanelaComando(controle);
	}

}
