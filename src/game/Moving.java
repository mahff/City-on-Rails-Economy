package game;

import java.awt.Color;
import java.util.Date;

public class Moving {
	private int weekendMovingRate;
	private Date workStartHour;
	private Date workEndHour;
	
	
	public Moving(int weekendMovingRate, Date workStartHour, Date workEndHour) {
		this.weekendMovingRate = weekendMovingRate;
		this.workStartHour = workStartHour;
		this.workEndHour = workEndHour;
	}

	
	/**
	 * @return the weekendMovingRate
	 */
	public int getWeekendMovingRate() {
		return weekendMovingRate;
	}
	/**
	 * @param weekendMovingRate the weekendMovingRate to set
	 */
	public void setWeekendMovingRate(int weekendMovingRate) {
		this.weekendMovingRate = weekendMovingRate;
	}

	/**
	 * @return the workStartHour
	 */
	public Date getWorkStartHour() {
		return workStartHour;
	}
	/**
	 * @param workStartHour the workStartHour to set
	 */
	public void setWorkStartHour(Date workStartHour) {
		this.workStartHour = workStartHour;
	}

	/**
	 * @return the workEndHour
	 */
	public Date getWorkEndHour() {
		return workEndHour;
	}
	/**
	 * @param workEndHour the workEndHour to set
	 */
	public void setWorkEndHour(Date workEndHour) {
		this.workEndHour = workEndHour;
	}

	
/*************************************************************************************************/
	
	
	/**
	 * Go to work or to state district, calculate time and choose to go or not
	 * @param town
	 * @param districtColorToGoTo
	 */
	public void goTo(Town town, Color districtColorToGoTo) {
		int townLength = town.getLength();
		
		for(int i=0 ; i<townLength ; i++){
			for(int j=0 ; j<townLength ; j++){
				District currentDistrict = town.getDistrict(i, j);
				
				if(currentDistrict.getColor() == Resident.residentColor) {
					int population = currentDistrict.getPopulation();
					int peopleWhoGoes = -1;
					
					if(districtColorToGoTo == Business.businessColor) {
						peopleWhoGoes = population;
					}
					else if(districtColorToGoTo == State.stateColor) {
						peopleWhoGoes = (int) (Math.random()%population);
					}
					
					
					for(int p=0 ; p<peopleWhoGoes ; p++) {
						int cycleForStation = goToNearestStation(town, i, j);
						int cycleForDistrict = -1;
						
						if(districtColorToGoTo == Business.businessColor) {
							cycleForDistrict = goToNearestDistrictType(town, Business.businessColor, i, j);
						}
						else if(districtColorToGoTo == State.stateColor) {
							cycleForDistrict = goToNearestDistrictType(town, State.stateColor, i, j);
						}
						
						
						if(cycleForStation != -1) {
							if(cycleForDistrict != -1) {
								
								//Time in minutes
								int timeToGoToStation = (int) (cycleForStation*Math.random()%5+1);
								int timeToGoToDistrict = (int) (cycleForDistrict*Math.random()%10+1);
								
								int totalTime = timeToGoToStation + timeToGoToDistrict;
								
								if(totalTime > 60) {
									Station currentStation = currentDistrict.getStation();
									currentStation.removePassenger(1);
									
									if(districtColorToGoTo == Business.businessColor) {
										((Business) currentDistrict).removeWorker(1);
									}
									else if(districtColorToGoTo == State.stateColor) {
										((State) currentDistrict).removeVisitor(1);
									}
								}
							}
						}
					}
				}
				
			}
		}
	}
	
	
	/**
	 * Go to the nearest district that corresponds to the given district type, from the given position
	 * @param town
	 * @param districtColor
	 * @param positionX
	 * @param positionY
	 * @return currentCircle or -1
	 */
	public int goToNearestDistrictType(Town town, Color districtColor, int positionX, int positionY) {
		int currentCircle = 1;
		int length = town.getLength();
		
		while(currentCircle<length/2+1) {
			for(int i=positionX-currentCircle ; i<=positionX+currentCircle ; i++){
				for(int j=positionY-currentCircle ; j<=positionY+currentCircle ; j++){
					
					if(i>=0 && j>=00 && i<length && j<length) {
						District currentDistrict = town.getDistrict(i, j);
						
						if(currentDistrict.getColor() == districtColor) {
							int totalPlace = currentDistrict.getPopulation();
							int currentPeopleNumber = -1;
							
							if(districtColor == Business.businessColor) {
								currentPeopleNumber = ((Business) currentDistrict).getCurrentWorkers();
							}
							else if(districtColor == State.stateColor) {
								currentPeopleNumber = ((State) currentDistrict).getCurrentVisitors();
							}
							
							if(currentPeopleNumber != -1 && currentPeopleNumber <= totalPlace) {
								if(districtColor == Business.businessColor) {
									((Business) currentDistrict).addWorker();
								}
								else if(districtColor == State.stateColor) {
									((State) currentDistrict).addVisitor();
								}
								
								return currentCircle;
							}
						}
					}
					
				}
			}
			currentCircle++;
		}
		
		return -1;
	}
	
	
	//TODO gerer avec les lignes :'(
	/**
	 * Go to the nearest station from the given position
	 * @param town
	 * @param positionX
	 * @param positionY
	 * @return currentCircle or -1
	 */
	public int goToNearestStation(Town town, int positionX, int positionY) {
		int currentCircle = 1;
		int length = town.getLength();
		
		District myDistrict = town.getDistrict(positionX, positionY);
		Station myStation = myDistrict.getStation();
		
		if(myStation != null) {
			if(myStation.getOverload() == false) {
				myStation.addPassenger();
				return currentCircle;
			}
		}
		
		while(currentCircle<length/2+1) {
			for(int i=positionX-currentCircle ; i<=positionX+currentCircle ; i++){
				for(int j=positionY-currentCircle ; j<=positionY+currentCircle ; j++){
					
					if(i>=0 && j>=00 && i<length && j<length) {
						District currentDistrict = town.getDistrict(i, j);
						Station currentStation = currentDistrict.getStation();
						
						if(currentStation != null) {
							if(currentStation.getOverload() == false) {
								currentStation.addPassenger();
								return currentCircle;
							}
						}
					}
					
				}
			}
			currentCircle++;
		}
		
		return -1;
	}
	
}
