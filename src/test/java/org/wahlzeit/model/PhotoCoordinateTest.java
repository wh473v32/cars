/*
 * PhotoCoordinateTest
 * Version 1.0
 * Date 26.10.2015
 * Copyright (c) 2015 by Sabrina Jahn
 */

package org.wahlzeit.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PhotoCoordinateTest {
	private SphericCoordinate location;
	private SphericCoordinate location2;

	private final double DELTA = 0.000001;

	@Before
	public void setup() {
		location = new SphericCoordinate(50, 150);
		location2 = new SphericCoordinate(-40, -160);
	}
		

	@Test
	public void testDefaultConstructor() {
		SphericCoordinate test = new SphericCoordinate();
		assertEquals(0.0, test.getLatitude(), 0);
		assertEquals(0.0, test.getLongitude(), 0);
	}

	@Test
	public void testOtherConstructor() {
		assertEquals(50, location.getLatitude(), DELTA);
		assertEquals(150, location.getLongitude(), DELTA);
	}

	@Test
	public void testGetLatitudinalDistance() {
		double latDist = location.getLatitudinalDistance(location2);
		assertEquals(90, latDist, DELTA);

	}
	
	@Test
	public void testGetLongitudinalDistance(){
		double longDist = location.getLongitudinalDistance(location2);
		assertEquals(-50, longDist, DELTA);
		
	}

	// TODO public void testGetDistance()
	
	
	// Input validation test
	@Test (expected = IllegalArgumentException.class)
	public void testLatOutOfBouncehigh() {
		SphericCoordinate location = new SphericCoordinate(91, 0);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testLatOutOfBouncelow() {
		SphericCoordinate location = new SphericCoordinate(-91, 0);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testLongOutOfBouncehigh() {
		SphericCoordinate location = new SphericCoordinate(0, 181);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testLongOutOfBouncelow() {
		SphericCoordinate location = new SphericCoordinate(0, -181);
	}

	
}
