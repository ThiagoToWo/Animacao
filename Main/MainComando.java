package Main;

import Janela.JanelaComando;
import Objetos.Forma;

public class MainComando {

	public static void main(String[] args) {
		Forma forma = new Forma(200, 100);
		new JanelaComando(forma);
	}

}
