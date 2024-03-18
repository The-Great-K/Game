package main.java.entity.movable;

import main.java.GamePanel;
import main.java.entity.Entity;

public abstract class MovableEntity extends Entity {
	public static double gravity = 0.5;

	public double fallTime = 0.0;

	public double moveX = 0.0, moveY = 0.0;
	public double speed;

	public MovableEntity(GamePanel gp, double x, double y, int width, int height) {
		super(x, y, width, height);
	}

	public void move() {
		moveY += Math.max(0.5, (fallTime / GamePanel.TPS) * gravity);

		setX(getXAsDouble() + moveX);
		setY(getYAsDouble() + moveY);
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
