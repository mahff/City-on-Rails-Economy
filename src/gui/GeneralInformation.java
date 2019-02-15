package gui;

import java.awt.Component;

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
		
		int generalPopulation = town.getGeneralPopulation();
		int generalSatisfaction = town.getGeneralSatisfaction();
		
		//TODO : appel aux fonctions pour recup les stats (dans TOWN)
		content += "Population: "+generalPopulation+"\n"
				+ "Satisfaction: "+generalSatisfaction+"\n"
				+ "Number of lines (metro): "+"0"+"\n"
				+ "Number of stations (metro): "+"0"+"\n"
				+ "Money: "+"0"+" MyLiu\n"
				+ "Date: "+"0"+"\n";

		summary.setText(content);
		
		return summary; 
	}
	
	
	private void setTown(Town town) {
		this.town = town;
	}

}
