package org.vast.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import org.vast.engines.LRUDMoveEngine;
import org.vast.engines.MoveEngine;
import org.vast.engines.WASDMoveEngine;
import org.vast.engines.WASDPerspectiveEngine;
import org.vast.main.Animation;
import org.vast.main.Engine;
import org.vast.main.Entity;
import org.vast.main.GameObject;
import org.vast.main.KeyInput;
import org.vast.main.Main;
import org.vast.main.Resources;
import org.vast.main.Shared;
import org.vast.main.Vector3D;

public class Player extends Entity {
	
	private Animation walk[] = {new Animation(Resources.sprites.get("walkFor"), 32, 54, 5),
			new Animation(Resources.sprites.get("walkRight"), 32, 54, 5),
			new Animation(Resources.sprites.get("walkBack"), 32, 54, 5),
			new Animation(Resources.sprites.get("walkLeft"), 32, 54, 5)};
	private BufferedImage stand[] = {Resources.sprites.get("standFor"),
			Resources.sprites.get("standRight"),
			Resources.sprites.get("standBack"),
			Resources.sprites.get("standLeft")};
	
	private Animation currentAnimation;
	private MoveEngine move = new WASDMoveEngine();

	public Player(Vector3D position) {
		super(position);
		addEngine(move);
		addEngine(new WASDPerspectiveEngine());
		effWidth = 32;
		effHeight = 54;
	}

	@Override
	public void render(Graphics g) {
		if (move.walking) {
			walk[relativeOrientation].update();
			drawImage = walk[relativeOrientation].getImage();
		} else {
			drawImage = stand[relativeOrientation];
		}
	}

	@Override
	public void collide(GameObject o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		System.out.println(relativeOrientation);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
