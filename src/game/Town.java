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
		funds -= getStationConstructionPrice();
	}
	
	public void payDistrictConstruction(){
		funds -= getDistrictConstructionPrice();
	}
	
	public void payLineSegmentConstruction(){
		funds -= getLineSegmentConstructionPrice();
	}
	
	public void payStationDestruction(){
		funds -= getStationDestructionPrice();
	}
	
	public void payLineSegmentDestruction(){
		funds -= getLineSegmentDestructionPrice();
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
