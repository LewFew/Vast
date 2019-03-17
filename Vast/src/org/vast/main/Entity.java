package org.vast.main;

public abstract class Entity extends GameObject{

	protected int life;
	
	public Entity(Vector3D position) {
		super(position);
	}
	
	public Entity(double x, double y, double z) {
		super(x, y, z);
	}
	
	@Override
	public void abstractCommon() {
		if (life <= 0) {
			//remove object
		}
	}

}
