/*
 * PhotoCoordinateTest
 * Version 2.1
 * Date 26.10.2015
 * Copyright (c) 2015 by Sabrina Jahn
 */

package org.wahlzeit.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PhotoCoordinateTest {
	
	private final double DELTA = 0.1;
	private Coordinate spheric1, spheric2, spheric3, spheric4, spheric5, spheric6;
	private Coordinate cartesian1, cartesian2, cartesian3, cartesian4, cartesian5, cartesian6;

	@Before
	public void setUp() {
		spheric1 = SphericCoordinate.getInstance(0, 0);
		spheric2 = SphericCoordinate.getInstance(15, 15);
		
		cartesian1 = CartesianCoordinate.getInstance(spheric1);
		cartesian2 = CartesianCoordinate.getInstance(spheric2);
		cartesian5 = CartesianCoordinate.getInstance(15, 20, 25);
		cartesian6 = CartesianCoordinate.getInstance(20, 30, 40);
		
		spheric5 = SphericCoordinate.getInstance(cartesian5);
		spheric6 = SphericCoordinate.getInstance(cartesian6);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testConstructor() {
		spheric3 = SphericCoordinate.getInstance(93, 0);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testConstructor2() {
		spheric4 = SphericCoordinate.getInstance(0, -184);
	}
	
	@Test
	public void testGetDistance() {
		assertEquals(2345.20, spheric1.getDistance(spheric2), DELTA);
		assertEquals(10003.90, spheric1.getDistance(cartesian2), DELTA);
		assertEquals(2345.20, cartesian1.getDistance(spheric2), DELTA);
		assertEquals(10003.90, cartesian1.getDistance(cartesian2), DELTA);
		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testGetDistancNull() {
		spheric1.getDistance(null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testGetDistanceNull2() {
		//assert false;
		cartesian1.getDistance(null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testGetDistanceDifferentSpheres() {
		spheric2.getDistance(SphericCoordinate.getInstance(0, 0, 5));
	} 

	@Test
	public void testIsEqual() {
		assertFalse(spheric1.isEqual(null));
		assertFalse(cartesian1.isEqual(null));
		//assertFalse(spheric1.isEqual(spheric2));
		assertFalse(cartesian1.isEqual(cartesian2));
		assertFalse(spheric1.isEqual(cartesian2));
		//assertFalse(cartesian1.isEqual(spheric2));
		
		assertTrue(spheric1.isEqual(SphericCoordinate.getInstance(spheric1)));
		assertTrue(cartesian2.isEqual(CartesianCoordinate.getInstance(cartesian2)));
		
		assertTrue(spheric1.isEqual(cartesian1));
		assertTrue(cartesian1.isEqual(spheric1));
	}

}