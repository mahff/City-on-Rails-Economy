package gui;

import java.awt.*;
import java.awt.event.*;
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
	JLabel welcome;
	JLabel haveFun;
	ImageIcon logo; 
    
    // Buttons
    JButton newGame = new JButton("New game");
    JButton backup = new JButton("Back up"); 
    JButton close = new JButton("Quit");

    public FirstView() {
    	
		try {
			icon = ImageIO.read(new File("rail.png"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		logo = new ImageIcon(icon);
		
		picLabel = new JLabel(logo);
		picLabel.setBounds(144,13,225,225);
		
		welcome = new JLabel("Welcome on RailCity, you can start a 'new game', or load a 'back up'!", SwingConstants.CENTER);
		welcome.setBounds(0, 262, 523, 16);
		
		haveFun = new JLabel("Have fun!", SwingConstants.CENTER);
		haveFun.setBounds(199, 280, 122, 16);
		
    	newGame.setBounds(199, 317, 122, 25);
    	backup.setBounds(199, 355, 122, 25);
    	close.setBounds(199, 393, 122, 25);
        view.setBackground(Color.WHITE);
        
        //Style
        Color blue = new Color(0, 115, 230);
        Color cyan = new Color(0, 179, 179);
        Font font = new Font("Tahoma", Font.BOLD, 13);
        newGame.setForeground(blue);
        backup.setForeground(blue);
        close.setForeground(blue);
        
        welcome.setForeground(cyan);
        haveFun.setForeground(cyan);
        welcome.setFont(font);
        haveFun.setFont(font);
    	
        // JPanel bounds
        view.setBounds(32, 29, 523, 447);
        view.setLayout(null);
        
        // Adding to JFrame
        view.add(picLabel); 
        view.add(welcome);
        view.add(haveFun);
        view.add(newGame);
        view.add(backup); 
        view.add(close); 
        
        // JFrame properties
        frame.getContentPane().setLayout(null);
        frame.getContentPane().add(view);
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setSize(592, 549);
        frame.setBackground(Color.BLACK);
        frame.setTitle("RailCity - Menu");
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false); //The window is not resizable anymore ;)
	    
        // listeners
        close.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				closeFrame();
			}
    	});
        
		frame.addWindowListener(new WindowAdapter() {
			  public void windowClosing(WindowEvent e) {
				   closeFrame();
			  }
		});
    }

    
	public static void main(String[] args) {
    	FirstView test = new FirstView(); 
    	test.initializeMap();
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
    	int confirmed = JOptionPane.showConfirmDialog(null,"Are you sure you want to exit the program?", "Exit Program?",JOptionPane.YES_NO_OPTION);
	    if (confirmed == JOptionPane.YES_OPTION) {
	    		System.exit(0);
	    }
    }
    
    public void Backup(File save) {
    	
    }
}
