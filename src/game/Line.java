package game;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;

import core.VariableRepository;

public class Line {
	private ArrayList<Station> stations = new ArrayList<>(); 
	private int intervalSubway; // time between 2 subways
	private Date departureHour; // hour the the first subway
	private String name;
	
	public Line(ArrayList<Station> stations, int intervalSubway, Date departureHour) {
		int numberOfLines = (int) VariableRepository.getInstance().searchByName("NumberOfLines");
		this.stations = stations;
		this.intervalSubway = intervalSubway;
		this.departureHour = departureHour;
		
		this.setName("Line " + numberOfLines);
		VariableRepository.getInstance().register("NumberOfLines", numberOfLines++);
	}
	
	public ArrayList<Station> getStations() {
		return stations;
	}

	public void setStations(ArrayList<Station> stations) {
		this.stations = stations;
	}

	public int getIntervalSubway() {
		return intervalSubway;
	}

	public void setIntervalSubway(int intervalSubway) {
		this.intervalSubway = intervalSubway;
	}

	public Date getDepartureHour() {
		return departureHour;
	}

	public void setDepartureHour(Date departureHour) {
		this.departureHour = departureHour;
	}
	
	public String toString() {
		StringBuffer toReturn = new StringBuffer();
		toReturn.append("Line Informations : \n\tStations : " + this.stations.toString() + " \n\tInterval Subway : " + this.intervalSubway + " \n\tdepartureHour : " + this.departureHour + ".\n");
		return toReturn.toString();
	}
	// TODO Amaury - Maybe change to Boolean ? 
	// public Line buildLine(HashMap<String, Station> stationsParam) {
	/*
	public Line buildLine(HashMap<String, Station> stationsToBuildParam) {
		// TODO - Update Lines and Stations instances correctly !!!!!
		Town townInstance = (Town) VariableRepository.getInstance().searchByName("Town");
		ArrayList<Station> newLineStations = new ArrayList<Station>(); 
		
		Collection cl = stationsToBuildParam.values();
		Iterator itr = cl.iterator();
		  
		while (itr.hasNext()) {
			// System.out.println(itr.next());
			Station toPutInArrayList = (Station) itr.next();
			newLineStations.add(toPutInArrayList);
		}
		
		// TODO - 
		Line lineToCreate = new Line(newLineStations, 5, new Date());
		
		// townInstance
		
		return lineToCreate;
	}
	*/
	
	/**
	 * @name name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @return the name of the District
	 */
	public String getName() {
		return this.name;
	}
	
	public void updateStations(ArrayList<Station> stationsToBuildParam) {
		ArrayList<Station> newLineStations = stationsToBuildParam; 
		// TODO - Update Lines and Stations instances correctly !!!!!
		Iterator<Station> itr = stationsToBuildParam.iterator();
		
		while (itr.hasNext()) {
			// System.out.println(itr.next());
			Station station= (Station) itr.next();
			station.addLines(this);
		}
		
		// TODO - 
		// Line lineToCreate = new Line(newLineStations, 5, new Date());
		
		// townInstance
	}
	
	
}
