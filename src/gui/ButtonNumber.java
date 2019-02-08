package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import core.VariableRepository;

public class ButtonNumber implements ActionListener{
    public int buttonX;
    public int buttonY;
    public String type; 
    Map updateMap = new Map(); 
    
    public ButtonNumber(int x, int y, String type){
    	this.buttonX = x;
    	this.buttonY = y;
    	this.type = type; 
    }
    
    // Amaury - Seems that the content of this method is never called in "Map".
    public void actionPerformed(ActionEvent e){
    	// les actions concernant les boutons de la carte se feront ici
        System.out.println("Clicked on the button "+getButtonX()+" : "+getButtonY());
        
        // Amaury - 
        // Original line of code
        //updateMap.updateButton("resident", getButtonX(), getButtonY()); 
        
        // Newly-implemented line of code
        String parameter = (String) VariableRepository.getInstance().searchByName("BuildingActionChoice");
        updateMap.updateButton(getButtonX(), getButtonY());
    }
	public int getButtonX() {
		return buttonX;
	}
	public void setButtonX(int buttonX) {
		this.buttonX = buttonX;
	}
	public int getButtonY() {
		return buttonY;
	}
	public void setButtonY(int buttonY) {
		this.buttonY = buttonY;
	}
    
    
}
