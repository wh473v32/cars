/*
 * AbstractCoordinate
 * Version 1.0
 * Date 13.11.2015
 * Copyright (c) 2015 by Sabrina Jahn
 */

package org.wahlzeit.model;

public abstract class AbstractCoordinate implements Coordinate {
	
	/** 
	 * @methodtype query
	 */
	@Override
	public double getDistance(Coordinate coord) {
		coordValidation(coord);
		SphericCoordinate own = ((AbstractCoordinate)this).inSpheric();
		SphericCoordinate other = ((AbstractCoordinate)coord).inSpheric();
		
		double distance = 0;
		final int EARTH_RADIUS = 6371;

		double radiant1 = Math.toRadians(own.getLatitude());
		double radiant2 = Math.toRadians(other.getLatitude());
		double radiantLongitudinalDistance = Math.toRadians(getLongitudinalDistance(own, other));
		
	
		distance = Math.acos(Math.sin(radiant1) * Math.sin(radiant2) + Math.cos(radiant1) * Math.cos(radiant2) * Math.cos(radiantLongitudinalDistance)) * EARTH_RADIUS;
			
		
		return distance;
	}

	/**
	 * @MethodType query
	 */
	protected double getLongitudinalDistance(SphericCoordinate own, SphericCoordinate other) {
		double lo = own.getLongitude() - other.getLongitude();
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
	 * @methodtype booleanQuery
	 */
	@Override
	public boolean isEqual(Coordinate coord) {
		SphericCoordinate own = ((AbstractCoordinate)this).inSpheric();
		SphericCoordinate other = ((AbstractCoordinate) coord).inSpheric();
		
		if (this == coord) {
			return true;
		}
		if (coord == null) {
			return false;
		}
		if (!(coord instanceof Coordinate)) {
			return false;
		}

		if (Double.doubleToLongBits(own.getLatitude()) != Double.doubleToLongBits(other.getLatitude())) {
			return false;
		}
		if (Double.doubleToLongBits(own.getLongitude()) != Double.doubleToLongBits(other.getLongitude())) {
			return false;
		}
		if (Double.doubleToLongBits(own.getRadius()) != Double.doubleToLongBits(other.getRadius())) {
			return false;
		}
		return true;
	}
	
	/**
	 * @methodType assertion
	 */
	private void coordValidation(Coordinate test) {
		String msg = "Your Coordinate has an invalid value!";
		if (test == null) {
			throw new IllegalArgumentException(msg);
		}
	}
	
	/**
	 * @methodtype convertion
	 */
	protected abstract CartesianCoordinate inCartesian();
	
	/**
	 * @methodtype convertion
	 */
	protected abstract SphericCoordinate inSpheric();

}
