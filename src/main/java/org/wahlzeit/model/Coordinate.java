/*
 * Coordinate
 * Version 2.0
 * Date 22.11.2015
 * Copyright (c) 2015 by Sabrina Jahn
 */

package org.wahlzeit.model;

public interface Coordinate {
	
	/**
	 * @methodtype query
	 */
	public double getDistance(Coordinate coord);
	
	/**
	 * @methodtype comparison
	 */
	public boolean isEqual(Coordinate coord);
	
	/**
	 * @methodtype get
	 */
	public abstract double getRadius();
	
	/**
	 * @methodtype set
	 */
	public abstract void setRadius(double radius);
	
	/**
	 * @methodtype get
	 */
	public abstract double getLatitude();
	
	/**
	 * @methodtype set
	 */
	public abstract void setLatitude(double latitude);
	
	/**
	 * @methodtype get
	 */
	public abstract double getLongitude();
	
	/**
	 * @methodtype set
	 */
	public abstract void setLongitude(double longitude);


}
