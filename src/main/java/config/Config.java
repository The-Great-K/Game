package main.java.config;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import main.java.GamePanel;

// For later use
public class Config {
	public GamePanel gp;

	public Config(GamePanel gp) {
		this.gp = gp;
	}

	public void saveConfig() {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter("config.txt"))) {

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void loadConfig() {
		try (BufferedReader br = new BufferedReader(new FileReader("config.txt"))) {

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
