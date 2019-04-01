package game;

import java.util.ArrayList;
import java.util.Date;

import core.LineNamesHashMap;
import core.VariableRepository;

public class Line {
	private ArrayList<Station> stations; 
	private int intervalSubway; // time between 2 subways
	private Date departureHour; // hour the the first subway
	private String name;
	
	
	public Line(ArrayList<Station> stations, int intervalSubway, Date departureHour) {
		int numberOfLines = (int) VariableRepository.getInstance().searchByName("NumberOfLines");
		
		this.setStations(stations);
		this.setIntervalSubway(intervalSubway);
		this.setDepartureHour(departureHour);
		
		this.setName("Line " + numberOfLines);
		VariableRepository.getInstance().register("NumberOfLines", numberOfLines++);
		this.setName(LineNamesHashMap.getInstance().giveIdToLine());
	}
	
	
	/**
	 * @return the stations
	 */
	public ArrayList<Station> getStations() {
		return stations;
	}
	/**
	 * @param stations the stations to set
	 */
	public void setStations(ArrayList<Station> stations) {
		this.stations = stations;
	}

	/**
	 * @return the intervalSubway
	 */
	public int getIntervalSubway() {
		return intervalSubway;
	}
	/**
	 * @param intervalSubway the intervalSubway to set
	 */
	public void setIntervalSubway(int intervalSubway) {
		this.intervalSubway = intervalSubway;
	}

	/**
	 * @return the departureHour
	 */
	public Date getDepartureHour() {
		return departureHour;
	}
	/**
	 * @param departureHour the departureHour to set
	 */
	public void setDepartureHour(Date departureHour) {
		this.departureHour = departureHour;
	}
	
	/**
	 * @return the name of the District
	 */
	public String getName() {
		return this.name;
	}
	/**
	 * @name name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @name name to set
	 */
	public Boolean equals(Line line) {
		/*
		Collection<String> list = new ArrayList(Arrays.asList("a","b", "c", "d", "e", "f", "g"));

	    List<String> sourceList = new ArrayList<String>(list);
	    List<String> destinationList = new ArrayList<String>(list);

	    list.add("boo");
	    list.remove("b");

	    sourceList.removeAll( list );
	    list.removeAll( destinationList );


	    System.out.println( sourceList );
	    System.out.println( list );
	    */
		return null;
	}
	

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		StringBuffer toReturn = new StringBuffer();
		toReturn.append("Line Informations : \n\tStations : " + this.stations.toString() + " \n\tInterval Subway : " + this.intervalSubway + " \n\tdepartureHour : " + this.departureHour + "\n\tname"+this.name + ".\n");
		return toReturn.toString();
	}
	
}
