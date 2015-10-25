package org.wahlzeit.model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class PhotoCoordinateTest {

private Photo photo;
private Photo photo2;
	
	@Before
	public void setUp() throws Exception {
		photo = new Photo();
		photo2 = new Photo();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		//constructor test
		assertNotNull(photo);
		assertNotNull(photo2);
		
		//coordinate constructor test
		photo.location = new Coordinate(50, 150);
		double lat1 = photo.location.getLatitude();
		double lon1 = photo.location.getLongitude();
		assertTrue(lat1 == 50);
		assertTrue(lon1 == 150);
		
		//TODO distance test
		photo2.location = new Coordinate(-40, -160);
		Coordinate test = photo.location.getDistance(photo2.location);
		assertTrue(test.getLatitude() == 90);
		assertTrue(test.getLongitude() == 210);
		
		fail("Not yet implemented");
	}

}
