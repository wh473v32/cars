package org.wahlzeit.model;

import java.util.HashMap;
import java.util.Map;

import org.wahlzeit.model.CarsPhoto.bodyType;
import org.wahlzeit.model.CarsPhoto.motorType;

public class CarManager {

	private static CarManager instance;

	protected Map<Integer, Car> cars = new HashMap<Integer, Car>();
	protected Map<Integer, CarType> carTypes = new HashMap<Integer, CarType>();

	public static CarManager getInstance() {
		if (instance == null) {
			instance = new CarManager();
		}
		return instance;
	}

	public void setInstance(CarManager manager) {
		if (instance != null) {
			throw new IllegalStateException("CarManager is already initialized!");
		}
		instance = manager;
	}

	public Car getCar(String brand, String model, String series) {
		if (cars.containsKey(carTypeHashCode(brand, model, series))) {
			return cars.get(carTypeHashCode(brand, model, series));
		}
		return null;
	}

	public Car createCar(String chassisNumber, motorType motor, int enginePower, int doors, bodyType type) {
		CarType ct = getCarType(chassisNumber);
		assert (ct != null);
		Car result = ct.instantiate(chassisNumber, motor, enginePower, doors, type);
		cars.put(carHashCode(chassisNumber), result);
		return result;
	}

	public CarType getCarType(String chassisNumber) {
		if (carTypes.containsKey(carHashCode(chassisNumber))) {
			return carTypes.get(carHashCode(chassisNumber));
		}
		return null;
	}

	public CarType createCarType(String chassisNumber, String brand, String model, String series) {
		assert (getCarType(chassisNumber) == null) : "CarType already exists!";
		CarType result = new CarType(brand, model, series);
		carTypes.put(carTypeHashCode(brand, model, series), result);
		return result;
	}

	/**
	 * @methodtype comparison
	 */
	public int carTypeHashCode(String brand, String model, String series) {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((brand == null) ? 0 : brand.hashCode());
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + ((series == null) ? 0 : series.hashCode());
		return result;
	}

	/**
	 * @methodtype comparison
	 */
	public int carHashCode(String chassisNumber) {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((chassisNumber == null) ? 0 : chassisNumber.hashCode());
		return result;
	}

}
