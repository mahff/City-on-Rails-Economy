/**
 * 
 */
package game;

import java.util.ArrayList;
import java.util.Date;

/**
 * @author Anne-Sophie
 *
 */
public class Town {
	//TODO comms
	
	private int length;
	private String[][] map;
	private Date time;
	
	private int fund;
	private ArrayList<District> districts;
	
	
	public Town (int length) {
		this.setLength(length);
		int dim = this.getLength();
		
		map = new String[dim][dim];
		
		for(int i=0 ; i<dim ; i++){
			for(int j=0 ; j<dim ; j++){
				setMapIJ(i, j, i+","+j);
			}
		}
	}

	
	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public String[][] getMap() {
		return map;
	}

	public void setMap(String[][] map) {
		this.map = map;
	}
	
	/**
	 * @param positionX
	 * @param positionY
	 * @return the value of the grid at the given position
	 */
	public String getMapIJ(int positionX, int positionY) 
	{
		return map[positionX][positionY];
	}

	
	/**
	 * @param positionX
	 * @param positionY
	 * @param car
	 */
	public void setMapIJ(int positionX, int positionY, String car) 
	{
		this.map[positionX][positionY] = car;
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

	public ArrayList<District> getDistricts() {
		return districts;
	}

	public void setDistricts(ArrayList<District> districts) {
		this.districts = districts;
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
				System.out.print(" | " + getMapIJ(i, j));
			}
			System.out.print(" |\n");
		}
	}
}
