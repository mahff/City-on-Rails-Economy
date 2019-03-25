package gui;

import java.awt.*;

import game.District;

public class DistrictInformation {
	
	/**
	 * Return the statistics of the given district
	 * @param district
	 * @return content
	 */
	public static String updateGeneralInfo(District district) {
		String content = "<html>"
				+ "<style> html{ padding-left: 60px; }</style>"
				+ "<center><u>Current District Statistics:</u></center><br/>";
		// String stationName = district.getStation().get;
		int population = district.getPopulation();
		int satisfaction = district.getSatisfaction();
		int nbLines = district.getNumberOfLines();
		boolean isThereStation = false;
		
		Color color = district.getColor();
		String type = "none";
		
			if(district.getStation() != null) {
				isThereStation = true;
			}
			
			if(color == Color.GREEN) {
				type = "Resident"; 
			}
			else if(color == Color.BLUE) {
				type = "Business";
			}
			else if(color == Color.YELLOW) {
				type = "State";
			}
		
		content += "Population: "+population+"<br/>"
				+ "District satisfaction: "+satisfaction+"<br/>"
				+ "Number of lines (metro): "+nbLines+"<br/>"
				+ "Presence of station (metro): "+isThereStation+"<br/>"
				+ "Type: "+type+"</html>";
		
		return content;
	}
	
}
