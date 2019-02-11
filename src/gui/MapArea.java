package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

import game.Business;
import game.Resident;
import game.State;
import game.Town;


public class MapArea extends JFrame implements ActionListener {
	private String[][] disctrictName = new String[8][8];
	Town town = new Town(6); 
	private EditMenu menu = new EditMenu(); 
	String districtChoice; 
	String geneInfo; 
	private int size = town.getLength(); 
	JPanel map = new JPanel(new GridLayout(size, size));
	private  JButton[][] button = new JButton[size][size];
	
	public MapArea(){
		JSplitPane sp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, ParameterArea.summaryParamFrame(), createMap());
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
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // If you close the window, the program will terminate
	    frame.setResizable(false);
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				frame.dispose();
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
	            map.add(button[i][j]); 
	    	}
	    }
	    
	    return map; 
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
		ParameterArea param = new ParameterArea();
		JComboBox<String> combo = param.combo; 
		districtChoice = String.valueOf(combo.getSelectedItem()) ; 
		if(button[buttonX][buttonY].getBackground() != Color.WHITE) {
			System.out.println("["+buttonX+"]["+buttonY+"]");
			ParameterArea.summary.setText("["+buttonX+"]["+buttonY+"]"); 
		}
				
		else {
			
			if(districtChoice == "Resident" && (button[buttonX][buttonY].getBackground() != new State().getColor() && button[buttonX][buttonY].getBackground() != new Business().getColor())) {
				button[buttonX][buttonY].setBackground(new Resident().getColor());
				disctrictName[buttonX][buttonY] = "["+buttonX+"]["+buttonY+"]";
				button[buttonX][buttonY].setForeground(Color.GREEN); 
			}
			else if(districtChoice == "Business" && button[buttonX][buttonY].getBackground() != new Resident().getColor() && button[buttonX][buttonY].getBackground() != new State().getColor()) {
				button[buttonX][buttonY].setBackground(new Business().getColor());
				button[buttonX][buttonY].setForeground(Color.BLUE); 
				disctrictName[buttonX][buttonY] = "["+buttonX+"]["+buttonY+"]";
			}
			else if(districtChoice == "State" && button[buttonX][buttonY].getBackground() != new Resident().getColor() && button[buttonX][buttonY].getBackground() != new Business().getColor()) {
				button[buttonX][buttonY].setBackground(new State().getColor());
				disctrictName[buttonX][buttonY] = "["+buttonX+"]["+buttonY+"]";
				button[buttonX][buttonY].setForeground(Color.YELLOW); 
			} 
			else if(districtChoice == "Station") {
				if(button[buttonX][buttonY].getBackground() == new Resident().getColor() || button[buttonX][buttonY].getBackground() == new Business().getColor() || button[buttonX][buttonY].getBackground() == new State().getColor()) {
					button[buttonX][buttonY].setForeground(Color.RED); 
					button[buttonX][buttonY].setForeground(Color.RED); 
				}
			}
			EventInformation.summary.setText("A new district "+districtChoice +" created !");
			GeneralInformation.summary.setText(getNumberOfDisctrict());
		}
	}
	
	public String getNumberOfDisctrict() {
		int state = 0; 
		int resident =0; 
		int business = 0; 
		
		for (int i = 0; i < size; i++) {
	    	for(int j=0; j< size; j++) {
	    		if(button[i][j].getBackground() == Color.YELLOW) 
	    			state ++; 
	    		else if(button[i][j].getBackground() == Color.BLUE) business++;
	    		else if(button[i][j].getBackground() == Color.GREEN) resident++; 
	    	}
	    		
	    }
		geneInfo = "<html>"+state+" State district </br>";
		geneInfo+=resident+" Resident Disctrict </br>";
		geneInfo+= business+" Business district </html>";
		GeneralInformation.summary.setText(geneInfo);
		return geneInfo; 
	}

}
