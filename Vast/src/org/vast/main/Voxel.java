package org.vast.main;

public abstract class Voxel extends GameObject {

	public Voxel(Vector3D position) {
		super(position);
	}
	
	public Voxel(double x, double y, double z) {
		super(x, y, z);
	}

}
