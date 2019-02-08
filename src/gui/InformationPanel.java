package gui;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class InformationPanel {
	JPanel panel = new JPanel(); 
	public InformationPanel() {
		
	}
	
	
	public JPanel displayInfo() {
		
		JLabel label = new JLabel(); 
		label.setText("salut"); 
		panel.add(label); 
		return panel; 
	}
	
	public void changeText() {
		
	}
	

}
