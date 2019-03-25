package org.vast.main;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

public abstract class Voxel extends GameObject {
	
	protected BufferedImage spriteSheet;
	
	public abstract void initializeImage();

	public Voxel(Vector3D position) {
		super(position);
		initializeImage();
	}
	
	public Voxel(double x, double y, double z) {
		super(x, y, z);
		initializeImage();
	}
	
	public void render(Graphics g) {
		//quick test
		switch(Shared.STATE) {
		case 0:
			drawImage = Shared.getSprite(0, 0, 32, spriteSheet);
			break;
		case 1:
			drawImage = Shared.getSprite(0, 0, 32, spriteSheet);
			break;
		case 2:
			drawImage = Shared.getSprite(0, 0, 32, spriteSheet);
			break;
		case 3:
			drawImage = Shared.getSprite(0, 0, 32, spriteSheet);
			break;
		}
	}

}
