package gui;

import java.awt.*;
import java.awt.event.*;
import java.util.Date;

import javax.swing.*;

import game.Business;
import game.District;
import game.Moving;
import game.Resident;
import game.State;
import game.Station;
import game.Town;


public class MapArea extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	
	
	private Town town;
	private int size;
	private JButton[][] button;
	
	private String[][] disctrictName;
	private District[][] districts;
	private String districtChoice; 
	/*
	private Business business;
	private Resident resident;
	private State state;
*/
	
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
	
	JComboBox<String> combo;
	
	
	public MapArea(){
		frame = new JFrame();
		town = new Town(11);
		size = town.getLength();
		
		paramArea = new ParameterArea(town);
		paramDist = new ParameterArea();
		
		disctrictName = new String[size][size];
		districts = new District[size][size];
		new District(0,0,Color.CYAN);
		/*business = new Business();
		resident = new Resident();
		state = new State();
		*/
		creatingLine = 0;
		
		map = new JPanel(new GridLayout(size, size));
		menu = new EditMenu(); 
		button = new JButton[size][size];
		stationButton = new JButton("Station");
		combo = ParameterArea.combo; 
		
		sp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, ParameterArea.summaryParamFrame(), createMap());
		sp2 = new JSplitPane(JSplitPane.VERTICAL_SPLIT, sp, EventInformation.setEnventInfo());
		
		sp.setDividerLocation(300*4/3);
		sp2.setDividerLocation(650*4/3);
		sp.setEnabled(false); 
		sp2.setEnabled(false);
		
		
		frame.setResizable(false);
		frame.add(sp2);
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
	            button[i][j].setSize(64*4/3, 64*4/3);
	            ParameterArea.stationButton.addActionListener(this);
	            map.add(button[i][j]); 
	    	}
	    }
	    
	    return map; 
	}
	
	
	public void actionPerformed(ActionEvent ae) {
        String action = ae.getActionCommand();
        if(action.equals("Station")) {
        	generateLine();
        }
        else if(action.equals("Complete Station Creation")){
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
		JButton stationButton = ParameterArea.stationButton;
		stationButton.setText("Complete Station Creation");
		creatingLine = 1;
		combo.setEnabled(false);
	}
	
	
	public void endLineGeneration() {
		JButton stationButton = ParameterArea.stationButton;
		stationButton.setText("Station");
		creatingLine = 0;
		combo.setEnabled(true);
	}
		
	
	public void updateButton(int buttonX, int buttonY) {
		System.out.println("["+buttonX+"]["+buttonY+"]");
		boolean isBuild = false;
		
		if(creatingLine==0) {
			districtChoice = String.valueOf(combo.getSelectedItem());
			
			District currentDistrict = town.getDistrict(buttonX, buttonY);
			Color currentDistrictColor;
			if(currentDistrict == null) {
				currentDistrictColor = Color.WHITE;
			}
			else {
				currentDistrictColor = currentDistrict.getColor();
			}
			
			
			if(currentDistrictColor != Color.WHITE) {
				distInfo = new DistrictInformation(districts[buttonX][buttonY]); 
				paramDist.getDistrictInformation().setDistrict(districts[buttonX][buttonY]);

				distInfo.setDistrict(districts[buttonX][buttonY]); 
				paramDist.changeDistrictInfo();
			}
					
			else if(districtChoice == "Resident" && (currentDistrictColor != State.stateColor && currentDistrictColor != Business.businessColor)) {
				districts[buttonX][buttonY] = new Resident(); 
				button[buttonX][buttonY].setBackground(Resident.residentColor);
				button[buttonX][buttonY].setIcon(new ImageIcon("resident.png"));
				town.setDistrict(buttonX, buttonY, districts[buttonX][buttonY]);
				disctrictName[buttonX][buttonY] = "["+buttonX+"]["+buttonY+"]";
				
				isBuild = true;
			}
			else if(districtChoice == "Business" && currentDistrictColor != Resident.residentColor && currentDistrictColor != State.stateColor) {
				districts[buttonX][buttonY] = new Business(); 
				button[buttonX][buttonY].setBackground(Business.businessColor);
				button[buttonX][buttonY].setIcon(new ImageIcon("business.png"));
				town.setDistrict(buttonX, buttonY, districts[buttonX][buttonY]);
				disctrictName[buttonX][buttonY] = "["+buttonX+"]["+buttonY+"]";
				
				isBuild = true;
			}
			else if(districtChoice == "State" && currentDistrictColor != Resident.residentColor && currentDistrictColor != Business.businessColor) {
				districts[buttonX][buttonY] = new State();
				button[buttonX][buttonY].setBackground(State.stateColor);
				button[buttonX][buttonY].setIcon(new ImageIcon("state.png"));
				town.setDistrict(buttonX, buttonY, districts[buttonX][buttonY]);
				disctrictName[buttonX][buttonY] = "["+buttonX+"]["+buttonY+"]";
				town.payDistrictConstruction();
				
				isBuild = true;
			} 
			
			//System.out.println("Localisation : X"+buttonX+" Y"+buttonY+town.getDistrict(buttonX, buttonY));
			if(isBuild) {
				EventInformation.addDistrict(districtChoice);
			}

			generalInfo = new GeneralInformation(town); 
			generalInfo.updateGeneralInfo();
			paramArea.changeInformation(); 
		
		}
		else {//...
			JPanel stationButton = ParameterArea.lines; 
			
			Station currentStationCreation = new Station(30, false, 0, new Moving(0, new Date(), new Date()));
			
			District currentDistrict = town.getDistrict(buttonX, buttonY);
			if(currentDistrict != null) {
				Color currentDistrictColor = currentDistrict.getColor();
				Station currentDistrictStation = currentDistrict.getStation();
			
				
				if(currentDistrictColor == Resident.residentColor && currentDistrictStation == null) {
					button[buttonX][buttonY].setIcon(new ImageIcon("resident_metro.png"));
					
					isBuild = true;
				}
				else if(currentDistrictColor == Business.businessColor && currentDistrictStation == null) {
					button[buttonX][buttonY].setIcon(new ImageIcon("business_metro.png"));
					
					isBuild = true;
				}
				else if(currentDistrictColor == State.stateColor && currentDistrictStation == null){
					button[buttonX][buttonY].setIcon(new ImageIcon("state_metro.png"));	
					
					isBuild = true;
				}
				
				if(isBuild) {
					town.payStationConstruction();
					town.getDistrict(buttonX, buttonY).setStation(currentStationCreation);
					EventInformation.addStation();
					
					System.out.println("Localisation : X"+buttonX+" Y"+buttonY+currentDistrict);
				}
			}
		}
	}
	
	
	public void closeFrame() {
		int confirmed = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit the program?", "Exit program?", JOptionPane.YES_NO_OPTION );
		if(confirmed == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}

}
