package main.java;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;

import javax.swing.JPanel;

import main.java.entity.Entity;
import main.java.handlers.KeyHandler;
import main.java.handlers.MouseHandler;
import main.java.tiles.Tile;
import main.java.tiles.TileManager;
import main.java.ui.GameState;
import main.java.ui.ScreenInit;
import main.java.ui.UI;

public class GamePanel extends JPanel implements Runnable {
	private static final long serialVersionUID = 915410960215136040L;

	public Thread gameThread;
	public static final int TPS = 60;

	public static Dimension screenDimensions = Toolkit.getDefaultToolkit().getScreenSize();

	public static int tileSize = (int) Math.floor(screenDimensions.getHeight() / 27);

	public MouseHandler mouseH = new MouseHandler(this);
	public static P p = new P();

	public KeyHandler keyH = new KeyHandler(this);

	public static int gravity = 10;

	public TileManager tm = new TileManager(this);
	public Tile[][] map;

	public UI ui = new UI(this);
	public static GameState gameState = GameState.TITLE_STATE;

	public GamePanel() {
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		this.setLayout(null);
		this.setFocusable(true);
		this.setPreferredSize(screenDimensions);
	}

	public void startGameThread() {
		gameThread = new Thread(this);
		gameThread.start();
		map = tm.readMap("resources/maps/map.lvtn");
	}

	@Override
	public void run() {
		while (gameThread != null) {
			// DELTA GAME LOOP
			double drawInterval = 1000000000 / TPS;
			double delta = 0;
			long lastTime = System.nanoTime();
			long timer = System.currentTimeMillis();
			long fps = 0;

			while (gameThread != null) {
				long currentTime = System.nanoTime();
				delta += (currentTime - lastTime) / drawInterval;
				lastTime = currentTime;

				while (delta >= 1) {
					update();
					delta--;
				}
				if (gameThread != null) {
					repaint();
				}

				fps++;
				if (System.currentTimeMillis() - timer > 1000) {
					timer += 1000;
					System.out.println("FPS: " + fps);
					logConsole();
					fps = 0;
				}
			}
		}
	}

	public void update() {
		ui.update(this);
		p.update(this);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D) g;

		ui.render(g2);

		p.render(g2);

		tm.renderMap(g2, map.length, map);

		g2.dispose();
	}

	public void logConsole() {
		System.out.println(ScreenInit.gameScreen.player.toString());
		System.out.println(keyH.w);
		System.out.println(screenDimensions.toString());

		System.out.println();
	}

	public static class P extends Entity {
		public P() {
			this.hitbox.width = 1;
			this.hitbox.height = 1;
		}

		@Override
		public void update(GamePanel gp) {
			this.hitbox.setLocation((int) gp.mouseH.location.getX(), (int) gp.mouseH.location.getY());
		}

		@Override
		public void render(Graphics2D g2) {
		}
	}
}
