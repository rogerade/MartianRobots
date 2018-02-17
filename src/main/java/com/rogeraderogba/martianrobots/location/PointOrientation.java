package com.rogeraderogba.martianrobots.location;

import com.rogeraderogba.martianrobots.enums.Orientation;

public class PointOrientation {

	private Point point;
	private Orientation orientation;
	
	public PointOrientation(Point point, Orientation orientation) {
		this.point = point;
		this.orientation = orientation;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((orientation == null) ? 0 : orientation.hashCode());
		result = prime * result + ((point == null) ? 0 : point.hashCode());
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
		PointOrientation other = (PointOrientation) obj;
		if (orientation != other.orientation)
			return false;
		if (point == null) {
			if (other.point != null)
				return false;
		} else if (!point.equals(other.point))
			return false;
		return true;
	}

	public Orientation getOrientation() {
		return this.orientation;
	}

	public Point getPoint() {
		return this.point;
	}
	
	@Override
	public String toString() {
		return this.point.getX() + " " + this.point.getY() + " " + this.orientation.getCode();
	}
}
