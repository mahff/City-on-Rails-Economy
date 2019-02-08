/**
 * 
 */
package gui;

import java.util.ArrayList;
import java.util.Date;

import game.*;

/**
 * @author Anne-Sophie
 *
 */
public class ConsoleTests {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Création ville / carte
		int length = 5;
		int weekEndMovingRate = 5;
		Date date1 = new Date();
		Date date2 = new Date();
		Town town = new Town(length);
			town.printMap();
		
			//Création d'un quartier 
		District d1 = new Business();
		District d2 = new Resident();
		District d3 = new State();
		District d4 = new Business();
		District d5 = new Resident();
		
		town.setDistrict(0, 0, d1);
		town.setDistrict(1, 2, d2);
		town.setDistrict(2, 3, d3);
		town.setDistrict(3, 3, d4);
		town.setDistrict(4, 3, d5);
		
			town.printMap();
			
		// Instanciation of a Moving-Object
		Moving moving1 = new Moving(weekEndMovingRate, date1, date2);
		
		// Instanciation of stations
		Station station1 = new Station(100, false, 20, moving1);
		Station station2 = new Station(200, false, 21, moving1);
		Station station3 = new Station(300, false, 22, moving1);
		Station station4 = new Station(400, false, 23, moving1);
		Station station5 = new Station(500, false, 24, moving1);
		
		// Instanciation of ArrayList<Station>
		ArrayList<Station> stationsArrayList = new ArrayList<Station>();
		stationsArrayList.add(station1);
		stationsArrayList.add(station2);
		stationsArrayList.add(station3);
		stationsArrayList.add(station4);
		stationsArrayList.add(station5);
		
		// Creation of a line
		Line line1 = new Line(stationsArrayList, weekEndMovingRate, new Date());
		
		
		
		
		
		System.out.println("Pop="+town.getGeneralPopulation()+" Satisf="+town.getGeneralSatisfaction());
	}

}
