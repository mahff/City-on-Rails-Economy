package game;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import core.VariableRepository;

public class District {
	private int population;
	private Station station;
	private int satisfaction;
	private Color color;
	private String name;
	
	
	public District(int population, int satisfaction, Color color) {
		int numberOfDistricts = (int) VariableRepository.getInstance().searchByName("NumberOfDistricts");
		this.setPopulation(population);
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
	
	
	public void removeStation() {
		//TODO retirer la station dans les statistiques
		//supprimer les lignes
		Station station = this.getStation();
		ArrayList<Line> lines = station.getLines();
		ArrayList<Station> stationsToModify = new ArrayList<Station>();
		
		//récup toutes les station possédant la ligne (toutes les lignes)
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
