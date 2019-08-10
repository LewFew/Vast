package org.vast.voxels;

import org.vast.main.GameObject;
import org.vast.main.Resources;
import org.vast.main.Vector3D;
import org.vast.main.Voxel;

public class VoxGrass extends Voxel {

	public VoxGrass(Vector3D position) {
		super(position);
	}

	@Override
	public void initializeImage() {
		spriteSheet = Resources.sprites.get("grass");
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

}
