package main.java.ui.screens.game;

import java.awt.Graphics2D;

import main.java.GamePanel;
import main.java.entity.movable.player.Player;
import main.java.ui.Screen;

public class GameScreen extends Screen {
	public GamePanel gp;
	public Graphics2D g2;

	public Player player;

	public GameScreen(GamePanel gp) {
		this.gp = gp;

		player = new Player(gp);
	}

	@Override
	public void update(GamePanel gp) {
		player.update(gp);
	}

	@Override
	public void render(Graphics2D g2) {
		this.g2 = g2;

		player.render(g2);
	}
}
