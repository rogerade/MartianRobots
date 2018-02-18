package com.rogeraderogba.martianrobots.enums;

import java.util.HashMap;
import java.util.Map;

import com.rogeraderogba.martianrobots.MartianRobotsException;

public enum Orientation {
	NORTH("N"), SOUTH("S"), EAST("E"), WEST("W");
	
	private String code = null;
	
	private Orientation(String s){
		this.code = s;
		Holder.MAP.put(s, this);
	}
	
	public String getCode() {
		return this.code;
	}
	
	private static class Holder {
        static Map<String, Orientation> MAP = new HashMap<>();
    }

	public static Orientation getOrientation(String s) {
		Orientation result = Holder.MAP.get(s);
		if (result == null) {
			throw new MartianRobotsException("Orientation not currently supported "+ s);
		}
		return result;
	}
}
