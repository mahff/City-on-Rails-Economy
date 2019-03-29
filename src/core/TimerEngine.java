package core;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import game.Town;
import gui.EventInformation;
import gui.FinalView;
import gui.RailsTestAmo;

public class TimerEngine implements ActionListener{
	
	private Timer timer;
	private Town map;
	// Amaury - Temporary variables for testing purpose
	public int days;
	public int hours;
	
	public TimerEngine (Town town) {
		this.map = town;
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
			map.collectBusinessTaxes();
			map.collectResidentialTaxes();
			EventInformation.collectTaxes(map);
			map.payLineMaintenance();
			map.payStationMaintenance();
			map.payStateDistrictMaintenance();
		}
		if(map.endGame()==-1) {
			new FinalView(false);
			VariableRepository repo = VariableRepository.getInstance();
			RailsTestAmo rta = (RailsTestAmo) repo.searchByName("mainframe");
			rta.getFrame().dispose();
			timer.stop();
		}
		else if(map.endGame()==1) {
			new FinalView(true);
			VariableRepository repo = VariableRepository.getInstance();
			RailsTestAmo rta = (RailsTestAmo) repo.searchByName("mainframe");
			rta.getFrame().dispose();
			timer.stop();
		}
	}
    public void start(){
        //...
    }

	public Timer getTimerTest() {
		return timer;
	}
	


	@Override
	public String toString() {
		return  "<html>"
				+ "<style> html{ padding-left: 100px; }</style>"
				+ "<center><u>TIME:</u> "+ days + ": " + hours*4+"</html>";
	}

	public void setTimerTest(Timer timerTest) {
		this.timer = timerTest;
	}
}
