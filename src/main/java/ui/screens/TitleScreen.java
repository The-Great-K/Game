package main.java.ui.screens;

import java.awt.Graphics2D;
import java.util.ArrayList;

import main.java.GamePanel;
import main.java.entity.button.Button;
import main.java.ui.GameState;
import main.java.ui.Screen;

public class TitleScreen extends Screen {
	public Button playButton, settingsButton, quitButton;

	public ArrayList<Button> buttonList = new ArrayList<>();

	private boolean setProperties = false;

	public TitleScreen(GamePanel gp) {
		this.gp = gp;

		playButton = new Button(gp, new Button.Properties().redirectTo(GameState.PLAY_STATE)
				.setFormattedProperties(gp, 0, 0, 24, 3).setDimensionsString("16x2").setText("PLAY"));
		settingsButton = new Button(gp, new Button.Properties().redirectTo(GameState.SETTINGS_STATE)
				.setFormattedProperties(gp, 0, 3, 24, 3).setDimensionsString("16x2").setText("SETTINGS"));
		quitButton = new Button(gp, new Button.Properties().onClickMethod(() -> System.exit(0))
				.setFormattedProperties(gp, 0, 6, 24, 3).setDimensionsString("16x2").setText("QUIT"));

		buttonList.add(playButton);
		buttonList.add(settingsButton);
		buttonList.add(quitButton);
	}

	public void update(GamePanel gp) {
		if (!setProperties) {
			setProperties = true;
		}

		for (Button button : buttonList) {
			button.update(gp);
		}
	}

	public void render(Graphics2D g2) {
		this.g2 = g2;

		for (Button button : buttonList) {
			button.render(g2);
		}
	}
}
