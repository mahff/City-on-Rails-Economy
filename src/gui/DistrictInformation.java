package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JLabel;

import game.District;

public class DistrictInformation {
	private JLabel summary = new JLabel();
	private District district;
	
	public DistrictInformation(District district) {
		setDistrict(district);
	}
	
	
	public Component updateGeneralInfo() {
		String content = "<html><center><u>Current District Statistics:</u><br/>";
		
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
		System.out.println(content);
		
		//Style
		Color cyan = new Color(0, 179, 179);
		Font font = new Font("Tahoma", Font.BOLD, 15);
		summary.setForeground(cyan);
		summary.setFont(font);
		
		return summary; 
	}
	
	
	void setDistrict(District district) {
		this.district = district;
	}

}
