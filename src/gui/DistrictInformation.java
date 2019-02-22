package gui;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;

import game.District;

public class DistrictInformation {
	private JLabel summary = new JLabel();
	private District district;
	
	public DistrictInformation(District district) {
		setDistrict(district);
	}
	
	
	public Component updateGeneralInfo() {
		String content = "<html><center>Current District Statistics: <br/>";
		
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
				+ "Satisfaction: "+satisfaction+"<br/>"
				+ "Number of lines (metro): "+nbLines+"<br/>"
				+ "Presence of station (metro): "+isThereStation+"<br/>"
				+ "Type: "+type+"</center></html>";

		summary.setText(content);
		
		return summary; 
	}
	
	
	void setDistrict(District district) {
		this.district = district;
	}

}
