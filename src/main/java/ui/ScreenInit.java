package main.java.ui;

import main.java.GamePanel;
import main.java.ui.screens.TitleScreen;
import main.java.ui.screens.game.GameScreen;
import main.java.ui.screens.settings.SettingsScreen;

public class ScreenInit {
	public static GamePanel gp;

	public ScreenInit(GamePanel gp) {
		ScreenInit.gp = gp;
	}

	public static GameScreen gameScreen = new GameScreen(gp);

	public static TitleScreen titleScreen = new TitleScreen(gp);

	public static SettingsScreen settingsScreen = new SettingsScreen(gp);
}
