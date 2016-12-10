package by.htp.cityname.runner;

import java.util.Scanner;

import by.htp.cityname.entity.CitySet;
import by.htp.cityname.logic.XMLReader;

public class MenuItems {
	private static CitySet cities = new CitySet();
	private static CitySet usedCities = new CitySet();
	
	public static void menuStart(){
		@SuppressWarnings("unused")
		XMLReader reader = new XMLReader(cities);
		System.out.println("Для выхода введите '0'.");
		System.out.print("Введите название города и нажмите enter: ");
		
		boolean exit = false;
		
		try(Scanner userInput = new Scanner(System.in)){
			
		while (!exit) {
			String value = userInput.nextLine();
			value = value.toUpperCase().trim();
			if (value.equals("0")) {
				exit = true;
			} else {
				MenuOperations.processCity(cities, usedCities, value);
				continue;
			}
		}
		} catch (Exception e) {
			System.out.println("Сломали :( ");
			System.out.println(e.getMessage());
		}
	}
}
