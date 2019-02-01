package game;

import java.util.ArrayList;

public class Station {
	public int capacity; 
	public Boolean overload; 
	public int numberPassenger; 
	public Moving moving; 
	public ArrayList<Line> lines = new ArrayList<>();
	
	
	public Station(int capacity, Boolean overload, int numberPassenger, Moving moving, ArrayList<Line> lines) {
		super();
		this.capacity = capacity;
		this.overload = overload;
		this.numberPassenger = numberPassenger;
		this.moving = moving;
		this.lines = lines;
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
	public void setLines(ArrayList<Line> lines) {
		this.lines = lines;
	} 
	

}
