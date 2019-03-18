package org.vast.main;

import java.awt.Graphics;
import java.awt.Graphics2D;

import org.vast.engines.LRUDMoveEngine;

public class Camera extends GameObject{

	public Camera(Vector3D position) {
		super(position);
		addEngine(new LRUDMoveEngine());
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void collide(GameObject o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		Shared.refFrame = new Vector3D(position.getX() - Main.WIDTH / 2.5, position.getY() - Main.HEIGHT / 2.5, position.getZ());
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
