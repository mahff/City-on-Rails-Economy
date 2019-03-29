package game;

import java.awt.Color;

public class Moving {
	
/*************************************************************************************************/
	
	
	/**
	 * Go to work or state district
	 * @param town
	 * @param toWork
	 */
	public void goTo(Town town, boolean toWork) {
		int townLength = town.getLength();
		
		for(int i=0 ; i<townLength ; i++){
			for(int j=0 ; j<townLength ; j++){
				District currentDistrict = town.getDistrict(i, j);
				int numberOfAngryPeople = 0;
				int numberOfHappyPeople = 0;
				
				if(currentDistrict.getColor() == Resident.residentColor) {
					int population = currentDistrict.getPopulation();
					int peopleWhoGoes = -1;
					
					if(toWork) {
						peopleWhoGoes = population;
					}
					else {
						peopleWhoGoes = (int) Math.random()%population;
					}
					
					for(int p=0 ; p<peopleWhoGoes ; p++) {
						int cycleForStation = goToNearestStation(town, i, j);
						int cycleForDistrict = -1;
						
						
						Color districtColorToGoTo;
						int random = (int) Math.random()%100+1;
						if(random <= 50) {
							districtColorToGoTo = State.stateColor;
						}
						else {
							districtColorToGoTo = Business.businessColor;
						}
						
						cycleForDistrict = goToNearestDistrictType(town, districtColorToGoTo, i, j);
						
						
						if(cycleForStation != -1) {
							if(cycleForDistrict != -1) {
								currentDistrict.removePeople(1);
								
								//Time in minutes
								int timeToGoToStation = (int) (cycleForStation*Math.random()%5+1);
								int timeToGoToDistrict = (int) (cycleForDistrict*Math.random()%10+1);
								
								int totalTime = timeToGoToStation + timeToGoToDistrict;
								
								if(totalTime > 60) {
									numberOfAngryPeople++;
								}
								else {
									numberOfHappyPeople++;
								}
							}
							else {
								numberOfAngryPeople++;
							}
						}
					}
					
					if(numberOfHappyPeople > numberOfAngryPeople) {
						town.changeDensity("moving", i, j, true);
					}
					else {
						town.changeDensity("moving", i, j, false);
					}
				}
			}
		}
	}
	
	
	/**
	 * Go back to home
	 * @param town
	 */
	public void goBackHome(Town town) {
		int townLength = town.getLength();
		
		for(int i=0 ; i<townLength ; i++){
			for(int j=0 ; j<townLength ; j++){
				District currentDistrict = town.getDistrict(i, j);
				int numberOfAngryPeople = 0;
				int numberOfHappyPeople = 0;
				
				if(currentDistrict.getColor() != Resident.residentColor) {
					int population = currentDistrict.getPopulation();
					
					for(int p=0 ; p<population ; p++) {
						int cycleForStation = goToNearestStation(town, i, j);
						int cycleForDistrict = goToNearestDistrictType(town, Resident.residentColor, i, j);
						
						if(cycleForStation != -1) {
							if(cycleForDistrict != -1) {
								currentDistrict.removePeople(1);
								
								//Time in minutes
								int timeToGoToStation = (int) (cycleForStation*Math.random()%5+1);
								int timeToGoToDistrict = (int) (cycleForDistrict*Math.random()%10+1);
								
								int totalTime = timeToGoToStation + timeToGoToDistrict;
								
								if(totalTime > 60) {
									numberOfAngryPeople++;
								}
								else {
									numberOfHappyPeople++;
								}
							}
							else {
								numberOfAngryPeople++;
							}
						}
					}
					
					if(numberOfHappyPeople > numberOfAngryPeople) {
						town.changeDensity("moving", i, j, true);
					}
					else {
						town.changeDensity("moving", i, j, false);
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
							int totalPlace = currentDistrict.getMaxPopulation();
							int currentPeopleNumber = currentDistrict.getPopulation();
							
							if(currentPeopleNumber != -1 && currentPeopleNumber <= totalPlace) {
								currentDistrict.addPerson();
								
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
		Station lastStation = myStation;
		
		if(myStation != null) {
			if(myStation.getOverload() == false) {
				myStation.addPassenger();
				return currentCircle;
			}
		}
		
		while(currentCircle <= length/2+1) {
			for(int i=positionX-currentCircle ; i<=positionX+currentCircle ; i++){
				for(int j=positionY-currentCircle ; j<=positionY+currentCircle ; j++){
					
					if(i>=0 && j>=00 && i<length && j<length) {
						District currentDistrict = town.getDistrict(i, j);
						Station currentStation = currentDistrict.getStation();
						
						if(currentStation != null) {
							if(currentStation.getOverload() == false) {
								lastStation = currentStation;
								currentStation.addPassenger();
								
								//TODO overload false quand les gens sont montes dans le metro
								currentStation.setOverload(true);
								
								return currentCircle;
							}
						}
					}
					
				}
			}
			currentCircle++;
		}
		
		lastStation.addPassenger();
		
		return currentCircle;
	}
	
}
