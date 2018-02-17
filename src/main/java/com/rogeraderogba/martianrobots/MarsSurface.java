package com.rogeraderogba.martianrobots;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.rogeraderogba.martianrobots.location.Point;
import com.rogeraderogba.martianrobots.location.PointOrientation;

public class MarsSurface {
	private List<Robot> robotList;
	private Point upperBound;
	private Set<PointOrientation> lostScents;
	
	public MarsSurface(int boundX, int boundY) {
		this.upperBound = new Point(boundX, boundY);
		this.robotList = new ArrayList<>();
		this.lostScents = new HashSet<>();
	}
	
	public void addRobot(Robot robot) {
		this.robotList.add(robot);
	}
	
	public Robot getCurrentRobot() {
		Robot currentRobot = null;
		if (this.robotList.size() > 0) {
			currentRobot = this.robotList.get(this.robotList.size()-1);
		}
		return currentRobot;
	}

	public boolean isLostScentPosition(PointOrientation pointOrientation) {
		return this.lostScents.contains(pointOrientation);
	}
	
	public Point getUpperBound() {
		return this.upperBound;
	}
	
	public void addLostScent(PointOrientation pointOrientation) {
		this.lostScents.add(pointOrientation);
	}
	
	public List<String> getRobotPositions() {
		return this.robotList.stream().map(Object::toString).collect(Collectors.toList());
	}
}
