package gui;

import java.awt.Color;
import java.awt.Component;

import javax.swing.*;

import game.District;
import game.Town;


public class ParameterArea {
	public static JComboBox<String> combo;
	private static JPanel lines;
	private static JButton stationButton;
	public static JButton lineButton;
	private static GeneralInformation generalInfo; 
	private static DistrictInformation distInfo;
	
	
	public ParameterArea(Town town) {
		combo = new JComboBox<String>();
		lines = new JPanel();
		stationButton = new JButton("Station");
		lineButton = new JButton("Create Line");
		
		generalInfo = new GeneralInformation(town); 
	}

	public ParameterArea(){
		combo = new JComboBox<String>();
		lines = new JPanel();
		stationButton = new JButton("Station");
		lineButton = new JButton("Create Line");
		
		distInfo = new DistrictInformation(new District(0,0,Color.WHITE)); 
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
		Color darkgrey = new Color(195, 203, 213);
		
		stationButton.setBackground(blue);
		lineButton.setBackground(blue);
		
		stationButton.setForeground(Color.WHITE);
		lineButton.setForeground(Color.WHITE);
		combo.setForeground(blue);
		
		
		JSplitPane sumSug = new JSplitPane(JSplitPane.VERTICAL_SPLIT, combo, lines);
		JSplitPane linelab = new JSplitPane(JSplitPane.VERTICAL_SPLIT, sumSug, distInfo.updateGeneralInfo());
		JSplitPane splitMap = new JSplitPane(JSplitPane.VERTICAL_SPLIT,  linelab, generalInfo.updateGeneralInfo());	
		splitMap.setEnabled(false);
		linelab.setEnabled(false);
		sumSug.setEnabled(false);
		splitMap.setDividerLocation(450);
		linelab.setDividerLocation(260);
		sumSug.setDividerLocation(27);    
		
		lines.setBackground(darkgrey);
		linelab.setBackground(darkgrey);
		splitMap.setBackground(darkgrey);

		return splitMap;
	}
	
	
	public void changeInformation() {
		generalInfo.updateGeneralInfo(); 
	}
	
	
	public void changeDistrictInfo() {
		distInfo.updateGeneralInfo();
	}
	
}
