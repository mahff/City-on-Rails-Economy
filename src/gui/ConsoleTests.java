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
	// private static org.apache.log4j.Logger log = Logger.getLogger(ConsoleTests.class);
	
	// Amaury - Selfmade map print inspired from Anne-Sophie's one. Much clear to me for debugging purpose in a graphic console view.
	public static void testMapPrint(int size, Town townParam) {
		District[][] toTest = townParam.getMap();
		System.out.print("_____________________________\n");
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (toTest[i][j] == null) {
					System.out.print(" | OO");
				} else {
					
					if ( toTest[i][j].getStation() != null ) {
						System.out.print(" | DS");
					} else {
						System.out.print(" | DO");
					}
				}
			}
			System.out.print(" |\n");
		}
		System.out.print("_____________________________\n");
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Cr�ation ville / carte
		int timerSpeed = 1000;
		int length = 5;
		int weekEndMovingRate = 5;
		Date date1 = new Date();
		Date date2 = new Date();
		
		Town town = new Town(6);
			// town.printMap();
			testMapPrint(length, town);
			//Cr�ation d'un quartier 
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
		
		testMapPrint(length, town);
			
		// Instanciation of a Moving-Object
		Moving moving1 = new Moving(weekEndMovingRate, date1, date2);
		
		// Instanciation of stations
		Station station1 = new Station(100, false, 20, moving1);
		Station station2 = new Station(200, false, 21, moving1);
		Station station3 = new Station(300, false, 22, moving1);
		Station station4 = new Station(400, false, 23, moving1);
		Station station5 = new Station(500, false, 24, moving1);
		
		Station station6 = new Station(110, false, 24, moving1);
		Station station7 = new Station(220, false, 24, moving1);
		Station station8 = new Station(330, false, 24, moving1);
		
		// Instanciation of ArrayList<Station>
		ArrayList<Station> stationsArrayList = new ArrayList<Station>();
		stationsArrayList.add(station1);
		d1.setStation(station1);
		stationsArrayList.add(station2);
		d2.setStation(station2);
		stationsArrayList.add(station3);
		d3.setStation(station3);
		stationsArrayList.add(station4);
		d4.setStation(station4);
		stationsArrayList.add(station5);
		d5.setStation(station5);
		
		//Second print of the map to check on the new state of the town
		testMapPrint(length, town);
		// Creation of a line
		Line line1 = new Line(stationsArrayList, weekEndMovingRate, new Date());			
		
		System.out.println(line1.toString());
		
		line1.updateStations(stationsArrayList);
		
		System.out.println("\n==============================================\n");
		System.out.println(line1.toString());
		
		System.out.println(station1.toString());
		System.out.println(station2.toString());
		System.out.println(station8.toString());
		
		System.out.println(town.getGeneralNumberOfStation());
				
		//System.out.println("Pop="+town.getGeneralPopulation()+" Satisf="+town.getGeneralSatisfaction());
		
	}

}
