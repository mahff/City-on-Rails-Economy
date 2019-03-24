package gui;

import game.Town;

public class GeneralInformation {
	
	/**
	 * Return the statistics of the city
	 * @param town
	 * @return content
	 */
	public static String updateGeneralInfo(Town town) {
		String content = "<html>"
				+ "<style> html{ padding-left: 30px; }</style>"
				+ "<center><u>City Statistics:</u></center><br/>";
		
		int generalPopulation = town.getGeneralPopulation();
		int generalSatisfaction = town.getGeneralSatisfaction();
		int generalNbLines = town.getGeneralNumberOfLines();
		int generalNbStations = town.getGeneralNumberOfStation();
		int funds = town.getFunds();
		
		content += "Population: "+generalPopulation+"<br/>"
				+ "General satisfaction: "+generalSatisfaction+"<br/>"
				+ "Number of lines (metro): "+generalNbLines+"<br/>"
				+ "Number of stations (metro): "+generalNbStations+"<br/>"
				+ "Money: "+funds+" MyLius </html>";
		
		return content;
	}
	
}
