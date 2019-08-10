package org.vast.misc;

import java.util.Comparator;

import org.vast.main.GameObject;

public class CompareZ implements Comparator<GameObject>{

	@Override
	public int compare(GameObject o1, GameObject o2) {
		if (o1.getPosition().getZ() == o2.getPosition().getZ()) {
			return Double.compare(o1.getDrawPosition().getY(), o2.getDrawPosition().getY());
		} else {
			return Double.compare(o1.getPosition().getZ(), o2.getPosition().getZ());
		}
	}

}
