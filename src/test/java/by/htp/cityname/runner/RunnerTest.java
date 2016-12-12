package by.htp.cityname.runner;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import by.htp.cityname.entity.CitySetTest;
import by.htp.cityname.entity.CityTest;
import by.htp.cityname.logic.XMLReaderTest;

@RunWith(value = Suite.class)
@SuiteClasses({
	CityTest.class,
	CitySetTest.class,
	XMLReaderTest.class,
	MenuItemsTest.class,
	MenuOperationsTest.class,
})

public class RunnerTest {

}
