package by.htp.cityname.runner;

import org.junit.BeforeClass;
import org.junit.Test;
import static org.mockito.Mockito.*;

import by.htp.cityname.entity.CitySet;

public class MenuItemsTest {
	public static CitySet cities; 
	public static String value;
	
	
	@BeforeClass
	public static void OnlyOnce(){
		cities = mock(CitySet.class);
		value = Configurator.getKey("city1Name");
	}
	
	@Test(expected = Exception.class)
	public void citiesNull() {
		MenuOperations.processCity(null, cities, value);
	}

	@Test(expected = Exception.class)
	public void valueNull() {
		MenuOperations.processCity(cities, cities, null);
	}
}
