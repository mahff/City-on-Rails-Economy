package core;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

import game.Moving;
import game.District;
import game.Station;
import game.Town;
import gui.EventInformation;
import gui.FinalView;
import gui.RailsTestAmo;

public class TimerEngine implements ActionListener{
	
	private Timer timer;
	private Town map;
	private Moving movements;
	// Amaury - Temporary variables for testing purpose
	public int days;
	public int hours;
	
	public TimerEngine (Town town) {
		this.movements = new Moving();
		this.map = town;
		hours = 0;
		days = 0;
		this.timer = new Timer(1000, this);
		this.timer.start();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		for(District[] districtLine : map.getMap()){
			for(District district : districtLine){
				if(district!=null) {
					Station station = district.getStation();
					if(station!=null) {
						if(station.getNumberPassenger()>300) station.setNumberPassenger(station.getNumberPassenger()-300);
						else station.setNumberPassenger(0);
					}
				}
			}
		}
		hours++;
		if ( hours == 6 ) {
			hours=0;
			days+=1;
			System.out.println(days+" jours sont passes.\n");
			
		}
		if(days%7==0&&hours==0) {
			map.collectBusinessTaxes();
			map.collectResidentialTaxes();
			EventInformation.collectTaxes(map);
			map.payLineMaintenance();
			map.payStationMaintenance();
			map.payStateDistrictMaintenance();
		}
		
		
		if((days%7!=0 || days%6!=0) && hours==2) {
			movements.goTo(map, true);
		}
		if((days%7!=0 || days%6!=0) && hours==4) {
			movements.goBackHome(map);
		}
		if((days%7==0 || days%6==0) && hours==3) {
			movements.goTo(map, false);
		}
		if((days%7==0 || days%6==0) && hours==4) {
			movements.goBackHome(map);
		}
		
		if(days%15 == 14) {
			System.out.print(map.getGeneralSatisfaction());
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
				+ "<center>D:  "+ days   + "  H: " + hours*4+"</html>";
	}

	public void setTimerTest(Timer timerTest) {
		this.timer = timerTest;
	}
}
