/*
 * Car
 * Version 1.0
 * Date 10.01.2016
 * Copyright (c) 2016 by Sabrina Jahn
 */

package org.wahlzeit.model;

import org.wahlzeit.model.CarsPhoto.bodyType;
import org.wahlzeit.model.CarsPhoto.motorType;

public class CarType {

	private String brand; // Hersteller (Audi)
	private String model; // Modell (A3)
	private String series; // Baureihe (8P)

	/**
	 * @methodtype constructor
	 */
	public CarType(String brand, String model, String series) {

		this.brand = brand;
		this.model = model;
		this.series = series;
	}

	public Car instantiate(String chassisNumber, motorType motor, int enginePower, int doors, bodyType type) {
		return new Car(this, chassisNumber, motor, enginePower, doors, type);
	}

	/**
	 * @methodtype get
	 */
	public String getBrand() {
		return brand;
	}

	/**
	 * @methodtype set
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}

	/**
	 * @methodtype get
	 */
	public String getModel() {
		return model;
	}

	/**
	 * @methodtype set
	 */
	public void setModel(String model) {
		this.model = model;
	}

	/**
	 * @methodtype get
	 */
	public String getSeries() {
		return series;
	}

	/**
	 * @methodtype set
	 */
	public void setSeries(String series) {
		this.series = series;
	}

}
