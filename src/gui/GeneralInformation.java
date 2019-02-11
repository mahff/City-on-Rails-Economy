package gui;

import java.awt.Component;

import javax.swing.JLabel;

public class GeneralInformation {
	
	
	static JLabel summary = new JLabel();
	
	
	public static Component setGeneralInfo() {
		summary.setText("General information");
		return summary; 
	}

}
