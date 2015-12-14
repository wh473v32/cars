/*
 * Coordinate
 * Version 1.0
 * Date 26.10.2015
 * Copyright (c) 2015 by Sabrina Jahn
 */

package org.wahlzeit.model;

public class Location {

	private String location;
	private SphericCoordinate coord;

	
	/**
	 * @methodtype constructor
	 */
	public Location() {
		this.coord = coord.getInstance();
		location = " ";
	}
	/**
	 * @methodtype constructor
	 */
	public Location(String location, SphericCoordinate coord) {
		this.location = location;
		this.coord = coord;
	}

	/**
	 * @methodtype constructor
	 */
	public Location(double latitude, double longitude) {
		this.coord = coord.getInstance(latitude, longitude);
		location = " ";
	}

	/**
	 * @methodtype constructor
	 */
	public Location(double latitude, double longitude, String location) {
		this.coord = coord.getInstance(latitude, longitude);
		this.location = location;
	}

	/**
	 * @methodtype get
	 */
	public String getName() {
		return location;
	}

	/**
	 * @methodtype set
	 */
	public void setName(String location) {
		this.location = location;
	}

	/**
	 * @methodtype get
	 */
	public SphericCoordinate getCoordinate() {
		return coord;
	}

	/**
	 * @methodtype set
	 */
	public void setCoordinate(SphericCoordinate coord) {
		this.coord = coord;
	}

}
	
	

