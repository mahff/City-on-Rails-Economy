package gui;

import java.awt.Color;
import java.awt.Component;

import javax.swing.*;

import game.District;
import game.Town;


public class ParameterArea {
	static JComboBox<String> combo = new JComboBox<String>();
	static JPanel lines = new JPanel();
	static JButton stationButton = new JButton("Station");
	static JButton lineButton = new JButton("Create Line");
	static GeneralInformation generalInfo; 
	static DistrictInformation distInfo;
	
	
	public ParameterArea(Town town) {
		generalInfo = new GeneralInformation(town); 
	}
	public ParameterArea(){
		distInfo = new DistrictInformation(new District(0,0,Color.WHITE)); 
	}
	public ParameterArea(District district) {
		distInfo = new DistrictInformation(district); 
	}
	
	public DistrictInformation getDistrictInformation() {
		return distInfo;
	}
	
	public static Component summaryParamFrame() {
		combo.addItem("Resident");
		combo.addItem("Business");
		combo.addItem("State");
		combo.addItem("Station");
		lines.add(stationButton);
		lines.add(lineButton);
		
		//Style
		Color blue = new Color(0, 115, 230);
		stationButton.setForeground(blue);
		lineButton.setForeground(blue);
		combo.setForeground(blue);
		
		
		JSplitPane sumSug = new JSplitPane(JSplitPane.VERTICAL_SPLIT, combo, lines);
		JSplitPane linelab = new JSplitPane(JSplitPane.VERTICAL_SPLIT, sumSug, distInfo.updateGeneralInfo());
		JSplitPane splitMap = new JSplitPane(JSplitPane.VERTICAL_SPLIT,  linelab, generalInfo.updateGeneralInfo());	
		splitMap.setEnabled(false);
		linelab.setEnabled(false);
		sumSug.setEnabled(false);
		splitMap.setDividerLocation(250);
		linelab.setDividerLocation(150);
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
