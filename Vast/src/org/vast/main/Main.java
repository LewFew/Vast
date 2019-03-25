package org.vast.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

import org.vast.entities.Player;
import org.vast.voxels.VoxDice;

public class Main implements Runnable{
	
	private boolean running = false;
	private Window frame;
	private Handler handler;
	private Camera camera;
	
	public static final int WIDTH = 640, HEIGHT = 360;
	
	public Main() {
		running = true;
		
		frame = new Window("Vast");
		frame.setSize(WIDTH, HEIGHT);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);
		
		frame.addKeyListener(new KeyInput());
		
		handler = new Handler();
		
		Player player = new Player(new Vector3D(100, 100, 100));
		
		camera = new Camera(new Vector3D(0, 0, 0), player);
		
		handler.objects.add(camera);
		handler.objects.add(new VoxDice(new Vector3D(300, 300, 200)));
		handler.objects.add(player);
		
		this.run();
	}

	public static void main(String[] args) {
		new Main();
	}
	
	public void update() {
		//System.out.println(Shared.STATE);
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
		
		//g.setColor(Color.RED);
		//g.fillRect(WIDTH / 2, HEIGHT / 2, 1, 1);
		
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
