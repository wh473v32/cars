/*
 * Coordinate
 * Version 2.0
 * Date 10.01.2016
 * Copyright (c) 2015-2016 by Sabrina Jahn
 */

package org.wahlzeit.model;

public class CarsPhoto extends Photo {

	protected enum motorType {
		diesel, gasoline, electric, LPG, unknown, other
	};

	protected enum bodyType {
		cabrio, coupe, limousine, SUV, minibus, combi, unknown, other
	};

	protected int enginePower;
	protected int doors;
	protected int buildYear;
	protected String brand;
	protected String model;
	protected motorType motor;
	protected bodyType type;

	protected Car car;

	/**
	 * @methodtype constructor
	 */
	public CarsPhoto() {
		super();
		this.brand = "n/a";
		this.model = "n/a";
		this.enginePower = 0;
		this.buildYear = 0;
		this.doors = 0;
		this.type = bodyType.unknown;
		this.motor = motorType.unknown;

	}

	/**
	 * @methodtype constructor
	 */
	public CarsPhoto(PhotoId id) {
		super(id);
		this.brand = "n/a";
		this.model = "n/a";
		this.enginePower = 0;
		this.buildYear = 0;
		this.doors = 0;
		this.type = bodyType.unknown;
		this.motor = motorType.unknown;

	}

	/**
	 * @methodtype constructor
	 */
	public CarsPhoto(PhotoId id, String brand, String model, int enginePower, int buildYear, int doors, bodyType type,
			motorType motor) {
		super(id);
		this.brand = brand;
		this.model = model;
		this.enginePower = enginePower;
		this.buildYear = buildYear;
		this.doors = doors;
		this.type = type;
		this.motor = motor;
	}

	public void setMotorType(motorType motor) {
		this.motor = motor;
	}

	/**
	 * @methodtype get
	 */
	public motorType getMotorType() {
		return motor;
	}

	/**
	 * @methodtype set
	 */
	public void setBodyType(bodyType type) {
		this.type = type;
	}

	/**
	 * @methodtype get
	 */
	public bodyType getBodyType() {
		return type;
	}

	/**
	 * @methodtype set
	 */
	public void setenginePower(int enginePower) {
		this.enginePower = enginePower;
	}

	/**
	 * @methodtype get
	 */
	public int getEnginePower() {
		return enginePower;
	}

	/**
	 * @methodtype set
	 */
	public void setDoors(int doors) {
		this.doors = doors;
	}

	/**
	 * @methodtype get
	 */
	public int getDoors() {
		return doors;
	}

	/**
	 * @methodtype set
	 */
	public void setbuildYear(int buildYear) {
		this.buildYear = buildYear;
	}

	/**
	 * @methodtype get
	 */
	public int getBuildYear() {
		return buildYear;
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
	public String getBrand() {
		return brand;
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
	public String getModel() {
		return model;
	}
	
	/**
	 * @methodtype set
	 */
	public void setCar(Car car){
		this.car = car;
	}
	
	/**
	 * @methodtype get
	 */
	public Car getCar(){
		return this.car;
	}

}
