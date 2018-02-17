package com.rogeraderogba.martianrobots;

import java.util.ArrayList;
import java.util.List;

import com.rogeraderogba.martianrobots.location.Point;
import com.rogeraderogba.martianrobots.location.PointOrientation;

public class MarsSurface {
	private List<Robot> robotList;
	private Point upperBound;
	private List<PointOrientation> lostScents;
	
	public MarsSurface(int boundX, int boundY) {
		this.upperBound = new Point(boundX, boundY);
		this.robotList = new ArrayList<>();
		this.lostScents = new ArrayList<>();
	}
}
