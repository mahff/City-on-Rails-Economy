package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.*;

import game.District;
import game.Town;

public class ParameterArea {
	public static JComboBox<String> districtType;
	public static JPanel districtPanel;
	static JLabel generalInfo; 
	private static JLabel districtInfo;
	
	
	public ParameterArea(Town town) {
		generalInfo = new JLabel();
		
		//Style
		Color purple = new Color(51, 102, 204);
		Font font = new Font("Tahoma", Font.BOLD, 15);
		
		generalInfo.setForeground(purple);
		generalInfo.setFont(font);
		
		changeGeneralInformation(town);
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
		
		splitMap.setEnabled(false);
		linelab.setEnabled(false);
		sumSug.setEnabled(false);
		
		splitMap.setDividerLocation(450);
		linelab.setDividerLocation(260);
		sumSug.setDividerLocation(27);    
		
		
		//Style
		Color darkgrey = new Color(195, 203, 213);
		
		linelab.setBackground(darkgrey);
		splitMap.setBackground(darkgrey);

		return splitMap;
	}
	
	
	/**
	 * Update the general information of the city
	 * @param town
	 */
	public void changeGeneralInformation(Town town) {
		generalInfo.setText(GeneralInformation.updateGeneralInfo(town));
	}
	
	
	/**
	 * Update the district information of the given district
	 * @param district
	 */
	public void changeDistrictInformation(District district) {
		districtInfo.setText(DistrictInformation.updateGeneralInfo(district));
	}

}
