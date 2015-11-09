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
	
	/*TODO public double getDistance(Coordinate other) {
		CartesianCoordinate otherCoord;
		if(other instanceof CartesianCoordinate){
			otherCoord = (CartesianCoordinate)other;
		} else {
			otherCoord = CartesianCoordinate.asCartesianCoordinate(other);
		}
		double euclidDist = Math.sqrt(Math.pow(this.x - otherCoord.x, 2)
				+ Math.pow(this.y - otherCoord.y, 2) 
				+ Math.pow(this.z - otherCoord.z, 2)); 
		double omega = 2 * Math.asin(euclidDist / 2 / EARTH_RADIUS);
		return omega * EARTH_RADIUS;
	}
	
	public boolean isEqual(Coordinate other) {
		if(other instanceof CartesianCoordinate){
			return equals(other);
		} else {
			CartesianCoordinate otherCoord = 
					CartesianCoordinate.asCartesianCoordinate(other);
			return equals(otherCoord);
		}
	}*/
	
	/**
	 * @methodType assertion
	 */
	public void coordValidation(SphericCoordinate test) {
		String msg = "Your Coordinate has an invalid value!";
		if (test == null) {
			throw new IllegalArgumentException(msg);
		}
	}

}
