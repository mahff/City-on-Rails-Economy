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
import gui.BuildingMenuActions;

import java.awt.GridBagLayout;

public class Map implements ActionListener {
	ActionListener listener;
	private EditMenu menu = new EditMenu(); 
    Town town = new Town(6); 
	private int size = town.getLength(); 
	private JButton[][] button = new JButton[size][size];
	private JFrame frame = new JFrame("RailCity");
	InformationPanel infoGene = new InformationPanel(); 
	//private BuildingMenuTemp buildingMenu;
	private BuildingMenuActions buildingMenu2;
	String districtChoice; 
	private String[][] disctrictName = new String[8][8];
	Boolean isSelect = false; 
	public Map(){
		
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    JPanel map = new JPanel(new GridLayout(size, size));
	    map.setLocation(300, 0);
	    map.setSize(400,400);
	    frame.getContentPane().setLayout(null); 
	    frame.getContentPane().setLayout(null);
	    frame.getContentPane().add(map);
	    
	    /*
	    buildingMenu = new BuildingMenuTemp();
	    GridBagLayout gridBagLayout = (GridBagLayout) buildingMenu.getLayout();
	    gridBagLayout.columnWidths = new int[]{89};
	    gridBagLayout.columnWeights = new double[]{0.0};
	    buildingMenu.setBounds(424, 88, 237, 211);
	    frame.getContentPane().add(buildingMenu);
	    */
	    
	    //Import of the new JPanel for the actions of Add new Lines/Stations
	    
	    buildingMenu2 = new BuildingMenuActions();
	    buildingMenu2.setBounds(0, 300, 242, 209);
	    frame.getContentPane().add(buildingMenu2);
	    
	    // Creates the buttons in the array
	    for (int i = 0; i < size; i++) {
	    	for(int j=0; j< size; j++) {
	    		button[i][j] = new JButton(i+","+j);
	            map.add(button[i][j]);
	            button[i][j].setForeground(Color.BLACK);
	            button[i][j].setBackground(Color.WHITE);
	            button[i][j].setBorderPainted(true);
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
		 
		 System.out.println("["+buttonX+"]["+buttonY+"]");
		 
		if(button[buttonX][buttonY].getBackground() != Color.WHITE) {
			System.out.println("["+buttonX+"]["+buttonY+"]");
			infoGene.displayInfo().setBounds(300,300,300,300);
			frame.add(infoGene.displayInfo()); 
		}
				
		else {
			ChoiceDisctrictType type = new ChoiceDisctrictType();
			districtChoice = type.getDistrictChoice(); 
			
			if(districtChoice == "Resident" && (button[buttonX][buttonY].getBackground() != new State().getColor() && button[buttonX][buttonY].getBackground() != new Business().getColor())) {
				button[buttonX][buttonY].setBackground(new Resident().getColor());
				disctrictName[buttonX][buttonY] = "["+buttonX+"]["+buttonY+"]";
			}
			else if(districtChoice == "Business" && button[buttonX][buttonY].getBackground() != new Resident().getColor() && button[buttonX][buttonY].getBackground() != new State().getColor()) {
				button[buttonX][buttonY].setBackground(new Business().getColor());
				disctrictName[buttonX][buttonY] = "["+buttonX+"]["+buttonY+"]";
			}
			else if(districtChoice == "State" && button[buttonX][buttonY].getBackground() != new Resident().getColor() && button[buttonX][buttonY].getBackground() != new Business().getColor()) {
				button[buttonX][buttonY].setBackground(new State().getColor());
				disctrictName[buttonX][buttonY] = "["+buttonX+"]["+buttonY+"]";
			} 
			else if(districtChoice == "Station") {
				if(button[buttonX][buttonY].getBackground() == new Resident().getColor() || button[buttonX][buttonY].getBackground() == new Business().getColor() || button[buttonX][buttonY].getBackground() == new State().getColor()) {
					button[buttonX][buttonY].setForeground(Color.RED); 
				}
			}
		}
	}
}



