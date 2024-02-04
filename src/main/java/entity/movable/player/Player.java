package main.java.entity.movable.player;

import java.awt.Color;
import java.awt.Graphics2D;

import main.java.GamePanel;
import main.java.entity.movable.MovableEntity;

public class Player extends MovableEntity {
	public Player(GamePanel gp) {
		super(gp, 100, 100, 100, 100);
	}

	public void moveKeys(GamePanel gp) {
		if (gp.keyH.w) {
			moveY = -4;
		}
		if (gp.keyH.a) {
			moveX = -4;
		}
		if (gp.keyH.s) {
			moveY = 4;
		}
		if (gp.keyH.d) {
			moveX = 4;
		}
	}

	@Override
	public void update(GamePanel gp) {
		moveKeys(gp);

		move();

		moveX = 0;
		moveY = 0;
	}

	@Override
	public void render(Graphics2D g2) {
		this.g2 = g2;

		g2.setColor(Color.red);
		g2.drawRect(getXAsInt(), getYAsInt(), getWidth(), getHeight());
		g2.drawString("Player", getXAsInt(), getYAsInt());
	}
}
