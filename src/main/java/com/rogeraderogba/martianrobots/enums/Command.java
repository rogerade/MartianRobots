package com.rogeraderogba.martianrobots.enums;

public enum Command {
	LEFT("L"), RIGHT("R"), FORWARD("F");
	
	private String code = null;
	
	Command(String code){
		this.code = code;
	}
	
	public String getCode() {
		return this.code;
	}
}
