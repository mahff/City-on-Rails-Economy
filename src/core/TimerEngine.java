package core;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class TimerEngine implements ActionListener{
	
	private static TimerEngine instance = new TimerEngine();
	private Timer timerTest;
	// Amaury - Temporary variables for testing purpose
	private int valueToTest;
	private int daysTestValue;
	
	public TimerEngine () {
		// Amaury - Temporary affectations
		this.valueToTest = 0;
		this.daysTestValue = 0;
		
		// Amaury - Temporary timer. A real one should be implemented soon.
		this.timerTest = new Timer(1000, this);
		
		this.timerTest.start();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		valueToTest++;
		System.out.println(valueToTest);
		if ( valueToTest == 15 ) {
			valueToTest=0;
			daysTestValue+=1;
			System.out.println(getDaysTestValue()+" jours sont passés.\n");
		}
	}
	
	public static TimerEngine getInstance() {
		return instance;
	}

	public Timer getTimerTest() {
		return timerTest;
	}

	public void setTimerTest(Timer timerTest) {
		this.timerTest = timerTest;
	}

	public int getValueToTest() {
		return valueToTest;
	}

	public void setValueToTest(int valueToTest) {
		this.valueToTest = valueToTest;
	}

	public int getDaysTestValue() {
		System.out.println("TEst days : " + this.daysTestValue +".\n");
		return daysTestValue;
	}

	public void setDaysTestValue(int daysTestValue) {
		this.daysTestValue = daysTestValue;
	}

	
	
}
