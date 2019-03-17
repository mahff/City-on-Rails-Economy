package core;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class TimerEngine implements ActionListener{
	
	private static TimerEngine instance = new TimerEngine();
	private Timer timer;
	// Amaury - Temporary variables for testing purpose
	private int days;
	private int hours;
	
	public TimerEngine () {
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
	}
    public void start(){
        //...
    }
	
	public static TimerEngine getInstance() {
		return instance;
	}

	public Timer getTimerTest() {
		return timer;
	}

	public void setTimerTest(Timer timerTest) {
		this.timer = timerTest;
	}
}
