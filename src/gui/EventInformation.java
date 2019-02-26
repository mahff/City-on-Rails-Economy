package gui;

import java.awt.*;

import javax.swing.*;


public class EventInformation {
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
        Color blue = new Color(0, 115, 230);
		Font font = new Font("Tahoma", Font.PLAIN, 14);
		list.setForeground(blue);
		list.setFont(font);
		
        return scrollPane;
	}


}
