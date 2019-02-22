package gui;

import java.awt.*;

import javax.swing.*;


public class EventInformation { //TODO : MapArea.java L:158 > EventInformation.listModel.add(0, "A new district "+districtChoice +" has been created !");
	static JList<String> list;
	static DefaultListModel<String> listModel;
	static JScrollPane scrollPane;
	
	public static Component setEnventInfo() {
		listModel = new DefaultListModel<String>();
		list = new JList<String>(listModel);
		
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setLayoutOrientation(JList.VERTICAL);
        scrollPane = new JScrollPane(list);
		
        listModel.addElement("Even information");
	
        
		//Style
		Color cyan = new Color(0, 179, 179);
		Font font = new Font("Tahoma", Font.PLAIN, 14);
		list.setForeground(cyan);
		list.setFont(font);
		
        return scrollPane;
	}


}
