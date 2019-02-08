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
	private int length;
	private String[][] map;
	private Date time;
	
	private int fund;
	private ArrayList<District> districts;
	
	public Town (int length) {
		
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
	
	
}
