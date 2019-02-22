package gui;

import java.awt.Color;
import java.awt.Component;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JSplitPane;

import game.District;
import game.Town;


public class ParameterArea {
	static JComboBox<String> combo = new JComboBox<String>();
	static JLabel summary = new JLabel();
	static JButton button = new JButton("Choose");
	static GeneralInformation generalInfo; 
	private static DistrictInformation distInfo;
	
	public ParameterArea(Town town) {
		
		generalInfo = new GeneralInformation(town); 
	}
	public ParameterArea(District district) {
		
		distInfo = new DistrictInformation(district); 
	}
	public static Component summaryParamFrame() {
		
		combo.addItem("Resident");
		combo.addItem("Business");
		combo.addItem("State");
		combo.addItem("Station");
		JSplitPane sumSug = new JSplitPane(JSplitPane.VERTICAL_SPLIT, combo, distInfo.updateGeneralInfo());
		JSplitPane splitMap = new JSplitPane(JSplitPane.VERTICAL_SPLIT,  sumSug, generalInfo.updateGeneralInfo());
		splitMap.setDividerLocation(150);
		sumSug.setDividerLocation(25);

		return splitMap;
	}
	
	public void changeInformation() {
		generalInfo.updateGeneralInfo(); 
	}
	public void changeDistrictInfo() {
		distInfo.updateGeneralInfo();
	}
	
}
