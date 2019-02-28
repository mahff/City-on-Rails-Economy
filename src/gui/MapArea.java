package gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import game.Business;
import game.District;
import game.Resident;
import game.State;
import game.Town;


public class MapArea extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	
	
	private Town town;
	private int size;
	private JButton[][] button;
	
	private String[][] disctrictName;
	private District[][] districts;
	private String districtChoice; 
	
	private Business business;
	private Resident resident;
	private State state;

	
	private DistrictInformation distInfo;
	private GeneralInformation generalInfo;
	
	
	private JFrame frame;
	private JSplitPane sp, sp2;
	private EditMenu menu;
	private JPanel map;
	private JButton stationButton;
	
	private int creatingLine;
	
	private ParameterArea paramArea;
	private ParameterArea paramDist;
	
	
	public MapArea(){
		frame = new JFrame();
		town = new Town(10);
		size = town.getLength();
		
		paramArea = new ParameterArea(town);
		paramDist = new ParameterArea();
		
		disctrictName = new String[8][8];
		districts = new District[size][size];
		new District(0,0,Color.CYAN);
		business = new Business();
		resident = new Resident();
		state = new State();
		
		creatingLine = 0;
		new EventInformation();
		
		map = new JPanel(new GridLayout(size, size));
		menu = new EditMenu(); 
		button = new JButton[size][size];
		stationButton = new JButton("Station");

		
		sp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, ParameterArea.summaryParamFrame(), createMap());
		sp2 = new JSplitPane(JSplitPane.VERTICAL_SPLIT, sp, EventInformation.setEnventInfo());
		
		sp.setDividerLocation(300);
		sp2.setDividerLocation(650);
		sp.setEnabled(false); 
		sp2.setEnabled(false);
		
		
		frame.setResizable(false);
		frame.add(sp2);
		frame.setSize(900,750);
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
	
	
	public Component createMap() {
		// Creates the buttons in the array
	    for (int i = 0; i < size; i++) {
	    	for(int j=0; j< size; j++) {
	    		button[i][j] = new JButton(i+","+j);
	            button[i][j].setForeground(Color.WHITE);
	            button[i][j].setBackground(Color.WHITE);
	            button[i][j].setBorderPainted(true);
	            button[i][j].addActionListener(this);
	            button[i][j].setIcon(new ImageIcon("grass.png"));
	            button[i][j].setSize(64, 64);
	            ParameterArea.lineButton.addActionListener(this);
	            map.add(button[i][j]); 
	    	}
	    }
	    
	    return map; 
	}
	
	
	public void actionPerformed(ActionEvent ae) {
        String action = ae.getActionCommand();
        if(action.equals("Create Line")) {
        	generateLine();
        }
        else if(action.equals("Complete Line Creation")){
        	endLineGeneration();
        }
        else {
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
	}
	
	public void generateLine(){
		JButton lineButton = ParameterArea.lineButton;
		lineButton.setText("Complete Line Creation");
		creatingLine = 1;
	}
	
	
	public void endLineGeneration() {
		JButton lineButton = ParameterArea.lineButton;
		lineButton.setText("Create Line");
		creatingLine = 0;
	}
		
	
	public void updateButton(int buttonX, int buttonY) {
		JComboBox<String> combo = ParameterArea.combo; 
		districtChoice = String.valueOf(combo.getSelectedItem()) ;
		if(creatingLine==0) {
			if(button[buttonX][buttonY].getBackground() != Color.WHITE) {
				distInfo = new DistrictInformation(districts[buttonX][buttonY]); 
				paramDist = new ParameterArea(districts[buttonX][buttonY]);
				paramDist.getDistrictInformation().setDistrict(districts[buttonX][buttonY]);
				System.out.println("["+buttonX+"]["+buttonY+"]");
				distInfo.setDistrict(districts[buttonX][buttonY]); 
				if(districtChoice == "Station") {
					if(button[buttonX][buttonY].getBackground() == new Resident().getColor()) {
						button[buttonX][buttonY].setIcon(new ImageIcon("resident_metro.png"));
						town.payStationConstruction();		
						System.out.println("Localisation : X"+buttonX+" Y"+buttonY+town.getDistrict(buttonX, buttonY));
					}else if(button[buttonX][buttonY].getBackground() == new Business().getColor() ) {
						button[buttonX][buttonY].setIcon(new ImageIcon("business_metro.png"));
						town.payStationConstruction();		
						System.out.println("Localisation : X"+buttonX+" Y"+buttonY+town.getDistrict(buttonX, buttonY));
					}else {
						button[buttonX][buttonY].setIcon(new ImageIcon("state_metro.png"));
						town.payStationConstruction();		
						System.out.println("Localisation : X"+buttonX+" Y"+buttonY+town.getDistrict(buttonX, buttonY));
					}
					
				}
				paramDist.changeDistrictInfo();
			}
					
			else if(districtChoice != "Station"){
				if(districtChoice == "Resident" && (button[buttonX][buttonY].getBackground() != new State().getColor() && button[buttonX][buttonY].getBackground() != new Business().getColor())) {
					districts[buttonX][buttonY] = resident; 
					button[buttonX][buttonY].setBackground(resident.getColor());
					button[buttonX][buttonY].setIcon(new ImageIcon("resident.png"));
					town.setDistrict(buttonX, buttonY, districts[buttonX][buttonY]);
					disctrictName[buttonX][buttonY] = "["+buttonX+"]["+buttonY+"]";
					
				}
				else if(districtChoice == "Business" && button[buttonX][buttonY].getBackground() != new Resident().getColor() && button[buttonX][buttonY].getBackground() != new State().getColor()) {
					districts[buttonX][buttonY] = business; 
					button[buttonX][buttonY].setBackground(business.getColor());
					button[buttonX][buttonY].setIcon(new ImageIcon("business.png"));
					town.setDistrict(buttonX, buttonY, districts[buttonX][buttonY]);
					disctrictName[buttonX][buttonY] = "["+buttonX+"]["+buttonY+"]";
					
				}
				else if(districtChoice == "State" && button[buttonX][buttonY].getBackground() != new Resident().getColor() && button[buttonX][buttonY].getBackground() != new Business().getColor()) {
					districts[buttonX][buttonY] = state;
					button[buttonX][buttonY].setBackground(state.getColor());
					button[buttonX][buttonY].setIcon(new ImageIcon("state.png"));
					town.setDistrict(buttonX, buttonY, districts[buttonX][buttonY]);
					disctrictName[buttonX][buttonY] = "["+buttonX+"]["+buttonY+"]";
					town.payDistrictConstruction();
				} 
				
				//System.out.println("Localisation : X"+buttonX+" Y"+buttonY+town.getDistrict(buttonX, buttonY));
				EventInformation.listModel.add(0,"A new district "+districtChoice +" has been created !");
				generalInfo = new GeneralInformation(town); 
				generalInfo.updateGeneralInfo();
				paramArea.changeInformation(); 
			}
		}
		else {
			//...
		}
	}
	
	
	public void closeFrame() {
		
		int confirmed = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit the program?", "Exit program?", JOptionPane.YES_NO_OPTION );
		if(confirmed == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}

}
