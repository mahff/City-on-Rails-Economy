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
		String content = "Current District Statistics:\n";
		
		//TODO : appel pour nbLines pour recup les stats (dans District)
		int population = district.getPopulation();
		int satisfaction = district.getSatisfaction();
		int nbLines = 0;
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
		
		content += "Population: "+population+"\n"
				+ "Satisfaction: "+satisfaction+"\n"
				+ "Number of lines (metro): "+nbLines+"\n"
				+ "Presence of station (metro): "+isThereStation+"\n"
				+ "Type: "+type+"\n";

		summary.setText(content);
		
		return summary; 
	}
	
	
	private void setDistrict(District district) {
		this.district = district;
	}

}
