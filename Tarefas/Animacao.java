package Tarefas;

import java.util.TimerTask;

import Objetos.Forma;

public class Animacao extends TimerTask {
	private Forma objeto;
	
	public Animacao(Forma obj) {
		objeto = obj;
	}
	@Override
	public void run() {
		objeto.atualizar();
		objeto.repaint();
		objeto.getToolkit().sync();
	}

}
