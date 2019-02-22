package game;

import java.awt.Color;

import core.VariableRepository;

public class District {
	public int population;
	public Station station;
	public int satisfaction;
	private Color color;
	private String name;

	
	public District(int population, int satisfaction, Color color) {
		//int numberOfDistricts = (int) VariableRepository.getInstance().searchByName("NumberOfDistricts");
		this.setPopulation(population);
		this.setSatisfaction(satisfaction);
		this.setColor(color);
		
		//this.setName("District " + numberOfDistricts);
		//VariableRepository.getInstance().register("NumberOfDistricts", numberOfDistricts++);
	}

	/**
	 * @return the population
	 */
	public int getPopulation() {
		return population;
	}


	/**
	 * @param population the population to set
	 */
	public void setPopulation(int population) {
		this.population = population;
	}


	/**
	 * @return the station
	 */
	public Station getStation() {
		return station;
	}


	/**
	 * @param station the station to set
	 */
	public void setStation(Station station) {
		this.station = station;
	}


	/**
	 * @return the satisfaction
	 */
	public int getSatisfaction() {
		return satisfaction;
	}


	/**
	 * @param satisfaction the satisfaction to set
	 */
	public void setSatisfaction(int satisfaction) {
		this.satisfaction = satisfaction;
	}


	/**
	 * @return the color
	 */
	public Color getColor() {
		return color;
	}


	/**
	 * @param color the color to set
	 */
	public void setColor(Color color) {
		this.color = color;
	}
	
	/**
	 * @name name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @return the name of the District
	 */
	public String getName() {
		return this.name;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "District [pop=" + population + ", station=" + station + ", satisfaction=" + satisfaction
				+ ", color=" + color + "]";
	}
}
