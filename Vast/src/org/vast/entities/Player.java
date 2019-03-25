package org.vast.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import org.vast.engines.LRUDMoveEngine;
import org.vast.main.Entity;
import org.vast.main.GameObject;
import org.vast.main.KeyInput;
import org.vast.main.Main;
import org.vast.main.Shared;
import org.vast.main.Vector3D;

public class Player extends Entity {

	public Player(Vector3D position) {
		super(position);
		addEngine(new LRUDMoveEngine());
		effWidth = 100;
		effHeight = 100;
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(Shared.round(drawPosition.getX()), Shared.round(drawPosition.getY()), 100, 100);
	}

	@Override
	public void collide(GameObject o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		//Shared.refFrame = new Vector3D(position.getX() - Main.WIDTH / 2.5, position.getY() - Main.HEIGHT / 2.5, position.getZ());
		if (KeyInput.isKeyDown(KeyEvent.VK_W)) {
			Shared.STATE = 0;
		}
		if (KeyInput.isKeyDown(KeyEvent.VK_A)) {
			Shared.STATE = 3;
		}
		if (KeyInput.isKeyDown(KeyEvent.VK_S)) {
			Shared.STATE = 2;
		}
		if (KeyInput.isKeyDown(KeyEvent.VK_D)) {
			Shared.STATE = 1;
		}
		
		System.out.println("X: " + drawPosition.getX() + " Y: " + drawPosition.getY() + " STATE: " + Shared.STATE);
		System.out.println("RX: " + position.getX() + " RY: " + position.getY());
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
