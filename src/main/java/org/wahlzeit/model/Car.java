/*
 * Car
 * Version 1.0
 * Date 10.01.2016
 * Copyright (c) 2016 by Sabrina Jahn
 */

package org.wahlzeit.model;

public class Car {

	private CarType carType;

	protected enum motorType {
		diesel, gasoline, electric, LPG, unknown, other
	};

	protected enum bodyType {
		cabrio, coupe, limousine, SUV, minibus, combi, unknown, other
	};

	private String chassisNumber; // Fahrgestellnummer
	private motorType motor; // Diesel, Benzin...
	private int enginePower; // PS
	private int doors; // Anzahl Türen
	private bodyType type; // Kombi, Limousine...

	/**
	 * @methodtype constructor
	 */
	public Car(CarType ct) {

		this.carType = ct;

	}

	/**
	 * @methodtype get
	 */
	public String getChassisNumber() {
		return chassisNumber;
	}

	/**
	 * @methodtype set
	 */
	public void setChassisNumber(String chassisNumber) {
		this.chassisNumber = chassisNumber;
	}

	/**
	 * @methodtype get
	 */
	public motorType getMotor() {
		return motor;
	}

	/**
	 * @methodtype set
	 */
	public void setMotor(motorType motor) {
		this.motor = motor;
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
	public void setEnginePower(int enginePower) {
		this.enginePower = enginePower;
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
	public void setDoors(int doors) {
		this.doors = doors;
	}

	/**
	 * @methodtype get
	 */

	public CarType getCarType() {
		return carType;
	}

	/**
	 * @methodtype set
	 */

	public void setCarType(CarType carType) {
		this.carType = carType;
	}

	/**
	 * @methodtype get
	 */

	public bodyType getType() {
		return type;
	}

	/**
	 * @methodtype set
	 */

	public void setType(bodyType type) {
		this.type = type;
	}

}
