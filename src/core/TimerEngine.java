package core;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import gui.EventInformation;
import gui.FinalView;
import gui.MapAreaTest;

public class TimerEngine implements ActionListener{
	
	private Timer timer;
	private MapAreaTest map;
	// Amaury - Temporary variables for testing purpose
	private int days;
	private int hours;
	
	public TimerEngine (MapAreaTest mapAreaTest) {
		this.map = mapAreaTest;
		hours = 0;
		days = 0;
		this.timer = new Timer(1000, this);
		this.timer.start();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		hours++;
		System.out.println(hours);
		if ( hours == 24 ) {
			hours=0;
			days+=1;
			System.out.println(days+" jours sont passés.\n");
		}
		if(days%7==0&&hours==0) {
			map.getTown().collectBusinessTaxes();
			map.getTown().collectResidentialTaxes();
			EventInformation.collectTaxes(map.getTown());
		}
		if(map.getTown().getFunds()<=-20000) {
			new FinalView(false);
		}
	}
    public void start(){
        //...
    }

	public Timer getTimerTest() {
		return timer;
	}

	public void setTimerTest(Timer timerTest) {
		this.timer = timerTest;
	}
}
