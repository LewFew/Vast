package org.vast.main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;

public class KeyInput implements KeyListener {
	
	private static HashSet<Integer> isDown = new HashSet<Integer>();
	private static HashSet<Integer> isReleased = new HashSet<Integer>();
	private static HashSet<Integer> isPressed = new HashSet<Integer>();
	
	public static boolean isKeyDown(int keycode) {
		if (isDown.contains(keycode)) 
			return true;
		else
			return false;
	}
	
	public static boolean isKeyReleased(int keycode) {
		if (isReleased.contains(keycode))
			return true;
		else
			return false;
	}
	
	public static boolean isKeyPressed(int keycode) {
		if (isPressed.contains(keycode))
			return true;
		else
			return false;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		isDown.add(e.getKeyCode());
		isPressed.add(e.getKeyCode());
	}

	@Override
	public void keyReleased(KeyEvent e) {
		isDown.remove(e.getKeyCode());
		isReleased.add(e.getKeyCode());
	}
	
	public static void clear() {
		isReleased.clear();
		isPressed.clear();
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

}