package main.java.entity;

import java.awt.Color;
import java.awt.Graphics2D;

import main.java.GamePanel;
import main.java.handlers.MouseHandler;

public class Pointer extends Entity {
	public Pointer(GamePanel gp) {
		super(gp);
	}

	public void update(GamePanel gp, MouseHandler mouseH) {
		this.x = mouseH.getX();
		this.y = mouseH.getY();
		this.hitbox.setLocation(mouseH.location);
	}

	@Override
	public void render(Graphics2D g2) {
		g2.setColor(Color.red);
		g2.drawRect(x, y, width, height);
	}

	@Override
	public void update(GamePanel gp) {
	}
}
