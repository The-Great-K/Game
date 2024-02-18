package main.java.tiles;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.java.GamePanel;

public class Tile extends Rectangle {
	private static final long serialVersionUID = 6006985910747580978L;

	public GamePanel gp;
	public Graphics2D g2;

	public int type;

	public int x, y;

	public BufferedImage image;

	public Tile(GamePanel gp, int x, int y, int type) {
		this.gp = gp;
		this.type = type;
		this.x = x;
		this.y = y;

		this.getImage(type);
	}

	private void getImage(int type) {
		try {
			switch (type) {
			case 1:
				image = ImageIO.read(getClass().getResourceAsStream("/textures/tile/default.png"));
				break;
			case 2:
				image = ImageIO.read(getClass().getResourceAsStream("/textures/tile/alternative.png"));
			default:
				break;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void render(Graphics2D g2) {
		g2.drawImage(image, x, y, GamePanel.tileSize, GamePanel.tileSize, null);
	}

	@Override
	public String toString() {
		return String.valueOf(type);
	}
}
