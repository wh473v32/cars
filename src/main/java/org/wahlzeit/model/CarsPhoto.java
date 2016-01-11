/*
 * Coordinate
 * Version 2.0
 * Date 10.01.2016
 * Copyright (c) 2015-2016 by Sabrina Jahn
 */

package org.wahlzeit.model;

public class CarsPhoto extends Photo {


	protected Car car;

	/**
	 * @methodtype constructor
	 */
	public CarsPhoto() {
		super();

	}

	/**
	 * @methodtype constructor
	 */
	public CarsPhoto(PhotoId id) {
		super(id);
	}

	/**
	 * @methodtype get
	 */
	public Car getCar() {
		return car;
	}

	/**
	 * @methodtype set
	 */
	public void setCar(Car car) {
		this.car = car;
	}



}
