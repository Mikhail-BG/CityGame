package by.htp.cityname.runner;

import java.util.Iterator;

import by.htp.cityname.entity.City;
import by.htp.cityname.entity.CitySet;

public class MenuOperations {

	private static City _objEmulCity;

	public static void processCity(CitySet cities, CitySet usedCities, String value) {

		if (_objEmulCity != null) {
			correctInput(cities, usedCities, value);
		} else {
			correctCity(cities, usedCities, value);
		}
	}

	private static void correctCity(CitySet cities, CitySet usedCities, String value) {
		if (ifCityInBase(cities, value)) {
			cityExists(cities, usedCities, value);
		} else {
			cityNonExists(value);
		}
	}

	private static void cityExists(CitySet cities, CitySet usedCities, String value) {
		System.out.println("Введеный город '" + value + "' есть");
		_objEmulCity = cityOut(cities, usedCities, value);
		System.out.println("Город: " + _objEmulCity.getName());
		outMessage(_objEmulCity);
	}

	private static void cityNonExists(String value) {
		System.out.println("Такого города '" + value + "' нет.");

		if (_objEmulCity != null) {
			outMessage(_objEmulCity);
		} else {
			System.out.print("Введите название города и нажмите enter: ");
		}
	}

	private static void correctInput(CitySet cities, CitySet usedCities, String value) {
		if (nextCityCorrect(_objEmulCity, value)) {
			if (!cityWasBefore(usedCities, value)) {
				correctCity(cities, usedCities, value);
			} else {
				System.out.println("Город '" + value + "' уже был.");
				outMessage(_objEmulCity);
			}
		} else {
			System.out.println("Название города должно начинаться на '" + _objEmulCity.getLastChar() + "'");
			outMessage(_objEmulCity);
		}
	}

	private static City cityOut(CitySet cities, CitySet usedCities, String value) {
		City cityAdd = new City(value);
		char lastChar = cityAdd.getLastChar();
		usedCities.addCity(cityAdd);
		Iterator<City> iterator = cities.iterator();

		while (iterator.hasNext()) {
			City city = iterator.next();
			if (lastChar == city.getFirstChar()) {
				cities.removeCity(city);
				usedCities.addCity(city);
				return city;
			}
		}
		return null;
	}

	private static boolean ifCityInBase(CitySet cities, String value) {
		boolean check = cities.containsCity(new City(value));
		return check;
	}

	private static boolean nextCityCorrect(City city, String value) {
		if (value.toCharArray()[0] != city.getLastChar()) {
			return false;
		}
		return true;
	}

	private static boolean cityWasBefore(CitySet usedCities, String value) {
		City cityChk = new City(value);
		Iterator<City> iterator = usedCities.iterator();
		while (iterator.hasNext()) {
			City city = iterator.next();
			if (city.getName().equals(cityChk.getName())) {
				return true;
			}
		}
		return false;
	}

	private static void outMessage(City _objEmulCity) {
		System.out.print("Введите название следующего города на букуву '" + _objEmulCity.getLastChar()
				+ "' и нажмите enter: ");
	}
}
