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
	
	public void payStationConstruction(){
		funds -= getStationConstructionPrice();
	}
	
	public void payDistrictConstruction(){
		funds -= getDistrictConstructionPrice();
	}
	
	public void payLineSegmentConstruction(){
		funds -= getLineSegmentConstructionPrice();
	}
	
	public void payStationDestruction(){
		int amount;
		if(funds>=500000) amount = 30000;
		else if(funds>=250000) amount = 25000;
		else if(funds>=175000) amount = 20000;
		else amount = 15000;
		funds -= amount;
	}
	
	public void payLineSegmentDestruction(){
		int amount;
		if(funds>=500000) amount = 10000;
		else if(funds>=250000) amount = 7000;
		else if(funds>=175000) amount = 6000;
		else amount = 5000;
		funds -= amount;
	}
	
	public void payStateDistrictMaintainance(){
		int amount;
		if(funds>=500000) amount = 7000;
		else if(funds>=250000) amount = 5000;
		else if(funds>=175000) amount = 4000;
		else amount = 3500;
		funds -= amount;
	}
	
	public void payLineMaintainance(){
		int amount;
		if(funds>=500000) amount = 2500;
		else if(funds>=250000) amount = 2000;
		else if(funds>=175000) amount = 1500;
		else amount = 1000;
		funds -= amount;
	}
	
	public void payStationMaintainance(){
		int amount;
		if(funds>=500000) amount = 3500;
		else if(funds>=250000) amount = 3000;
		else if(funds>=175000) amount = 2000;
		else amount = 1500;
		funds -= amount;
	}
	
	public void collectResidentialTaxes(){
		
	}
	
	public void collectBusinessTaxes(){
		
	}
	
}
