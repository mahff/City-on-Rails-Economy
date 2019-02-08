/**
 * 
 */
package gui;

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
		
		Town town = new Town(length);
			town.printMap();
		
			//Création d'un quartier
		District d1 = new Business();
		District d2 = new Resident();
		town.setDistrict(0, 0, d1);
		town.setDistrict(1, 2, d2);
			town.printMap();
			
		System.out.println("Pop="+town.getGeneralPopulation()+" Satisf="+town.getGeneralSatisfaction());
	}

}
