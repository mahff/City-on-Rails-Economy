package gui;

import java.awt.Component;

import javax.swing.JLabel;

public class EventInformation {
	
	static JLabel summary = new JLabel();
	
	
	public static Component setEnventInfo() {
		summary.setText("Event information");
		return summary; 
	}


}
