package org.wahlzeit.model;

public class SphericCoordinate implements Coordinate{
	
	private double latitude;
	private double longitude;
	private double radius;

	
	private static final int EARTH_RADIUS = 6371;

	
	/**
	 * @MethodType constructor
	 */
	public SphericCoordinate() {
		this(0, 0);
	}
	
	public SphericCoordinate(double latitude, double longitude) {
		this(latitude, longitude, EARTH_RADIUS);
	}

	/**
	 * @MethodType constructor
	 */
	public SphericCoordinate(double latitude, double longitude, double radius) {
		String msg = "Wrong parameters! longitude has interval [-180,180], latitude has interval [-90,90].";
		// Input validation longitude
		if (longitude < -180 || longitude > 180) {
			throw new IllegalArgumentException(msg);
		}
		// Input validation latitude
		if (latitude < -90 || latitude > 90) {
			throw new IllegalArgumentException(msg);
		}

		this.latitude = latitude;
		this.longitude = longitude;
		this.radius = radius;
	}
	
	/**
	 * @MethodType query
	 */
	public double getDistance(Coordinate coord) {
		
		
		
		coordValidation(coord);
		
		double distance = 0;
		double radiant1 = Math.toRadians(this.latitude);
		double radiant2 = Math.toRadians(coord.getLatitude());
		double radiantLongitudinalDistance = Math.toRadians(getLongitudinalDistance(coord));

		distance = Math.acos(Math.sin(radiant1) * Math.sin(radiant2) + Math.cos(radiant1) * Math.cos(radiant2) * Math.cos(radiantLongitudinalDistance)) * EARTH_RADIUS;
		
		return distance;
	}

	/**
	 * @MethodType query
	 */
	public double getLatitudinalDistance(SphericCoordinate lat) {
		coordValidation(lat);
		double la = latitude - lat.getLatitude();
		// calculation shortest distance
		if (Math.abs(la) > 90) {
			if (la < 0) {
				la += 180;
			} else {
				la -= 180;
			}
		}
		return la;
	}

	/**
	 * @MethodType query
	 */
	public double getLongitudinalDistance(SphericCoordinate lon) {
		coordValidation(lon);
		double lo = longitude - lon.getLongitude();
		// calculation shortest distance
		if (Math.abs(lo) > 180) {
			if (lo < 0) {
				lo += 360;
			} else {
				lo -= 360;
			}
		}
		return lo;
	}

	/**
	 * @methodType get
	 */
	public double getLatitude() {
		return this.latitude;
	}

	/**
	 * @methodType get
	 */
	public double getLongitude() {
		return this.longitude;
	}
	
	/**
	 * @methodType get
	 */
	public double getRadius(){
		return this.radius;
	}
	
	public void setRadius(double radius){
		String msg = "The value of radius has to be greater than 0!";
		if (radius < 0){
			throw new IllegalArgumentException(msg);
		}
		this.radius = radius;
	}

	/**
	 * @methodType assertion
	 */
	public void coordValidation(SphericCoordinate test) {
		String msg = "Your Coordinate has an invalid value!";
		if (test == null) {
			throw new IllegalArgumentException(msg);
		}
	}
	
	//TODO 
	public boolean isEqual(Coordinate other) {
		return false;
		
	}
}
