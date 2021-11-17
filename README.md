# Animacao

Este projeto tem as classes mais básicas que podem colaborar entre si para criar animações e permitir o controle de formas na tela.

1) Classes básicas.

	1.1. objetos.Forma (implementa a interface objetos.Modelo),
	
	1.2. paineis.Canvas (estende JPanel),
	
	1.3. tarefas.Animacao (estende Thread),
	
	1.4. tarefas.Controle (implementa KeyListener),
	
	1.5. janela.JanelaAnimacao (estende JFrame),
	
	1.6. janela.JanelaComando (estende JFrame) e
	
	1.7. tarefas.Colisao

2) Descrições.

	2.1. objetos.Forma:
	
		é a forma básica (um quadrado) que implementa todos os métodos da interface Modelo para serem usadas nos Canvas e nos parâmetros de métodos do Controle. Uma
		Forma pode ser estendida e ter seu método void pintar(Graphics) sobrecarregado para fazer figuras diferenciadas. É possível também compor uma derivação de Forma
		com Colisao, aproveitando de seus métodos.
		
	2.2. paineis.Canvas:
	
		é o painel básico onde as Formas serão acrescentadas. O Canvas tem duas listas de Formas, as animadas e as controladas, que serão atualizadas pelas classes
		Animacao e Controle, respectivamente. Canvas chama o método paintComponent(Graphics) de JPanel repintando a atualização das posições das Formas.
		
	2.3. tarefas.Animacao:
	
		é uma trhead criada com um Canvas em seu construtor, que chama em uma frequência fixa o método repaint() deste Canvas, atualizando a posição das Formas animadas
		deste.
	
	2.4. tarefas.Controle:
	
		é criada com um Canvas em seu construtor e é um KeyListener que atualiza a posição das Formas controladas desse Canvas. Como KeyListener é adicionada a
		JanelaComando.
		
	2.5. janela.JanelaAnimacao: 
	
		janela criada com uma Animacao ao seu construtor. Ela adiciona o Canvas da Animacao ao frame e inicia sua thread.
	
	2.6. janela.JanelaComando: 
	
		janela criada com um Controle em seu constutor. Ela adiciona o Canvas que tem no Controle ao frame e usa o Controle como KeyListener.
		
	2.7. tarefas.Colisao:
	
		implementa métodos booleans de colisão por dentro e por fora entre Modelos e entre Modelos e JComponents. É uma classe independente que pode ser usada em
		composição dentro de Canvas ou Formas para decidir o que fazer quando estas classes colidem entre si nas atualizações de suas posições.
		
3. Exemplo de animação:

	No exemplo abaixo dois círculos, um vermelho e um azul, movem - se livremente dentro da janela, colidindo com as paredes e entre si. Suas velocidades são refletidas
nas paredes do Canvas fechado e trocadas quando uma bate na outra.
	
<pre> import java.awt.Color;

import java.awt.Graphics;

import janela.JanelaAnimacao;

import objetos.Forma;

import paineis.Canvas;

import tarefas.Animacao;

import tarefas.Colisao;

public class MainAnimacao {

	public static void main(String[] args) {
	
		// cria as formas	
		BolaQueColide bolaVermelhaQueColide = new BolaQueColide(10, 200, 20, 20, Color.red);
		BolaQueColide bolaAzulQueColide = new BolaQueColide(200, 10, 20, 20, Color.blue);
		
		// configura os movimentos iniciais
		bolaVermelhaQueColide.setInc(2, 1);
		bolaAzulQueColide.setInc(1, 2);	
		
		// cria um canvas
		CanvasFechadoComColisao canvasFechadoComColisao = new CanvasFechadoComColisao();
		
		// adiciona s formas no canvas
		canvasFechadoComColisao.addFormaAnimada(bolaVermelhaQueColide);
		canvasFechadoComColisao.addFormaAnimada(bolaAzulQueColide);
		
		// cria uma animação
		Animacao a = new Animacao(canvasFechadoComColisao);
		
		// cria uma janela de animação e adiciona a animação
		new JanelaAnimacao(a);
	}	
}

class BolaQueColide extends Forma {

	int x, y, w, h;
	Color c;
	
	public BolaQueColide(int x, int y, int w, int h, Color c) {
		super(x, y, w, h, c);
	}
	
	Colisao col = new Colisao();	
	
	public boolean colidiuCom(Forma f) {
		return col.colidiuPorFora(this, f);
	}
	
	@Override
	public void pintar(Graphics g) {
		g.setColor(super.getColor());
		g.fillOval(super.getX(), super.getY(), super.getWidth(), super.getHeight());
	}
}

class CanvasFechadoComColisao extends Canvas {	

	Colisao col = new Colisao();	
	
	@Override
	public void atualizarAnimado(int i) {
	
		BolaQueColide forma = (BolaQueColide) getFormaAnimada(i);
		
		if (col.colidiuPorDentroDireita(forma, this) || col.colidiuPorDentroEsquerda(forma, this)) {
			forma.setDx(-1 * forma.getDx());
		}
		
		if (col.colidiuPorDentroAcima(forma, this) || col.colidiuPorDentroAbaixo(forma, this)) { 
			forma.setDy(-1 * forma.getDy());
		}
		
		for (int j = 0; j < super.qtdeDeFormasAnimadas(); j++) {
			if (j == i) continue; // garante que não colidirá uma forma com ela mesma			
			Forma alvo = getFormaAnimada(j);
			if (forma.colidiuCom(alvo)) { // trocam velocidades
				int xTemp = forma.getDx();
				int yTemp = forma.getDy();
				forma.setInc(alvo.getDx(), alvo.getDy());
				alvo.setInc(xTemp, yTemp);
			}
		}
		
		forma.incAnimacao();
	}	
}</pre>

4. Exemplo de controle.
	No exemplo abaixo, dois quadrados, um preto e um vermelho podem ser controlados de forma independente por diferentes setores do teclado.
	
import java.awt.Color;

import janela.JanelaComando;

import objetos.Forma;

import paineis.Canvas;

import tarefas.Controle;

public class MainComando {

	public static void main(String[] args) {
	
		// cria as formas
		Forma f1 = new Forma(1, 1, 20, 20, Color.black);
		Forma f2 = new Forma(20, 30, 20, 20, Color.red);
		
		// configura o incremento das formas
		f1.setInc(30, 30);
		f2.setInc(10, 10);
		
		// configura as chaves de controle para as forma.
		// Exemplo 1: 37 = seta esquerda, 38 seta para cima, 
		// 39 = seta direita e 40 = seta para baixo.
		// Exemplo 2: 65 = 'a', 87 = 'w', 68 = 'd' e 83 = 's'.
		// Exemplo 3: KeyEvent.VK_A = 'a', KeyEvent.VK_W = 'w',
		// KeyEvent.VK_D = 'd' e KeyEvent.VK_S = 's'.
		f1.setControles(37, 38, 39, 40);
		f2.setControles(65, 87, 68, 83);
		
		//cria o canvas
		Canvas canvas = new Canvas();
		
		// adiciona as formas ao canvas
		canvas.addFormaControlada(f1);
		canvas.addFormaControlada(f2);	
		
		// cria um controle cujas as formas controladas do canvas serão 
		// atualizadas, com os incrementos passados em void setInc(int,int),
		// a cada clique no teclado.
		Controle controle = new Controle(canvas);
		
		// cria uma janela de controle
		new JanelaComando(controle);
	}
