package gui;

import java.awt.*;

import javax.swing.*;


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
		Font font = new Font("Tahoma", Font.PLAIN, 14);
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
	
	public static void addLine() {
		listModel.add(0, "A new line has been created!");
	}
}
