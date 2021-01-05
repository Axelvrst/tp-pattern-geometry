package org.acme.geometry;

import java.util.ArrayList;
import java.util.List;

public class LineString implements Geometry {
	
	private List<Point> points;
	public static final String TYPE = "LineString";
	
	
	public LineString() {
		this.points = new ArrayList<Point>();
	}

	public LineString(List<Point> points) {
		this.points = points;
	}
	
	public int getNumPoints() {
		return this.points.size();
	}
	
	public Point getPointN(int n) {
		return this.points.get(n);
	}

	@Override
	public String getType() {
		return TYPE;
	}
	
	@Override
	public boolean isEmpty() {
		return this.points.isEmpty();
	}
	
	@Override
	public void translate(double dx, double dy) {
		for (Point point : points) {
			point.translate(dx, dy);
		}
	}
	
	@Override
	public LineString clone() {
		List<Point> pts = new ArrayList<>(getNumPoints());
		
		for (Point point : points) {
			pts.add(point.clone());
		}
		
		return new LineString(pts);
	}
	
	
}
