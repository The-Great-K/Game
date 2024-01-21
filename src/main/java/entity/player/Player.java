package main.java.entity.player;

import java.awt.Color;
import java.awt.Graphics2D;

import main.java.GamePanel;
import main.java.entity.Entity;

public class Player extends Entity {
	public Player(GamePanel gp) {
		super(gp, 100, 100, 100, 100);
	}

	@Override
	public void update(GamePanel gp) {
		if (gp.keyH.w == true) {
			this.y -= 5;
		}
	}

	@Override
	public void render(Graphics2D g2) {
		this.g2 = g2;

		g2.setColor(Color.red);
		g2.drawRect(x, y, width, height);
		g2.drawString("Player", x, y);
	}
}
