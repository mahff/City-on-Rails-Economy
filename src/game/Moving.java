package game;

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

	public int getWeekendMovingRate() {
		return weekendMovingRate;
	}

	public void setWeekendMovingRate(int weekendMovingRate) {
		this.weekendMovingRate = weekendMovingRate;
	}

	public Date getWorkStartHour() {
		return workStartHour;
	}

	public void setWorkStartHour(Date workStartHour) {
		this.workStartHour = workStartHour;
	}

	public Date getWorkEndHour() {
		return workEndHour;
	}

	public void setWorkEndHour(Date workEndHour) {
		this.workEndHour = workEndHour;
	}
	
	
	
	/************************************************************************/
	
	public void goToWork(Town town) {
		int townLength = town.getLength();
		
		for(int i=0 ; i<townLength ; i++){
			for(int j=0 ; j<townLength ; j++){
				District currentDistrict = town.getDistrict(i, j);
				
				if(currentDistrict.getColor() == Resident.residentColor) {
					int cycleForStation = goToNearestStation(town, i, j);
					int cycleForBusiness = workToNearestBusinessDistrict(town, i, j);
					
					if(cycleForStation != -1) {
						if(cycleForBusiness != -1) {
							
							//Time in minutes
							int timeToGoToStation = (int) (cycleForStation*Math.random()%5+1);
							int timeToGoBusiness = (int) (cycleForBusiness*Math.random()%10+1);
							
							int totalTime = timeToGoToStation + timeToGoBusiness;
							
							if(totalTime > 60) {
								Station currentStation = currentDistrict.getStation();
								currentStation.removePassenger(1);
								((Business) currentDistrict).removeWorker(1);
							}
						}
					}
				}
				
			}
		}
	}
	
	
	public int workToNearestBusinessDistrict(Town town, int positionX, int positionY) {
		int currentCircle = 1;
		int length = town.getLength();
		
		while(currentCircle<length/2+1) {
			for(int i=positionX-currentCircle ; i<=positionX+currentCircle ; i++){
				for(int j=positionY-currentCircle ; j<=positionY+currentCircle ; j++){
					
					if(i>=0 && j>=00 && i<length && j<length) {
						District currentDistrict = town.getDistrict(i, j);
						
						if(currentDistrict.getColor() == Business.businessColor) {
							int totalWork = currentDistrict.getPopulation();
							int currentWorkers = ((Business) currentDistrict).getCurrentWorkers();
							
							if(currentWorkers <= totalWork) {
								((Business) currentDistrict).addWorker();
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
	
	
	//TODO gérer avec les lignes :'(
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
