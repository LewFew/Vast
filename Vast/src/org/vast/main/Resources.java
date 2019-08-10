package org.vast.main;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;

public class Resources {
	
	public static HashMap<String, BufferedImage> sprites = new HashMap<String, BufferedImage>();
	
	public static String getPath(String relative) {
		return Resources.class.getClassLoader().getResource(relative).getPath();
	}
	
	public static File getFile(String relative) {
		return new File(Resources.class.getClassLoader().getResource(relative).getFile());
	}
	
}