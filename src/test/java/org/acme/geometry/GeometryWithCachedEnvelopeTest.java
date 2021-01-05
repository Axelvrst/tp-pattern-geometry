package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

public class GeometryWithCachedEnvelopeTest {
	
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
	
}
