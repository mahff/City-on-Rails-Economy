package game;

public class Business extends District{
	
	public Business(int population, int income, Station station, int satisfaction) {
		super(population, income, station, satisfaction);
		// TODO Auto-generated constructor stub
	}

	public int income;
	
	

	public int getIncome() {
		return income;
	}

	public void setIncome(int income) {
		this.income = income;
	}

}
