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
	
	// os métodos abaixo são chamados de forma automática em canvas quando estão em animação
	void inc();
	
	void pintar(Graphics g);
	
}
