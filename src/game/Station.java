package game;

import java.util.ArrayList;

import core.VariableRepository;

public class Station {
	private int capacity; 
	private Boolean overload; 
	private int numberPassenger; 
	private Moving moving; 
	private ArrayList<Line> lines;
	private String name;
	
	
	public Station(int capacity, Boolean overload, int numberPassenger, Moving moving) {
		int numberOfStations = (int) VariableRepository.getInstance().searchByName("NumberOfStations");
		
		this.lines = new ArrayList<Line>();
		
		this.setCapacity(capacity);
		this.setOverload(overload);
		this.setNumberPassenger(numberPassenger);
		this.setMoving(moving);
		
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
	 * @return the moving
	 */
	public Moving getMoving() {
		return moving;
	}
	/**
	 * @param moving the moving to set
	 */
	public void setMoving(Moving moving) {
		this.moving = moving;
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
		toReturn.append("Station Informations : \n\tCapacity : " + this.capacity + " \n\t" + "Overload state : " + this.overload + " \n\tNumber of Passengers : " + this.numberPassenger + " \n\tMoving States : " + this.moving + "\n\tLines List :" + this.lines.size() + ".\n");
		return toReturn.toString();
	}
	
	
	
	
	public void addLine(Line line) {
		this.lines.add(line);
	} 
	
	
	public void removeLine(Line line) {
		for(int i=0 ; i<lines.size() ; i++) {
			if(lines.get(i).equals(line)) {
				lines.remove(i);
			}
		}
	}

}
