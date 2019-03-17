package org.vast.main;

public class Shared {

	private static int STATE = 0; //Direction that player is facing 0 = up moving clockwise
	private static Vector3D refFrame; //Usually the position of the player or camera
	
	/*
	 * The reason for the static shannegins is so these values are "read-only"
	 * to some classes, but writable to others. Specifically, those who have an
	 * object of the Shared class can write to it.
	 */
	
	public static Vector3D transformVector3D(Vector3D original) {
		double x = original.getX(), y = original.getY(), z = original.getZ();
		switch (STATE) {
		case 0:
			return original;
		case 1:
			return new Vector3D(y, -x, z);
		case 2:
			return new Vector3D(-x, -y, z);
		case 3:
			return new Vector3D(y, x, z);
		}
		return null;
	}
	
	public static Vector3D transformVector3DPosition(Vector3D original) {
		double x = original.getX(), y = original.getY(), z = original.getZ();
		double deltaX = refFrame.getX() - x, deltaY = refFrame.getY() - y, deltaZ = refFrame.getZ() - z;
		switch (STATE) {
		case 0:
			return original;
		case 1:
			return new Vector3D(y, -x, z);
		case 2:
			return new Vector3D(-x, -y, z);
		case 3:
			return new Vector3D(y, x, z);
		}
		return null;
	}
	
	@SuppressWarnings("static-access")
	public void setState(int STATE) {
		this.STATE = STATE;
	}
	
	public static int getState() {
		return STATE;
	}
	
	@SuppressWarnings("static-access")
	public void setRefFrame(Vector3D refFrame) {
		this.refFrame = refFrame;
	}
	
	public static Vector3D getRefFrame() {
		return refFrame;
	}
}
