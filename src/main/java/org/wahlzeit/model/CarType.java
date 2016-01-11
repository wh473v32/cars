/*
 * Car
 * Version 1.0
 * Date 10.01.2016
 * Copyright (c) 2016 by Sabrina Jahn
 */

package org.wahlzeit.model;


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

	public Car createInstance() {
		return new Car(this);
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
