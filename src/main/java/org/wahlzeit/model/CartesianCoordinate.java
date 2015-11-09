package org.wahlzeit.model;

public class CartesianCoordinate implements Coordinate {
	
	private double x;
	private double y;
	private double z;
	
	private static final int EARTH_RADIUS = 6371;
	
	/**
	 * @methodtype constructor
	 */
	public CartesianCoordinate() {
		x = 0.0;
		y = 0.0;
		z = 0.0;
	}
	
	/**
	 * @methodtype constructor
	 */
	public CartesianCoordinate(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	
	/**
	 * @MethodType query
	 */	
	public double getDistance(CartesianCoordinate coord) {
		//TODO Input validation
		
		CartesianCoordinate other = coord;
		
		double euclidDist = Math.sqrt(Math.pow(this.x - other.x, 2) + Math.pow(this.y - other.y, 2) + Math.pow(this.z - other.z, 2)); 
		double result = 2 * Math.asin(euclidDist / 2 / EARTH_RADIUS);
		return result * EARTH_RADIUS;
	}
	
	public boolean isEqual(Coordinate other) {
		
		//TODO
		
		return false;
		
	}
	
	/**
	 * @methodType assertion
	 */
	public void coordValidation(CartesianCoordinate test) {
		String msg = "Your Coordinate has an invalid value!";
		if (test == null) {
			throw new IllegalArgumentException(msg);
		}
	}

}
