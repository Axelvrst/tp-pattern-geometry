package org.acme.geometry;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class WktVisitorTest {
	
	@Test
	public void testVisitEmptyPoint() {
		WktVisitor visitor = new WktVisitor();
		Geometry geometry = new Point();
		geometry.accept(visitor);
		Assert.assertEquals("POINT EMPTY", visitor.getResult());
	}
	
	@Test
	public void testVisitPoint() {
		WktVisitor visitor = new WktVisitor();
		Geometry geometry = new Point(new Coordinate(3.0,4.0));
		geometry.accept(visitor);
		Assert.assertEquals("POINT(3.0 4.0)", visitor.getResult());
	}
	
	@Test
	public void testVisitLineStringEmpty() {
		WktVisitor visitor = new WktVisitor();
        Geometry geometry = new LineString();
        geometry.accept(visitor);
		Assert.assertEquals("LINESTRING EMPTY", visitor.getResult());
	}
	
	@Test
	public void testWriteLineStringGeom() {
		List<Point> points = new ArrayList<Point>();
        points.add(new Point(new Coordinate(3.0, 4.0)));
        points.add(new Point(new Coordinate(1.0, 2.0)));
        WktVisitor visitor = new WktVisitor();
        Geometry geometry = new LineString(points);
        geometry.accept(visitor);
		Assert.assertEquals("LINESTRING(3.0 4.0,1.0 2.0)", visitor.getResult());
	}

}
