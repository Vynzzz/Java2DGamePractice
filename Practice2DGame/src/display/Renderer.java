package display;

import java.awt.Graphics;

import main.Game;

public class Renderer {
	public void render(Game game, Graphics graphics) {
		game.getGameObject().forEach(gameObject -> graphics.drawImage(
				gameObject.getSprite(), 
				gameObject.getPosition().getX(), 
				gameObject.getPosition().getY(), 
				null));
	}
}
