package org.vast.engines;

import java.awt.event.KeyEvent;

import org.vast.main.Engine;
import org.vast.main.GameObject;
import org.vast.main.KeyInput;
import org.vast.main.Shared;
import org.vast.main.Vector3D;

public class WASDMoveEngine extends MoveEngine {

	@Override
	public void engUpdate(GameObject parent) {
		Vector3D add;
		
		walking = false;
		
		if (!KeyInput.isKeyDown(KeyEvent.VK_SHIFT)) {
			if (KeyInput.isKeyDown(KeyEvent.VK_A)) {
				add = Shared.transformVector3D(new Vector3D(-5, 0, 0));
				parent.setPosition(parent.getPosition().add(add));
				parent.setOrientation((Shared.STATE + 3) % 4);
				walking = true;
			}
			if (KeyInput.isKeyDown(KeyEvent.VK_D)) {
				add = Shared.transformVector3D(new Vector3D(5, 0, 0));
				parent.setPosition(parent.getPosition().add(add));
				parent.setOrientation((Shared.STATE + 1) % 4);
				walking = true;
			}
			if (KeyInput.isKeyDown(KeyEvent.VK_W)) {
				add = Shared.transformVector3D(new Vector3D(0, -5, 0));
				parent.setPosition(parent.getPosition().add(add));
				parent.setOrientation((Shared.STATE + 0) % 4);
				walking = true;
			}
			if (KeyInput.isKeyDown(KeyEvent.VK_S)) {
				add = Shared.transformVector3D(new Vector3D(0, 5, 0));
				parent.setPosition(parent.getPosition().add(add));
				parent.setOrientation((Shared.STATE + 2) % 4);
				walking = true;
			}
		}
	}

}
