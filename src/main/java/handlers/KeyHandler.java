package main.java.handlers;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import main.java.GamePanel;

public class KeyHandler extends KeyAdapter {
	public GamePanel gp;

	// IF THESE ARE PRESSED DOWN
	public boolean w, a, s, d;

	public KeyHandler(GamePanel gp) {
		this.gp = gp;

		gp.addKeyListener(this);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();

		if (code == KeyEvent.VK_W) {
			w = true;
		}
		if (code == KeyEvent.VK_A) {
			a = true;
		}
		if (code == KeyEvent.VK_S) {
			s = true;
		}
		if (code == KeyEvent.VK_D) {
			d = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int code = e.getKeyCode();

		if (code == KeyEvent.VK_W) {
			w = false;
		}
		if (code == KeyEvent.VK_A) {
			a = false;
		}
		if (code == KeyEvent.VK_S) {
			s = false;
		}
		if (code == KeyEvent.VK_D) {
			d = false;
		}
	}
}
