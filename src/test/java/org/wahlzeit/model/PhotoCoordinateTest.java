/*
 * PhotoCoordinateTest
 * Version 1.0
 * Date 26.10.2015
 * Copyright (c) 2015 by Sabrina Jahn
 */

package org.wahlzeit.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class PhotoCoordinateTest {

	@Test
	public void test() {

		Coordinate location;
		Coordinate location2;
		Coordinate location3;
		// coordinate constructor test
		location = new Coordinate(50, 150);
		double lat1 = location.getLatitude();
		double lon1 = location.getLongitude();
		assertTrue(lat1 == 50);
		assertTrue(lon1 == 150);

		// distance tests
		location2 = new Coordinate(-40, -160);
		Coordinate test = location.getDistance(location2);
		assertTrue(test.getLatitude() == 90);
		assertTrue(test.getLongitude() == -50);

		test = location2.getDistance(location);
		assertTrue(test.getLatitude() == -90);
		assertTrue(test.getLongitude() == 50);

		// Input validation test
		try {
			location3 = new Coordinate(-91, -181);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
