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
		String content = "City Statistics:\n";
		
		//TODO : appel aux fonctions pour recup les stats (dans TOWN)
		int generalPopulation = town.getGeneralPopulation();
		int generalSatisfaction = town.getGeneralSatisfaction();
		int generalNbLines = 0;
		int generalNbStations = 0;
		int funds = town.getFunds();
		Date date = town.getTime();
		
		content += "Population: "+generalPopulation+"\n"
				+ "Satisfaction: "+generalSatisfaction+"\n"
				+ "Number of lines (metro): "+generalNbLines+"\n"
				+ "Number of stations (metro): "+generalNbStations+"\n"
				+ "Money: "+funds+" MyLiu\n"
				+ "Date: "+date+"\n";

		summary.setText(content);
		
		return summary; 
	}
	
	
	private void setTown(Town town) {
		this.town = town;
	}

}
