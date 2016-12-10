package by.htp.cityname.runner;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

import by.htp.cityname.entity.City;
import by.htp.cityname.logic.XMLReader;

public class MenuItems {
	private static HashSet<City> cities = new HashSet<City>();
	private static HashSet<City> usedCities = new HashSet<City>();
	
	public static void menuStart(){
		@SuppressWarnings("unused")
		XMLReader reader = new XMLReader(cities);
		System.out.println("Для выхода введите '0'.");
		System.out.println("введите название города и нажмите enter: ");
		
		boolean exit = false;
		
		try(Scanner userInput = new Scanner(System.in)){
			
		while (!exit) {
			String value = userInput.nextLine();
			value = value.toUpperCase().trim();
			if (value.equals("0")) {
				exit = true;
			} else {
			if (ifCityInBase(value)){
				System.out.println("Такой город есть");
				cityOut(value);
				System.out.println("введите название следующего города и нажмите enter: ");
				continue;
			} else {
				System.out.println("Такого города нет");
				System.out.println("введите название города и нажмите enter: ");
				continue;
			}
			}
		}
		} catch (Exception e) {
			System.out.println("Сломали :( ");
			System.out.println(e.getMessage());
		}
	}
	
	private static boolean ifCityInBase(String value){
		boolean check = cities.contains(new City(value));
		return check;
	}
	
	private static void cityOut(String value){
		
		City cityAdd = new City(value);
		char lastChar = cityAdd.get_chrLastChar();
		usedCities.add(cityAdd);
		
		Iterator<City> iterator = cities.iterator();
		
		while (iterator.hasNext()){
			City city = iterator.next();
			if (lastChar == city.get_chrFirstChar()){
				System.out.println(city.get_strName());
				cities.remove(city);
				usedCities.add(city);
				break;
			}
		}
	}
}
