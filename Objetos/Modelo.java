package objetos;

import java.awt.Graphics;

public interface Modelo {

	int getX();

	int getY();
	
	int getWidth();

	int getHeight();

	int getDx();

	int getDy();

	void setX(int x);

	void setY(int y);

	void setWidth(int w);

	void setHeight(int h);
	
	void setDx(int dx);

	void setDy(int dy);

	void setInc(int dx, int dy);
	
	void setCtrlL(int ctrlL);

	void setCtrlU(int ctrlU);

	void setCtrlR(int ctrlR);

	void setCtrlD(int ctrlD);
	
	void setControles(int esquerda, int cima, int direita, int baixo);
	
	void incControle(int key);
	// os métodos abaixo são chamados de forma automática em canvas quando estão em animação
	void incAnimacao();
	
	void pintar(Graphics g);
	
}
