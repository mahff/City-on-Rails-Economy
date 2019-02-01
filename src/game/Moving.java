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
}
