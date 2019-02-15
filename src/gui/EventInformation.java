package gui;

import java.awt.Component;

import javax.swing.JLabel;

import game.Town;

public class EventInformation {
	
	
	static JLabel summary = new JLabel();
	
	
	public static Component setEnventInfo() {
		summary.setText("Event information");
		return summary; 
	}


}
