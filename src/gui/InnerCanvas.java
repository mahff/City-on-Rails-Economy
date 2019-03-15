package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.Timer;
import javax.imageio.ImageIO;
import javax.swing.JComponent;
import game.State;
import game.Station;
import core.VariableRepository;
import game.Business;
import game.District;
import game.Line;
import game.Moving;
import game.Resident;
import game.Town;

public class InnerCanvas extends JComponent implements MouseListener, MouseMotionListener,ActionListener {
	private Point mousePosition;
	ParameterArea paramarea; 
	private BufferedImage grassImage;
	private BufferedImage residentDistrictImage;
	private BufferedImage businessDistrictImage;
	private BufferedImage stateDistrictImage;
	private BufferedImage residentStationImage;
	private BufferedImage businessStationImage;
	private BufferedImage stateStationImage;
	 
	// TODO - Find a way to avoid making this attribute as static
	private static Town town;
	private Graphics2D g;
	// For alpha purpose
	private static ArrayList<ArrayList<Point>> ArrayListOfPointsArrayList;
	Timer timer;
	public InnerCanvas (Town town) {
		InnerCanvas.town = town;
		 
		paramarea = new ParameterArea(town); 
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		this.mousePosition = new Point(0,0);
		InnerCanvas.ArrayListOfPointsArrayList = new ArrayList<ArrayList<Point>>();
		// this.g = (Graphics2D) this.getGraphics();
		timer = new Timer(5000, this);
		timer.start();
		try {
			this.grassImage = ImageIO.read(new File("grass.png"));
			this.residentDistrictImage = ImageIO.read(new File("resident.png"));
			this.businessDistrictImage = ImageIO.read(new File("business.png"));
			this.stateDistrictImage = ImageIO.read(new File("state.png"));
			this.residentStationImage = ImageIO.read(new File("resident_metro.png"));
			this.businessStationImage = ImageIO.read(new File("business_metro.png"));
			this.stateStationImage = ImageIO.read(new File("state_metro.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		VariableRepository.getInstance().register("stationArrayListForLineBuilding", new ArrayList<Station>());
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
        drawMouseCursor();
        this.buildArrayListLinesPoints();
        drawLines();

        // System.out.println(this.town.getTownLines());
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
    	for (int i = 0; i < InnerCanvas.town.getLength(); i++) {
    		for (int j = 0; j < InnerCanvas.town.getLength(); j++) {
        		this.g.drawImage(this.grassImage, j*guiScale, i*guiScale, guiScale, guiScale, null);
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
    	
		for (int i = 0; i < InnerCanvas.town.getLength(); i++) {
			for (int j = 0; j < InnerCanvas.town.getLength(); j++) {
				x = j*guiScale;
				y= i*guiScale;
				this.g.drawRect(x, y, guiScale, guiScale);
				this.g.drawString("["+ String.valueOf(i)+" "+String.valueOf(j) +"]", j*guiScale, i*guiScale);
				this.g.setColor(Color.LIGHT_GRAY);
				
				if (InnerCanvas.town.getDistrict(j, i) != null) {
					Color color = InnerCanvas.town.getDistrict(j, i).getColor();
					if (color == Color.YELLOW) {
						this.g.drawImage(this.residentDistrictImage, j*guiScale, i*guiScale, guiScale, guiScale, null);
					} else if (color == Color.GREEN) {
						this.g.drawImage(this.businessDistrictImage, j*guiScale, i*guiScale, guiScale, guiScale, null);
					} else if (color == Color.BLUE) {
						this.g.drawImage(this.stateDistrictImage, j*guiScale, i*guiScale, guiScale, guiScale, null);
					} 
					
					if ((InnerCanvas.town.getDistrict(j, i).getStation() != null)) {
						if (color == Color.YELLOW) {
							this.g.drawImage(this.residentStationImage, j*guiScale, i*guiScale, guiScale, guiScale, null);
						} else if (color == Color.GREEN) {
							this.g.drawImage(this.businessStationImage, j*guiScale, i*guiScale, guiScale, guiScale, null);
						} else if (color == Color.BLUE) {
							this.g.drawImage(this.stateStationImage, j*guiScale, i*guiScale, guiScale, guiScale, null);
						}
					}
				}
			}
		}
	}
    
    @SuppressWarnings("unchecked")
	public void collisionDetection() {
    	int guiScale = GUIParameters.SCALE;
    	
    	double xPoss;
    	double yPoss;
    	
    	double xPosss;
    	double yPosss;
    	
    	Point test = this.getMousePosition();
    	
    	xPoss = test.getX() / guiScale;
    	yPoss = test.getY() / guiScale;
    	
    	xPosss = (int) xPoss;
    	yPosss = (int) yPoss;
    	
    	// System.out.println(xPos + " " + yPos + ".\n");
    	// System.out.println(xPoss + " " + yPoss + ".\n");
    	// System.out.println(xPosss + " " + yPosss + ".\n");
    	// System.out.println(this.getParent().getParent());
    	
    	if(town.getDistrict((int)xPosss, (int)yPosss) == null && DistrictOptions.canBuildDistrict()) {
    		
    		String choice = DistrictOptions.getSelectedType();
			
			District newDistrict = null;
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
				// town.payStationConstruction();
				// EventInformation.addStation();
				EventInformation.addDistrict(choice);
			}
    	}
    	
    	if(town.getDistrict((int)xPosss, (int)yPosss) != null) {
    		if (DistrictOptions.canBuildStation()) {
    			String choice = DistrictOptions.getSelectedType();
    			boolean isBuild = false;
    			
    	    	// if (choice == "Station") {
	    		Station newStation = new Station(30, false, 0, new Moving(0, new Date(), new Date()));
	    		        		
        		District currentDistrict = town.getDistrict((int) xPosss, (int) yPosss);
        		
        		// Color currentDistrictColor = currentDistrict.getColor();
    			Station currentDistrictStation = currentDistrict.getStation();
    			
    			if(currentDistrictStation == null) {
    				isBuild = true;
    				// currentDistrict.setStation(newStation);
    			}
    			
    			if(isBuild) {
					town.getDistrict((int) xPosss, (int) yPosss).setStation(newStation);
					// buttonMap[posX][posY].setIcon(img);
					town.payStationConstruction();
					
					EventInformation.addStation();
				}
    		}
    		
    		ArrayList<Station> tempArrayListForLineBuilding = (ArrayList<Station>) VariableRepository.getInstance().searchByName("stationArrayListForLineBuilding");
    		
    		if(DistrictOptions.canBuildLine()) {
    			District currentDistrict = town.getDistrict((int) xPosss, (int) yPosss);
    			
    			if(currentDistrict != null && currentDistrict.getStation() != null) {
    				Station currentDistrictStation = currentDistrict.getStation();
    				
    				tempArrayListForLineBuilding.add(currentDistrictStation);
    				System.out.println("BuildingLine");
    			}
    			
    		} 
    		/*
    		else if (!(DistrictOptions.canBuildLine()) && tempArrayListForLineBuilding.size() > 0 ) {
    			Line newLine = new Line(tempArrayListForLineBuilding, 20, new Date());
    			
    			for(Station station : tempArrayListForLineBuilding) {
    				station.addLine(newLine);
    			}
    			
    			
    			EventInformation.addLine(tempArrayListForLineBuilding);
    			town.payLineSegmentConstruction();
				
				tempArrayListForLineBuilding.clear();
				System.out.println("EndBuildingLine");
    		}
    		*/
    	}
    	
    	repaint();
    }
    
    
    public void drawDistrictBorder(double x, double y) {
    	int guiScale = GUIParameters.SCALE;
    	
    	this.g.setColor(Color.BLUE);
    	this.g.drawRect((int)x*guiScale, (int)y*guiScale, guiScale, guiScale);
    	this.g.drawImage(this.residentDistrictImage, (int) x*guiScale, (int) y*guiScale, guiScale, guiScale, null);
    	
    	repaint();
    }
    
	public void drawLines() {
    	int guiScale = GUIParameters.SCALE;
    	int guiScaleMiddle = GUIParameters.SCALE_MIDDLE;
    	Point lastPoint = null;
    	Point actualPoint = null;
    	for (ArrayList<Point> pointsArrayList : InnerCanvas.ArrayListOfPointsArrayList) {
    		// System.out.println(pointsArrayList.size());
    		for (Point point : pointsArrayList) {
    			/*
    			if (actualPoint != null) {
    				lastPoint = actualPoint;
    			}
    			*/
    			lastPoint = actualPoint;
    			actualPoint = point;
    			
    			Color c = Color.getHSBColor(0.0f, 1.0f, 1.0f);
    			
    			if ( actualPoint != null && lastPoint != null ) {
    				int i;
    				for(i=0; i<20; i++) {
    					c = Color.getHSBColor(i*0.15f, 1.0f, 1.0f);
    					this.g.setColor(c);
    					this.g.drawLine((int) lastPoint.getX() + guiScaleMiddle, (int) lastPoint.getY() + guiScaleMiddle, (int) actualPoint.getX() + guiScaleMiddle, (int) actualPoint.getY() + guiScaleMiddle);
    				}
    			}
    			// =========================
    			/*
    			if ( lastPoint == null ) {
					lastPoint = point;
				} else if ( actualPoint == null ) {
					actualPoint = point;
				} else if ( actualPoint != null && lastPoint != null ) {
				*/
					
					// lastPoint = actualPoint;
					// actualPoint = null;
				
    			
    		}
    		lastPoint = null;
        	actualPoint = null;
			
		}
    	
    	repaint();
    }
    
	// TODO - Somehow find a solution so that we DON'T have to call this method in a static way into the DistrictOptions endCreationLine() method ...
    public void buildArrayListLinesPoints() {
    	int guiScale = GUIParameters.SCALE;
    	ArrayList<Line> linesArrayList = town.getTownLines();
    	ArrayList<Point> actualPointsArrayList = null;
    	
    	// System.out.println(town.getTownLines());
    	/*
    	Point lastPoint = null;
    	Point actualPoint = null;
    	int actualLineIndex = 0;
    	int totalLineIndex = linesArrayList.size();
    	*/
    	
    	for(Line line : linesArrayList) {
    		// ArrayList<Station> stationsArrayList = line;
    		// actualLineIndex++;
    		actualPointsArrayList = new ArrayList<Point>();
    		// System.out.println("testLoop1");
			for (Station station : line.getStations()) {
				// System.out.println("testLoop2");
				// TODO - Optimize with a while loop, to avoid iterating over the WHOLE town-array while we already found ALL the stations of a line.
				for (int i = 0; i < town.getLength(); i++) {
					for (int j = 0; j < town.getLength(); j++) {
						// System.out.println("testLoop3");
						if ( town.getDistrict(j, i) != null && town.getDistrict(j, i).getStation() != null ) {
							if (town.getDistrict(j, i).getStation() != null) {
								if ( station.equals(town.getDistrict(j, i).getStation())  ) {
									actualPointsArrayList.add(new Point(j*guiScale,i*guiScale));
									
								}
								
							}
							/*
							if ( lastPoint == null ) {
								lastPoint = new Point(j*guiScale,i*guiScale);
							} else if ( lastPoint != null ) {
								actualPoint = new Point(j*guiScale,i*guiScale);
							} else if ( actualPoint != null && lastPoint != null ) {
								
								actualPoint = null;
								lastPoint = null;
							}
							*/
						}
					}
				}
			}
			
			InnerCanvas.ArrayListOfPointsArrayList.add(actualPointsArrayList);
		}
    }
    
    // TODO - Somehow find a solution so that we DON'T have to call this method in a static way into the DistrictOptions endCreationLine() method ...
    public static void createLine() {
    	ArrayList<Station> tempArrayListForLineBuilding = (ArrayList<Station>) VariableRepository.getInstance().searchByName("stationArrayListForLineBuilding");
    	
    	ArrayList<Station> copy = (ArrayList<Station>) tempArrayListForLineBuilding.clone();
    	
    	// System.out.println(tempArrayListForLineBuilding);
    	
    	if (!(DistrictOptions.canBuildLine()) && tempArrayListForLineBuilding.size() > 0 ) {
			Line newLine = new Line( copy, 20, new Date());
			
			System.out.println(newLine);
			System.out.println(town.getTownLines());
			
			// System.out.println(tempArrayListForLineBuilding);
			for(Station station : tempArrayListForLineBuilding) {
				station.addLine(newLine);
			}
			
			town.getTownLines().add(newLine);
			// System.out.println(newLine);
			// System.out.println(town.getTownLines());
			// ArrayListOfPointsArrayList.add(tempArrayListForLineBuilding);
			EventInformation.addLine(tempArrayListForLineBuilding);
			// town.payLineSegmentConstruction();
			
			// System.out.println(town.getTownLines());
			
			
			// tempArrayListForLineBuilding.clear();
			
			
			
			System.out.println("EndBuildingLine");
			// buildArrayListLinesPoints();
		}
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
		
		
	}
	
	public void showDistrictInformation(District district) {
    	if(district !=null) {
    		paramarea.changeDistrictInformation(district);
    		//System.out.println(DistrictInformation.updateGeneralInfo(district));
    	}
    }
	
	public void showGeneralInformation() {
		paramarea.changeGeneralInformation(town);
	}
	
	@Override
	public void mousePressed(MouseEvent arg0) {
		int guiScale = GUIParameters.SCALE;
    	
    	int xPos = (int) this.mousePosition.getX();
    	int yPos = (int) this.mousePosition.getY();
    	
    	xPos = (int) xPos / guiScale;
    	yPos = (int) yPos / guiScale;
		
    	showDistrictInformation(town.getDistrict(xPos, yPos));
    	
    	showGeneralInformation();
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
		this.mousePosition = arg0.getPoint();
		// System.out.println("MOUSE MOVE");
		// this.drawMouseCursor(arg0);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		showGeneralInformation();
		
	}
}