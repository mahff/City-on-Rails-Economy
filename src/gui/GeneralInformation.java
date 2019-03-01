package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
	SimpleDateFormat sdf;
	private int currentSecond;
    private Calendar calendar;
    Timer timer ;
	
	
	public GeneralInformation(Town town) {
		summary = new JLabel();
		clock = new JLabel(); 
		summary.setBorder(new EmptyBorder(0,0,250,0));
		generalInfo = new JPanel(); 
		generalInfo.add(summary);
		generalInfo.add(clock);
		timer = new Timer();
		sdf  = new SimpleDateFormat("hh:mm");
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
		
		int testDisplay = TimerEngine.getInstance().getDaysTestValue();	//Test affichage de l'heure dans l'IHM
		// Date date = .TimerEngine();
		
		content += "Population: "+generalPopulation+"<br/>"
				+ "Satisfaction: "+generalSatisfaction+"<br/>"
				+ "Number of lines (metro): "+generalNbLines+"<br/>"
				+ "Number of stations (metro): "+generalNbStations+"<br/>"
				+ "Money: "+funds+" MyLiu </html>";
		summary.setText(content);
		
		//Style
		Color cyan = new Color(0, 179, 179);
		Font font = new Font("Tahoma", Font.BOLD, 15);
		summary.setForeground(cyan);
		summary.setFont(font);
		
		return generalInfo; 
	}
	
	private void reset(){
        calendar = Calendar.getInstance();
        currentSecond = calendar.get(Calendar.SECOND);
    }
    public void start(){
        reset();
        //int testDisplay = TimerEngine.getInstance().getDaysTestValue();	//Test affichage de l'heure dans l'IHM
        timer.scheduleAtFixedRate( new TimerTask(){
            public void run(){
                if( currentSecond == 60 ) {
                    reset();
                }
                clock.setText( String.format("%s:%02d", sdf.format(calendar.getTime()), currentSecond ));
                currentSecond++;
            }
        }, 0, 1000 );
    }
	
	private void setTown(Town town) {
		this.town = town;
	}
}
