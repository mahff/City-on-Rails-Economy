package game;

import java.util.ArrayList;

public class Station {
	public int capacity; 
	public Boolean overload; 
	public int numberPassenger; 
	public Moving moving; 
	public ArrayList<Line> lines;
	
	
	public Station(int capacity, Boolean overload, int numberPassenger, Moving moving) {
		// super();
		this.capacity = capacity;
		this.overload = overload;
		this.numberPassenger = numberPassenger;
		this.moving = moving;
		this.lines = new ArrayList<Line>();
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
	public String toString() {
		StringBuffer toReturn = new StringBuffer();
		toReturn.append("Station Informations : \n\tCapacity : " + this.capacity + " \n\t" + "Overload state : " + this.overload + " \n\tNumber of Passengers : " + this.numberPassenger + " \n\tMoving States : " + this.moving + "\n\tLines List :" + this.lines.size() + ".\n");
		return toReturn.toString();
	}

}
