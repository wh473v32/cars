/*
 * CartesianCoordinate
 * Version 2.0
 * Date 13.11.2015
 * Copyright (c) 2015 by Sabrina Jahn
 */

package org.wahlzeit.model;

public class CartesianCoordinate extends AbstractCoordinate {

	private double x;
	private double y;
	private double z;

	/**
	 * @methodtype factory method
	 */
	public static CartesianCoordinate getInstance() {
		return getInstance(0, 0, 0);
	}

	/**
	 * @methodtype factory method
	 */
	public static CartesianCoordinate getInstance(double x, double y, double z) {
		CartesianCoordinate temp = new CartesianCoordinate(x, y, z);
		synchronized (instance) {
			if (!instance.containsKey(temp.hashCode())) {
				instance.put(temp.hashCode(), temp);
			}
			temp = (CartesianCoordinate) instance.get(temp.hashCode());
		}

		return temp;

	}

	/**
	 * @methodtype factory method
	 */
	public static CartesianCoordinate getInstance(Coordinate other) {
		CartesianCoordinate temp = new CartesianCoordinate(other);
		synchronized (instance) {
			if (!instance.containsKey(temp.hashCode())) {
				instance.put(temp.hashCode(), temp);
			}
			temp = (CartesianCoordinate) instance.get(temp.hashCode());
		}

		return temp;

	}

	/**
	 * @methodtype constructor
	 */
	protected CartesianCoordinate(double x, double y, double z) {
		assertInvariants();

		setX(x);
		setY(y);
		setZ(z);

		assertInvariants();
	}

	/**
	 * @methodtype constructor
	 */
	protected CartesianCoordinate(Coordinate other) {
		assertValidCoordinate(other);
		assertValidLatitude(other.getLatitude());
		assertValidLongitude(other.getLongitude());
		assertValidRadius(other.getRadius());

		inCartesian(other.getLatitude(), other.getLongitude(), other.getRadius());

		assertInvariants();

	}

	@Override
	public String toString() {
		return "CartesianCoordinate [x=" + x + ", y=" + y + ", z=" + z + "]";
	}

	/**
	 * @methodtype conversion
	 */
	protected SphericCoordinate inSpheric() {
		assertValidX(this.x);
		assertValidY(this.y);
		assertValidZ(this.z);

		if (x == 0 && y == 0 && z == 0)
			return new SphericCoordinate(0, 0, 0);
		double r = Math.sqrt(this.x * this.x + this.y * this.y + this.z * this.z);
		double lat = Math.toDegrees((Math.acos(this.z / r)));
		if (x == 0 && y == 0)
			return new SphericCoordinate(lat, 0, r);
		double lon = Math.toDegrees((Math.acos(this.x / (this.x * this.x + this.y * this.y))));

		return new SphericCoordinate(lat, lon, r);
	}

	/**
	 * @methodtype conversion
	 */
	private void inCartesian(double latitude, double longitude, double radius) {
		assertValidLatitude(latitude);
		assertValidLongitude(longitude);
		assertValidRadius(radius);

		double radLat = Math.toRadians(latitude);
		double radLong = Math.toRadians(longitude);

		x = radius * Math.cos(radLong) * Math.sin(radLat);
		y = radius * Math.sin(radLong) * Math.sin(radLat);
		z = radius * Math.cos(radLat);

		assertInvariants();

	}

	/**
	 * @methodtype get
	 */
	public double getX() {
		return x;
	}

	/**
	 * @methodtype set
	 */
	public void setX(double x) {
		assertValidX(x);
		this.x = x;
	}

	/**
	 * @methodtype get
	 */
	public double getY() {
		return y;
	}

	/**
	 * @methodtype set
	 */
	public void setY(double y) {
		assertValidY(y);
		this.y = y;
	}

	/**
	 * @methodtype get
	 */
	public double getZ() {
		return z;
	}

	/**
	 * @methodtype set
	 */
	public void setZ(double z) {
		assertValidZ(z);
		this.z = z;
	}

	/**
	 * @methodtype get
	 */
	@Override
	public double getRadius() {
		return Math.sqrt(this.x * this.x + this.y * this.y + this.z * this.z);
	}

	/**
	 * @methodtype set
	 */
	@Override
	public void setRadius(double radius) {
		assertValidRadius(radius);
		inCartesian(this.getLatitude(), this.getLongitude(), radius);
		assertInvariants();

	}

	/**
	 * @methodtype get
	 */
	@Override
	public double getLatitude() {
		return this.inSpheric().getLatitude();
	}

	/**
	 * @methodtype set
	 */
	@Override
	public void setLatitude(double latitude) {
		assertValidLatitude(latitude);
		inCartesian(latitude, this.getLongitude(), this.getRadius());
		assertInvariants();

	}

	/**
	 * @methodtype get
	 */
	@Override
	public double getLongitude() {
		return this.inSpheric().getLongitude();
	}

	/**
	 * @methodtype set
	 */
	@Override
	public void setLongitude(double longitude) {
		assertValidLongitude(longitude);
		inCartesian(this.getLatitude(), longitude, this.getRadius());
		assertInvariants();

	}

	/**
	 * @methodtype assertion
	 */
	protected void assertValidX(double x) {
		assert !Double.isNaN(x);
	}

	/**
	 * @methodtype assertion
	 */
	protected void assertValidY(double y) {
		assert !Double.isNaN(y);
	}

	/**
	 * @methodtype assertion
	 */
	protected void assertValidZ(double z) {
		assert !Double.isNaN(z);
	}

	/**
	 * @methodtype assertion
	 */
	protected void assertInvariants() {
		assertValidX(x);
		assertValidY(y);
		assertValidZ(z);
	}

}
