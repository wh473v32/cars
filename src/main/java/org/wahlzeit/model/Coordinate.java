package org.wahlzeit.model;

import java.security.InvalidParameterException;

public class Coordinate {

	private double latitude;
	private double longitude;

	public Coordinate(double latitude, double longitude) {
		String msg = "Wrong parameters! longitude has interval [-180,180], latitude has interval [-90,90].";
		if (longitude < -180 || longitude > 180) {
			// ERROR
			throw new InvalidParameterException(msg);

		}

		if (latitude < -90 || latitude > 90) {
			// ERROR
			throw new InvalidParameterException(msg);
		}

		this.latitude = latitude;
		this.longitude = longitude;
	}

	public Coordinate getDistance(Coordinate coord) {
		Coordinate ret = new Coordinate(getLatitudinalDistance(coord), getLongitudinalDistance(coord));
		return ret;
	}

	public double getLatitudinalDistance(Coordinate lat) {
		double la = 0;
		if (latitude < 0 || lat.getLatitude() < 0) {
			la = Math.min(lat.getLatitude() - latitude, latitude - lat.getLatitude());
		} else {
			la = lat.getLatitude() - latitude;
		}
		return la;
	}

	public double getLongitudinalDistance(Coordinate lon) {
		double lo = 0;
		if (longitude < 0 || lon.getLatitude() < 0) {
			lo = Math.min(lon.getLatitude() - longitude, longitude - lon.getLatitude());
		} else {
			lo = lon.getLatitude() - longitude;
		}
		return lo;
	}

	public double getLatitude() {
		return this.latitude;
	}

	public double getLongitude() {
		return this.longitude;
	}

}
