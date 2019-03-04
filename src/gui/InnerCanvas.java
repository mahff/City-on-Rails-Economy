package gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JPanel;

import game.State;
import core.StateMachine;
import game.Business;
import game.District;
import game.Resident;
import game.Town;

public class InnerCanvas extends JComponent implements MouseListener, MouseMotionListener {
	private Point mousePosition;
	private BufferedImage img;
	private BufferedImage img2;
	private BufferedImage img3;
	private BufferedImage img4;
	private Town town;
	private Graphics2D g;
	
	public InnerCanvas (Town town) {
		this.town = town;
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		this.mousePosition = new Point(0,0);
		// this.g = (Graphics2D) this.getGraphics();
		
		try {
			this.img = ImageIO.read(new File("grass.png"));
			this.img2 = ImageIO.read(new File("resident.png"));
			this.img3 = ImageIO.read(new File("business.png"));
			this.img4 = ImageIO.read(new File("state.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void paintComponent(Graphics g) {
        super.paintComponent(g);      
        this.g = (Graphics2D) g;
        // Graphics2D g2 = (Graphics2D) g;
        // this.g= this.getGraphics();
        // Draw Text
        
        try {
			paintGrass();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        paintTown();
        
        /*
        if ( StateMachine.getInstance().getState() == State.BUILDING ) {
        	this.collisionDetection();
        	StateMachine.getInstance().setState(State.IDLE);
        }
        */
        // drawMouseCursor();
    }  
    
    public void paintGrass() throws IOException {
    	int guiScale = GUIParameters.SCALE;
    	for (int i = 0; i < this.town.getLength(); i++) {
    		for (int j = 0; j < this.town.getLength(); j++) {
        		this.g.drawImage(this.img, j*guiScale, i*guiScale, guiScale, guiScale, null);
        	}
    	}
    }
    
    public void drawMouseCursor() {
    	// Point mousePosition = this.getMousePosition();
    	int guiScale = GUIParameters.SCALE;
    	
    	int xPos = (int) this.mousePosition.getX();
    	int yPos = (int) this.mousePosition.getY();
    	
    	xPos = (int) xPos / guiScale;
    	yPos = (int) yPos / guiScale;
    	
    	this.g.setColor(Color.GREEN);
    	this.g.fillRect(xPos*guiScale, yPos * guiScale, guiScale, guiScale);
    	repaint();
    	// repaint();
    }
    
    public void paintTown() {
    	int guiScale = GUIParameters.SCALE;
    	int x;
    	int y;
    	
		for (int i = 0; i < this.town.getLength(); i++) {
			for (int j = 0; j < this.town.getLength(); j++) {
				x = j*guiScale;
				y= i*guiScale;
				this.g.drawRect(x, y, guiScale, guiScale);
				this.g.drawString("["+ String.valueOf(i)+" "+String.valueOf(j) +"]", j*guiScale, i*guiScale);
				this.g.setColor(Color.LIGHT_GRAY);
				
				if (this.town.getDistrict(j, i) != null) {
					Color color = this.town.getDistrict(j, i).getColor();
					if (color == Color.YELLOW) {
						this.g.drawImage(this.img2, j*guiScale, i*guiScale, guiScale, guiScale, null);
					} else if (color == Color.GREEN) {
						this.g.drawImage(this.img3, j*guiScale, i*guiScale, guiScale, guiScale, null);
					} else if (color == Color.BLUE) {
						this.g.drawImage(this.img4, j*guiScale, i*guiScale, guiScale, guiScale, null);
					}
				}
			}
		}
	}
    
    public void collisionDetection() {
    	int guiScale = GUIParameters.SCALE;
    	
    	double xPos;
    	double yPos;
    	
    	double xPoss;
    	double yPoss;
    	
    	double xPosss;
    	double yPosss;
    	
    	Point test = this.getMousePosition();
    	
    	xPos = Math.floorMod((int) test.getX(), guiScale);
    	yPos = Math.floorMod((int) test.getY(), guiScale);
    	
    	xPoss = test.getX() / guiScale;
    	yPoss = test.getY() / guiScale;
    	
    	xPosss = (int) xPoss;
    	yPosss = (int) yPoss;
    	
    	// System.out.println(xPos + " " + yPos + ".\n");
    	// System.out.println(xPoss + " " + yPoss + ".\n");
    	System.out.println(xPosss + " " + yPosss + ".\n");
    	System.out.println(this.getParent().getParent());
    	if(town.getDistrict((int)xPosss, (int)yPosss) == null && DistrictOptions.canBuildDistrict()) {
    		
    		String choice = DistrictOptions.getSelectedType();
			
			District newDistrict = null;
			ImageIcon img = null;
			boolean isBuild = false;
			
    		if (choice == "Residential") {
    			newDistrict = new Resident();
				
				isBuild = true;
        	} else if (choice == "Business") {
        		newDistrict = new Business();
				isBuild = true;
        	} else if (choice == "State") {
        		newDistrict = new State();
				
				town.payDistrictConstruction();
				
				isBuild = true;
        	}
    		
    		if(isBuild) {
				town.setDistrict((int)xPosss, (int)yPosss, newDistrict);
				// buttonMap[posX][posY].setIcon(img);
				
				EventInformation.addDistrict(choice);
			}
    	}
    	// this.town.setDistrict(xPosss, yPosss, new);
    	// System.out.println(test.toString());
    	
    	// this.town.getMap()[][]	
    	// drawDistrictBorder(xPosss, yPosss);
    	repaint();
    }
    
    public void drawDistrictBorder(double x, double y) {
    	int guiScale = GUIParameters.SCALE;
    	
    	this.g.setColor(Color.BLUE);
    	this.g.drawRect((int)x*guiScale, (int)y*guiScale, guiScale, guiScale);
    	this.g.drawImage(this.img2, (int) x*guiScale, (int) y*guiScale, guiScale, guiScale, null);
    	System.out.println("testestest");
    	System.out.println(this.g.toString());
    	repaint();
    }
    

    @Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
    	// StateMachine.getInstance().setState(State.BUILDING);
		collisionDetection();
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		// this.mousePosition = this.getMousePosition();
		// System.out.println("MOUSE MOVE");
		// this.drawMouseCursor(arg0);
	}
}