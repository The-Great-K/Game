package main.java.ui.screens.settings;

import java.awt.Graphics2D;

import main.java.GamePanel;
import main.java.ui.Screen;

public class SettingsScreen extends Screen {
	public GamePanel gp;
	public Graphics2D g2;

	public SettingsScreen(GamePanel gp) {
		this.gp = gp;
	}

	@Override
	public void update(GamePanel gp) {
	}

	@Override
	public void render(Graphics2D g2) {
		this.g2 = g2;
	}
}
