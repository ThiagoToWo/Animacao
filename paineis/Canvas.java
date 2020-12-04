package paineis;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

import objetos.Forma;

public class Canvas extends JPanel {
	
	private static final long serialVersionUID = 6259775046055696149L;
	private ArrayList<Forma> formaAnimadaList;
	private ArrayList<Forma> formaControladaList;
	
	public Canvas() {
		formaAnimadaList = new ArrayList<>();
		formaControladaList = new ArrayList<>();
	}
		
	public Canvas(Forma fc) {
		formaAnimadaList = new ArrayList<>();
		formaControladaList = new ArrayList<>();
		formaControladaList.add(fc);
	}
	
	public Canvas(Forma fa, Forma fc) {
		formaAnimadaList = new ArrayList<>();
		formaControladaList = new ArrayList<>();
		formaAnimadaList.add(fa);
		formaControladaList.add(fc);
	}
	
	public Forma getFormaAnimada(int i) {
		return formaAnimadaList.get(i);
	}
	
	private Forma getFormaControlada(int i) {
		return formaControladaList.get(i);
	}
	
	public void addFormaAnimada(Forma fa) {
		formaAnimadaList.add(fa);
	}
	
	public int qtdeDeFormasAnimadas() {
		return formaAnimadaList.size();
	}
	
	public void addFormaControlada(Forma fc) {
		formaControladaList.add(fc);
	}
	
	public int qtdeDeFormasControladas() {
		return formaControladaList.size();
	}
	
	public void atualizarContolado(int i, int key) {
		Forma forma = getFormaControlada(i);
		forma.incControle(key);
	}	

	public void atualizarAnimado(int i) {
		Forma forma = getFormaAnimada(i);
		forma.incAnimacao();
	}
		
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);		
		for (Forma forma : formaAnimadaList) {
			forma.pintar(g);
		}
		
		for (Forma forma : formaControladaList) {
			forma.pintar(g);
		}
	}	
	
}
