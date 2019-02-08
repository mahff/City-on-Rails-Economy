package gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import core.VariableRepository;

public class BuildingMenuTemp extends JPanel implements ActionListener{
	JButton businessDistrictBuildingButton = new JButton("Build New Line");
	JButton stateDistrictBuildingButton = new JButton("Build New Station");
    // private JPanel display;
	public BuildingMenuTemp() {
		initUI();
	}
	
	private void initUI() {
		// JPanel panel = new JPanel();
	    this.setBounds(573, 108, 94, 211);
	    GridBagLayout gbl_panel = new GridBagLayout();
	    gbl_panel.columnWidths = new int[]{89, 89, 89, 0};
	    gbl_panel.rowHeights = new int[]{23, 0, 0, 0, 0, 0};
	    gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
	    gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
	    this.setLayout(gbl_panel);
	    
	    
	    GridBagConstraints gbc_businessDistrictBuildingButton = new GridBagConstraints();
	    gbc_businessDistrictBuildingButton.anchor = GridBagConstraints.NORTHWEST;
	    gbc_businessDistrictBuildingButton.insets = new Insets(0, 0, 5, 5);
	    gbc_businessDistrictBuildingButton.gridx = 0;
	    gbc_businessDistrictBuildingButton.gridy = 1;
	    businessDistrictBuildingButton.addActionListener(this);
	    this.add(businessDistrictBuildingButton, gbc_businessDistrictBuildingButton);
	    
	    
	    GridBagConstraints gbc_stateDistrictBuildingButton = new GridBagConstraints();
	    gbc_stateDistrictBuildingButton.insets = new Insets(0, 0, 5, 5);
	    gbc_stateDistrictBuildingButton.anchor = GridBagConstraints.NORTHWEST;
	    gbc_stateDistrictBuildingButton.gridx = 0;
	    gbc_stateDistrictBuildingButton.gridy = 2;
	    stateDistrictBuildingButton.addActionListener(this);
	    this.add(stateDistrictBuildingButton, gbc_stateDistrictBuildingButton);
		
	}
		 

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String buildingToBuild = e.getActionCommand().toString();
		String toReturn = "";
		// Amaury - Ugly way of doing this, but easier for me to understand it when reading it on the fly
		// More exotic way to actually do this is to use enum type to list all the different kinds of build-able buildings and to use equals on all the enum-var in the enum type.
		// Waste-oriented Code
		/*
		if ( buildingToBuild.equals("Resident District") ) {
			toReturn = buildingToBuild;
		} else if ( buildingToBuild.equals("Business District") ) {
			toReturn = buildingToBuild;
		} else if ( buildingToBuild.equals("State District") ) {
			toReturn = buildingToBuild;
		} else if ( buildingToBuild.equals("Station") ) {
			toReturn = buildingToBuild;
		} else if ( buildingToBuild.equals("Line") ) {
			toReturn = buildingToBuild;
		} 
		*/
		
		if (buildingToBuild.equals("Build New District") ) {
			toReturn = "resident";
		} else if ( buildingToBuild.equals("Business District") ) {
			toReturn = "business";
		} else if ( buildingToBuild.equals("State District") ) {
			toReturn = "state";
		} else if ( buildingToBuild.equals("Station") ) {
			toReturn = "station";
		} else if ( buildingToBuild.equals("Line") ) {
			toReturn = "line";
		} 
		
		// The variable should be instantiated and initialized since the beginning of the game. 
		// We should actually implements an init-method somewhere to init() ALL the variables that will be used in the program.
		VariableRepository.getInstance().register("BuildingActionChoice",toReturn);
		
		/*
        int red = color.getRed();
        int green = color.getGreen();
        int blue = color.getBlue();
		*/
		// System.out.println(e.getActionCommand().toString()+"\n");
		/*
		switch (e.getActionCommand().toString()) {
        case "Resident District":  monthString = "January";
                 break;
        case 2:  monthString = "February";
                 break;
        case 3:  monthString = "March";
                 break;
        case 4:  monthString = "April";
                 break;
        case 5:  monthString = "May";
                 break;
        default: monthString = "Invalid month";
                 break;
    } 
	*/
        // var setCol = new Color(red, green, blue);
        // display.setBackground(setCol);
		
	}

}
