package game;

import java.util.ArrayList;

import core.VariableRepository;

public class Station {
	public int capacity; 
	public Boolean overload; 
	public int numberPassenger; 
	public Moving moving; 
	public ArrayList<Line> lines;
	private String name;
	
	public Station(int capacity, Boolean overload, int numberPassenger, Moving moving) {
		int numberOfStations = (int) VariableRepository.getInstance().searchByName("NumberOfStations");
		// super();
		this.capacity = capacity;
		this.overload = overload;
		this.numberPassenger = numberPassenger;
		this.moving = moving;
		this.lines = new ArrayList<Line>();
		
		this.setName("Station " + numberOfStations);
		VariableRepository.getInstance().register("NumberOfStations", numberOfStations++);
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public Boolean getOverload() {
		return overload;
	}
	public void setOverload(Boolean overload) {
		this.overload = overload;
	}
	public int getNumberPassenger() {
		return numberPassenger;
	}
	public void setNumberPassenger(int numberPassenger) {
		this.numberPassenger = numberPassenger;
	}
	public Moving getMoving() {
		return moving;
	}
	public void setMoving(Moving moving) {
		this.moving = moving;
	}
	public ArrayList<Line> getLines() {
		return lines;
	}
	public void addLines(Line line) {
		this.lines.add(line);
	} 
	
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
	
	public String toString() {
		StringBuffer toReturn = new StringBuffer();
		toReturn.append("Station Informations : \n\tCapacity : " + this.capacity + " \n\t" + "Overload state : " + this.overload + " \n\tNumber of Passengers : " + this.numberPassenger + " \n\tMoving States : " + this.moving + "\n\tLines List :" + this.lines.size() + ".\n");
		return toReturn.toString();
	}

}
