package paineis;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

import objetos.Forma;

public class Canvas extends JPanel {
	
	private ArrayList<Forma> formaList;
	
	public Canvas() {
		formaList = new ArrayList<>();		
	}
	
	public Canvas(Forma f) {
		formaList = new ArrayList<>();
		formaList.add(f);
	}
	
	public Forma getForma(int i) {
		return formaList.get(i);
	}
	
	public void addForma(Forma f) {
		formaList.add(f);
	}
	
	public int quantidadeDeFormas() {
		return formaList.size();
	}	
	
	public void atualizarContolavel(int dx, int dy) {
		Forma forma = formaList.get(0);
		if (forma.getDx() != dx || forma.getDy() != dy ) {
			forma.setInc(dx, dy);
		}
		forma.inc();
	}
	
	public void atualizar(int i) {
		Forma forma = formaList.get(i);
		forma.inc();
	}
		
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);		
		for (Forma forma : formaList) {
			forma.pintar(g);
		}
	}
	
}
