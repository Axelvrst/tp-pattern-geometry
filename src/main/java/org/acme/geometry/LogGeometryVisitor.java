package org.acme.geometry;

import java.io.PrintStream;

public class LogGeometryVisitor implements GeometryVisitor {
	
	private PrintStream out;
	
	public LogGeometryVisitor(PrintStream out) {
		this.out = out;
	}

	@Override
	public void visit(Point point) {
		out.print("Je suis un point avec x=" + Double.toString(point.getCoordinate().getX()) + " et y=" + Double.toString(point.getCoordinate().getY()));
	}

	@Override
	public void visit(LineString lineString) {
		out.print("Je suis une polyligne définie par " + String.valueOf(lineString.getNumPoints()) + " point(s)");		
	}

}
