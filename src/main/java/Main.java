package main.java;

import javax.swing.JFrame;

public class Main {
	public static void main(String[] args) {
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setTitle("Game");

		window.setLocationRelativeTo(null);
		window.setUndecorated(true);
		window.setVisible(true);

		GamePanel gp = new GamePanel();
		window.add(gp);

		window.pack();

		GamePanel.device.setFullScreenWindow(window);

		gp.startGameThread();
	}
}