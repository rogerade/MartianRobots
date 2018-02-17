package com.rogeraderogba.martianrobots.enums;

public enum Orientation {
	NORTH("N"), SOUTH("S"), EAST("E"), WEST("W");
	
	private String code = null;
	
	private Orientation(String s){
		this.code = s;
	}
	
	public String getCode() {
		return this.code;
	}
}
