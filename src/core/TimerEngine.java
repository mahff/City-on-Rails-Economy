package core;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class TimerEngine {
	private Timer timerTest;
	// Amaury - Temporary variables for testing purpose
	private int valueToTest;
	private int daysTestValue;
	
	public TimerEngine () {
		// Amaury - Temporary affectations
		this.valueToTest = 0;
		this.daysTestValue = 0;
		
		// Amaury - Temporary timer. A real one should be implemented soon.
		this.timerTest = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				valueToTest++;
				System.out.println(valueToTest);
				if ( valueToTest == 15 ) {
					valueToTest=0;
					daysTestValue+=1;
					System.out.println(daysTestValue+" jours sont passés.\n");
				}
			}
	    });
		
		this.timerTest.start();
	}
}
