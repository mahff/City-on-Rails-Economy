package game;

public class State extends District {
	public State(int population, int income, Station station, int satisfaction) {
		super(population, income, station, satisfaction);
		// TODO Auto-generated constructor stub
	}

	public int getExpenses() {
		return expenses;
	}

	public void setExpenses(int expenses) {
		this.expenses = expenses;
	}

	public int expenses;

	
	
	
	
}
