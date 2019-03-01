package gui;

/*
import java.util.Timer;
import java.util.TimerTask;
import core.TimerEngine;
*/

import game.Town;


public class GeneralInformation {
	//TODO clock;
	
	/*
	private JLabel clock;
    Timer timer ;
    int hours;
    int days;
	*/
	
	/*ANCIEN CONSTRUCTEUR
	public GeneralInformation(Town town) {
		clock = new JLabel(); 
		generalInfo = new JPanel();
		generalInfo.add(clock);
		timer = new Timer();
		hours =  TimerEngine.getInstance().getDaysTestValue();
		days = 0;
		start();
		
	}
	*/
	
	public static String updateGeneralInfo(Town town) {
		String content = "<html>"
				+ "<style> html{ padding-left: 30px; }</style>"
				+ "<center><u>City Statistics:</u></center><br/>";
		
		int generalPopulation = town.getGeneralPopulation();
		int generalSatisfaction = town.getGeneralSatisfaction();
		int generalNbLines = town.getGeneralNumberOfLines();
		int generalNbStations = town.getGeneralNumberOfStation();
		int funds = town.getFunds();
		
		content += "Population: "+generalPopulation+"<br/>"
				+ "Satisfaction: "+generalSatisfaction+"<br/>"
				+ "Number of lines (metro): "+generalNbLines+"<br/>"
				+ "Number of stations (metro): "+generalNbStations+"<br/>"
				+ "Money: "+funds+" MyLiu </html>";
		
		return content;
	}
	
	/*
	private void reset(){
		hours = 0; 
        days++; 
    }
    public void start(){
        reset();
        timer.scheduleAtFixedRate( new TimerTask(){
            public void run(){
                if( hours == 15 ) {
                    reset();
                }
                clock.setText( String.format("%d : %02d", days , hours ));
                clock.setForeground(purple);
                clock.setFont(font);
                hours++; 
            }
        }, 0, 1000 );
    }
	*/
}
