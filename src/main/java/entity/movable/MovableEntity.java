package main.java.entity.movable;

import main.java.GamePanel;
import main.java.entity.Entity;

public abstract class MovableEntity extends Entity {
	public static int gravity = 1;

	public double moveX = 0.0, moveY = 0.0;
	public double speed;

	public MovableEntity(GamePanel gp, double x, double y, int width, int height) {
		super(gp, x, y, width, height);
	}

	public void move() {
		setX(getX() + moveX);
		setY(getY() + moveY);
	}

	public double getSpeed() {
		return speed;
	}

	public int getSpeedAsInt() {
		return (int) speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}
}
