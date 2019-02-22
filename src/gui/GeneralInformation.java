package gui;

import java.awt.*;
import javax.swing.JLabel;

import core.TimerEngine;
import game.Town;

public class GeneralInformation {
	private JLabel summary;
	private Town town;
	
	
	public GeneralInformation(Town town) {
		summary = new JLabel();
		setTown(town);
	}
	
	
	public Component updateGeneralInfo() {
		String content = "<html><center><u>City Statistics:</u></center><br/>";
		
		int generalPopulation = town.getGeneralPopulation();
		int generalSatisfaction = town.getGeneralSatisfaction();
		int generalNbLines = town.getGeneralNumberOfLines();
		int generalNbStations = town.getGeneralNumberOfStation();
		int funds = town.getFunds();
		int testDisplay = TimerEngine.getInstance().getDaysTestValue();	//Test affichage de l'heure dans l'IHM
		// Date date = .TimerEngine();
		
		content += "Population: "+generalPopulation+"<br/>"
				+ "Satisfaction: "+generalSatisfaction+"<br/>"
				+ "Number of lines (metro): "+generalNbLines+"<br/>"
				+ "Number of stations (metro): "+generalNbStations+"<br/>"
				+ "Money: "+funds+" MyLiu<br/>"
				+ "Date: "+testDisplay+"</html>";

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
