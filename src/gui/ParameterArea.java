package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.*;

import game.District;
import game.Town;


public class ParameterArea {
	public static JComboBox<String> combo;
	public static JPanel lines;
	public static JButton stationButton;
	public static JButton lineButton;
	public static JButton destroyStation;
	public static JButton destroyLine;
	public static JLabel description;
	private static GeneralInformation generalInfo; 
	private static DistrictInformation distInfo;
	
	
	public ParameterArea(Town town) {
		combo = new JComboBox<String>();
		lines = new JPanel();
		stationButton = new JButton("Station");
		lineButton = new JButton("Line"); 
		destroyStation = new JButton("Destroy Station");
		destroyLine = new JButton("Destroy Line");
		
		generalInfo = new GeneralInformation(town);
	}

	public ParameterArea(){
		combo = new JComboBox<String>();
		lines = new JPanel();
		stationButton = new JButton("Station");
		lineButton = new JButton("Line");
		destroyStation = new JButton("Destroy Station");
		destroyLine = new JButton("Destroy Line");
		
		distInfo = new DistrictInformation(new District(0,0,Color.WHITE)); 
	}
	

	
	public DistrictInformation getDistrictInformation() {
		return distInfo;
	}
	
	
	public static Component summaryParamFrame() {
		combo.addItem("Choose the district type...");
		combo.addItem("Residential");
		combo.addItem("Business");
		combo.addItem("State");
		
		description = new JLabel("Actions on the metro network :");
        lines.setLayout(null);
		lines.add(description); 
		lines.add(stationButton);
		lines.add(lineButton);
		lines.add(destroyStation);
		lines.add(destroyLine);
		
		description.setBounds(85,20,250,25);	//horizontal,vertical
		stationButton.setBounds(60,60,122,25);
		lineButton.setBounds(210,60,122,25);
		destroyStation.setBounds(60,110,122,25);
		destroyLine.setBounds(210,110,122,25);
		
		
		//Style
		Color blue = new Color(0, 115, 230);
		Color darkgrey = new Color(195, 203, 213);
		Color cyan = new Color(0, 179, 179);
		Color gray = new Color(20, 20, 20);
		Font font = new Font("Tahoma", Font.BOLD, 15);
		
		description.setForeground(gray);
		description.setFont(font);
		
		stationButton.setBackground(blue);
		lineButton.setBackground(blue);
		destroyStation.setBackground(blue);
		destroyLine.setBackground(blue);
		
		stationButton.setForeground(Color.WHITE);
		lineButton.setForeground(Color.WHITE);
		destroyStation.setForeground(Color.WHITE);
		destroyLine.setForeground(Color.WHITE);
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
