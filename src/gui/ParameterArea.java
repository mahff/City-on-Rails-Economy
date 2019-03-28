package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.*;

import core.TimerEngine;
import game.District;
import game.Town;

public class ParameterArea {
	public static JComboBox<String> districtType;
	public static JPanel districtPanel;
	static JLabel generalInfo, time; 
	private static JLabel districtInfo;
	private TimerEngine timer; 
	
	public ParameterArea(Town town) {
		generalInfo = new JLabel();
		time = new JLabel(); 
		//Style
		Color purple = new Color(51, 102, 204);
		Font font = new Font("Tahoma", Font.BOLD, 15);
		timer = new TimerEngine(town); 
		generalInfo.setForeground(purple);
		generalInfo.setFont(font);
		time.setFont(new Font("Tahoma", Font.BOLD, 22));
		time.setForeground(purple);
		changeGeneralInformation(town);
		changeTime(); 
	}

	public ParameterArea(){
		districtInfo = new JLabel();
		
		//Style
		Color purple = new Color(51, 102, 204);
		Font font = new Font("Tahoma", Font.BOLD, 15);
		
		districtInfo.setForeground(purple);
		districtInfo.setFont(font);
		
		
		changeDistrictInformation(new District(0, 0, 0,Color.WHITE));
	}
	
	
	/**
	 * Return the aside of the GUI
	 * @return splitMap
	 */
	public Component summaryParamFrame() {
		districtType = DistrictOptions.getComboBox();
		districtPanel = DistrictOptions.getButtons();
		
		
		JSplitPane sumSug = new JSplitPane(JSplitPane.VERTICAL_SPLIT, districtType, districtPanel);
		JSplitPane linelab = new JSplitPane(JSplitPane.VERTICAL_SPLIT, sumSug, districtInfo);
		JSplitPane splitMap = new JSplitPane(JSplitPane.VERTICAL_SPLIT,  linelab, generalInfo);	
		JSplitPane splitTime = new JSplitPane(JSplitPane.VERTICAL_SPLIT,  splitMap, time);	
		
		
		splitMap.setEnabled(false);
		linelab.setEnabled(false);
		sumSug.setEnabled(false);
		splitTime.setEnabled(false);
		
		sumSug.setDividerLocation(40);
		splitMap.setDividerLocation(425);
		linelab.setDividerLocation(200);
		splitTime.setDividerLocation(735);
		
		
		//Style
		Color darkgrey = new Color(195, 203, 213);
		
		linelab.setBackground(darkgrey);
		splitMap.setBackground(darkgrey);
		splitTime.setBackground(darkgrey);
		return splitTime;
	}
	
	
	/**
	 * Update the general information of the city
	 * @param town
	 */
	public void changeGeneralInformation(Town town) {
		generalInfo.setText(GeneralInformation.updateGeneralInfo(town));
	}
	
	public void changeTime() {
		time.setText(timer.toString());
	}
	
	
	/**
	 * Update the district information of the given district
	 * @param district
	 */
	public void changeDistrictInformation(District district) {
		districtInfo.setText(DistrictInformation.updateGeneralInfo(district));
	}

}
