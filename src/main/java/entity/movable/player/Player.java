package main.java.entity.movable.player;

import java.awt.Color;
import java.awt.Graphics2D;

import main.java.GamePanel;
import main.java.entity.movable.MovableEntity;

public class Player extends MovableEntity {
	public Player(GamePanel gp) {
		super(gp, GamePanel.tileSize, GamePanel.tileSize, 100, 100);
	}

	public void moveKeys(GamePanel gp) {
		if (gp.keyH.w) {
			gp.keyH.w = false;
			moveY = -12;
			fallTime = 0;
			gp.keyH.jumping = true;
		}

		if (gp.keyH.a && gp.keyH.d)
			moveX = 0;
		else if (gp.keyH.a)
			moveX = -4;
		else if (gp.keyH.d)
			moveX = 4;
		else
			moveX = 0;
	}

	@Override
	public void update(GamePanel gp) {
		moveKeys(gp);

		move();

		fallTime += 1;
	}

	@Override
	public void render(Graphics2D g2) {
		this.g2 = g2;

		g2.setColor(Color.red);
		g2.drawRect(getX(), getY(), getWidth(), getHeight());
		g2.drawString("Player", getX(), getY());
	}
}
