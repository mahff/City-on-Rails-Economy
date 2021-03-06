package gui;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import java.util.ArrayList;
import java.util.Date;

import javax.swing.JComponent;

import game.*;
import core.StationNamesHashMap;
import core.VariableRepository;

public class InnerCanvas extends JComponent implements MouseListener, MouseMotionListener {
	private static final long serialVersionUID = 1L;
	
	
	private Point mousePosition;
	ParameterArea paramarea; 
	private BufferedImage grassImage;
	private BufferedImage residentDistrictImage;
	private BufferedImage businessDistrictImage;
	private BufferedImage stateDistrictImage;
	private BufferedImage residentStationImage;
	private BufferedImage businessStationImage;
	private BufferedImage stateStationImage;
	 

	private static Town town;
	private Graphics2D g;
	
	// For alpha purpose
	public static ArrayList<ArrayList<Point>> ArrayListOfPointsArrayList;
	private static Boolean hasToRefreshLinesPoints;

	
	
	public InnerCanvas (Town town) {
		InnerCanvas.town = town;
		 
		paramarea = new ParameterArea(town); 
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		this.mousePosition = new Point(0,0);
		InnerCanvas.ArrayListOfPointsArrayList = new ArrayList<ArrayList<Point>>();

		try {
			this.grassImage = ImageIO.read(new File("grass.png"));
			this.residentDistrictImage = ImageIO.read(new File("resident.png"));
			this.businessDistrictImage = ImageIO.read(new File("business.png"));
			this.stateDistrictImage = ImageIO.read(new File("state.png"));
			this.residentStationImage = ImageIO.read(new File("resident_metro.png"));
			this.businessStationImage = ImageIO.read(new File("business_metro.png"));
			this.stateStationImage = ImageIO.read(new File("state_metro.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		VariableRepository.getInstance().register("stationArrayListForLineBuilding", new ArrayList<Station>());
		hasToRefreshLinesPoints = false;
	}
	
	public void paintComponent(Graphics g) {
        super.paintComponent(g);      
        this.g = (Graphics2D) g;
        
        try {
			paintGrass();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
        paintTown();
        drawMouseCursor();
        this.buildArrayListLinesPoints();
        showGeneralInformation();
        paramarea.changeTime(); 
        drawLines();
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
    	
    	int guiScale = GUIParameters.SCALE;
    	
    	int xPos = (int) this.mousePosition.getX();
    	int yPos = (int) this.mousePosition.getY();
    	
    	xPos = (int) xPos / guiScale;
    	yPos = (int) yPos / guiScale;
    	
    	this.g.setColor(new Color(26, 255, 26, 120));
    	this.g.fillRect(xPos*guiScale, yPos * guiScale, guiScale, guiScale);
    	repaint();
    }
    
    public void paintTown() {
    	int guiScale = GUIParameters.SCALE;
    	int x;
    	int y;
    	
		for (int i = 0; i < InnerCanvas.town.getLength(); i++) {
			for (int j = 0; j < InnerCanvas.town.getLength(); j++) {
				x = j*guiScale;
				y = i*guiScale;
				this.g.setColor(new Color(195, 203, 213));
				this.g.drawRect(x, y, guiScale, guiScale);
				// this.g.drawString("["+ String.valueOf(i)+" "+String.valueOf(j) +"]", j*guiScale+2, i*guiScale+67);
				// 
				
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
    	
    	if(town.getDistrict((int)xPosss, (int)yPosss) == null && DistrictOptions.canBuildDistrict()) {
    		
    		String choice = DistrictOptions.getSelectedType();
			
			District newDistrict = null;
			boolean isBuild = false;
			
    		if (choice == "Residential") {
    			newDistrict = new Resident();
				isBuild = true;
        	} 
    		else if (choice == "Business") {
        		newDistrict = new Business();
				isBuild = true;
        	} 
    		else if (choice == "State") {
        		newDistrict = new State();
				boolean canBuild = town.payStateDistrictConstruction();
				
				if(canBuild) {
					isBuild = true;
				}
				else {
					isBuild = false;
					EventInformation.notEnoughMoney();
				}
        	} 
    		
    		if(isBuild) {
				town.setDistrict((int)xPosss, (int)yPosss, newDistrict);

				if(choice == "Business") {
					town.changeDensity("business", (int)xPosss, (int)yPosss, true);
				}
				
				EventInformation.addDistrict(choice);
			}
    	}
    	
    	if(town.getDistrict((int)xPosss, (int)yPosss) != null) {
    		if (DistrictOptions.canBuildStation()) {
    			boolean isBuild = false;
    			
    			Station newStation = new Station(50, false, 0, StationNamesHashMap.getInstance().chooseRandomName());
    			
        		District currentDistrict = town.getDistrict((int) xPosss, (int) yPosss);
    			Station currentDistrictStation = currentDistrict.getStation();
    			
    			if(currentDistrictStation == null) {
    				isBuild = true;
    			}
    			
    			if(isBuild) {
					boolean canBuild = town.payStationConstruction();
					
					if(canBuild) {
						currentDistrict.setStation(newStation);

						town.changeDensity("station", (int)xPosss, (int)yPosss, true);
						
						EventInformation.addStation();
					}
					else {
						EventInformation.notEnoughMoney();
					}
					
				}
    		}
    		
    		ArrayList<Station> tempArrayListForLineBuilding = (ArrayList<Station>) VariableRepository.getInstance().searchByName("stationArrayListForLineBuilding");
    		
    		if(DistrictOptions.canBuildLine()) {
    			District currentDistrict = town.getDistrict((int) xPosss, (int) yPosss);
    			
    			if(currentDistrict != null && currentDistrict.getStation() != null) {
    				Station currentDistrictStation = currentDistrict.getStation();
    				
    				if ( !tempArrayListForLineBuilding.contains(currentDistrictStation) ) {
    					tempArrayListForLineBuilding.add(currentDistrictStation);
    					
        				System.out.println("BuildingLine");
    				}
    			}
    			
    		} 
    	}
    	
    	//destroy station
    	if(town.getDistrict((int)xPosss, (int)yPosss) != null && DistrictOptions.canDestroyStation()) {
    		District currentDistrict = town.getDistrict((int)xPosss, (int)yPosss);
    		Station currentDistrictStation = currentDistrict.getStation();
    		if(currentDistrictStation != null) {
    			
    			boolean canDestroy = town.payStationDestruction();
				
				if(canDestroy) {
					currentDistrict.removeStation();

					town.changeDensity("station", (int)xPosss, (int)yPosss, false);
					
					EventInformation.removeStation();
				}
				else {
					EventInformation.notEnoughMoney();
				}
				
    		}
    	}
    	
    	repaint();
    }
    
    private static float colorMultiplier=0.0f;
    
	public void drawLines() {
    	int guiScaleMiddle = GUIParameters.SCALE_MIDDLE;
    	Point lastPoint = null;
    	Point actualPoint = null;
    	
    	for (ArrayList<Point> pointsArrayList : InnerCanvas.ArrayListOfPointsArrayList) {
    		for (Point point : pointsArrayList) {
    			lastPoint = actualPoint;
    			actualPoint = point;
    			
    			Color c = Color.getHSBColor(0.0f, 1.0f, 1.0f);
    			
    			if ( actualPoint != null && lastPoint != null ) {
    					c = Color.getHSBColor(colorMultiplier, 1.0f, 1.0f);
    					this.g.setColor(c);
    					this.g.setStroke(new BasicStroke(3.0f));
    					this.g.drawLine((int) lastPoint.getX() + guiScaleMiddle, (int) lastPoint.getY() + guiScaleMiddle, (int) actualPoint.getX() + guiScaleMiddle, (int) actualPoint.getY() + guiScaleMiddle);
    				
    			}
    		}
    		lastPoint = null;
        	actualPoint = null;
		}
    }
	
    
    public void buildArrayListLinesPoints() {
    	int guiScale = GUIParameters.SCALE;
    	ArrayList<Line> linesArrayList = town.getTownLines();

    	
    	if (hasToRefreshLinesPoints == true) {
    		InnerCanvas.ArrayListOfPointsArrayList.clear();
    		for(Line line : linesArrayList) {
        		
    			ArrayList<Point> actualPointsArrayList = new ArrayList<Point>();
        		
    			for (Station station : line.getStations()) {
    				for (int i = 0; i < town.getLength(); i++) {
    					for (int j = 0; j < town.getLength(); j++) {
    						// System.out.println("testLoop3");
    						if ( town.getDistrict(j, i) != null) {
    							Station currentStation = town.getDistrict(j, i).getStation();
    							if (currentStation != null) {
    								if ( station.equals(currentStation)  ) {
    									actualPointsArrayList.add(new Point(j*guiScale,i*guiScale));
    								}
    							}
    						}
    					}
    				}
    			}
    			
    			ArrayList<Point> pointsArrayListToAdd = new ArrayList<Point>(actualPointsArrayList);
    			InnerCanvas.ArrayListOfPointsArrayList.add(pointsArrayListToAdd);
    			System.out.println(actualPointsArrayList);
    			actualPointsArrayList = null;
    			
    		}
    		hasToRefreshLinesPoints = false;
    		
    	}
    	repaint();
    }
    
    public static void createLine() {
    	@SuppressWarnings("unchecked")
		ArrayList<Station> tempArrayListForLineBuilding = (ArrayList<Station>) VariableRepository.getInstance().searchByName("stationArrayListForLineBuilding");
    	
    	@SuppressWarnings("unchecked")
    	ArrayList<Station> copy = (ArrayList<Station>) tempArrayListForLineBuilding.clone();
    	
    	if (!(DistrictOptions.canBuildLine()) && tempArrayListForLineBuilding.size() > 1 ) {
			Line newLine = new Line( copy, 20, new Date());
			
			if ( !town.getTownLines().contains(newLine) ) {
				for(Station station : tempArrayListForLineBuilding) {
					station.addLine(newLine);
				}
				
				town.getTownLines().add(newLine);
				
				EventInformation.addLine(tempArrayListForLineBuilding);
				tempArrayListForLineBuilding.clear();
				
				hasToRefreshLinesPoints = true;
			} else {
				EventInformation.lineAlreadyExist();
			}
		} else {
			tempArrayListForLineBuilding.clear();
			EventInformation.notEnoughStationsSelected();
		}
    	colorMultiplier += 0.15f;
    }
    
    @Override
	public void mouseClicked(MouseEvent arg0) {
		collisionDetection();
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		
		
	}
	
	public void showDistrictInformation(District district) {
    	if(district !=null) {
    		paramarea.changeDistrictInformation(district);
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
		
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		this.mousePosition = arg0.getPoint();
	}
}