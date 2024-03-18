package main.java.entity.button;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.java.GamePanel;
import main.java.entity.Entity;
import main.java.entity.interfaces.OnClickFunctionEntity;
import main.java.handlers.MouseHandler;
import main.java.ui.GameState;

public class Button extends Entity implements OnClickFunctionEntity {
	public BufferedImage normalImage;
	public BufferedImage hoveringImage;
	public BufferedImage clickedImage;

	public Button.Properties properties;

	public String dimensionsString;
	public String text;
	public Dimension dimensions;

	public Button(GamePanel gp, Button.Properties p) {
		super(p.x, p.y, p.width, p.height);

		this.dimensionsString = p.dimensionsString;
		this.text = p.text;

		this.properties = p;

		getButtonImages();
	}

	public void getButtonImages() {
		try {
			normalImage = ImageIO.read(getClass()
					.getResourceAsStream("/textures/button/normal/button_" + dimensionsString + "_normal.png"));
			hoveringImage = ImageIO.read(getClass()
					.getResourceAsStream("/textures/button/hovering/button_" + dimensionsString + "_hover.png"));
			clickedImage = ImageIO.read(getClass()
					.getResourceAsStream("/textures/button/clicked/button_" + dimensionsString + "_clicked.png"));
		} catch (IOException e) {
			e.getStackTrace();
		}
		this.image = normalImage;
	}

	@Override
	public void onClick() {
		if (this.properties.stateRedirect != null) {
			GamePanel.gameState = this.properties.stateRedirect;
		} else if (this.properties.onClickMethod != null) {
			this.properties.onClickMethod.onClick();
		} else {
			System.out.println("ERROR: NO ONCLICK FUNCTION");
		}
	}

	@Override
	public void update(GamePanel gp) {
		this.hitbox = new Rectangle(getX(), getY(), getWidth(), getHeight());

		if (isTouching(GamePanel.p)) {
			if (MouseHandler.clicked) {
				clickChecker = true;
			} else if (clickChecker && MouseHandler.released) {
				onClick();
				clickChecker = false;
				MouseHandler.released = false;
			}
		} else {
			clickChecker = false;
		}
	}

	@Override
	public void render(Graphics2D g2) {
		this.g2 = g2;

		BufferedImage image = this.image;

		g2.drawImage(image, getX(), getY(), getWidth(), getHeight(), null);

		if (!isTouching(GamePanel.p)) {
			g2.drawImage(image, getX(), getY(), getWidth(), getHeight(), null);
		} else {
			if (MouseHandler.clicked) {
				g2.drawImage(clickedImage, getX(), getY(), getWidth(), getHeight(), null);
			} else {
				g2.drawImage(hoveringImage, getX(), getY(), getWidth(), getHeight(), null);
			}
		}

		g2.setColor(Color.red);
		g2.setFont(g2.getFont().deriveFont(Font.BOLD, (int) (GamePanel.tileSize * 1.5)));
		g2.drawString(text, this.getXForCenteredText(text), this.getYForCenteredText(text));
	}

	public int getXForCenteredText(String text) {
		int width = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
		int x = getX() + getWidth() / 2 - width / 2;
		return x;
	}

	public int getYForCenteredText(String text) {
		int height = (int) g2.getFontMetrics().getStringBounds(text, g2).getHeight();
		int y = getY() + getHeight() / 2 + height / 3;
		return y;
	}

	public static class Properties {
		GameState stateRedirect;
		int x = 0;
		int y = 0;
		int width = 0;
		int height = 0;
		String text = "";
		String dimensionsString;
		Dimension dimensions;
		OnClickFunctionEntity onClickMethod;

		public Button.Properties redirectTo(GameState gameState) {
			this.stateRedirect = gameState;
			return this;
		}

		public Button.Properties setFormattedProperties(GamePanel gp, int x, int y, int width, int height) {
			this.setX(GamePanel.tileSize * x);
			this.setY(GamePanel.tileSize * y);
			this.setWidth(GamePanel.tileSize * width);
			this.setHeight(GamePanel.tileSize * height);
			return this;
		}

		public Button.Properties onClickMethod(OnClickFunctionEntity onClickMethod) {
			this.onClickMethod = onClickMethod;
			return this;
		}

		public Button.Properties setX(int x) {
			this.x = x;
			return this;
		}

		public Button.Properties setY(int y) {
			this.y = y;
			return this;
		}

		public Button.Properties setWidth(int width) {
			this.width = width;
			return this;
		}

		public Button.Properties setHeight(int height) {
			this.height = height;
			return this;
		}

		public Button.Properties setText(String text) {
			this.text = text;
			return this;
		}

		public Button.Properties setDimensionsString(String dimensionsString) {
			this.dimensionsString = dimensionsString;
			return this;
		}

		public Dimension getDimensions() {
			String[] dimensionList = dimensionsString.split("x");
			this.dimensions = new Dimension(Integer.parseInt(dimensionList[0]), Integer.parseInt(dimensionList[1]));
			return this.dimensions;
		}
	}
}
