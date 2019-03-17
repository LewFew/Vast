package org.vast.entities;

import java.awt.Color;
import java.awt.Graphics2D;

import org.vast.engines.LRUDMoveEngine;
import org.vast.main.Entity;
import org.vast.main.GameObject;
import org.vast.main.Vector3D;

public class Player extends Entity {

	public Player(Vector3D position) {
		super(position);
		addEngine(new LRUDMoveEngine());
	}

	@Override
	public void render(Graphics2D g2d) {
		g2d.setColor(Color.BLUE);
		g2d.fillRect((int)position.getX(), (int)position.getY(), 100, 100);
	}

	@Override
	public void collide(GameObject o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
