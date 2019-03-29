package gui;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

import game.Station;
import game.Town;

public class EventInformation {
	private static JList<String> list;
	private static DefaultListModel<String> listModel;
	private static JScrollPane scrollPane;
	
	
	/**
	 * Return the event information
	 * @return scrollPane
	 */
	public static Component setEnventInfo() {
		listModel = new DefaultListModel<String>();
		list = new JList<String>(listModel);
		
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setLayoutOrientation(JList.VERTICAL);
        scrollPane = new JScrollPane(list);
		
        listModel.addElement("Event information");

		//Style
        Color blue = new Color(0, 115, 230);
		Font font = new Font("Tahoma", Font.BOLD, 14);
		list.setForeground(blue);
		list.setFont(font);
		
        return scrollPane;
	}

	
	/**
	 * Add a line of text in the event information when adding a district
	 * @param type
	 */
	public static void addDistrict(String type) {
		if(type != "null") {
			listModel.add(0, "A new "+ type  +" district has been created!");
		}
	}
	
	
	/**
	 * Add a line of text in the event information when adding a station
	 */
	public static void addStation() {
		listModel.add(0, "A new station has been created!");
	}
	
	public static void collectTaxes(Town town){
		listModel.add(0, "We have collected taxes! The municipal treasury holds "+town.getFunds()+" mylius");
	}
	
	
	/**
	 * Add a line of text in the event information when adding a line
	 * @param stations
	 */
	public static void addLine(ArrayList<Station> stations) {
		String stationsList = "";
		
		for(int i=0 ; i<stations.size() ; i++) {
			stationsList += stations.get(i).getName();
			if(i != stations.size()-1) {
				stationsList += " / ";
			}
		}
		
		listModel.add(0, "A new line has been created (" + stationsList + ")!");
	}
	
	
	/**
	 * Add a line of text in the event information when removing a station
	 */
	public static void removeStation() {
		listModel.add(0, "A station has been destroyed!");
	}
	
	
	public static void notEnoughMoney() {
		listModel.add(0, "YOU DON'T HAVE ENOUGH MONEY TO DO THAT!");
	}
	
	public static void notEnoughStationsSelected() {
		listModel.add(0, "Warning : A line has to be build with at least 2 stations !");
	}

	public static void lineAlreadyExist() {
		listModel.add(0, "An identical line already exists in town !");
	}
}
