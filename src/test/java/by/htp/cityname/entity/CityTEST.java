package by.htp.cityname.entity;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
//import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)

public class CityTest {
	
	public String name;
	public char firstChar;
	public char lastChar;
	
	public CityTest(String name, char firstChar, char lastChar){
		this.name = name;
		this.firstChar = firstChar;
		this.lastChar = lastChar;
	}
	
	@Parameterized.Parameters
    public static Collection<Object[]> getTestData() {
          return Arrays.asList(new Object[][]{
        {"МИНСК", 'М', 'К'},
        {"СИДНЕЙ", 'С', 'Е'},
        {"КАЗАНЬ", 'К', 'Н'},
    });
 }
    
    City city;
    
	@Before
	public void onlyOnce() {
		city = new City(name);
		
	}

	@Test
	public void tstCity() {
		assertNotNull(city);
	}

	@Test
	public void tstName() {
		assertEquals(name, city.getName());
		
	}
	
	@Test
	public void tstFirstChar() {
		assertEquals(firstChar, city.getFirstChar());
	}
	
	@Test
	public void tstLastChar() {
		assertEquals(lastChar, city.getLastChar());
	}

}
