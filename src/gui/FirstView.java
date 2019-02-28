package gui;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class FirstView {
	private JPanel view;
	private JFrame frame;
    
	private BufferedImage icon;
	private ImageIcon logo; 
    
	private JLabel picLabel;
	private JLabel welcome;
	private JLabel haveFun;
	
	private JButton newGame;
	private JButton backup;
	private JButton close;
    
    
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
			icon = ImageIO.read(new File("railtransparent.png"));
		} 
		catch (IOException e1) {
			e1.printStackTrace();
		}
		
		logo = new ImageIcon(icon);
		picLabel = new JLabel(logo);
		
        
        //Sizes
		view.setBounds(130, 36, 630, 447);
		
		picLabel.setBounds(199,6,225,225);
		welcome.setBounds(6, 252, 630, 25);
		haveFun.setBounds(239, 280, 152, 25);
		
        newGame.setBounds(249, 317, 122, 25);
    	backup.setBounds(249, 356, 122, 25);
    	close.setBounds(249, 393, 122, 25);
        
    	
        //Style
        Color blue = new Color(0, 115, 230);
        Font font = new Font("Tahoma", Font.BOLD, 16);
        
        view.setBackground(Color.WHITE);
        
        newGame.setBackground(blue);
        backup.setBackground(blue);
        close.setBackground(blue);
        
        newGame.setForeground(Color.WHITE);
        backup.setForeground(Color.WHITE);
        close.setForeground(Color.WHITE);
        
        welcome.setForeground(Color.WHITE);
        haveFun.setForeground(Color.WHITE);
        welcome.setFont(font);
        haveFun.setFont(font);
    	
        
        // Adding to JFrame
        view.add(picLabel); 
        view.add(welcome);
        view.add(haveFun);
        view.add(newGame);
        view.add(backup); 
        view.add(close); 
        view.setBackground(new Color(0,0,0,0));
        
        // JFrame properties
        frame.getContentPane().setLayout(null);
       
        frame.getContentPane().setBackground(Color.LIGHT_GRAY);
        frame.setSize(900, 550);
        frame.setTitle("RailCity - Menu");
        frame.setLocationRelativeTo(null);
        
        try {
			frame.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("city.jpg")))));
			frame.getContentPane().add(view);
		}
        catch (IOException e1) {
			e1.printStackTrace();
		}
        
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
		try {
			UIManager.setLookAndFeel ("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e1) {
			e1.printStackTrace();
		}
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
