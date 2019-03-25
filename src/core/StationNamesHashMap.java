package core;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

public class StationNamesHashMap {
	public static HashMap<String, Boolean> stationsNames = new HashMap<>();
	private static StationNamesHashMap instance = new StationNamesHashMap();
	private static int id;
	
	private StationNamesHashMap() {
		id = 0;
		stationsNames.put("Trocadero", false);
		stationsNames.put("Tokiro", false);
		stationsNames.put("Metro 2033", false);
		stationsNames.put("Apero", false);
		stationsNames.put("Stillebas", false);
		stationsNames.put("Last Light", false);
		stationsNames.put("Defense de l'Arche", false);
		stationsNames.put("Katakeru", false);
		stationsNames.put("Pois-Chiche", false);
		stationsNames.put("Nord de la Gare", false);
		stationsNames.put("Hildegarde", false);
		stationsNames.put("Asgard", false);
		stationsNames.put("Acropole", false);
		stationsNames.put("Atlantide", false);
		stationsNames.put("Abydos", false);
		stationsNames.put("Troie", false);
		stationsNames.put("Thèbes", false);
		stationsNames.put("Karnak", false);
		stationsNames.put("Olympe", false);
		stationsNames.put("John Wick", false);
		stationsNames.put("Gilets Rouges", false);
		stationsNames.put("Napoléon", false);
		stationsNames.put("Exodus", false);
		stationsNames.put("Polis Massa", false);
		stationsNames.put("Heildar", false);
		stationsNames.put("Esplanade de la Def", false);
		stationsNames.put("Belvédère", false);
		stationsNames.put("Colosse de Rhodes", false);
		stationsNames.put("Rive du Styx", false);
		/*
		stationsNames.put("", false);
		*/
	}
	
	public String chooseRandomName() {
		int hashMapSize = this.stationsNames.size();
		int randomChoosedIndice = 0;
		Boolean foundName = false;
		Boolean isUsed = false;
		String name = null;
		int i = 0;
		Map.Entry<String, Boolean> pair = null;
		
		while (foundName == false) {
			
			randomChoosedIndice = (int) (Math.random()*(hashMapSize-1)) + 1;
			
			
			Iterator<Entry<String, Boolean>> it = stationsNames.entrySet().iterator();
		    while (it.hasNext() && i < randomChoosedIndice) {
		        pair = (Entry<String, Boolean>)it.next();
		        
		        name = (String) pair.getKey();
		        isUsed = (Boolean) pair.getValue();
		        it.remove(); // avoids a ConcurrentModificationException
		        i++;
		    }
		    
		    if (!it.hasNext()) {
		    	name = "Station" + String.valueOf(id);
		    	id++;
		    	foundName = true;
		    } else if (isUsed == false ) {
		    	System.out.println("name" + name);
		    	System.out.println("i " + i);
		    	pair.setValue(true);
		    	foundName = true;
		    }
		}
		
		return name;
	}
	
	public static StationNamesHashMap getInstance() {
		return instance;
	}
}
