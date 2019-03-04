package gui;

import java.awt.BorderLayout;
import java.awt.event.*;

import javax.swing.*;

import game.*;


public class MapArea{
	private Town town;
	private static JFrame frame;
	
	private JSplitPane sp, sp2;
	private EditMenu menu;
	private MapButton mapButton;
	public static ParameterArea paramDistrict;
	public static ParameterArea paramCity;
	
	public MapArea(){
		frame = new JFrame();
		town = new Town(11);
		
		menu = new EditMenu();
		mapButton = new MapButton(town);
		paramCity = new ParameterArea(town);
		paramDistrict = new ParameterArea();
		
		sp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, paramDistrict.summaryParamFrame(), mapButton.createMap());
		sp2 = new JSplitPane(JSplitPane.VERTICAL_SPLIT, sp, EventInformation.setEnventInfo());
		
		sp.setDividerLocation(300*4/3);
		sp2.setDividerLocation(650*4/3);
		sp.setEnabled(false); 
		sp2.setEnabled(false);
		
		
		frame.setResizable(false);
		frame.add(sp2, BorderLayout.LINE_START);
		frame.setSize(900*4/3,750*4/3);
		frame.setVisible(true);
		frame.setJMenuBar(menu.getMenu());
		frame.setLocationRelativeTo(null);
	    frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	    frame.setResizable(false);
	    
	    
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				closeFrame(); 
			}
		});
	}
	
	
	public static void closeForEndGame(boolean success) {
		frame.dispose();
        new FinalView(success); 
	}
	
	
	public void closeFrame() {
		int confirmed = JOptionPane.showConfirmDialog(null,"Are you sure you want to exit the program?", "Exit Program?",JOptionPane.YES_NO_OPTION);
	    if (confirmed == JOptionPane.YES_OPTION) {
	    		System.exit(0);
	    }
	}

}
