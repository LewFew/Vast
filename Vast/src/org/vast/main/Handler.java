package org.vast.main;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

public class Handler {
	
	ArrayList<GameObject> objects = new ArrayList<GameObject>();
	
	public void update() {
		for (GameObject o : objects) {
			o.common();
			for (Engine e : o.getEngines()) {
				e.engUpdate(o);
			}
			o.update();
		}
	}
	
	public void render(Graphics g) {
		for (GameObject o : objects) {
			o.render(g);
		}
	}
}
