package org.vast.voxels;

import java.awt.Graphics2D;

import org.vast.main.GameObject;
import org.vast.main.Shared;
import org.vast.main.Vector3D;
import org.vast.main.Voxel;

public class VoxDice extends Voxel{

	public VoxDice(Vector3D position) {
		super(position);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void collide(GameObject o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void initializeImage() {
		spriteSheet = Shared.loadSprite("resources/sprites/dice.png");
	}

}
