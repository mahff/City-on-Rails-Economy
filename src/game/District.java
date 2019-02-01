package game;

public class District {
	public int population; 
	public int income; 
	public Station station;
	public int satisfaction;
	public District(int population, int income, Station station, int satisfaction) {
		super();
		this.population = population;
		this.income = income;
		this.station = station;
		this.satisfaction = satisfaction;
	}
	public int getPopulation() {
		return population;
	}
	public void setPopulation(int population) {
		this.population = population;
	}
	public int getIncome() {
		return income;
	}
	public void setIncome(int income) {
		this.income = income;
	}
	public Station getStation() {
		return station;
	}
	public void setStation(Station station) {
		this.station = station;
	}
	public int getSatisfaction() {
		return satisfaction;
	}
	public void setSatisfaction(int satisfaction) {
		this.satisfaction = satisfaction;
	} 
	
	
	

}
