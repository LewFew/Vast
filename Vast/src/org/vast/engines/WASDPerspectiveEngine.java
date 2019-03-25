package org.vast.engines;

import java.awt.event.KeyEvent;

import org.vast.main.Engine;
import org.vast.main.GameObject;
import org.vast.main.KeyInput;
import org.vast.main.Shared;

public class WASDPerspectiveEngine implements Engine{

	@Override
	public void engUpdate(GameObject parent) {
		if (KeyInput.isKeyDown(KeyEvent.VK_W) && KeyInput.isKeyDown(KeyEvent.VK_SHIFT)) {
			Shared.STATE = 0;
		}
		if (KeyInput.isKeyDown(KeyEvent.VK_A) && KeyInput.isKeyDown(KeyEvent.VK_SHIFT)) {
			Shared.STATE = 3;
		}
		if (KeyInput.isKeyDown(KeyEvent.VK_S) && KeyInput.isKeyDown(KeyEvent.VK_SHIFT)) {
			Shared.STATE = 2;
		}
		if (KeyInput.isKeyDown(KeyEvent.VK_D) && KeyInput.isKeyDown(KeyEvent.VK_SHIFT)) {
			Shared.STATE = 1;
		}
	}

}
