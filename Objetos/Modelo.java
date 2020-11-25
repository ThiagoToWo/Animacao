package objetos;

import java.awt.Color;
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
	
	// os m�todos abaixo s�o chamados de forma autom�tica em canvas quando est�o em anima��o
	void inc();
	
	void pintar(Graphics g);
	
}
