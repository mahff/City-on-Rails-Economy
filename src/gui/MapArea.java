package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.Timer;

import core.VariableRepository;
import game.Business;
import game.District;
import game.Resident;
import game.State;
import game.Town;


public class MapArea extends JFrame implements ActionListener {
	private int creatingLine;
	private String[][] disctrictName = new String[8][8]; 
	private Town town = new Town(6);
	Business business = new Business();
	Resident resident = new Resident();
	State state = new State();
	DistrictInformation distInfo; 
	private EditMenu menu = new EditMenu(); 
	String districtChoice; 
	String geneInfo; 
	EventInformation eventInfo = new EventInformation();
	GeneralInformation generalInfo; 
	private District district = new District(0,0,Color.CYAN);
	private int size = town.getLength(); 
	ParameterArea paramArea = new ParameterArea(town);
	ParameterArea paramDist = new ParameterArea();
	private District[][] districts = new District[size][size];
	JPanel map = new JPanel(new GridLayout(size, size));
	private  JButton[][] button = new JButton[size][size];
	
	public MapArea(){
		creatingLine = 0;
		JSplitPane sp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, paramArea.summaryParamFrame(), createMap());
		JSplitPane sp2 = new JSplitPane(JSplitPane.VERTICAL_SPLIT, sp, EventInformation.setEnventInfo());
		sp.setDividerLocation(300);
		sp2.setDividerLocation(490);
		sp.setEnabled(false); 
		sp2.setEnabled(false);
		JFrame frame = new JFrame();
		frame.setResizable(false);
		frame.add(sp2);
		frame.setSize(800,600);
		frame.setVisible(true);
		frame.setJMenuBar(menu.getMenu());
	    frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); // If you close the window, the program will terminate
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
	            button[i][j].setForeground(Color.BLACK);
	            button[i][j].setBackground(Color.WHITE);
	            button[i][j].setBorderPainted(true);
	            button[i][j].addActionListener(this);
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
		System.out.println("YOLO");
		JButton lineButton = ParameterArea.lineButton;
		if(creatingLine==0) {
			lineButton.setText("Complete Line Creation");
			creatingLine = 1;
		}
		else {
			lineButton.setText("Create Line");
			creatingLine = 0;
		}
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
				district = districts[buttonX][buttonY]; 
				distInfo.setDistrict(districts[buttonX][buttonY]); 
				if(districtChoice == "Station") {
					if(button[buttonX][buttonY].getBackground() == new Resident().getColor() || button[buttonX][buttonY].getBackground() == new Business().getColor() || button[buttonX][buttonY].getBackground() == new State().getColor()) {
						button[buttonX][buttonY].setForeground(Color.RED); 
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
					town.setDistrict(buttonX, buttonY, districts[buttonX][buttonY]);
					disctrictName[buttonX][buttonY] = "["+buttonX+"]["+buttonY+"]";
					
				}
				else if(districtChoice == "Business" && button[buttonX][buttonY].getBackground() != new Resident().getColor() && button[buttonX][buttonY].getBackground() != new State().getColor()) {
					districts[buttonX][buttonY] = business; 
					button[buttonX][buttonY].setBackground(business.getColor());
					town.setDistrict(buttonX, buttonY, districts[buttonX][buttonY]);
					disctrictName[buttonX][buttonY] = "["+buttonX+"]["+buttonY+"]";
					
				}
				else if(districtChoice == "State" && button[buttonX][buttonY].getBackground() != new Resident().getColor() && button[buttonX][buttonY].getBackground() != new Business().getColor()) {
					districts[buttonX][buttonY] = state;
					button[buttonX][buttonY].setBackground(state.getColor());
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
	
	JButton stationButton = new JButton("Station");
	
	public void closeFrame() {
		
		int confirmed = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit the program?", "Exit program?", JOptionPane.YES_NO_OPTION );
		if(confirmed == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}

}
