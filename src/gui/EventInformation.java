package gui;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

import game.Station;


public class EventInformation {
	private static JList<String> list;
	private static DefaultListModel<String> listModel;
	private static JScrollPane scrollPane;
	
	
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

	
	public static void addDistrict(String type) {
		if(type != "null") {
			listModel.add(0, "A new "+ type  +" district has been created!");
		}
	}
	
	public static void addStation() {
		listModel.add(0, "A new station has been created!");
	}
	
	public static void addLine(ArrayList<Station> stations) { //TODO afficher la liste des stations sur lesquelles passe la ligne créée, pour l'affichage
		String stationsList = "";
		
		for(Station station : stations) {
			stationsList += station.toString() + "/";
		}
		
		listModel.add(0, "A new line has been created (" + stationsList + ")!");
	}
}
