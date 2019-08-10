package org.vast.engines;

import org.vast.main.Engine;

public abstract class MoveEngine implements Engine{
	public double maxSpeed;
	public double speedDerivative;
	public boolean walking;
}
