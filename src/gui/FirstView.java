package gui;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class FirstView {
    JPanel view;
    JFrame frame;
    
    BufferedImage icon;
    ImageIcon logo; 
    
	JLabel picLabel;
	JLabel welcome;
	JLabel haveFun;
	
    JButton newGame;
    JButton backup;
    JButton close;

    
    public FirstView() {
    	//Initialize
    	view = new JPanel();
    	frame = new JFrame();
    	
    	view.setLayout(null);
    	
    	newGame = new JButton("New game");
    	backup = new JButton("Back up"); 
    	close = new JButton("Quit");
    	
    	welcome = new JLabel("Welcome on RailCity, you can start a 'new game', or load a 'back up'!", SwingConstants.CENTER);
    	haveFun = new JLabel("Have fun!", SwingConstants.CENTER);
    	
    	
    	//Image
    	try {
            frame.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("city.png")))));
        } 
    	catch (IOException e) {
            e.printStackTrace();
        }
    	
		try {
			icon = ImageIO.read(new File("rail.png"));
		} 
		catch (IOException e1) {
			e1.printStackTrace();
		}
		
		logo = new ImageIcon(icon);
		picLabel = new JLabel(logo);
		
        
        //Sizes
		view.setBounds(32, 29, 523, 447);
		
		picLabel.setBounds(144,13,225,225);
		welcome.setBounds(0, 262, 523, 16);
		haveFun.setBounds(199, 280, 122, 16);
		
        newGame.setBounds(199, 317, 122, 25);
    	backup.setBounds(199, 355, 122, 25);
    	close.setBounds(199, 393, 122, 25);
        
    	
        //Style
        Color blue = new Color(0, 115, 230);
        Color cyan = new Color(0, 179, 179);
        Font font = new Font("Tahoma", Font.BOLD, 13);
        
        view.setBackground(Color.WHITE);
        
        newGame.setForeground(blue);
        backup.setForeground(blue);
        close.setForeground(blue);
        
        welcome.setForeground(cyan);
        haveFun.setForeground(cyan);
        welcome.setFont(font);
        haveFun.setFont(font);
    	
        
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
        frame.setTitle("RailCity - Menu");
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);
	    
        
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
