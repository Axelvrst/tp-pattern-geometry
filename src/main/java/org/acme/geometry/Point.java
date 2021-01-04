package org.acme.geometry;

public class Point {
	
	private Coordinate coordinate;
	
	public Point() {
		
	}
	public Point(Coordinate coordinate) {
		this.coordinate = coordinate;
	}
	public Coordinate getCoordinate() {
		return coordinate;
	}

}
