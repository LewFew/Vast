package org.vast.main;

import java.awt.image.BufferedImage;

public class Animation {

	private int frame = 0;
	private int maxFrames;
	private BufferedImage spriteSheet;
	private int tileWidth, tileHeight;
	
	private int delay;
	
	private BufferedImage currentFrame;
	
	public Animation(BufferedImage spriteSheet, int tileWidth, int tileHeight, int delay) {
		
		//For now, this only accepts sprite STRIPS. (Only one layer of sprites)
		
		this.spriteSheet = spriteSheet;
		this.tileWidth = tileWidth;
		this.tileHeight = tileHeight;
		
		maxFrames = (spriteSheet.getWidth() / tileWidth) * delay;
	}
	
	public void update() {
		currentFrame = Shared.getSprite((int)(frame/delay) * tileWidth, 0, tileWidth, tileHeight, spriteSheet);
		frame = (frame + 1) % maxFrames;
	}
	
	public BufferedImage getImage() {
		return currentFrame;
	}
	
	public void reset() {
		frame = 0;
	}
	
	public void setFrame(int frame) {
		this.frame = frame;
	}
	
	public int getFrame() {
		return frame;
	}
	
}