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
	private int fund;
	
	
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

	public int getFund() {
		return fund;
	}

	public void setFund(int fund) {
		this.fund = fund;
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
}
