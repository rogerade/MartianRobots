package com.rogeraderogba.martianrobots.enums;

import java.util.HashMap;
import java.util.Map;

import com.rogeraderogba.martianrobots.location.Point;
import com.rogeraderogba.martianrobots.location.PointOrientation;

public enum Command {
	LEFT('L'), RIGHT('R'), FORWARD('F');
	
	private static final Map<Orientation, Orientation> beforeToAfterLeftCommandMap;
	private static final Map<Orientation, Orientation> beforeToAfterRightCommandMap;
	static {
		beforeToAfterLeftCommandMap = new HashMap<>();
		beforeToAfterLeftCommandMap.put(Orientation.NORTH, Orientation.WEST);
		beforeToAfterLeftCommandMap.put(Orientation.WEST, Orientation.SOUTH);
		beforeToAfterLeftCommandMap.put(Orientation.SOUTH, Orientation.EAST);
		beforeToAfterLeftCommandMap.put(Orientation.EAST, Orientation.NORTH);
		beforeToAfterRightCommandMap = new HashMap<>();
		beforeToAfterRightCommandMap.put(Orientation.NORTH, Orientation.EAST);
		beforeToAfterRightCommandMap.put(Orientation.EAST, Orientation.SOUTH);
		beforeToAfterRightCommandMap.put(Orientation.SOUTH, Orientation.WEST);
		beforeToAfterRightCommandMap.put(Orientation.WEST, Orientation.NORTH);
	}
	
	private char code;
	
	Command(char code){
		this.code = code;
	}
	
	public char getCode() {
		return this.code;
	}

	public PointOrientation getNextPointOrientation(PointOrientation pointOrientation) {
		Point newPoint = null;
		Orientation newOrientation = null;
		switch(this) {
			case LEFT:
				newOrientation = beforeToAfterLeftCommandMap.get(pointOrientation.getOrientation());
				newPoint = pointOrientation.getPoint();
				break;
			case RIGHT:
				newOrientation = beforeToAfterRightCommandMap.get(pointOrientation.getOrientation());
				newPoint = pointOrientation.getPoint();
				break;
			case FORWARD:
				newOrientation = pointOrientation.getOrientation();
				int x = pointOrientation.getPoint().getX();
				int y = pointOrientation.getPoint().getY();
				switch(pointOrientation.getOrientation()) {
					case NORTH :
						y += 1;
						break;
					case EAST :
						x += 1;
						break;
					case SOUTH :
						y -= 1;
						break;
					case WEST :
						x -= 1;
						break;
				}
				newPoint = new Point(x,y);
				break;
		}
		return new PointOrientation(newPoint, newOrientation);
	}
	
	public static Command getCommand(char c) {
		Command result = null;
		for(Command command : Command.values()) {
			if(command.getCode() == c) {
				result = command;
				break;
			}
		}
		return result;
	}
}
