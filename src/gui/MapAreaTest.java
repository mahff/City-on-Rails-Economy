package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.SwingUtilities;

import game.Town;
import java.awt.BorderLayout;
import java.awt.Canvas;

public class MapAreaTest extends JPanel {
	private Town town;
	/*
	private BufferedImage img;
	private BufferedImage img2;
	*/
	private JSplitPane sp, sp2;
	private EditMenu menu;
	public static ParameterArea paramDistrict;
	public static ParameterArea paramCity;
	private InnerCanvas canvas;
	
	
	public MapAreaTest() {
        setBorder(BorderFactory.createLineBorder(Color.black));
        this.town = new Town(20);
        
        canvas = new InnerCanvas(this.town);
    	menu = new EditMenu();
		paramCity = new ParameterArea(town);
		paramDistrict = new ParameterArea();
		setLayout(new BorderLayout(0, 0));
		
		sp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, paramDistrict.summaryParamFrame(), canvas);
		sp2 = new JSplitPane(JSplitPane.VERTICAL_SPLIT, sp, EventInformation.setEnventInfo());
		
		sp.setDividerLocation(300*4/3);
		sp2.setDividerLocation(650*4/3);
		sp.setEnabled(false); 
		sp2.setEnabled(false);
		
		// System.out.println(SwingUtilities.getRoot(this));
		
		// this.setResizable(false);
		this.add(sp2);
		this.setOpaque(true);
		
		
		// sp2.setBounds(x, y, width, height);
		//this.add(sp2);
		// this.setJMenuBar(menu.getMenu());
		// this.setLocationRelativeTo(null);
		// this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		// this.setResizable(false);
		/*
		JFrame frame = (JFrame) SwingUtilities.getRootPane(this).getParent();
		
		frame.setResizable(false);
		frame.add(sp2);
		frame.setSize(900*4/3,750*4/3);
		frame.setVisible(true);
		frame.setJMenuBar(menu.getMenu());
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.setResizable(false);
		*/
        // Ugly way of doing this. Need to create a class for drawing
    }

    public Dimension getPreferredSize() {
        return new Dimension(GUIParameters.WINDOW_WIDTH,GUIParameters.WINDOW_HEIGHT);
    }
}
