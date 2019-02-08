package gui;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import game.Business;
import game.Resident;
import game.State;
import game.Town;

import java.awt.GridBagLayout;

public class Map implements ActionListener {
	ActionListener listener;
	private EditMenu menu = new EditMenu(); 
    Town town = new Town(6); 
	private int size = town.getLength(); 
	private JButton[][] button = new JButton[size][size];
	private JFrame frame = new JFrame("RailCity");
	private BuildingMenuTemp buildingMenu;
	private String[][] disctrictName = new String[8][8];	
	public Map(){
		
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    JPanel map = new JPanel(new GridLayout(size, size));
	    map.setLocation(0, 0);
	    map.setSize(400,400);
	    frame.getContentPane().setLayout(null); 
	    frame.getContentPane().setLayout(null);
	    frame.getContentPane().add(map);
	    
	    buildingMenu = new BuildingMenuTemp();
	    GridBagLayout gridBagLayout = (GridBagLayout) buildingMenu.getLayout();
	    gridBagLayout.columnWidths = new int[]{89};
	    gridBagLayout.columnWeights = new double[]{0.0};
	    buildingMenu.setBounds(424, 88, 237, 211);
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
        			
        	        updateButton(Integer.parseInt(part1), Integer.parseInt(part2));
                }
        	}
        }
	}
	
	public void updateButton(int buttonX, int buttonY) {
		 String[] choices = { "Resident", "Business", "State", "Station"};
		    String districtChoice = (String) JOptionPane.showInputDialog(null, "Choose now...",
		        "The Choice of a Lifetime", JOptionPane.QUESTION_MESSAGE, null,choices, choices[1]);
		    System.out.println(districtChoice);
		if(districtChoice == "Resident" && button[buttonX][buttonY].getBackground() != new State().getColor() && button[buttonX][buttonY].getBackground() != new Business().getColor()) {
			button[buttonX][buttonY].setBackground(new Resident().getColor());
			// button[buttonX][buttonY].setEnabled(false);
			disctrictName[buttonX][buttonY] = "["+buttonX+"]["+buttonY+"]";
			
		}
		else if(districtChoice == "Business" && button[buttonX][buttonY].getBackground() != new Resident().getColor() && button[buttonX][buttonY].getBackground() != new State().getColor()) {
			button[buttonX][buttonY].setBackground(new Business().getColor());
			// button[buttonX][buttonY].setEnabled(false);
			disctrictName[buttonX][buttonY] = "["+buttonX+"]["+buttonY+"]";
		}
		else if(districtChoice == "State" && button[buttonX][buttonY].getBackground() != new Resident().getColor() && button[buttonX][buttonY].getBackground() != new Business().getColor()) {
			button[buttonX][buttonY].setBackground(new State().getColor());
			// button[buttonX][buttonY].setEnabled(false);
			disctrictName[buttonX][buttonY] = "["+buttonX+"]["+buttonY+"]";
		} 
		else if(districtChoice == "Station") {
			if(button[buttonX][buttonY].getBackground() == new Resident().getColor() || button[buttonX][buttonY].getBackground() == new Business().getColor() || button[buttonX][buttonY].getBackground() == new State().getColor()) {
				button[buttonX][buttonY].setForeground(Color.RED);
			}
		}
		System.out.println(disctrictName[buttonX][buttonY] );
	}

}



