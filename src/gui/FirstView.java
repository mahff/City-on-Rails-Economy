package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class FirstView {
	// JPanel
    JPanel view = new JPanel();
    
    JFrame frame = new JFrame(); 
    
    //Image
    BufferedImage icon;
	JLabel picLabel;
	ImageIcon logo; 
    
    // Buttons
    JButton newGame = new JButton("New Game");
    JButton backup = new JButton("Back up"); 
    JButton close = new JButton("Close");

    public FirstView() {
    	
		try {
			
			icon = ImageIO.read(new File("rail.png"));
			
			logo = new ImageIcon(icon);
			picLabel = new JLabel(logo);
			
         
	    	frame.setLayout(null); 
	    	 picLabel.setBounds(0,0,0,0);
			 view.add(picLabel); 
	    	newGame.setBounds(0, 200, 100, 100);
	    	backup.setBounds(0, 200, 100, 100);
	    	close.setBounds(0, 200, 100, 100);
	    	
	        // JPanel bounds
	        view.setBounds(1200, 1200, 150, 400);
	
	        // Adding to JFrame
	        view.add(newGame);
	        view.add(backup); 
	        view.add(close); 
	        frame.add(view);
	        view.setLocation(325,100);
	
	        // JFrame properties
	        frame.setSize(800, 600);
	        frame.setBackground(Color.BLACK);
	        frame.setTitle("RailCity");
	        frame.setLocationRelativeTo(null);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setVisible(true);
	        frame.setResizable(false); //The window is not resizable anymore ;)
	        
		} catch (IOException e) {
			e.printStackTrace();
		}
		
    }

    public static void main(String[] args) {
    	FirstView test = new FirstView(); 
    	test.initializeMap();
        test.closeFrame();
    }
    
    public void initializeMap() {
    	newGame.addActionListener(new ActionListener() {
    	    @Override
    	    public void actionPerformed(ActionEvent e) {
    	        System.out.println("Going to Map!"+e);
    	        frame.dispose();
    	        
    	        new MapArea(); 
    	    }
    	});
    }

    public void closeFrame() {
    	close.addActionListener(new ActionListener() {
    	    public void actionPerformed(ActionEvent e){
    	    	System.exit(0);
    	    }
    	});
    }
    
    public void Backup(File save) {
    	
    }
	
}
