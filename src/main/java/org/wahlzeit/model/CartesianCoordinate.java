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
	
	private static final int EARTH_RADIUS = 6371;
	
	/**
	 * @methodtype constructor
	 */
	public CartesianCoordinate() {
		setX(0.0);
		setY(0.0);
		setZ(0.0);
	}
	
	/**
	 * @methodtype constructor
	 */
	public CartesianCoordinate(double x, double y, double z) {
		setX(x);
		setY(y);
		setZ(z);
	}
	
	
	/**
	 * @MethodType query
	 */	
	public double getDistance(Coordinate coord) {
		coordValidation(coord);
		CartesianCoordinate other = (CartesianCoordinate) coord;
		if(coord instanceof SphericCoordinate) {
			other = ((SphericCoordinate) coord).inCartesian();
		}
		
		double euclidDist = Math.sqrt(Math.pow(this.x - other.x, 2) + Math.pow(this.y - other.y, 2) + Math.pow(this.z - other.z, 2)); 
		double result = 2 * Math.asin(euclidDist / 2 / EARTH_RADIUS);
		return result * EARTH_RADIUS;
	}
	
	
	
	public boolean isEqual(Coordinate other) {
		
		return equals(other);
		
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

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(x);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(y);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(z);
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
		if (!(obj instanceof CartesianCoordinate)) {
			return false;
		}
		CartesianCoordinate other = (CartesianCoordinate) obj;
		if (Double.doubleToLongBits(x) != Double.doubleToLongBits(other.x)) {
			return false;
		}
		if (Double.doubleToLongBits(y) != Double.doubleToLongBits(other.y)) {
			return false;
		}
		if (Double.doubleToLongBits(z) != Double.doubleToLongBits(other.z)) {
			return false;
		}
		return true;
	}

	
	@Override
	public String toString() {
		return "CartesianCoordinate [x=" + x + ", y=" + y + ", z=" + z + "]";
	}

	/**
	 * @methodtype conversion
	 */
	public CartesianCoordinate inCartesian() {
		return this;
	}
	
	/**
	 * @methodtype conversion
	 */	
	protected SphericCoordinate inSpheric(){
		double r = Math.sqrt(this.x * this.x + this.y * this.y + this.z * this.z); 
		double lat = Math.toDegrees((Math.asin(this.z/r)));
		double lon = Math.toDegrees((Math.atan2(this.y, this.x)));
		
		return new SphericCoordinate (lat,lon);
		}

	/**
	 * @return the x
	 */
	public double getX() {
		return x;
	}

	/**
	 * @param x the x to set
	 */
	public void setX(double x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public double getY() {
		return y;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(double y) {
		this.y = y;
	}

	/**
	 * @return the z
	 */
	public double getZ() {
		return z;
	}

	/**
	 * @param z the z to set
	 */
	public void setZ(double z) {
		this.z = z;
	}
		
	}
	
	    


