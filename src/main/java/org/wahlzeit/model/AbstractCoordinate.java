/*
 * AbstractCoordinate
 * Version 2.0
 * Date 22.11.2015
 * Copyright (c) 2015 by Sabrina Jahn
 */

package org.wahlzeit.model;

import java.util.HashMap;

public abstract class AbstractCoordinate implements Coordinate {
	
	protected static final double DELTA = 0.1;
	protected static final int MAX_SIZE = 1024;
	protected static HashMap<Integer, AbstractCoordinate> instance = new HashMap<>(MAX_SIZE);
	
	/** 
	 * @methodtype query
	 */
	@Override
	public double getDistance(Coordinate other) {
		assertValidCoordinate(other);
		assertSameRadius(other.getRadius());
			
		double distance = 0;
		final int EARTH_RADIUS = 6371;

		double radiant1 = Math.toRadians(this.getLatitude());
		double radiant2 = Math.toRadians(other.getLatitude());
		double radiantLongitudinalDistance = Math.toRadians(getLongitudinalDistance(other));
		
	
		distance = Math.acos(Math.sin(radiant1) * Math.sin(radiant2) + Math.cos(radiant1) * Math.cos(radiant2) * Math.cos(radiantLongitudinalDistance)) * EARTH_RADIUS;
			
		
		return distance;
	}

	/**
	 * @MethodType query
	 */
	protected double getLongitudinalDistance(Coordinate other) {
		
		double lo = this.getLongitude() - other.getLongitude();
		// calculation shortest distance
		if (Math.abs(lo) > 180) {
			if (lo < 0) {
				lo += 360;
			} else {
				lo -= 360;
			}
		}
		return lo;
	}
	
	/**
	 * @methodtype comparison
	 */
	@Override
	public boolean isEqual(Coordinate other){
				
		if (this == other) {
			return true;
		}
		if (other == null) {
			return false;
		}
		if (!(other instanceof Coordinate)) {
			return false;
		}

		if (Double.doubleToLongBits(this.getLatitude()) - Double.doubleToLongBits(other.getLatitude()) > DELTA) {
			return false;
		}
		if (Double.doubleToLongBits(this.getLongitude()) - Double.doubleToLongBits(other.getLongitude()) > DELTA) {
			return false;
		}
		if (Double.doubleToLongBits(this.getRadius()) - Double.doubleToLongBits(other.getRadius()) > DELTA) {
			return false;
		}
		return true;
	}
	
	/**
	 * @methodtype comparison
	 */
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(this.getLatitude());
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(this.getLongitude());
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(this.getRadius());
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	
	/**
	 * @methodType assertion
	 */
	protected void assertValidCoordinate(Coordinate test) {
		String msg = "Your Coordinate has an invalid value!";
		if (test == null) {
			throw new IllegalArgumentException(msg);
		}
	}
	
	/**
	 * @methodtype assertion
	 */
	protected void assertSameRadius(double otherRadius) {
		if (Math.abs(this.getRadius() - otherRadius) >= DELTA)
			throw new IllegalArgumentException("Cannot calculate distance, points have different radiants and are therefore located on different spheres!");
	}

	/**
	 * @methodtype assertion
	 */
	protected void assertValidLatitude(double latitude) {
		assert !Double.isNaN(latitude);
		if (latitude < -90 || latitude >= 90)
			throw new IllegalArgumentException("Wrong parameters! Latitude needs interval of [-90,90].");
	}
	
	/**
	 * @methodtype assertion
	 */
	protected void assertValidLongitude(double longitude) {
		assert !Double.isNaN(longitude);
		if (longitude < -180 || longitude >= 180)
			throw new IllegalArgumentException("Wrong parameters! Latitude needs interval of [-180,180].");
	}
	
	/**
	 * @methodtype assertion
	 */
	protected void assertValidRadius(double radius) {
		assert !Double.isNaN(radius);
		if (radius < 0)
			throw new IllegalArgumentException("The value of radius has to be greater than 0!");
	}
	
	/**
	 * @methodtype conversion
	 */
	protected abstract SphericCoordinate inSpheric();

}
