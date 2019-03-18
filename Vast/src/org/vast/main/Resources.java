package org.vast.main;

import java.awt.Image;
import java.util.HashMap;

public class Resources {
	
	public static HashMap<String, Image> sprites = new HashMap<String, Image>();
	
	public static String getPath(String relative) {
		return Resources.class.getClassLoader().getResource(relative).getPath();
	}
	
}