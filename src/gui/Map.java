package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.MenuBar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;

import core.VariableRepository;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class Map implements ActionListener {
	ActionListener listener;
	public int size = 5; 
	public EditMenu menu = new EditMenu(); 
	public JButton[][] button = new JButton[size][size];
	public JFrame frame = new JFrame("RailCity");
	Icon business = new ImageIcon("business.jpg");
	Icon resident = new ImageIcon("resident.jpg");
	Icon state = new ImageIcon("state.jpg");
	private BuildingMenuTemp buildingMenu;
	
	public Map(){
		
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    JPanel map = new JPanel(new GridLayout(size, size));
	    map.setLocation(0, 0);
	    map.setSize(400,400);
	    frame.getContentPane().setLayout(null); 
	    frame.getContentPane().setLayout(null);
	    frame.getContentPane().add(map);
	    
	    buildingMenu = new BuildingMenuTemp();
	    buildingMenu.setBounds(461, 108, 252, 211);
	    frame.getContentPane().add(buildingMenu);
	    
	    // Creates the buttons in the array
	    for (int i = 0; i < size; i++) {
	    	for(int j=0; j< size; j++) {
	    		button[i][j] = new JButton(i+","+j);
	            map.add(button[i][j]);
	            button[i][j].setForeground(Color.BLACK);
	            button[i][j].setBackground(Color.WHITE);
	            button[i][j].setBorderPainted(true);
	            //button[i][j].setFocusPainted(false);
	            button[i][j].addActionListener(this);
	    	}
	    }
	    frame.setTitle("RailCity");
	    frame.setSize(800, 600); 
	    frame.setVisible(true); 
	    frame.setJMenuBar(menu.getMenu());
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // If you close the window, the program will terminate
	    frame.setResizable(false);
	}
	
	public void actionPerformed(ActionEvent ae) {
        String action = ae.getActionCommand();
        for(int i=0; i<size; i++) {
        	for(int j=0; j<size;j++) {
        		String data = i+","+j; 
        		if (action.equals(data)) {
        			String[] parts = data.split(",");
        			String part1 = parts[0]; 
        			String part2 = parts[1];
        			
        			String parameter = (String) VariableRepository.getInstance().searchByName("BuildingActionChoice");
        	        updateButton(parameter, Integer.parseInt(part1), Integer.parseInt(part2));
        	        
        			// updateButton("resident", Integer.parseInt(part1), Integer.parseInt(part2)); 
                    // System.out.println(i+"+"+j);
                }
        	}
        }
	}
	
	public void updateButton(String type, int buttonX, int buttonY) {
		System.out.println(type+"\n");
		// String buildingState = "Failed";
		Boolean buildingState = false;
		if(type == "resident") {
			button[buttonX][buttonY].setIcon(resident);
			button[buttonX][buttonY].setEnabled(false);
			buildingState = true;
			// buildingState = "Success.";
			// System.out.println("resident");
		}
		else if(type == "business") {
			button[buttonX][buttonY].setIcon(business);
			button[buttonX][buttonY].setEnabled(false);
			// buildingState = "Success.";
			buildingState = true;
		}
		else if(type == "state") {
			button[buttonX][buttonY].setIcon(state);
			button[buttonX][buttonY].setEnabled(false);
			// buildingState = "Success.";
			buildingState = true;
		} 
		else if (type == "station") {
			System.out.println("station");
		} 
		else if (type == "line") {
			System.out.println("line");
		}
		
		if (buildingState) {
			System.out.println(type + " building state on " + buttonX + " " + buttonY + " ");
			System.out.println("=> " + "Success.");
		} else {
			System.out.println("No building proccess en route.");
			System.out.println("=> " + "Failed.");
			
			System.out.println("Please, select a building before launching a building-site.");
		}
	}
}



