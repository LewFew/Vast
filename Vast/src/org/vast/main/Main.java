package org.vast.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

import org.vast.entities.Player;

public class Main implements Runnable{
	
	private boolean running = false;
	private Window frame;
	private Handler handler;
	
	public static final int WIDTH = 640, HEIGHT = 360;
	
	public Main() {
		running = true;
		
		frame = new Window("Vast");
		frame.setSize(WIDTH, HEIGHT);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		frame.addKeyListener(new KeyInput());
		
		handler = new Handler();
		
		handler.objects.add(new Player(new Vector3D(100, 100, 100)));
		
		this.run();
	}

	public static void main(String[] args) {
		new Main();
	}
	
	public void update() {
		handler.update();
	}
	
	public void render() {
		
		BufferStrategy bs;
		
		if (frame.getBufferStrategy() == null) {
			frame.createBufferStrategy(3);
		}
		
		bs = frame.getBufferStrategy();
		
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(Color.WHITE);
		
		//Clear
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		handler.render(g);
		
		bs.show();
	}
	
	public void run() {
		long lastTime = System.nanoTime();
		while (running) {
			long currentTime = System.nanoTime();
			if (currentTime - lastTime >= (1000000000/60)) {
				lastTime = currentTime;
				update();
				render();
			}
		}
	}

}
