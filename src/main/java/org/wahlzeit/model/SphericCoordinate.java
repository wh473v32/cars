/*
 * SphericCoordinate
 * Version 2.0
 * Date 13.11.2015
 * Copyright (c) 2015 by Sabrina Jahn
 */

package org.wahlzeit.model;

public class SphericCoordinate extends AbstractCoordinate{
	
	private double latitude;
	private double longitude;
	private double radius;

	
	private static final int EARTH_RADIUS = 6371;

	
	/**
	 * @MethodType constructor
	 */
	public SphericCoordinate() {
		this(0, 0);
	}
	
	public SphericCoordinate(double latitude, double longitude) {
		this(latitude, longitude, EARTH_RADIUS);
	}

	/**
	 * @MethodType constructor
	 */
	public SphericCoordinate(double latitude, double longitude, double radius) {
		String msg = "Wrong parameters! longitude has interval [-180,180], latitude has interval [-90,90].";
		// Input validation longitude
		if (longitude < -180 || longitude > 180) {
			throw new IllegalArgumentException(msg);
		}
		// Input validation latitude
		if (latitude < -90 || latitude > 90) {
			throw new IllegalArgumentException(msg);
		}

		setLatitude(latitude);
		setLongitude(longitude);
		setRadius(radius);
	}
	
	/**
	 * @MethodType query
	 */
	public double getDistance(Coordinate coord) {

		coordValidation(coord);
		SphericCoordinate other = (SphericCoordinate) coord;
		if(coord instanceof CartesianCoordinate) {
			other = ((CartesianCoordinate) coord).inSpheric();
		}
		
		
		double distance = 0;
		double radiant1 = Math.toRadians(this.latitude);
		double radiant2 = Math.toRadians(other.getLatitude());
		double radiantLongitudinalDistance = Math.toRadians(getLongitudinalDistance(other));

		distance = Math.acos(Math.sin(radiant1) * Math.sin(radiant2) + Math.cos(radiant1) * Math.cos(radiant2) * Math.cos(radiantLongitudinalDistance)) * EARTH_RADIUS;
		
		return distance;
	}

	/**
	 * @MethodType query
	 */
	public double getLatitudinalDistance(SphericCoordinate lat) {
		coordValidation(lat);
		double la = latitude - lat.getLatitude();
		// calculation shortest distance
		if (Math.abs(la) > 90) {
			if (la < 0) {
				la += 180;
			} else {
				la -= 180;
			}
		}
		return la;
	}

	/**
	 * @MethodType query
	 */
	public double getLongitudinalDistance(SphericCoordinate lon) {
		coordValidation(lon);
		double lo = longitude - lon.getLongitude();
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
	 * @methodType get
	 */
	public double getLatitude() {
		return this.latitude;
	}

	/**
	 * @param latitude the latitude to set
	 */
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	/**
	 * @param longitude the longitude to set
	 */
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	/**
	 * @methodType get
	 */
	public double getLongitude() {
		return this.longitude;
	}
	
	/**
	 * @methodType get
	 */
	public double getRadius(){
		return this.radius;
	}
	
	/**
	 * @methodType set
	 */
	
	public void setRadius(double radius){
		String msg = "The value of radius has to be greater than 0!";
		if (radius < 0){
			throw new IllegalArgumentException(msg);
		}
		this.radius = radius;
	}

	/**
	 * @methodType assertion
	 */
	public void coordValidation(Coordinate test) {
		String msg = "Your Coordinate has an invalid value!";
		if (test == null) {
			throw new IllegalArgumentException(msg);
		}
	}
	
	/**
	 * @methodtype conversion
	 */
	protected SphericCoordinate inSpheric() {
		return this;
	}
	
	/**
	 * @methodtype conversion
	 */
	protected CartesianCoordinate inCartesian() {

		double radLat = Math.toRadians(this.latitude);
		double radLong = Math.toRadians(this.longitude);

		double x = this.radius * Math.cos(radLong)
				* Math.sin(radLat);
		double y = this.radius * Math.sin(radLong)
				* Math.sin(radLat);
		double z = this.radius * Math.cos(radLat);

		return new CartesianCoordinate(x, y, z);
	}
	
	
	public boolean isEqual(Coordinate other) {
		
		return equals(other);
		
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(latitude);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(longitude);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(radius);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	/**
	 * @methodtype booleanQuery
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof SphericCoordinate)) {
			return false;
		}
		SphericCoordinate other = (SphericCoordinate) obj;
		if (Double.doubleToLongBits(latitude) != Double.doubleToLongBits(other.latitude)) {
			return false;
		}
		if (Double.doubleToLongBits(longitude) != Double.doubleToLongBits(other.longitude)) {
			return false;
		}
		if (Double.doubleToLongBits(radius) != Double.doubleToLongBits(other.radius)) {
			return false;
		}
		return true;
	}


	@Override
	public String toString() {
		return "SphericCoordinate [latitude=" + latitude + ", longitude=" + longitude + ", radius=" + radius + "]";
	}

	
	
	
}
