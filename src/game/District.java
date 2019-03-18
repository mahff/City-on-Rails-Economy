package game;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import core.VariableRepository;

public class District {
	private int population; //currentPeople
	private int maxPopulation; //currentMaxPeople (en fonction de la densite)
	private int totalMaxPeople; //Max sur 1 district avec la densite max = 3 000 (static ?)
	
	private Station station;
	private int satisfaction;
	private Color color;
	private String name;
	
	
	public District(int population, int maxPopulation, int satisfaction, Color color) {
		int numberOfDistricts = (int) VariableRepository.getInstance().searchByName("NumberOfDistricts");
		
		this.setTotalMaxPeople(3000);
		
		this.setPopulation(population);
		this.setMaxPopulation(maxPopulation);
		this.setSatisfaction(satisfaction);
		this.setColor(color);
		this.setStation(null);
		
		this.setName("District " + numberOfDistricts);
		VariableRepository.getInstance().register("NumberOfDistricts", numberOfDistricts++);
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
	 * Add a person to the district (Only for Business & State)
	 */
	public void addPerson() {
		int currentPopulation = this.getPopulation();
		int maxPopulation = this.getMaxPopulation();
		if(currentPopulation < maxPopulation) {
			this.population++;
		}
	}
	/**
	 * Remove the given number of people from the district (Only for Business & State)
	 * @param number the number to remove
	 */
	public void removePeople(int number) {
		int currentPopulation = this.getPopulation();
		if(currentPopulation > 0) {
			this.population = currentPopulation-number;
		}
	}
	
	/**
	 * @return the maxPopulation
	 */
	public int getMaxPopulation() {
		return maxPopulation;
	}
	/**
	 * @param maxPopulation the maxPopulation to set
	 */
	public void setMaxPopulation(int maxPopulation) {
		this.maxPopulation = maxPopulation;
	}
	
	/**
	 * @return the totalMaxPeople
	 */
	public int getTotalMaxPeople() {
		return totalMaxPeople;
	}
	/**
	 * @param totalMaxPeople the totalMaxPeople to set
	 */
	public void setTotalMaxPeople(int totalMaxPeople) {
		this.totalMaxPeople = totalMaxPeople;
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
		return "District [station=" + station + ", satisfaction=" + satisfaction
				+ ", color=" + color + "]";
	}
	
	
/*************************************************************************************************/
	
	
	/**
	 * @return the number of lines going by the district.
	 */
	public int getNumberOfLines() {
		int numberOfLines = 0;
		if ( this.station != null ) {
			numberOfLines = this.station.getLines().size();
		}
		
		return numberOfLines;
	}
	
	
	//TODO retirer la station dans les statistiques
	/**
	 * Remove the station and the lines that cross it
	 */
	public void removeStation() {
		//supprimer les lignes
		Station station = this.getStation();
		ArrayList<Line> lines = station.getLines();
		ArrayList<Station> stationsToModify = new ArrayList<Station>();
		
		//recup toutes les station possedant la ligne (toutes les lignes)
		for(Line line : lines) {
			stationsToModify.addAll(line.getStations());
		}
		
		//supprimer les doublons
		Set<Station> set = new HashSet<>(stationsToModify);
		stationsToModify.clear();
		stationsToModify.addAll(set);
		
		//pour chaque station supprimer la ligne
		for(Station s : stationsToModify) {
			for(Line l : lines) {
				s.removeLine(l);
			}
			
		}
		
		//supprimer la station du district et donc de la carte
		this.setStation(null);
	}
	
}
