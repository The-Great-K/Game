package main.java;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;

import javax.swing.JPanel;

import main.java.entity.Pointer;
import main.java.handlers.KeyHandler;
import main.java.handlers.MouseHandler;
import main.java.ui.GameState;
import main.java.ui.ScreenInit;
import main.java.ui.UI;

public class GamePanel extends JPanel implements Runnable {
	private static final long serialVersionUID = 915410960215136040L;

	public Thread gameThread;
	public static final int TPS = 60;

	public static Dimension screenDimensions = Toolkit.getDefaultToolkit().getScreenSize();
	public static GraphicsDevice device = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()[0];

	public static int tileSize = (int) Math.floor(screenDimensions.getHeight() / 36);

	public MouseHandler mouseH = new MouseHandler(this);
	public Pointer pointer = new Pointer(this);

	public KeyHandler keyH = new KeyHandler(this);

	public UI ui = new UI(this);
	public static GameState gameState = GameState.TITLE_STATE;

	public GamePanel() {
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		this.setLayout(null);
		this.setFocusable(true);
	}

	public void startGameThread() {
		gameThread = new Thread(this);
		gameThread.start();
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
		pointer.update(this, mouseH);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D) g;

		ui.render(g2);

		pointer.render(g2);

		g2.dispose();
	}

	public void logConsole() {
		System.out.println(ScreenInit.gameScreen.player.toString());
		System.out.println(keyH.w);

		System.out.println();
	}
}
