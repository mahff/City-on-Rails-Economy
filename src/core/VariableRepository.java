package core;

import java.util.HashMap;
import java.util.Map;


// Here are the keys and the values of the objects stored in this VariableRepository.
// <"BuildingActionChoice",String> => To store which kind of building we choosed in the menu. In relation with the ButtonNumber Class.
// <"NumberOfStations", Integer>
// <"NumberOfLines", Integer>
// <"NumberOfDistricts", Integer>
public class VariableRepository {
	private Map<String, Object> variables = new HashMap<String, Object>();
	private static VariableRepository instance = new VariableRepository();
	
	
	/**
	 * This class is used as a Variable Repository pattern, as well as a Singleton. The constructor actually do nothing apart from being instantiated once in the entire run of the code.
	 */
	private VariableRepository() {

	}
	
	
	/**
	 * Return the sole instance of the VariableRepository class.
	 * 
	 * @return instance
	 */
	public static VariableRepository getInstance() {
		return instance;
	}

	/**
	 * Used to store a variable inside the HashMap which contains all the variables needed. A string is used as a Key, and an object as value.
	 * You'll need to cast every value you want to use after retrieving them.
	 * 
	 * @param name The name and the key of the variable we want to store.
	 * @param initialValue The variable used as the value we want to store.
	 */
	public void register(String name, Object initialValue) {
		variables.put(name, initialValue);
	}
	
	
	/*
	public void modify(String name, Object initialValue) {
		this.variables.computeIfPresent(name, (k, v) -> initialValue);
	}
	
	public int search(Object variable) {
		return variables.get(variable.getName());
	}
	*/
	
	/**
	 * Method that is called when we want to retrieve an object/variable from the HashMap of the VariableRepository.
	 * 
	 * @param name The name, key of the object we want to retrieve.
	 * @return variables An object that was stored inside the VariableRepository by the user.
	 */
	public Object searchByName(String name) {
		return variables.get(name);
	} 
	
	/**
	 * Remove an object from the Repository when deemed necessary.
	 * 
	 * @param name The name, key of the object we want to erase.
	 */
	public void removeByName(String name) {
		variables.remove(name);
	}
	
	/**
	 * Used as a debugging tool to see the content of the HashMap of the Variable Repository.
	 */
	public void printHashMap() {
		System.out.println("test print testestestest");
		for (String name: variables.keySet()){

            String key =name.toString();
            String value = variables.get(name).toString();  
            System.out.println(key + " " + value);  
		}	 
	}
}
