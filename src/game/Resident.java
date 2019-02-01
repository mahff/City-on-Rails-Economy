package game;

public class Resident extends District{
	
	public Resident(int population, int income, Station station, int satisfaction) {
		super(population, income, station, satisfaction);
	}

	public int income;

	

	public int getIncome() {
		return income;
	}

	public void setIncome(int income) {
		this.income = income;
	} 
}
