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
		
		content += "Population: "+generalPopulation+"\n"
				+ "Satisfaction: "+generalSatisfaction+"\n";

		summary.setText(content);
		
		return summary; 
	}
	
	
	private void setTown(Town town) {
		this.town = town;
	}
	
	private Town getTown() {
		return this.town;
	}

}
