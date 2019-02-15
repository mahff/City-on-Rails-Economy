package gui;

import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JSplitPane;

import game.Town;


public class ParameterArea {
	
	
	static JComboBox<String> combo = new JComboBox<String>();
	static JLabel summary = new JLabel();
	static JButton button = new JButton("Choose");
	static GeneralInformation generalInfo; 
	
	public ParameterArea(Town town) {
		generalInfo = new GeneralInformation(town); 
	}

	public static Component summaryParamFrame() {
		
		combo.addItem("Resident");
		combo.addItem("Business");
		combo.addItem("State");
		summary.setText("Summary");
		JSplitPane sumSug = new JSplitPane(JSplitPane.VERTICAL_SPLIT, combo, summary);

		JSplitPane splitMap = new JSplitPane(JSplitPane.VERTICAL_SPLIT,  sumSug, generalInfo.updateGeneralInfo());
		splitMap.setDividerLocation(150);
		sumSug.setDividerLocation(50);

		return splitMap;
	}
	
	public void changeInformation() {
		generalInfo.updateGeneralInfo(); 
	}
	


}
