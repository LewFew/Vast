package org.vast.main;

import java.awt.image.BufferedImage;
import java.util.HashMap;

public class Resources {
	
	public static HashMap<String, BufferedImage> sprites = new HashMap<String, BufferedImage>();
	
	public static String getPath(String relative) {
		return Resources.class.getClassLoader().getResource(relative).getPath();
	}
	
}