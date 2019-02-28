package api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import core.VariableRepository;
import game.District;
import game.Line;
import game.Station;
import game.Town;

/*
 * Amaury
 * "API" that is used to avoid having variables in-betweens GUI-classes or Data-classes when interacting with the GUI.
 * Might be useful to create something more elaborated than this.
 */
public class BuildingAPI {
	private BuildingAPI instance = new BuildingAPI();
	
	public BuildingAPI getInstanceOf() {
		return this.instance;
	}
	
	public BuildingAPI() {
		
	}
	// touchhhhhhhhhhhhhhhhhhhhh
	/*
	 * Weird method to actually return the argument of this method
	 */
	public Object returnValue(Object varToReturn) {
		return varToReturn;
	}
	
	public HashMap<String, Station> getTownStations() {
		HashMap<String, Station> toReturn = new HashMap<String, Station>();
		Town townInstance = (Town) VariableRepository.getInstance().searchByName("Town");
		
		for (int i = 0; i < townInstance.getLength(); i++) {
			for (int j = 0; j < townInstance.getLength(); j++) {
				District toPut;
				toPut = townInstance.getDistrict(i, j);
				String districtCoordinates = i +"-"+ j;
				toReturn.put(districtCoordinates, toPut.station);
			}
		}
		
		return toReturn;
	};
	
	public void updateTownStations(Line lineToAdd) {
		ArrayList<Station> stations = lineToAdd.getStations();
		// With Station-class lines attribute (ArrayList) and Line-Class stations attribute (ArrayList)
		Iterator<Station> i = stations.iterator();
		
		while (i.hasNext()) {
			Station toUpdate = (Station) i.next();
			toUpdate.addLines(lineToAdd);
			// System.out.println(i.next());
		}
	};
	
	
	/*
	public HashMap<String, Station> getStationsFromGUI() {
		return null;
	}
	*/
}
