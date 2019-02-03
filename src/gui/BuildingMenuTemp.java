package gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.border.LineBorder;

import static javax.swing.GroupLayout.Alignment.CENTER;
import static javax.swing.LayoutStyle.ComponentPlacement.UNRELATED;

public class BuildingMenuTemp extends JPanel implements ActionListener{
	
	private JToggleButton residentDistrictBuildingButton;
    private JToggleButton businessDistrictBuildingButton;
    private JToggleButton stateDistrictBuildingButton;
    private JToggleButton stationBuildingButton;
    private JToggleButton lineBuildingButton;
    
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
	    
	    JButton residentDistrictBuildingButton = new JButton("Resident District");
	    GridBagConstraints gbc_residentDistrictBuildingButton = new GridBagConstraints();
	    gbc_residentDistrictBuildingButton.anchor = GridBagConstraints.NORTHWEST;
	    gbc_residentDistrictBuildingButton.insets = new Insets(0, 0, 5, 5);
	    gbc_residentDistrictBuildingButton.gridx = 0;
	    gbc_residentDistrictBuildingButton.gridy = 0;
	    this.add(residentDistrictBuildingButton, gbc_residentDistrictBuildingButton);
	    
	    JButton businessDistrictBuildingButton = new JButton("Business District");
	    GridBagConstraints gbc_businessDistrictBuildingButton = new GridBagConstraints();
	    gbc_businessDistrictBuildingButton.anchor = GridBagConstraints.NORTHWEST;
	    gbc_businessDistrictBuildingButton.insets = new Insets(0, 0, 5, 5);
	    gbc_businessDistrictBuildingButton.gridx = 0;
	    gbc_businessDistrictBuildingButton.gridy = 1;
	    this.add(businessDistrictBuildingButton, gbc_businessDistrictBuildingButton);
	    
	    JButton stateDistrictBuildingButton = new JButton("State District");
	    GridBagConstraints gbc_stateDistrictBuildingButton = new GridBagConstraints();
	    gbc_stateDistrictBuildingButton.insets = new Insets(0, 0, 5, 5);
	    gbc_stateDistrictBuildingButton.anchor = GridBagConstraints.NORTHWEST;
	    gbc_stateDistrictBuildingButton.gridx = 0;
	    gbc_stateDistrictBuildingButton.gridy = 2;
	    this.add(stateDistrictBuildingButton, gbc_stateDistrictBuildingButton);
	    
	    JButton stationBuildingButton = new JButton("Station");
	    GridBagConstraints gbc_stationBuildingButton = new GridBagConstraints();
	    gbc_stationBuildingButton.insets = new Insets(0, 0, 5, 5);
	    gbc_stationBuildingButton.gridx = 0;
	    gbc_stationBuildingButton.gridy = 3;
	    this.add(stationBuildingButton, gbc_stationBuildingButton);
	    
	    JButton lineBuildingButton = new JButton("Line");
	    GridBagConstraints gbc_lineBuildingButton = new GridBagConstraints();
	    gbc_lineBuildingButton.insets = new Insets(0, 0, 0, 5);
	    gbc_lineBuildingButton.gridx = 0;
	    gbc_lineBuildingButton.gridy = 4;
	    this.add(lineBuildingButton, gbc_lineBuildingButton);
		
	}
		 

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		/*
        int red = color.getRed();
        int green = color.getGreen();
        int blue = color.getBlue();
		*/
		System.out.println(e.getActionCommand().toString());
        if (e.getActionCommand().equals("red")) {
        	/*
            if (red == 0) {
                red = 255;
            } else {
                red = 0;
            }
            */
        }

        // var setCol = new Color(red, green, blue);
        // display.setBackground(setCol);
		
	}

}
