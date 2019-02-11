package gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class InformationPanel {
	JTextArea area = new JTextArea(); 
	String txt; 
	JPanel panel = new JPanel();
	public InformationPanel(String txt) {
		this.txt = txt; 
	}
	
	JPanel getPanel() {
	    JLabel label = new JLabel(txt);
	    panel.add(label);
	    showInfo(txt);
	    System.out.println(getClass()+" "+txt);
	    return panel;
	  }
	
	
	public void showInfo(String txt) {
		area.setText(txt);
		panel.setBounds(573, 108, 94, 211);
	    GridBagLayout gbl_panel = new GridBagLayout();
	    gbl_panel.columnWidths = new int[]{89, 89, 89, 0};
	    gbl_panel.rowHeights = new int[]{23, 0, 0, 0, 0, 0};
	    gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
	    gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
	    panel.setLayout(gbl_panel);
	    
	    GridBagConstraints gbc_businessDistrictBuildingButton = new GridBagConstraints();
	    gbc_businessDistrictBuildingButton.anchor = GridBagConstraints.NORTHWEST;
	    gbc_businessDistrictBuildingButton.insets = new Insets(0, 0, 5, 5);
	    gbc_businessDistrictBuildingButton.gridx = 0;
	    panel.add(area, gbc_businessDistrictBuildingButton);
	    
	}
	

}
