package tarefas;

import javax.swing.JComponent;

import objetos.Modelo;

public class Colisao {

	public boolean colidiuPorDentroDirOuEsq(Modelo c1, JComponent c2) {
		return (c1.getX() <= c2.getX() || c1.getX() + c1.getWidth() >= c2.getWidth());
	}
	
	public boolean colidiuPorDentroCimaOuBaixo(Modelo c1, JComponent c2) {
		return (c1.getY() <= c2.getY() || c1.getY() + c1.getHeight() >= c2.getHeight());
	}
		
	public boolean colidiuPorDentroDirOuEsq(Modelo c1, Modelo c2) {
		return (c1.getX() <= c2.getX() || c1.getX() + c1.getWidth() >= c2.getWidth());
	}
	
	public boolean colidiuPorDentroCimaOuBaixo(Modelo c1, Modelo c2) {
		return (c1.getY() <= c2.getY() || c1.getY() + c1.getHeight() >= c2.getHeight());
	}

	public boolean colidiuPorFora(Modelo c1, Modelo c2) {
		int x1 = c1.getX();
		int y1 = c1.getY();
		int w1 = c1.getWidth();
		int h1 = c1.getHeight();
		int x2 = c2.getX();
		int y2 = c2.getY();
		int w2 = c2.getWidth();
		int h2 = c2.getHeight();
		
		boolean pelaDireita = (x1 + w1 >= x2);
		boolean pelaEsquerda = (x1 <= x2 + w2);
		boolean porCima = (y1 <= y2 + h2);
		boolean porBaixo = (y1 + h1 >= y2);
		
		return (pelaDireita && pelaEsquerda && porCima && porBaixo);
	}
	
	public boolean colidiuPorFora(Modelo c1, JComponent c2) {
		int x1 = c1.getX();
		int y1 = c1.getY();
		int w1 = c1.getWidth();
		int h1 = c1.getHeight();
		int x2 = c2.getX();
		int y2 = c2.getY();
		int w2 = c2.getWidth();
		int h2 = c2.getHeight();
		
		boolean pelaDireita = (x1 + w1 >= x2);
		boolean pelaEsquerda = (x1 <= x2 + w2);
		boolean porCima = (y1 <= y2 + h2);
		boolean porBaixo = (y1 + h1 >= y2);
		
		return (pelaDireita && pelaEsquerda && porCima && porBaixo);
	}
	
}
