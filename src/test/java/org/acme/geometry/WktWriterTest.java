package org.acme.geometry;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

public class WktWriterTest {
	
	@Test
	public void testWriteEmptyPointGeom() {
		Geometry g = new Point();
		WktWriter writer = new WktWriter();
		Assert.assertEquals("POINT EMPTY", writer.write(g));
	}
	
	@Test
	public void testWritePointGeom() {
		Geometry g = new Point(new Coordinate(3.0,4.0));
		WktWriter writer = new WktWriter();
		Assert.assertEquals("POINT(3.0 4.0)", writer.write(g));
	}
	
	@Test
	public void testWriteLineStringEmptyGeom() {
        Geometry g = new LineString();
		WktWriter writer = new WktWriter();
		
		Assert.assertEquals("LINESTRING EMPTY", writer.write(g));
	}
	
	@Test
	public void testWriteLineStringGeom() {
		List<Point> points = new ArrayList<Point>();
        points.add(new Point(new Coordinate(3.0, 4.0)));
        points.add(new Point(new Coordinate(1.0, 2.0)));
        Geometry g = new LineString(points);
		WktWriter writer = new WktWriter();
		
		Assert.assertEquals("LINESTRING(3.0 4.0,1.0 2.0)", writer.write(g));
	}
	
}
