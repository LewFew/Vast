package org.vast.main;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import org.vast.misc.CompareZ;

public class Handler {
	
	ArrayList<GameObject> objects = new ArrayList<GameObject>();
	CompareZ cmp = new CompareZ();
	
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
		Collections.sort(objects, cmp);
		for (GameObject o : objects) {
			o.render(g);
			o.commonDraw(g);
		}
	}
}
