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
		//Cr�ation ville / carte
		int length = 5;
		
		Town town = new Town(length);
			town.printMap();
		
			//Cr�ation d'un quartier
		District d1 = new Business();
		town.setDistrict(0, 0, d1);
			town.printMap();
			
			
	}

}
