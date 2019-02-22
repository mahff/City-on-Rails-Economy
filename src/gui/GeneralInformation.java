package gui;

import java.awt.*;
import java.util.Date;
import javax.swing.JLabel;

import game.Town;

public class GeneralInformation {
	private JLabel summary;
	private Town town;
	
	
	public GeneralInformation(Town town) {
		summary = new JLabel();
		setTown(town);
	}
	
	
	public Component updateGeneralInfo() {
		String content = "<html><center><u>City Statistics:</u><br/>";
		
		int generalPopulation = town.getGeneralPopulation();
		int generalSatisfaction = town.getGeneralSatisfaction();
		int generalNbLines = town.getGeneralNumberOfLines();
		int generalNbStations = town.getGeneralNumberOfStation();
		int funds = town.getFunds();
		Date date = town.getTime();
		
		content += "Population: "+generalPopulation+"<br/>"
				+ "Satisfaction: "+generalSatisfaction+"<br/>"
				+ "Number of lines (metro): "+generalNbLines+"<br/>"
				+ "Number of stations (metro): "+generalNbStations+"<br/>"
				+ "Money: "+funds+" MyLiu<br/>"
				+ "Date: "+date+"</center></html>";

		summary.setText(content);
		
		//Style
		Color cyan = new Color(0, 179, 179);
		Font font = new Font("Tahoma", Font.BOLD, 15);
		summary.setForeground(cyan);
		summary.setFont(font);
		
		return summary; 
	}
	
	
	private void setTown(Town town) {
		this.town = town;
	}
}
