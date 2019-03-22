package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class DistrictOptions {
	private static JPanel districtPanel;
	
	private static JLabel description;
	
	private static JComboBox<String> districtType;
	
	private static JButton createStation;
	private static JButton createLine;
	private static JButton destroyStation;
	private static JButton destroyLine;
	
	private static int isCreatingStation = 0, isCreatingLine = 0, isDestroyingStation = 0;
	
	
	/**
	 * Return the combo box to choose the district type to create
	 * @return districtType
	 */
	public static JComboBox<String> getComboBox() {
		districtType = new JComboBox<String>();
		
		districtType.addItem("Choose the district type...");
		districtType.addItem("Residential");
		districtType.addItem("Business");
		districtType.addItem("State");
		
		Font font = new Font("Tahoma", Font.BOLD, 15);
		districtType.setFont(font);
		
		
		//Listeners
		districtType.addActionListener(new ActionListener() {
    	    @Override
    	    public void actionPerformed(ActionEvent e) {
    	    	
    	    }
    	});
		
		return districtType;
	}
	
	
	/**
	 * Return the the districts action buttons
	 * @return districtPanel
	 */
	public static JPanel getButtons() {
		districtPanel = new JPanel();

		description = new JLabel("Actions on the metro network :");
		
		createStation = new JButton("Create Station");
		createLine = new JButton("Create Line"); 
		destroyStation = new JButton("Destroy Station");
		destroyLine = new JButton("Destroy Line");
		
		description.setBounds(85,20,250,25);
		createStation.setBounds(60,60,122,25);
		createLine.setBounds(210,60,122,25);
		destroyStation.setBounds(60,110,122,25);
		destroyLine.setBounds(210,110,122,25);
		
		//Style
		Color blue = new Color(0, 115, 230);
		Color purple = new Color(51, 102, 204);
		Color darkgrey = new Color(195, 203, 213);
		Font font = new Font("Tahoma", Font.BOLD, 15);
		
		description.setFont(font);
		
		createStation.setBackground(blue);
		createLine.setBackground(blue);
		destroyStation.setBackground(blue);
		destroyLine.setBackground(blue);
		
		description.setForeground(purple);
		createStation.setForeground(Color.WHITE);
		createLine.setForeground(Color.WHITE);
		destroyStation.setForeground(Color.WHITE);
		destroyLine.setForeground(Color.WHITE);
		
		districtPanel.setBackground(darkgrey);
		
		//Add
		districtPanel.setLayout(null);
		districtPanel.add(description); 
		districtPanel.add(createStation);
		districtPanel.add(createLine);
		districtPanel.add(destroyStation);
		districtPanel.add(destroyLine);
		
		
		//Listeners
		createStation.addActionListener(new ActionListener() {
    	    @Override
    	    public void actionPerformed(ActionEvent e) {
    	    	if(createStation.getText() == "Create Station") {
    	    		createStation();
    	    	}
    	    	else {
    	    		endCreationStation();
    	    	}
    	    }
    	});
		createLine.addActionListener(new ActionListener() {
    	    @Override
    	    public void actionPerformed(ActionEvent e) {
    	    	if(createLine.getText() == "Create Line") {
    	    		createLine();
    	    	}
    	    	else {
    	    		endCreationLine();
    	    	}
    	    }
    	});
		destroyStation.addActionListener(new ActionListener() {
    	    @Override
    	    public void actionPerformed(ActionEvent e) {
    	    	if(destroyStation.getText() == "Destroy Station") {
    	    		destroyStation();
    	    	}
    	    	else {
    	    		endDestroyStation();
    	    	}
    	    }
    	});
		destroyLine.addActionListener(new ActionListener() {
    	    @Override
    	    public void actionPerformed(ActionEvent e) {
    	    	String[] lines = {"line 1", "line 2"}; //TODO récupérer les lignes
    	    	String selected = (String)JOptionPane.showInputDialog(null, "Please select the line to destroy", "Destroy Line", JOptionPane.QUESTION_MESSAGE, null, lines, lines[0]);
    	    	System.out.println("SELECTED="+selected);
    	    	
    	    	if(selected != null) {
    	    		//TODO trouver ligne correspondante dans town.getTownLines() et appeler town.removeLine()
        	    	
    	    	}
    	    	
    	    }
    	});
		
		
		return districtPanel;
	}
	
	
	/**
	 * Toggle on/off buttons when one is already selected
	 * @param enable
	 * @param buttonEnable
	 */
	private static void toggleElements(boolean enable, JButton buttonEnable) {
		createStation.setEnabled(enable);
		createLine.setEnabled(enable);
		destroyStation.setEnabled(enable);
		destroyLine.setEnabled(enable);
		
		if(buttonEnable != null) {
			buttonEnable.setEnabled(true);
		}
	}
	
	
	/**
	 * Change the buttons when creating a station
	 */
	private static void createStation(){
		createStation.setText("Complete Station Creation");
		createStation.setBounds(5,60,200,25);
		
		isCreatingStation = 1;
		districtType.setEnabled(false);
		toggleElements(false, createStation);
	}
	
	
	/**
	 * Change the buttons when station creation is done
	 */
	private static void endCreationStation() {
		createStation.setText("Create Station");
		createStation.setBounds(60,60,122,25);
		
		isCreatingStation = 0;
		districtType.setEnabled(true);
		toggleElements(true, createStation);
	}
	
	
	/**
	 * Change the buttons when creating a line
	 */
	private static void createLine(){
		createLine.setText("Complete Line Creation");
		createLine.setBounds(187,60,200,25);
		
		isCreatingLine = 1;
		districtType.setEnabled(false);
		toggleElements(false, createLine);
	}
	
	
	/**
	 * Change the buttons when line creation is done
	 */
	private static void endCreationLine() {
		createLine.setText("Create Line");
		createLine.setBounds(210,60,122,25);
		
		isCreatingLine = 0;
		districtType.setEnabled(true);
		toggleElements(true, createLine);
		
		// MapButton.printLine();
		InnerCanvas.createLine();
	}
	
	
	/**
	 * Change the buttons when creating a station
	 */
	private static void destroyStation(){
		destroyStation.setText("Complete Station Deletion");
		destroyStation.setBounds(5,110,200,25);
		
		isDestroyingStation = 1;
		districtType.setEnabled(false);
		toggleElements(false, destroyStation);
	}
	
	
	/**
	 * Change the buttons when station creation is done
	 */
	private static void endDestroyStation() {
		destroyStation.setText("Destroy Station");
		destroyStation.setBounds(60,110,122,25);
		
		isDestroyingStation = 0;
		districtType.setEnabled(true);
		toggleElements(true, destroyStation);
	}
	
	
	/**
	 * Return a boolean to know if it's possible to build a district
	 * @return true or false
	 */
	public static boolean canBuildDistrict() {
		if(isCreatingStation == 0 && isCreatingLine == 0 && isDestroyingStation == 0) {
			return true;
		}
		return false;
	}
	
	
	/**
	 * Return a boolean to know if it's possible to build a station
	 * @return true or false
	 */
	public static boolean canBuildStation() {
		if(isCreatingStation == 1 && isCreatingLine == 0 && isDestroyingStation == 0) {
			return true;
		}
		return false;
	}
	
	
	/**
	 * Return a boolean to know if it's possible to build a line
	 * @return true or false
	 */
	public static boolean canBuildLine() {
		if(isCreatingStation == 0 && isCreatingLine == 1 && isDestroyingStation == 0) {
			return true;
		}
		return false;
	}
	
	
	/**
	 * Return a boolean to know if it's possible to destroy a station
	 * @return true or false
	 */
	public static boolean canDestroyStation() {
		if(isDestroyingStation == 1) {
			return true;
		}
		return false;
	}
	
	
	/**
	 * Return the selected item in the combo box
	 * @return selected item in combo box
	 */
	public static String getSelectedType() {
		return String.valueOf(districtType.getSelectedItem());
	}
	
}
