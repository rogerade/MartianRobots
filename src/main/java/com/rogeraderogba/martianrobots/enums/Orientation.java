package com.rogeraderogba.martianrobots.enums;

import com.rogeraderogba.martianrobots.MartianRobotsException;

public enum Orientation {
	NORTH("N"), SOUTH("S"), EAST("E"), WEST("W");
	
	private String code = null;
	
	private Orientation(String s){
		this.code = s;
	}
	
	public String getCode() {
		return this.code;
	}

	public static Orientation getOrientation(String s) {
		Orientation result = null;
		for(Orientation o : Orientation.values()) {
			if (o.getCode().equals(s)) {
				result = o;
				break;
			}
		}
		if (result == null) {
			throw new MartianRobotsException("Orientation not currently supported "+ s);
		}
		return result;
	}
}
