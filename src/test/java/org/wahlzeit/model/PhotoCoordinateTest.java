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
		spheric1 = new SphericCoordinate(0, 0);
		spheric2 = new SphericCoordinate(15, 15);
		
		cartesian1 = new CartesianCoordinate(spheric1);
		cartesian2 = new CartesianCoordinate(spheric2);
		cartesian5 = new CartesianCoordinate(15, 20, 25);
		cartesian6 = new CartesianCoordinate(20, 30, 40);
		
		spheric5 = new SphericCoordinate(cartesian5);
		spheric6 = new SphericCoordinate(cartesian6);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testConstructor() {
		spheric3 = new SphericCoordinate(93, 0);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testConstructor2() {
		spheric4 = new SphericCoordinate(0, -184);
	}
	
	/*@Test
	public void testGetDistance() {
		assertEquals(2345.20, spheric1.getDistance(spheric2), DELTA);
		assertEquals(10003.90, spheric1.getDistance(cartesian2), DELTA);
		assertEquals(2345.20, cartesian1.getDistance(spheric2), DELTA);
		assertEquals(2345.20, cartesian1.getDistance(cartesian2), DELTA);
		
	}*/
	
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
		spheric2.getDistance(new SphericCoordinate(0, 0, 5));
	} 

	/*@Test
	public void testIsEqual() {
		assertFalse(spheric1.isEqual(null));
		assertFalse(cartesian1.isEqual(null));
		assertFalse(spheric1.isEqual(spheric2));
		assertFalse(cartesian1.isEqual(cartesian2));
		assertFalse(spheric1.isEqual(cartesian2));
		assertFalse(cartesian1.isEqual(spheric2));
		
		assertTrue(spheric1.isEqual(new SphericCoordinate(spheric1)));
		assertTrue(cartesian2.isEqual(new CartesianCoordinate(cartesian2)));
		
		assertTrue(spheric1.isEqual(cartesian1));
		assertTrue(spheric3.isEqual(cartesian3));
		assertTrue(cartesian1.isEqual(spheric1));
		assertTrue(cartesian3.isEqual(spheric3));
	}*/

}