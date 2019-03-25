package org.vast.main;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;

public abstract class GameObject {

	protected Vector3D position;
	protected Vector3D drawPosition;
	protected Vector3D velocity;
	protected Vector3D acceleration;
	protected ArrayList<Vector3D> forces = new ArrayList<Vector3D>();	
	protected ArrayList<Engine> engines = new ArrayList<Engine>();
	protected Rectangle hitBox;
	protected boolean isTangible = true;
	protected int mass;
	protected int orientation; //direction the object is facing
	protected Image drawImage;
	protected int effWidth, effHeight;
	protected boolean visible = true;
	
	protected boolean destroyed = false;
	
	public GameObject(Vector3D position) {
		this.position = position;
		acceleration = new Vector3D(0, 0, 0);
		velocity = new Vector3D(0, 0, 0);
	}
	
	public GameObject(double x, double y, double z) {
		position = new Vector3D(x, y, z);
		acceleration = new Vector3D(0, 0, 0);
		velocity = new Vector3D(0, 0, 0);
	}
	
	public abstract void render(Graphics g);
	public abstract void collide(GameObject o);
	public abstract void update();
	public abstract void destroy();
	
	public void abstractCommon() {};
	
	public void addEngine(Engine engine) {
		engines.add(engine);
	}
	
	public void commonDraw(Graphics g) {
		if (visible && drawImage != null) {
			g.drawImage(drawImage, Shared.round(drawPosition.getX()), Shared.round(drawPosition.getY()), null);
		}
	}
	
	public void common() {
		//Set new draw position, etc.
		
		if (drawImage != null) {
			effWidth = drawImage.getWidth(null);
			effHeight = drawImage.getHeight(null);
		}
		
		drawPosition = Shared.transformVector3DPosition(new Vector3D(position.getX(), position.getY() - position.getZ(), 0));
		drawPosition.setX(drawPosition.getX() + Main.WIDTH / 2 - (effWidth / 2));
		drawPosition.setY(drawPosition.getY() + Main.HEIGHT / 2 - (effHeight / 2));
		
		//Physics
		if (isTangible) {
			Vector3D netForce = new Vector3D(0, 0, 0);
			for (Vector3D force : forces) {
				netForce.add(force);
			}
			acceleration.add(netForce);
			velocity.add(acceleration);
			
			//check for collisions, use better algo later.
			
			position.add(velocity);
		}
	}
	
	public Vector3D getDrawPosition() {
		return drawPosition;
	}
	
	public ArrayList<Engine> getEngines() {
		return engines;
	}
	
	public Vector3D getPosition() {
		return position;
	}
	
	public void setPosition(Vector3D position) {
		this.position = position;
	}
	
	public Vector3D getVelocity() {
		return velocity;
	}
	
	public void setVelocity(Vector3D velocity) {
		this.velocity = velocity;
	}
	
	public Vector3D getAcceleration() {
		return acceleration;
	}
	
	public void setAcceleration(Vector3D acceleration) {
		this.acceleration = acceleration;
	}
	
}
