package gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.border.LineBorder;

import static javax.swing.GroupLayout.Alignment.CENTER;
import static javax.swing.LayoutStyle.ComponentPlacement.UNRELATED;

public class BuildingMenuTemp extends JFrame implements ActionListener{
	
	private JToggleButton residentDistrictBuildingButton;
    private JToggleButton businessDistrictBuildingButton;
    private JToggleButton stateDistrictBuildingButton;
    private JToggleButton stationBuildingButton;
    private JToggleButton lineBuildingButton;
    
    private JPanel display;

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	private void initUI() {
		residentDistrictBuildingButton = new JToggleButton("Resident District");
		residentDistrictBuildingButton.addActionListener(this);
		
		businessDistrictBuildingButton = new JToggleButton("Business District");
		businessDistrictBuildingButton.addActionListener(this);
		
		stateDistrictBuildingButton = new JToggleButton("State District");
		stateDistrictBuildingButton.addActionListener(this);
		
		stationBuildingButton = new JToggleButton("Station");
		stationBuildingButton.addActionListener(this);
		
		lineBuildingButton = new JToggleButton("Line");
		lineBuildingButton.addActionListener(this);
		
		display = new JPanel();
		display.setPreferredSize(new Dimension(120, 120));
		display.setBorder(LineBorder.createGrayLineBorder());
		display.setBackground(Color.black);
		
		//createLayout(residentDistrictBuild, greenBtn, blueBtn, display);
		createLayout(residentDistrictBuildingButton, businessDistrictBuildingButton, stateDistrictBuildingButton, stationBuildingButton, lineBuildingButton, display);
		setTitle("JToggleButton");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
		 
	private void createLayout(JComponent... arg) {

        Container pane = getContentPane();
        GroupLayout gl = new GroupLayout(pane);
        pane.setLayout(gl);

        gl.setAutoCreateContainerGaps(true);
        gl.setAutoCreateGaps(true);

        gl.setHorizontalGroup(gl.createSequentialGroup()
                .addGroup(gl.createParallelGroup()
                        .addComponent(arg[0])
                        .addComponent(arg[1])
                        .addComponent(arg[2])
                        .addComponent(arg[3])
                        .addComponent(arg[4]))
                .addPreferredGap(UNRELATED)
                .addComponent(arg[5])
        );

        gl.setVerticalGroup(gl.createParallelGroup(CENTER)
                .addGroup(gl.createSequentialGroup()
                        .addComponent(arg[0])
                        .addComponent(arg[1])
                        .addComponent(arg[2])
                        .addComponent(arg[3])
                        .addComponent(arg[4]))
                .addComponent(arg[5])
        );

        // gl.linkSize(redBtn, greenBtn, blueBtn);

        pack();
    }


}
