/**
 * 
 */
package gui;

import game.Town;

/**
 * @author Anne-Sophie
 *
 */
public class ConsoleTests {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int length = 5;
		
		Town town = new Town(length);
		town.printMap();
	}

}
