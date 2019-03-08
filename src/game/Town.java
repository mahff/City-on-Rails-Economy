/**
 * 
 */
package game;

import java.util.ArrayList;
import java.util.Date;

import core.VariableRepository;


public class Town {
	private int length;
	private District[][] map;
	private Date time;
	private int funds;
	
	
	public Town (int length) {
		VariableRepository.getInstance().register("NumberOfDistricts", 0);
		VariableRepository.getInstance().register("NumberOfLines", 0);
		VariableRepository.getInstance().register("NumberOfStations", 0);
		
		
		funds = 70000;
		this.setLength(length);
		int dim = this.getLength();
		
		map = new District[dim][dim];
		
		for(int i=0 ; i<dim ; i++){
			for(int j=0 ; j<dim ; j++){
				setDistrict(i, j, null);
			}
		}
	}

	
	/**
	 * @return the length
	 */
	public int getLength() {
		return length;
	}
	/**
	 * @param length the length to set
	 */
	public void setLength(int length) {
		this.length = length;
	}


	/**
	 * @return the map
	 */
	public District[][] getMap() {
		return map;
	}
	/**
	 * @param map the map to set
	 */
	public void setMap(District[][] map) {
		this.map = map;
	}

	/**
	 * @return the time
	 */
	public Date getTime() {
		return time;
	}
	/**
	 * @param time the time to set
	 */
	public void setTime(Date time) {
		this.time = time;
	}
	
	/**
	 * @return the funds
	 */
	public int getFunds() {
		return funds;
	}
	/**
	 * @param funds the funds to set
	 */
	public void setFunds(int funds) {
		this.funds = funds;
	}


	

	/**
	 * 
	 * @param positionX
	 * @param positionY
	 * @return the district of the map at the given position
	 */
	public District getDistrict(int positionX, int positionY) {
		return map[positionX][positionY];
	}

	/**
	 * 
	 * @param positionX
	 * @param positionY
	 * @param district
	 */
	public void setDistrict(int positionX, int positionY, District district) {
		this.map[positionX][positionY] = district;
	}
	
	
/*************************************************************************************************/
	
	/** 
	 * Print the current map 
	 * */
	public void printMap() 
	{
		System.out.println("\nMAP :\n");
		for(int i=0 ; i<this.getLength() ; i++)
		{
			for(int j=0 ; j<this.getLength() ; j++)
			{
				System.out.print(" | " + getDistrict(i, j));
			}
			System.out.print(" |\n");
		}
	}
	
	
	public int endGame() {
		if(this.getFunds()<=-20000 || (this.getGeneralSatisfaction()<=5 && this.getGeneralPopulation() > 100)) {
			//defaite
			return -1;
		}
		else if(this.getGeneralSatisfaction()>=100) {
			//victoire
			return 1;
		}
		return 0; //continuer
	}
	
	
	public void removeLine(Line line) {
		//TODO retirer la ligne dans les statistiques
		ArrayList<Station> stations = line.getStations();
		
		for(Station station : stations) {
			station.removeLine(line);
		}
	}
	
/*************************************************************************************************/
				/*City statitics*/
	
	public int getGeneralSatisfaction() {
		int generalSatisfaction = 0;
		int div = 1;
		for(int i=0 ; i<this.getLength() ; i++)
		{
			for(int j=0 ; j<this.getLength() ; j++)
			{
				District d = getDistrict(i, j);
				if(d != null) {
					System.out.println("Get satisf"); 
					generalSatisfaction += d.getSatisfaction();
					div++;
				}
			}
		}
		return generalSatisfaction/div;
	}
	
	
	public int getGeneralPopulation() {
		int generalPopulation = 0;
		for(int i=0 ; i<this.getLength() ; i++)
		{
			for(int j=0 ; j<this.getLength() ; j++)
			{
				District d = getDistrict(i, j);
				if(d != null) {
					generalPopulation += d.getPopulation();
				}
			}
		}
		return generalPopulation;
	}
	
	
	public int getGeneralNumberOfStation() {
		District[][] arrayToIterateThrough = this.getMap();
		int i = 0;
		int j = 0;
		int numberOfStations = 0;
		for (i = 0; i < this.getLength(); i++) {
			for (j = 0; j < this.getLength(); j++) {
				if ( arrayToIterateThrough[i][j] != null ) {
					if ( arrayToIterateThrough[i][j].getStation() != null ) {
						numberOfStations++;
					}
				}
			}
		}
		System.out.println("Numb of station" + numberOfStations + "\n");
		return numberOfStations;
		
	}
	
	
	public int getGeneralNumberOfLines() {
		int numberOfDistricts = (int) VariableRepository.getInstance().searchByName("NumberOfLines");
		return numberOfDistricts;
	}

/*************************************************************************************************/
				/*Funds management*/
	
	public int getStationConstructionPrice() {
		if(funds>=500000) return 100000;
		else if(funds>=250000) return 70000;
		else if(funds>=175000) return 60000;
		else return 50000;
	}
	
	
	public int getDistrictConstructionPrice() {
		if(funds>=500000) return 60000;
		else if(funds>=250000) return 40000;
		else if(funds>=175000) return 35000;
		else return 30000;
	}
	
	
	public int getLineSegmentConstructionPrice() {
		if(funds>=500000) return 40000;
		else if(funds>=250000) return 30000;
		else if(funds>=175000) return 250000;
		else return 20000;
	}
	
	
	public int getStationDestructionPrice() {
		if(funds>=500000) return 30000;
		else if(funds>=250000) return 25000;		 

		else if(funds>=175000) return 20000;
		else return 15000;
	}
	
	
	public int getLineSegmentDestructionPrice() {
		if(funds>=500000) return 10000;
		else if(funds>=250000) return 7000;
		else if(funds>=175000) return 6000;
		else return 5000;
	}
	
	
	public int getStateDistrictMaintainancePrice() {
		if(funds>=500000) return 7000;
		else if(funds>=250000) return 5000;
		else if(funds>=175000) return 4000;
		else return 3500;
	}
	
	
	public int getLineMaintainancePrice() {
		if(funds>=500000) return 2500;
		else if(funds>=250000) return 2000;
		else if(funds>=175000) return 1500;
		else return 1000;
	}
	
	
	public int getStationMaintainancePrice() {
		if(funds>=500000) return 3500;
		else if(funds>=250000) return 3000;
		else if(funds>=175000) return 2000;
		else return 1500;
	}
	
	
	
	public void payStationConstruction(){
		if(funds+20000>=getStationConstructionPrice())
			funds -= getStationConstructionPrice();
		else System.out.println("You don't have enough with "+funds); //...
	}

	
	public void payDistrictConstruction(){
		if(funds+20000>=getDistrictConstructionPrice())
			funds -= getDistrictConstructionPrice();
		else  System.out.println("You don't have enough with "+funds); //...
	}
	
	
	public void payLineSegmentConstruction(){
		if(funds+20000>=getLineSegmentConstructionPrice())
			funds -= getLineSegmentConstructionPrice();
		else System.out.println("You don't have enough with "+funds); //...
	}
	
	
	public void payStationDestruction(){
		if(funds+20000>=getStationDestructionPrice())
			funds -= getStationDestructionPrice();
		else System.out.println("You don't have enough with "+funds); //...
	}
	
	
	public void payLineSegmentDestruction(){
		if(funds+20000 >=getLineSegmentDestructionPrice())
			funds -= getLineSegmentDestructionPrice();
		else System.out.println("You don't have enough with "+funds); //...
	}
	
	
	public void payStateDistrictMaintainance(){
		funds -= getStateDistrictMaintainancePrice();
	}
	
	
	public void payLineMaintainance(){
		funds -= getLineMaintainancePrice();
	}
	
	
	public void payStationMaintainance(){
		funds -= getStationMaintainancePrice();
	}
	
	
	public void collectResidentialTaxes(){
		 int amount = 0;
		 for(District districts[] : map) {
			 for(District district : districts){
				 if(district.getClass().getName()=="Resident") {
					 int currentAmount = 140*district.getPopulation();
					 if(district.getSatisfaction()<=10) currentAmount *= 0.95;
					 else if(district.getSatisfaction()<=5) currentAmount *= 0.7;
					 else if(district.getSatisfaction()<=3) currentAmount *= 0.6;
					 amount += currentAmount;
				 }
			 }
		 }
		 funds += amount;
		 //...
	}
	
	
	public void collectBusinessTaxes(){
		int amount = 0;
		 for(District districts[] : map) {
			 for(District district : districts){
				 if(district.getClass().getName()=="Business") {
					 int currentAmount = 140*district.getPopulation();
					 if(district.getSatisfaction()<=10) currentAmount *= 0.95;
					 else if(district.getSatisfaction()<=5) currentAmount *= 0.7;
					 else if(district.getSatisfaction()<=3) currentAmount *= 0.6;
					 amount += currentAmount;
				 }
			 }
		 }
		 funds += amount;
		 //...
	}
	
/*************************************************************************************************/
	
	
}
