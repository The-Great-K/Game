package main.java.ui;

import java.awt.Graphics2D;
import java.util.ArrayList;

import main.java.GamePanel;
import main.java.entity.button.Button;

public abstract class Screen {
	public GamePanel gp;
	public Graphics2D g2;

	public static void checkButtonClick(GamePanel gp, ArrayList<Button> buttonList) {
		for (Button button : buttonList) {
			if (button.isTouching(gp.pointer)) {
				button.image = button.hoveringImage;
				if (gp.mouseH.mouseDown) {
					button.onClick();
				}
			} else {
				button.image = button.normalImage;
			}
		}
	}

	public abstract void update(GamePanel gp);

	public abstract void render(Graphics2D g2);
}
