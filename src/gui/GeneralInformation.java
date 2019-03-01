package gui;

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import core.TimerEngine;
import game.Town;

public class GeneralInformation {
	private JLabel summary;
	private JLabel clock; 
	private JPanel generalInfo; 
	private Town town;
	Color cyan;
	Font font;

    Timer timer ;
    int hours;
    int days;
	
	
	public GeneralInformation(Town town) {
		summary = new JLabel();
		clock = new JLabel(); 
		summary.setBorder(new EmptyBorder(0,0,250,0));
		generalInfo = new JPanel(); 
		generalInfo.add(summary);
		generalInfo.add(clock);
		cyan = new Color(0, 179, 179);
		font = new Font("Tahoma", Font.BOLD, 15);
		timer = new Timer();
		hours =  TimerEngine.getInstance().getDaysTestValue();
		setTown(town);
		start();
	}

	
	public Component updateGeneralInfo() {
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
		summary.setText(content);
		
		summary.setForeground(cyan);
		summary.setFont(font);
		
		return generalInfo; 
	}
	
	private void reset(){
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
                clock.setForeground(cyan);
                clock.setFont(font);
                hours++; 
            }
        }, 0, 1000 );
    }
	
	private void setTown(Town town) {
		this.town = town;
	}
}
