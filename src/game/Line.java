package game;

import java.util.ArrayList;
import java.util.Date;

public class Line {
	private ArrayList<Station> stations = new ArrayList<>(); 
	private int intervalSubway; // time between 2 subways
	private Date departureHour; // hour the the first subway
	
	public Line(ArrayList<Station> stations, int intervalSubway, Date departureHour) {
		super();
		this.stations = stations;
		this.intervalSubway = intervalSubway;
		this.departureHour = departureHour;
	}
	
	public ArrayList<Station> getStations() {
		return stations;
	}

	public void setStations(ArrayList<Station> stations) {
		this.stations = stations;
	}

	public int getIntervalSubway() {
		return intervalSubway;
	}

	public void setIntervalSubway(int intervalSubway) {
		this.intervalSubway = intervalSubway;
	}

	public Date getDepartureHour() {
		return departureHour;
	}

	public void setDepartureHour(Date departureHour) {
		this.departureHour = departureHour;
	}
	
}
