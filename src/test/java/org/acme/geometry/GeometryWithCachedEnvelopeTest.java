package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

public class GeometryWithCachedEnvelopeTest{
	
	public static final double EPSILON = 1.0e-15;

	@Test
	public void testGetEnvelope() {
		Geometry g = new Point(new Coordinate(3.0, 3.0));
		g = new GeometryWithCachedEnvelope(g);
		Envelope a = g.getEnvelope();
		Envelope b = g.getEnvelope();
		Assert.assertSame(a, b);
	}
	
	@Test
	public void testGetType() {
		Geometry g = new Point(new Coordinate(3.0, 3.0));
		g = new GeometryWithCachedEnvelope(g);
		Assert.assertEquals("Point", g.getType());
	}
	
	@Test
	public void testIsEmpty() {
		Geometry g = new Point();
		g = new GeometryWithCachedEnvelope(g);
		Assert.assertTrue(g.isEmpty());
	}

	@Test
	public void testTranslate() {
		Geometry g = new Point(new Coordinate(3.0, 3.0));
		g = new GeometryWithCachedEnvelope(g);
		Envelope a = g.getEnvelope();
		g.translate(1.0, 3.0);
		Envelope b = g.getEnvelope();
		Assert.assertNotEquals(a.getXmax(), b.getXmax(), EPSILON);
	}
	
	@Test
	public void testClone() {
		Geometry g = new Point(new Coordinate(3.0, 3.0));
		g = new GeometryWithCachedEnvelope(g);
		Envelope a = g.getEnvelope();
		Geometry copy = g.clone();
		Envelope b = copy.getEnvelope();
		Assert.assertEquals(a.getXmax(), b.getXmax(), EPSILON);
	}
	
	@Test
	public void testAccept() {
		GeometryVisitor builder = new EnvelopeBuilder();
		Geometry g = new Point(new Coordinate(3.0, 3.0));
		g = new GeometryWithCachedEnvelope(g);
		g.accept(builder);
		Assert.assertEquals(3.0, g.getEnvelope().getXmin(), EPSILON);
	}
	
}
