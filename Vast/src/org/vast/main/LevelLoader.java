package org.vast.main;

import org.vast.entities.Player;

public class LevelLoader {
	
	public static void loadLevel(int[][][] levelGrid, Handler h) {
		Shared.levelGrid = levelGrid;
		
		//This may be optimized by using fixed values for level size
		for (int x = 0; x < levelGrid.length; x++) {
			for (int y = 0; y < levelGrid[x].length; y++) {
				for (int z = 0; z < levelGrid[x][y].length; z++) {
					switch (levelGrid[x][y][z]) {
						case 1:
							h.objects.add(new Player(new Vector3D(x * 32, y * 32, z * 32)));
					}
				}
			}
		}
	}
	
}
