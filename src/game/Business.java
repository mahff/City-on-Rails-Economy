package game;

import java.awt.Color;

public class Business extends District{
	public static Color businessColor = Color.BLUE;
	private int currentWorkers;
	
	
	public Business() {
		super(0, 10, businessColor);
		currentWorkers=0;
	}


	
	/**
	 * @return the currentWorkers
	 */
	public int getCurrentWorkers() {
		return currentWorkers;
	}

	/**
	 * @param currentWorkers the currentWorkers to set
	 */
	public void setCurrentWorkers(int currentWorkers) {
		this.currentWorkers = currentWorkers;
	}
	
	
	/**
	 * Add a worker to the business district
	 */
	public void addWorker() {
		this.currentWorkers++;
	}
	
	
	/**
	 * Remove the given number of workers to the business district
	 * @param number
	 */
	public void removeWorker(int number) {
		int currentNumber = this.currentWorkers;
		if(currentNumber-number >= 0) {
			this.currentWorkers = currentNumber-number;
		}
	}
}
