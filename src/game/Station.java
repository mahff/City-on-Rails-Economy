package game;

import java.util.ArrayList;

import core.VariableRepository;

public class Station {
	private int capacity; 
	private Boolean overload; 
	private int numberPassenger;
	private ArrayList<Line> lines;
	private String name;
	
	
	public Station(int capacity, Boolean overload, int numberPassenger) {
		int numberOfStations = (int) VariableRepository.getInstance().searchByName("NumberOfStations");
		
		this.lines = new ArrayList<Line>();
		
		this.setCapacity(capacity);
		this.setOverload(overload);
		this.setNumberPassenger(numberPassenger);
		
		this.setName("Station " + numberOfStations);
		VariableRepository.getInstance().register("NumberOfStations", numberOfStations++);
	}
	
	
	/**
	 * @return the capacity
	 */
	public int getCapacity() {
		return capacity;
	}
	/**
	 * @param capacity the capacity to set
	 */
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	/**
	 * @return the overload
	 */
	public Boolean getOverload() {
		return overload;
	}
	/**
	 * @param overload the overload to set
	 */
	public void setOverload(Boolean overload) {
		this.overload = overload;
	}

	/**
	 * @return the numberPassenger
	 */
	public int getNumberPassenger() {
		return numberPassenger;
	}
	/**
	 * @param numberPassenger the numberPassenger to set
	 */
	public void setNumberPassenger(int numberPassenger) {
		this.numberPassenger = numberPassenger;
	}

	/**
	 * @return the lines
	 */
	public ArrayList<Line> getLines() {
		return lines;
	}
	/**
	 * @param lines the lines to set
	 */
	public void setLines(ArrayList<Line> lines) {
		this.lines = lines;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		StringBuffer toReturn = new StringBuffer();
		toReturn.append("Station Informations : \n\tCapacity : " + this.capacity + " \n\t" + "Overload state : " + this.overload + " \n\tNumber of Passengers : " + this.numberPassenger + "\n\tLines List :" + this.lines.size() + ".\n");
		return toReturn.toString();
	}
	
	
/*************************************************************************************************/
	
	
	/**
	 * Add a line to the station
	 * @param line
	 */
	public void addLine(Line line) {
		this.lines.add(line);
	} 
	
	
	/**
	 * Remove a line from the station
	 * @param line
	 */
	public void removeLine(Line line) {
		for(int i=0 ; i<lines.size() ; i++) {
			if(lines.get(i).equals(line)) {
				lines.remove(i);
			}
		}
	}
	
	
	/**
	 * Add a passenger which wait at the station
	 */
	public void addPassenger() {
		int currentPassengers = this.getNumberPassenger();
		this.setNumberPassenger(currentPassengers++);
		
		int newNumber = this.getNumberPassenger();
		int capacity = this.getCapacity();
		if(newNumber >= capacity) {
			this.setOverload(true);
		}
	}
	
	
	/**
	 * Remove the given number of passengers which wait at the station
	 * @param number
	 */
	public void removePassenger(int number) {
		int currentNumber = this.numberPassenger;
		if(currentNumber-number >= 0) {
			this.numberPassenger = currentNumber-number;
		}
		
		int newNumber = this.getNumberPassenger();
		int capacity = this.getCapacity();
		if(newNumber < capacity) {
			this.setOverload(false);
		}
	}
}
