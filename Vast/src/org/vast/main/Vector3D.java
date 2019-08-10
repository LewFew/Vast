package org.vast.main;

public class Vector3D {
	
	private double x, y, z;

	public Vector3D(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public double getMagnitude() {
		return 0.0;
	}
	
	public Vector3D add(Vector3D summand) {
		x += summand.x;
		y += summand.y;
		z += summand.z;
		return this;
	}
	
	public void setX(double x) {
		this.x = x;
	}
	
	public void setY(double y) {
		this.y = y;
	}
	
	public void setZ(double z) {
		this.z = z;
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	public double getZ() {
		return z;
	}
	
}
