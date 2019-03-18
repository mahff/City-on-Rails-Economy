package gui;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.*;

import game.*;

public class MapButton {
	private JPanel map;
	private JButton[][] buttonMap;
	private int size;
	private Town town;
	
	private static ArrayList<Station> stationsListForLineCreation;
	
	
	public MapButton(Town town) {
		this.town = town;
		size = town.getLength();
		
		buttonMap = new JButton[size][size];
		
		stationsListForLineCreation = new ArrayList<Station>();
		
		map = createMap();
	}
	
	
	
	public JPanel createMap() {
		map = new JPanel(new GridLayout(size, size));
		ImageIcon img = new ImageIcon("grass.png");
		
	    for (int i = 0 ; i < size ; i++) {
	    	for(int j = 0 ; j < size ; j++) {
	    		buttonMap[i][j] = new JButton(i+","+j); //TODO utile ?
	    		buttonMap[i][j].setBackground(Color.WHITE);
	    		buttonMap[i][j].setForeground(Color.WHITE);
	    		buttonMap[i][j].setBorderPainted(true);
	    		buttonMap[i][j].setIcon(img);
	    		buttonMap[i][j].setSize(64*4/3, 64*4/3);
	    		
	    		int positionX = i, positionY = j;
	    		
	    		buttonMap[i][j].addActionListener(new ActionListener() {
	    			@Override
	    			public void actionPerformed(ActionEvent arg0) {
	    				doSomething(positionX, positionY);
	    			}
	        	});
	            
	    		
	            map.add(buttonMap[i][j]); 
	    	}
	    }
	    return map;
	}
	
	
	public JButton[][] getButtonMap() {
		return buttonMap;
	}
	
	
	public void doSomething(int positionX, int positionY) {
		printDistrict(positionX, positionY);
		printStation(positionX, positionY);
		addStation(positionX, positionY);
		
		District currentDistrict = town.getDistrict(positionX, positionY);
		
		if(currentDistrict != null) {
			MapArea.paramDistrict.changeDistrictInformation(currentDistrict);
			MapArea.paramCity.changeGeneralInformation(town);
		}
		
		int end = town.endGame();
		if(end != 0) {
			boolean success;
			if(end == -1) {
				success = false;
			}
			else {
				success = true;
			}
			MapArea.closeForEndGame(success);
		}
	}
	
	
	
	public void printDistrict(int posX, int posY) {
		if(town.getDistrict(posX, posY) == null && DistrictOptions.canBuildDistrict()) {
			String choice = DistrictOptions.getSelectedType();
			
			District newDistrict = null;
			ImageIcon img = null;
			boolean isBuild = false;
			
			if(choice == "Residential") {
				newDistrict = new Resident();
				img = new ImageIcon("resident.png");
				
				isBuild = true;
			}
			else if(choice == "Business") {
				newDistrict = new Business();
				img = new ImageIcon("business.png");
				
				isBuild = true;
			}
			else if(choice == "State") {
				newDistrict = new State();
				img = new ImageIcon("state.png");
				
				town.payStateDistrictConstruction();
				
				isBuild = true;
			}
			
			if(isBuild) {
				town.setDistrict(posX, posY, newDistrict);
				buttonMap[posX][posY].setIcon(img);
				
				EventInformation.addDistrict(choice);
			}
		}
	}
	
	
	public void printStation(int posX, int posY) {
		Station newStation = new Station(30, false, 0);
		
		District currentDistrict = town.getDistrict(posX, posY);
		
		if(currentDistrict != null  && DistrictOptions.canBuildStation()) {
			Color currentDistrictColor = currentDistrict.getColor();
			Station currentDistrictStation = currentDistrict.getStation();
			ImageIcon img = null;
			boolean isBuild = false;
			
			if(currentDistrictStation == null) {
				if(currentDistrictColor == Resident.residentColor) {
					img = new ImageIcon("resident_metro.png");
					
					isBuild = true;
				}
				else if(currentDistrictColor == Business.businessColor) {
					img = new ImageIcon("business_metro.png");
					
					isBuild = true;
				}
				else if(currentDistrictColor == State.stateColor){
					img = new ImageIcon("state_metro.png");
					
					isBuild = true;
				}
				
				if(isBuild) {
					town.getDistrict(posX, posY).setStation(newStation);
					buttonMap[posX][posY].setIcon(img);
					town.payStationConstruction();
					
					EventInformation.addStation();
				}
			}
		}
	}
	
	
	public void addStation(int posX, int posY) {
		if(DistrictOptions.canBuildLine()) {
			District currentDistrict = town.getDistrict(posX, posY);
			
			if(currentDistrict != null && currentDistrict.getStation() != null) {
				Station currentDistrictStation = currentDistrict.getStation();
				
				stationsListForLineCreation.add(currentDistrictStation);
			}
		}
	}
	
	public static void printLine() {
		if(stationsListForLineCreation.size()>0) {
			Line newLine = new Line(stationsListForLineCreation, 20, new Date());
			
			for(Station station : stationsListForLineCreation) {
				station.addLine(newLine);
			}
			
			stationsListForLineCreation.clear();
			EventInformation.addLine(stationsListForLineCreation);
		}
	}
	
	
}
