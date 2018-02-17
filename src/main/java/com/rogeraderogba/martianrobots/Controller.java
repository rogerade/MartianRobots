package com.rogeraderogba.martianrobots;

import java.util.List;

import com.rogeraderogba.martianrobots.enums.Command;
import com.rogeraderogba.martianrobots.enums.Orientation;
import com.rogeraderogba.martianrobots.location.Point;
import com.rogeraderogba.martianrobots.location.PointOrientation;

public class Controller {
	
	private MarsSurface marsSurface;
	
	public Controller() {
	}

	public void setUpperRightCoordinate(int x, int y) {
		this.marsSurface = new MarsSurface(x, y);		
	}

	public void addRobot(int x, int y, Orientation orientation) {
		Robot robot = new Robot(x, y, orientation);
		this.marsSurface.addRobot(robot);
	}

	public void commandRobot(List<Command> commands) {
		if(commands != null && commands.size() > 0) {
			Robot currentRobot = this.marsSurface.getCurrentRobot();
			PointOrientation pointOrientation = currentRobot.getPointOrientation();
			for(Command command : commands) {
				if (Command.FORWARD == command && this.marsSurface.isLostScentPosition(pointOrientation)) {
					// Ignore
				}
				else {
					PointOrientation nextPointOrientation = command.getNextPointOrientation(pointOrientation);
					Point nextPoint = nextPointOrientation.getPoint();
					if (isWithinBounds(nextPoint.getX(), this.marsSurface.getUpperBound().getX()) && 
						isWithinBounds(nextPoint.getY(), this.marsSurface.getUpperBound().getY())) {
						currentRobot.setPointOrientation(nextPointOrientation);
					}
					else {
						this.marsSurface.addLostScent(currentRobot.getPointOrientation());
						currentRobot.setIsLost();
					}
				}
			}
		}
	}
	
	public boolean isWithinBounds(int value, int max) {
		return value > 0 && value <= max;
	}

	public List<String> getFinalGridPositions() {
		return this.marsSurface.getRobotPositions();
	}
}