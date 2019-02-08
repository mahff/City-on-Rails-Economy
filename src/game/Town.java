/**
 * 
 */
package game;

import java.util.Date;

/**
 * @author Anne-Sophie
 *
 */
public class Town {
	private int length;
	private District[][] map;
	
	private Date time;
	private int funds;
	
	
	public Town (int length) {
		this.setLength(length);
		int dim = this.getLength();
		
		map = new District[dim][dim];
		
		for(int i=0 ; i<dim ; i++){
			for(int j=0 ; j<dim ; j++){
				setDistrict(i, j, null);
			}
		}
	}

	
	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public District[][] getMap() {
		return map;
	}

	public void setMap(District[][] map) {
		this.map = map;
	}
	
	/**
	 * @param positionX
	 * @param positionY
	 * @return the value of the grid at the given position
	 */
	public District getDistrict(int positionX, int positionY) 
	{
		return map[positionX][positionY];
	}

	
	public void setDistrict(int positionX, int positionY, District district) 
	{
		this.map[positionX][positionY] = district;
	}
	

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public int getFunds() {
		return funds;
	}
	
	
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
		if(this.getFunds()<=-20000 || this.getGeneralSatisfaction()<=5) {
			//defaite
			return -1;
		}
		else if(this.getGeneralSatisfaction()>=100) {
			//victoire
			return 1;
		}
		return 0; //continuer
	}
	
	public int getGeneralSatisfaction() {
		int generalSatisfaction = 0;
		for(int i=0 ; i<this.getLength() ; i++)
		{
			for(int j=0 ; j<this.getLength() ; j++)
			{
				District d = getDistrict(i, j);
				generalSatisfaction += d.getSatisfaction();
			}
		}
		return generalSatisfaction;
	}
	
	public int getGeneralPopulation() {
		int generalPopulation = 0;
		for(int i=0 ; i<this.getLength() ; i++)
		{
			for(int j=0 ; j<this.getLength() ; j++)
			{
				District d = getDistrict(i, j);
				generalPopulation += d.getPopulation();
			}
		}
		return generalPopulation;
	}
	
	//-------------------------------------------------------
	
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
		if(funds>=getStationConstructionPrice())
			funds -= getStationConstructionPrice();
		else; //...
	}
	
	public void payDistrictConstruction(){
		if(funds>=getDistrictConstructionPrice())
			funds -= getDistrictConstructionPrice();
		else; //...
	}
	
	public void payLineSegmentConstruction(){
		if(funds>=getLineSegmentConstructionPrice())
			funds -= getLineSegmentConstructionPrice();
		else; //...
	}
	
	public void payStationDestruction(){
		if(funds>=getStationDestructionPrice())
			funds -= getStationDestructionPrice();
		else; //...
	}
	
	public void payLineSegmentDestruction(){
		if(funds>=getLineSegmentDestructionPrice())
			funds -= getLineSegmentDestructionPrice();
		else; //...
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
		 
	}
	
	public void collectBusinessTaxes(){
		
	}
	
}
