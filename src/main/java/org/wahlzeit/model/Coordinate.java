/*
 * Coordinate
 * Version 1.0
 * Date 26.10.2015
 * Copyright (c) 2015 by Sabrina Jahn
 */

package org.wahlzeit.model;

import java.security.InvalidParameterException;

public class Coordinate {

	private double latitude;
	private double longitude;

	public Coordinate(double latitude, double longitude) {
		String msg = "Wrong parameters! longitude has interval [-180,180], latitude has interval [-90,90].";
		// Input validation longitude
		if (longitude < -180 || longitude > 180) {
			throw new InvalidParameterException(msg);
		}
		// Input validation latitude
		if (latitude < -90 || latitude > 90) {
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
		double la = latitude - lat.getLatitude();
		//calculation shortest distance
		if (Math.abs(la) > 90) {
			if (la < 0) {
				la += 180;
			} else {
				la -= 180;
			}
		}
		return la;
	}

	public double getLongitudinalDistance(Coordinate lon) {
		double lo = longitude - lon.getLongitude();
		//calculation shortest distance
		if (Math.abs(lo) > 180) {
			if (lo < 0) {
				lo += 360;
			} else {
				lo -= 360;
			}
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
