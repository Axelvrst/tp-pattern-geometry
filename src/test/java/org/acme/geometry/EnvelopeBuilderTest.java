package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

public class EnvelopeBuilderTest {
	
	 public static final double EPSILON = 1.0e-15;

    @Test
    public void testEmptyEnveloppe() {
        EnvelopeBuilder builder = new EnvelopeBuilder();
        Envelope result = builder.build();
        Assert.assertTrue(result.isEmpty());
    }

    @Test
    public void testBuilder() {
        EnvelopeBuilder builder = new EnvelopeBuilder();
        builder.insert(new Coordinate(3.0, 4.0));
        builder.insert(new Coordinate(2.0, 1.0));
        builder.insert(new Coordinate(8.0, 6.0));
        Envelope result = builder.build();

        Assert.assertEquals(2.0, result.getXmin(), EPSILON);
        Assert.assertEquals(1.0, result.getYmin(), EPSILON);
        Assert.assertEquals(8.0, result.getXmax(), EPSILON);
        Assert.assertEquals(6.0, result.getYmax(), EPSILON);
    }

}
