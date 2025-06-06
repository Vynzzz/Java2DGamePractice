package display;

import javax.swing.*;

import input.Input;
import main.Game;

import java.awt.*;
import java.awt.image.BufferStrategy;


public class Display extends JFrame{
	private static final long serialVersionUID = 1L;
	private Canvas canvas;
	private Renderer renderer;
	
	public Display(int width, int height, Input input) {
		setTitle("2D Game");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		
		this.renderer = new Renderer();
		
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(width, height));
		canvas.setFocusable(false);
		add(canvas);
		addKeyListener(input);
		pack();
		
		canvas.createBufferStrategy(3);
		
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public void render(Game game) {
		BufferStrategy bufferStrategy = canvas.getBufferStrategy();
		Graphics graphics = bufferStrategy.getDrawGraphics();
		
		graphics.setColor(Color.BLACK);
		graphics.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
		
		renderer.render(game, graphics);
		
		graphics.dispose();
		bufferStrategy.show();
	}
	
	
}
