package main.java.ui;

import java.awt.Graphics2D;

import main.java.GamePanel;

public class UI {
	public GamePanel gp;
	public Graphics2D g2;

	public UI(GamePanel gp) {
		this.gp = gp;
	}

	public void update(GamePanel gp) {
		switch (GamePanel.gameState) {
		case TITLE_STATE:
			ScreenInit.titleScreen.update(gp);
			Screen.checkButtonClick(gp, ScreenInit.titleScreen.buttonList);
			break;
		case PLAY_STATE:
			ScreenInit.gameScreen.update(gp);
			break;
		case SETTINGS_STATE:
			ScreenInit.settingsScreen.update(gp);
			break;
		default:
			break;
		}
	}

	public void render(Graphics2D g2) {
		this.g2 = g2;
		switch (GamePanel.gameState) {
		case TITLE_STATE:
			ScreenInit.titleScreen.render(g2);
			break;
		case PLAY_STATE:
			ScreenInit.gameScreen.render(g2);
			break;
		case SETTINGS_STATE:
			ScreenInit.settingsScreen.render(g2);
			break;
		default:
			break;
		}
	}
}
