package janela;

import javax.swing.JFrame;

public class Janela extends JFrame {
	
	private static final long serialVersionUID = -2134290156153868930L;

	public Janela() {		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(500, 100);
		setSize(500, 500);
		setVisible(true);
	}
	
}
