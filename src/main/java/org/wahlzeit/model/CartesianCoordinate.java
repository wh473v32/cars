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
		x = 0.0;
		y = 0.0;
		z = 0.0;
	}
	
	/**
	 * @methodtype constructor
	 */
	public CartesianCoordinate(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	
	/**
	 * @MethodType query
	 */	
	public double getDistance(CartesianCoordinate coord) {
		coordValidation(coord);
		CartesianCoordinate other = coord;
		
		double euclidDist = Math.sqrt(Math.pow(this.x - other.x, 2) + Math.pow(this.y - other.y, 2) + Math.pow(this.z - other.z, 2)); 
		double result = 2 * Math.asin(euclidDist / 2 / EARTH_RADIUS);
		return result * EARTH_RADIUS;
	}
	
	
	
	public boolean isEqual(CartesianCoordinate other) {
		
		return equals(other);
		
	}
	
	/**
	 * @methodType assertion
	 */
	public void coordValidation(CartesianCoordinate test) {
		String msg = "Your Coordinate has an invalid value!";
		if (test == null) {
			throw new IllegalArgumentException(msg);
		}
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
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
	 * @methodtype convertion
	 */
	@Override
	protected CartesianCoordinate inCartesian() {
		return this;
	}
	
	/**
	 * @methodtype convertion
	 */	
	protected SphericCoordinate inSpheric(){
		double r = Math.sqrt(this.x * this.x + this.y * this.y + this.z * this.z); 
		double lat = Math.toDegrees((Math.asin(this.z/r)));
		double lon = Math.toDegrees((Math.atan2(this.y, this.x)));
		
		return new SphericCoordinate (lat,lon);
		}
		
	}
	
	    


