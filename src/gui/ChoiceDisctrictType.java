package gui;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ChoiceDisctrictType {
	JDialog dialog;
	String districtChoice; 
	
	public ChoiceDisctrictType() {
		displayGUI(); 
	}

	  private void displayGUI() {
		  String[] choices = { "Resident", "Business", "State"};
			 districtChoice = (String) JOptionPane.showInputDialog(null, "Choose now...",
			        "The Choice of a Lifetime", JOptionPane.QUESTION_MESSAGE, null,choices, choices[1]);
			 System.out.println(districtChoice);
	  }

	  private JPanel getPanel() {
	    JPanel panel = new JPanel();
	    JLabel label = new JLabel("Java Technology Dive Log");
	    panel.add(label);

	    return panel;
	  }
	  
	  
	  public String getDistrictChoice(){
		  return districtChoice; 
	  }
}
