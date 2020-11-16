package Main;

import java.awt.event.KeyEvent;
import java.util.Timer;

import Janela.Janela;
import Objetos.Forma;
import Tarefas.Animacao;

public class MainAnimacao {

	public static void main(String[] args) {
		Janela jan = new Janela();
		Forma f = new Forma(0, 0);
		Animacao an = new Animacao(f);
		Timer tempo = new Timer();
		tempo.scheduleAtFixedRate(an, 0, 20);
		
		jan.add(f);
	}

}
