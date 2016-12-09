package by.htp.cityname.entity;

import static org.junit.Assert.*;

import org.junit.Test;

public class CityTEST {
	
	@Test
	public void tstCity(){
		assertNotNull(new City("Минск"));
	}

}
