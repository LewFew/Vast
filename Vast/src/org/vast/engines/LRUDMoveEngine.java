package org.vast.engines;

import java.awt.event.KeyEvent;

import org.vast.main.Engine;
import org.vast.main.GameObject;
import org.vast.main.KeyInput;
import org.vast.main.Shared;
import org.vast.main.Vector3D;

public class LRUDMoveEngine implements Engine {

	//Simple right now. Can change later
	
	@Override
	public void engUpdate(GameObject parent) {	
		Vector3D add;
		
		if (KeyInput.isKeyDown(KeyEvent.VK_LEFT)) {
			add = Shared.transformVector3D(new Vector3D(-5, 0, 0));
			parent.setPosition(parent.getPosition().add(add));
		}
		if (KeyInput.isKeyDown(KeyEvent.VK_RIGHT)) {
			add = Shared.transformVector3D(new Vector3D(5, 0, 0));
			parent.setPosition(parent.getPosition().add(add));
		}
		if (KeyInput.isKeyDown(KeyEvent.VK_UP)) {
			add = Shared.transformVector3D(new Vector3D(0, -5, 0));
			parent.setPosition(parent.getPosition().add(add));
		}
		if (KeyInput.isKeyDown(KeyEvent.VK_DOWN)) {
			add = Shared.transformVector3D(new Vector3D(0, 5, 0));
			parent.setPosition(parent.getPosition().add(add));
		}
	}

}
