package main.java.tiles;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import main.java.GamePanel;

public class TileManager {
	public GamePanel gp;

	public TileManager(GamePanel gp) {
		this.gp = gp;
	}

	public Tile[][] readMap(String file) {
		Tile[][] map;
		int length = 0;
		int height = 0;

		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			while (br.readLine() != null)
				height++;

			br.close();

			height--;
		} catch (IOException e) {
			e.printStackTrace();
		}

		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String line = br.readLine();
			length = Integer.parseInt(line);

			map = new Tile[length][height];

			int row = 0;
			while ((line = br.readLine()) != null) {
				String[] values = line.split(" ");
				for (int col = 0; col < values.length; col++) {
					map[row][col] = new Tile(gp, GamePanel.tileSize * row, GamePanel.tileSize * col,
							Integer.parseInt(values[col]));
				}
				row++;
			}

			br.close();
			return map;
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	public void renderMap(Graphics2D g2, int height, Tile[][] map) {
		try {
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
