package by.htp.cityname.runner;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import by.htp.cityname.entity.City;
import by.htp.cityname.entity.CitySet;

public class MenuOperationsTest {
	
	public static CitySet cities;
	public static CitySet usedCities;
	public static String value;
	public static City city;
	
	@BeforeClass
	public static void onlyOnce(){
		cities = new CitySet();
		usedCities = new CitySet();
	}
	
	@Before
	public void everyTime(){
		value = Configurator.getKey("city1Name");
		city = new City(value);
		cities.addCity(city);
		cities.addCity(new City(Configurator.getKey("city3Name")));
	}

	@Test
	public void firstRunAddCityToUsedCities() {
		System.out.println("---");
		value = "норильск";
		MenuOperations.processCity(cities, usedCities, value);
		assertTrue("City removed from 'cities'", cities.containsCity(city));
		assertTrue("City added to 'usedCities', AI proposes other city", usedCities.containsCity(city));
	}
	
	@Test
	public void runDeleteCityInCities() {
		System.out.println("---");
		System.out.println("test2");
		MenuOperations.processCity(cities, usedCities, value);
		assertFalse("City removed from 'cities', you won!", cities.containsCity(city));
	}
}
