package com.rogeraderogba.martianrobots.location;

import com.rogeraderogba.martianrobots.MartianRobotsException;

public final class Point {

	private static final int COORDINATE_MAXIMUM_VALUE = 50;
	private final int x;
	private final int y;
	
	public Point(int x, int y) {
		if (x > COORDINATE_MAXIMUM_VALUE || y > COORDINATE_MAXIMUM_VALUE) {
			throw new MartianRobotsException(
					String.format("Coordinate maximum exceeded Max=%s, X=%s, Y=%s", COORDINATE_MAXIMUM_VALUE, x, y));
		}
		if (x < 0 || y < 0) {
			throw new MartianRobotsException("Coordinates should not be less than 0");
		}
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point other = (Point) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
}