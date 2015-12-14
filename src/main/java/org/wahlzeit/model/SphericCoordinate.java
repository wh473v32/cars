/*
 * SphericCoordinate
 * Version 2.1
 * Date 22.11.2015
 * Copyright (c) 2015 by Sabrina Jahn
 */

package org.wahlzeit.model;

public class SphericCoordinate extends AbstractCoordinate {

	private double latitude;
	private double longitude;
	private double radius;

	private static final int EARTH_RADIUS = 6371;

	/**
	 * @methodtype factory method
	 */
	public static SphericCoordinate getInstance() {
		return getInstance(0, 0, EARTH_RADIUS);
	}

	/**
	 * @methodtype factory method
	 */
	public static SphericCoordinate getInstance(double latitude, double longitude) {
		return getInstance(latitude, longitude, EARTH_RADIUS);
	}

	/**
	 * @methodtype factory method
	 */
	public static SphericCoordinate getInstance(double latitude, double longitude, double radius) {
		SphericCoordinate temp = new SphericCoordinate(latitude, longitude, radius);
		synchronized (instance) {
			if (!instance.containsKey(temp.hashCode())) {
				instance.put(temp.hashCode(), temp);
			}
			temp = (SphericCoordinate) instance.get(temp.hashCode());
		}

		return temp;

	}

	/**
	 * @methodtype factory method
	 */
	public static SphericCoordinate getInstance(Coordinate other) {
		SphericCoordinate temp = new SphericCoordinate(other);
		synchronized (instance) {
			if (!instance.containsKey(temp.hashCode())) {
				instance.put(temp.hashCode(), temp);
			}
			temp = (SphericCoordinate) instance.get(temp.hashCode());
		}

		return temp;

	}

	/**
	 * @MethodType constructor
	 */
	protected SphericCoordinate(double latitude, double longitude, double radius) {

		setLatitude(latitude);
		setLongitude(longitude);
		setRadius(radius);

		assertInvariants();
	}

	/**
	 * @methodtype constructor
	 */
	protected SphericCoordinate(Coordinate other) {
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
	public double getRadius() {
		return this.radius;
	}

	/**
	 * @methodType set
	 */
	public void setRadius(double radius) {
		assertValidRadius(radius);
		this.radius = radius;
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
