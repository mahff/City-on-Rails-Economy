package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.MenuBar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.*;

public class Map implements ActionListener {
	ActionListener listener;
	public int size = 5; 
	public EditMenu menu = new EditMenu(); 
	public JButton[][] button = new JButton[size][size];
	public JFrame frame = new JFrame("RailCity");
	Icon business = new ImageIcon("business.jpg");
	Icon resident = new ImageIcon("resident.jpg");
	Icon state = new ImageIcon("state.jpg");
	Map(){
		
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    JPanel map = new JPanel(new GridLayout(size, size));
	    map.setSize(400,400);
	    frame.setLayout(null); 
	    frame.getContentPane().add(map);
	    // Creates the buttons in the array
	    for (int i = 0; i < size; i++) {
	    	for(int j=0; j< size; j++) {
	    		button[i][j] = new JButton(i+","+j);
	            map.add(button[i][j]);
	            button[i][j].setForeground(Color.BLACK);
	            button[i][j].setBackground(Color.WHITE);
	            button[i][j].setBorderPainted(true);
	            //button[i][j].setFocusPainted(false);
	            button[i][j].addActionListener(this);
	    	}
	    }
	    frame.setTitle("RailCity");
	    frame.getContentPane().setLayout(new BorderLayout());
	    frame.setSize(800, 600); 
	    frame.setVisible(true); 
	    frame.setJMenuBar(menu.getMenu());
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // If you close the window, the program will terminate
	    frame.setResizable(false); //The window is not resizable anymore ;)
	    
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
        			updateButton("resident", Integer.parseInt(part1), Integer.parseInt(part2)); 
                    System.out.println(i+"+"+j);
                }
        	}
        }
	}
	
	public void updateButton(String type, int buttonX, int buttonY) {
		System.out.println(type);
		if(type == "resident") {
			button[buttonX][buttonY].setIcon(resident);
			button[buttonX][buttonY].setEnabled(false);
		}
		else if(type == "business") {
			button[buttonX][buttonY].setIcon(business);
			button[buttonX][buttonY].setEnabled(false);
		}
		else if(type == "state") {
			button[buttonX][buttonY].setIcon(state);
			button[buttonX][buttonY].setEnabled(false);
		}
	}
	
	
	
}



