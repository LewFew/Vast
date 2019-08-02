package org.vast.main;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Shared {

	public static int STATE = 0; //Direction that player is facing 0 = up moving clockwise
	public static Vector3D refFrame = new Vector3D(0, 0, 0); //Usually the position of the player or camera
	public static double scaleFactor = 0.7;
	
	/*
	 * The reason for the static shannegins is so these values are "read-only"
	 * to some classes, but writable to others. Specifically, those who have an
	 * object of the Shared class can write to it.
	 */

    public static BufferedImage loadSprite(String path) {

        BufferedImage sprite = null;

        try {
            sprite = ImageIO.read(new File(Resources.getPath(path)));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sprite;
    }

    public static BufferedImage getSprite(int xGrid, int yGrid, int tileSizeWidth, int tileSizeHeight, BufferedImage img) {
        return img.getSubimage(xGrid, yGrid, tileSizeWidth, tileSizeHeight);
    }
	
	public static Vector3D rotatePoint(Vector3D origin, Vector3D point, double angle) {
		//May have to change this to origin.y - point.y because 0,0 is at the top.
		
		double deltaX = point.getX() - origin.getX(), deltaY = point.getY() - origin.getY();
		double theta = Math.atan2(deltaY, deltaX);
		double l = Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2));
		return new Vector3D(l * Math.cos(theta + angle), l * Math.sin(theta + angle), point.getZ());
	}
	
	public static int round(double n) {
		if (n - (int)n >= 0.5) {
			return (int)n + 1;
		} else {
			return (int)n;
		}
	}
	
	public static Vector3D transformVector3D(Vector3D original) {
		return rotatePoint(new Vector3D(0, 0, 0), original, STATE * (Math.PI / 2));
	}
	
	public static Vector3D transformVector3DPosition(Vector3D original) {
		Vector3D rP = rotatePoint(refFrame, original, (STATE) * (Math.PI / 2));
		if (STATE == 1 || STATE == 3) {
			rP.setX(-rP.getX());
			rP.setY(-rP.getY());
			//rP.setZ(-rP.getZ());
		}
		return rP;
	}
	
}
