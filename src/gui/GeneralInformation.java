package gui;

import java.awt.Component;
import java.util.Date;

import javax.swing.JLabel;

import game.Town;

public class GeneralInformation {
	private JLabel summary = new JLabel();
	private Town town;
	
	
	public GeneralInformation(Town town) {
		setTown(town);
	}
	
	
	public Component updateGeneralInfo() {
		String content = "<html><center>City Statistics: <br/>";
		
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
		
		return summary; 
	}
	
	
	private void setTown(Town town) {
		this.town = town;
	}

}
