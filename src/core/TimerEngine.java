package core;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import gui.EventInformation;
import gui.FinalView;
import gui.MapAreaTest;
import gui.RailsTestAmo;

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
		if ( hours == 6 ) {
			hours=0;
			days+=1;
			System.out.println(days+" jours sont passés.\n");
		}
		if(days%7==0&&hours==0) {
			map.getTown().collectBusinessTaxes();
			map.getTown().collectResidentialTaxes();
			EventInformation.collectTaxes(map.getTown());
			map.getTown().payLineMaintainance();
			map.getTown().payStationMaintainance();
			map.getTown().payStateDistrictMaintainance();
		}
		if(map.getTown().getFunds()<=-20000&&hours==0) {
			new FinalView(false);
			VariableRepository repo = VariableRepository.getInstance();
			RailsTestAmo rta = (RailsTestAmo) repo.searchByName("mainframe");
			rta.getFrame().dispose();
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
