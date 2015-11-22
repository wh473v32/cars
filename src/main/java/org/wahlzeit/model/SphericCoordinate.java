/*
 * SphericCoordinate
 * Version 2.1
 * Date 22.11.2015
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

		setLatitude(latitude);
		setLongitude(longitude);
		setRadius(radius);
		
		assertInvariants();
	}
	
	/**
	 * @methodtype constructor
	 */
	public SphericCoordinate(Coordinate other) {
		assertValidCoordinate(other);
		
		setLatitude(other.getLatitude());
		setLongitude(other.getLongitude());
		setRadius(other.getRadius());
		
		assertInvariants();
	}

	/**
	 * @MethodType query
	 */
	public double getLatitudinalDistance(SphericCoordinate lat) {
		assertValidCoordinate(lat);
	
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
	 * @methodType get
	 */
	public double getLatitude() {
		return this.latitude;
	}

	/**
	 * @methodtype set
	 */
	public void setLatitude(double latitude) {
		assertValidLatitude(latitude);
		this.latitude = latitude;
	}


	/**
	 * @methodType get
	 */
	public double getLongitude() {
		return this.longitude;
	}
	
	/**
	 * @methodtype set
	 */
	public void setLongitude(double longitude) {
		assertValidLongitude(longitude);
		this.longitude = longitude;
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
		assertValidRadius(radius);
		this.radius = radius;
	}

	/**
	 * @methodtype conversion
	 */
	protected SphericCoordinate inSpheric() {
		return this;
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
	 * @methodtype conversion
	 */
	@Override
	public String toString() {
		return "SphericCoordinate [latitude=" + latitude + ", longitude=" + longitude + ", radius=" + radius + "]";
	}

	/**
	 * @methodtype assertion
	 */
	protected void assertInvariants() {
		assertValidLatitude(latitude);
		assertValidLongitude(longitude);
		assertValidRadius(radius);
	}
	
	
}
