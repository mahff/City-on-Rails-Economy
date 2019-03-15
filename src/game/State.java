package game;

import java.awt.Color;

public class State extends District {
	public static Color stateColor = Color.YELLOW;
	private int currentVisitors;
	
	
	public State() {
		super(0, 10, stateColor);
	}


	
	/**
	 * @return the currentWorkers
	 */
	public int getCurrentVisitors() {
		return currentVisitors;
	}

	/**
	 * @param currentWorkers the currentWorkers to set
	 */
	public void setCurrentVisitors(int currentVisitors) {
		this.currentVisitors = currentVisitors;
	}
	
	
	/**
	 * Add a visitor to the state district
	 */
	public void addVisitor() {
		this.currentVisitors++;
	}
	
	
	/**
	 * Remove the given number of visitors to the state district
	 * @param number
	 */
	public void removeVisitor(int number) {
		int currentNumber = this.currentVisitors;
		if(currentNumber-number >= 0) {
			this.currentVisitors = currentNumber-number;
		}
	}
}
