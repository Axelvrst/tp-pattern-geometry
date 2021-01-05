package org.acme.geometry;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class LogGeometryVisitorTest {
	
	@Test
	public void testVisitPoint() {
		
		Geometry geometry = new Point(new Coordinate(3.0, 4.0));
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(os);
		LogGeometryVisitor visitor = new LogGeometryVisitor(out);
		geometry.accept(visitor);
		
		String result = os.toString();
		
		Assert.assertEquals("Je suis un point avec x=3.0 et y=4.0", result);

	}
	
	@Test
	public void testVisitLineString() {
		
		List<Point> points = new ArrayList<Point>();
        points.add(new Point(new Coordinate(3.0, 4.0)));
        points.add(new Point(new Coordinate(1.0, 2.0)));
        Geometry geometry = new LineString(points);		ByteArrayOutputStream os = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(os);
		LogGeometryVisitor visitor = new LogGeometryVisitor(out);
		geometry.accept(visitor);
		
		String result = os.toString();
		
		Assert.assertEquals("Je suis une polyligne définie par 2 point(s)", result);

	}
	

}
