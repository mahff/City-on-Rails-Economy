package gui;

import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JSplitPane;


public class ParameterArea {
	
	
	static JComboBox<String> combo = new JComboBox<String>();
	static JLabel summary = new JLabel();
	static JButton button = new JButton("Choose");

	public static Component summaryParamFrame() {
		
		combo.addItem("Resident");
		combo.addItem("Business");
		combo.addItem("State");
		summary.setText("Summary");
		JSplitPane sumSug = new JSplitPane(JSplitPane.VERTICAL_SPLIT, combo, summary);

		JSplitPane splitMap = new JSplitPane(JSplitPane.VERTICAL_SPLIT, GeneralInformation.setGeneralInfo(), sumSug);
		splitMap.setDividerLocation(300);
		sumSug.setDividerLocation(50);

		return splitMap;
	}
	


}
