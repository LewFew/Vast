package org.vast.main;

import java.awt.Color;
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
		
		//Draw top piece

		drawImage = Shared.getSprite(0, 0, 32, 32, spriteSheet);
		
		//Draws bottom piece
		switch((Shared.STATE + orientation) % 4) {
		case 0:
			g.drawImage(Shared.getSprite(32, 0, 32, 32, spriteSheet),
					Shared.round(drawPosition.getX()),
					Shared.round(drawPosition.getY() + effHeight),
					effWidth, Shared.round(effHeight * Shared.scaleFactor), null);	
			break;
		case 1:
			g.drawImage(Shared.getSprite(64, 0, 32, 32, spriteSheet),
					Shared.round(drawPosition.getX()),
					Shared.round(drawPosition.getY() + effHeight),
					effWidth, Shared.round(effHeight * Shared.scaleFactor), null);	
			break;
		case 2:
			g.drawImage(Shared.getSprite(96, 0, 32, 32, spriteSheet),
					Shared.round(drawPosition.getX()),
					Shared.round(drawPosition.getY() + effHeight),
					effWidth, Shared.round(effHeight * Shared.scaleFactor), null);	
			break;
		case 3:
			g.drawImage(Shared.getSprite(128, 0, 32, 32, spriteSheet),
					Shared.round(drawPosition.getX()),
					Shared.round(drawPosition.getY() + effHeight),
					effWidth, Shared.round(effHeight * Shared.scaleFactor), null);	
			break;
		}
		
		//tint
		
		g.setColor(new Color(0, 0, 0, 80));
		g.fillRect(Shared.round(drawPosition.getX()),
					Shared.round(drawPosition.getY() + effHeight), effWidth, Shared.round(effHeight * Shared.scaleFactor));
	}

}
