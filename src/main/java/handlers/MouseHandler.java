package main.java.handlers;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import main.java.GamePanel;

public class MouseHandler extends MouseAdapter {
	public GamePanel gp;

	public Point location = new Point(0, 0);

	public boolean mouseDown = false;

	public MouseHandler(GamePanel gp) {
		this.gp = gp;

		gp.addMouseListener(this);
		gp.addMouseMotionListener(this);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		mouseDown = true;
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		mouseDown = false;
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		location.x = e.getX();
		location.y = e.getY();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		location.x = e.getX();
		location.y = e.getY();
	}

	public int getX() {
		return location.x;
	}

	public int getY() {
		return location.y;
	}
}
