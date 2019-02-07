package api;

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
}
