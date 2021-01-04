package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

public class PointTest {
	
	public static final double EPSILON = 1.0e-15;
	
	
	@Test
	public void testDefaultConstructor(){
		// TODO
		Point p = new Point();
		Assert.assertEquals(true, p.isEmpty());
	}
	
	@Test
	public void testConstructorXY(){
		// TODO
		Point p = new Point(new Coordinate(3.0, 4.0));
		Assert.assertEquals(3.0, p.getCoordinate().getX(), EPSILON);
		Assert.assertEquals(4.0, p.getCoordinate().getY(), EPSILON);
	}
	
	@Test
	public void testGetType(){
		// TODO
		Point p = new Point();
		Assert.assertEquals("Point", p.getType());
	}
	
	@Test
	public void testTranslate(){
		// TODO
		Point p = new Point(new Coordinate(3.0, 4.0));
		p.translate(1.0, 2.0);
		Assert.assertEquals(4.0, p.getCoordinate().getX(), EPSILON);
		Assert.assertEquals(6.0, p.getCoordinate().getY(), EPSILON);
	}
	
	@Test
	public void testClone(){
		// TODO
		Point p = new Point(new Coordinate(3.0, 4.0));
		Geometry copy = p.clone();
		copy.translate(1.0, 1.0);
		
		Assert.assertEquals(3.0, p.getCoordinate().getX(), EPSILON);
		Assert.assertEquals(4.0, p.getCoordinate().getY(), EPSILON);
	}

}
