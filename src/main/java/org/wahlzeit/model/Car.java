/*
 * Car
 * Version 1.0
 * Date 10.01.2016
 * Copyright (c) 2016 by Sabrina Jahn
 */

package org.wahlzeit.model;

import org.wahlzeit.model.CarsPhoto.bodyType;
import org.wahlzeit.model.CarsPhoto.motorType;

public class Car {

	private CarType carType;

	private String chassisNumber; // Fahrgestellnummer
	private motorType motor; // Diesel, Benzin...
	private int enginePower; // PS
	private int doors; // Anzahl Türen
	private bodyType type; // Kombi, Limousine...

	/**
	 * @methodtype constructor
	 */
	public Car(CarType ct, String chassisNumber, motorType motor, int enginePower, int doors, bodyType type) {

		this.carType = ct;
		this.chassisNumber = chassisNumber;
		this.motor = motor;
		this.enginePower = enginePower;
		this.doors = doors;
		this.type = type;

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

	public CarType getType() {
		return carType;
	}

	/**
	 * @methodtype set
	 */

	public void setType(CarType carType) {
		this.carType = carType;
	}

}
