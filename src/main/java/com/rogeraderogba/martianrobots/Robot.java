package com.rogeraderogba.martianrobots;

import java.util.List;

import com.rogeraderogba.martianrobots.enums.Command;
import com.rogeraderogba.martianrobots.enums.Orientation;
import com.rogeraderogba.martianrobots.location.Point;
import com.rogeraderogba.martianrobots.location.PointOrientation;

public class Robot {
	private PointOrientation pointOrientation;
	private boolean isLost;
	
	public Robot(int x, int y, Orientation orientation) {
		this.pointOrientation = new PointOrientation(new Point(x, y), orientation);
		this.isLost = false;
	}
	
	public void processCommands(List<Command> commands) {
		
	}
	
	public PointOrientation getPointOrientation() {
		return this.pointOrientation;
	}

	public boolean isLost() {
		return isLost;
	}

	public void setIsLost() {
		this.isLost = true;
	}

	public void setPointOrientation(PointOrientation nextPointOrientation) {
		this.pointOrientation = nextPointOrientation;
	}
	
	@Override
	public String toString() {
		return this.pointOrientation.toString() + " " + ((this.isLost) ? "LOST" : "");
	}
}