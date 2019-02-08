package gui;

import javax.swing.JLabel;
import javax.swing.JPanel;


public class GenaralInformationPanel extends JPanel{
	
	private String text;
	private JLabel generalInfoLabel = new JLabel(); 
	
	public GenaralInformationPanel(String text) {
		super();
		this.text = text;
	}
	
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	} 
	
	
	JLabel showInfo() {
		
		generalInfoLabel.setText(getText());
		
		return generalInfoLabel; 
		
	}

	
	

}
