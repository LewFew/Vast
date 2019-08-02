package org.vast.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFrame;

import org.vast.entities.Player;
import org.vast.voxels.VoxDice;
import org.vast.voxels.VoxGrass;
import org.vast.voxels.VoxTest;

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
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(Resources.getPath("resources/sprites/sprites.txt")));
			String line;
			String[] read;
			while ((line = br.readLine()) != null) {
				read = line.split(" ## ");
				Resources.sprites.put(read[0], Shared.loadSprite(read[1]));
			}
			
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.exit(1);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		
		Player player = new Player(new Vector3D(100, 100, 100));
		
		camera = new Camera(new Vector3D(0, 0, 0), player);
		
		handler.objects.add(camera);
		handler.objects.add(new VoxDice(new Vector3D(300, 300, 100)));
		handler.objects.add(new VoxTest(new Vector3D(500, 300, 100)));
		
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 10; j++) {
				handler.objects.add(new VoxGrass(new Vector3D(600 + i * 32, 300 + j * 32, 50)));
			}
		}
		
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 10; j++) {
				handler.objects.add(new VoxGrass(new Vector3D(600 + i * 32, 300 + j * 32, 82)));
			}
		}
		
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
				System.out.println(1000000000/(currentTime - lastTime) + " FPS");
				lastTime = currentTime;
				update();
				render();
			}
		}
	}

}
