package main.java.entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import main.java.GamePanel;

public abstract class Entity extends Object {
	public GamePanel gp;
	public Graphics2D g2;

	public int x, y;
	public double rotation;
	public int width, height;

	public BufferedImage image;

	public Rectangle hitbox = new Rectangle(1, 1);

	public Entity(GamePanel gp, int x, int y, int width, int height) {
		this.gp = gp;
		setX(x);
		setY(y);
		setWidth(width);
		setHeight(height);
	}

	public Entity(GamePanel gp, int x, int y) {
		this.gp = gp;
		setX(x);
		setY(y);
	}

	public Entity(GamePanel gp) {
		this.gp = gp;
	}

	public boolean isTouching(Entity entity) {
		if (entity.hitbox != null) {
			return entity.hitbox.intersects(this.hitbox);
		} else {
			return false;
		}
	}

	public abstract void update(GamePanel gp);

	public abstract void render(Graphics2D g2);

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setX(double x) {
		this.x = (int) x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setY(double y) {
		this.y = (int) y;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public void setWidth(double width) {
		this.width = (int) width;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public void setHeight(double height) {
		this.height = (int) height;
	}

	@Override
	public String toString() {
		return "X: " + this.x + ", Y: " + this.y + ", Width: " + this.width + ", Height: " + this.height;
	}
}
