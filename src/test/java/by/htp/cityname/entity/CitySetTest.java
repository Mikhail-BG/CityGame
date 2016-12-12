package by.htp.cityname.entity;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.BeforeClass;
import org.junit.AfterClass;
import org.junit.Test;

public class CitySetTest {

	public static CitySet cities;
	public static String cityName1 = "минск";
	public static City city1;
	public static City city2;
	public static int NumOfCities = 1;

	@BeforeClass
	public static void OnlyOnce() {
		cities = new CitySet();
		city1 = new City(cityName1);
		cities.addCity(city1);
		city2 = null;
	}
	
	@Test
	public void cityAdd() {
		assertTrue("city1 added",cities.addCity(city1));
		assertFalse("city2 not added",cities.addCity(city2));
	}
	
	@Test
	public void cityNumberOfElements() {
		assertEquals("Number of cities", NumOfCities, cities.numberOfElements());
	}
	
	@Test
	public void cityRemove() {
		assertTrue("city1 removed", cities.removeCity(city1));
	}
	
	@Test
	public void cityContains(){
		assertTrue("city1 in cities", cities.containsCity(new City(cityName1)));
	}
	
	@Test
	public void iteratorCity(){
		Iterator<City> iterator = cities.iterator();
		int index = 0;
		while (iterator.hasNext()){
			index++;
			if (index == 20) {break;}
		}
		assertEquals("TROUBLE WITH ITERATOR", cities.numberOfElements(),index);
	}
	
	@AfterClass
	public static void removeObjcs() {
		city1 = null;
		cities = null;
	}
}
