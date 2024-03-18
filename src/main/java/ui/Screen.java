package main.java.ui;

import java.awt.Graphics2D;

import main.java.GamePanel;

public abstract class Screen {
	public GamePanel gp;
	public Graphics2D g2;

	public abstract void update(GamePanel gp);

	public abstract void render(Graphics2D g2);
}
