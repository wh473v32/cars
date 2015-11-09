/*
 * Coordinate
 * Version 1.0
 * Date 26.10.2015
 * Copyright (c) 2015 by Sabrina Jahn
 */

package org.wahlzeit.model;

public class CarsPhoto extends Photo {
	
	protected enum motorType {diesel, gasoline, electric, LPG, unknown, other};
	protected enum bodyType {cabrio, coupe, limousine, SUV, minibus, combi, unknown, other};
	protected int enginePower;
	protected int doors;
	protected int buildYear;
	protected String brand;
	protected String model;
	protected motorType motor;
	protected bodyType type;
	
	
	public CarsPhoto(){
		super();
		this.brand = "n/a";
		this.model = "n/a";
		this.enginePower = 0;
		this.buildYear = 0;
		this.doors = 0;
		this.type = bodyType.unknown;
		this.motor = motorType.unknown;
		
	}
	
	public CarsPhoto(PhotoId id){
		super(id);
		this.brand = "n/a";
		this.model = "n/a";
		this.enginePower = 0;
		this.buildYear = 0;
		this.doors = 0;
		this.type = bodyType.unknown;
		this.motor = motorType.unknown;
		
	}
	
	public CarsPhoto(PhotoId id, String brand, String model, int enginePower, int buildYear, int doors, bodyType type, motorType motor){
		super(id);
		this.brand = brand;
		this.model = model;
		this.enginePower = enginePower;
		this.buildYear = buildYear;
		this.doors = doors;
		this.type = type;
		this.motor = motor;
	}
	
	
	public void setMotorType(motorType motor){
		this.motor = motor;
	}
	
	public motorType getMotorType(){
		return motor;
	}
	
	
	public void setBodyType(bodyType type){
		this.type = type;
	}
	
	public bodyType getBodyType(){
		return type;
	}
	
	public void setenginePower(int enginePower){
		this.enginePower = enginePower;
	}
	
	public int getEnginePower(){
		return enginePower;
	}
	public void setDoors(int doors){
		this.doors = doors;
	}
	public int getDoors(){
		return doors;
	}
	
	public void setbuildYear(int buildYear){
		this.buildYear = buildYear;
	}
	public int getBuildYear(){
		return buildYear;
	}
	public void setBrand(String brand){
		this.brand = brand;
	}
	public String getBrand(){
		return brand;
	}
	
	public void setModel(String model){
		this.model = model;
	}
	public String getModel(){
		return model;
	}
	
	
	

}
