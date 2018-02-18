package com.rogeraderogba.martianrobots.enums;

import java.util.HashMap;
import java.util.Map;

import com.rogeraderogba.martianrobots.MartianRobotsException;
import com.rogeraderogba.martianrobots.location.Point;
import com.rogeraderogba.martianrobots.location.PointOrientation;

public enum Command {
	LEFT('L'){
		public PointOrientation getNextPointOrientation(PointOrientation pointOrientation) {
			Point newPoint = pointOrientation.getPoint();;
			Orientation newOrientation = beforeToAfterLeftCommandMap.get(pointOrientation.getOrientation());
			return new PointOrientation(newPoint, newOrientation);
		}
	}, 
	RIGHT('R'){
		public PointOrientation getNextPointOrientation(PointOrientation pointOrientation) {
			Point newPoint = pointOrientation.getPoint();;
			Orientation newOrientation = beforeToAfterRightCommandMap.get(pointOrientation.getOrientation());
			return new PointOrientation(newPoint, newOrientation);
		}
	}, 
	FORWARD('F'){
		public PointOrientation getNextPointOrientation(PointOrientation pointOrientation) {
			Orientation newOrientation = pointOrientation.getOrientation();
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
			Point newPoint = new Point(x,y);
			return new PointOrientation(newPoint, newOrientation);
		}	
	};
	
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
		Holder.MAP.put(code, this);
	}
	
	public char getCode() {
		return this.code;
	}
	
	private static class Holder {
        static Map<Character, Command> MAP = new HashMap<>();
    }
	
	public abstract PointOrientation getNextPointOrientation(PointOrientation pointOrientation); 
	
	public static Command getCommand(char c) {
		Command result = Holder.MAP.get(c);

		if (result == null) {
			throw new MartianRobotsException("Command currently not supported");
		}
		return result;
	}
}
