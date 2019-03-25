package org.vast.main;

import java.awt.Graphics;
import java.awt.Graphics2D;

import org.vast.engines.LRUDMoveEngine;

public class Camera extends GameObject { 
	
	private GameObject tracking;
	
	public Camera(Vector3D position, GameObject tracking) {
		super(position);
		//addEngine(new LRUDMoveEngine());
		this.tracking = tracking;
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
		Shared.refFrame = new Vector3D(position.getX() - Main.WIDTH / 2, position.getY() - Main.HEIGHT / 2, position.getZ());
		velocity = new Vector3D((tracking.getPosition().getX() - (position.getX() - Main.WIDTH / 2)) / 5,
				(tracking.getPosition().getY() - (position.getY() - Main.HEIGHT / 4.5)) / 5, 0);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
