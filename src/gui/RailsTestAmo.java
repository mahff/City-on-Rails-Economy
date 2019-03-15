package gui;

import java.awt.CardLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class RailsTestAmo extends JFrame  {

	JFrame frame;
	private JPanel card1;
	private JPanel card2;
	private JPanel cards;
	private CardLayout cardsLayout;
	private EditMenu menu;
	

	public RailsTestAmo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(0, 0, GUIParameters.WINDOW_WIDTH,GUIParameters.WINDOW_HEIGHT);
		frame.setResizable(false);
		// frame.setBounds(100, 100, 1900,1080);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// frame.setSize(900*4/3,750*4/3);
		/*
		frame.setResizable(false);
		// frame.add(sp2);
		
		// frame.setJMenuBar(menu.getMenu());
		frame.setLocationRelativeTo(null);
		*/
		
		menu = new EditMenu();
		card1 = new JPanel();
		card1.setLayout(null);
		card2 = new MapAreaTest();

		cardsLayout = new CardLayout();
		//Create the panel that contains the "cards".
		cards = new JPanel(cardsLayout);
		cards.add(card1, "Panel1");
		
		cards.add(card2, "Panel2");
		
		frame.setJMenuBar(menu.getMenu());
		cardsLayout.next(cards);
		frame.add(cards);
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				closeFrame(); 
			}
		});
	}
	public void closeFrame() {
		int confirmed = JOptionPane.showConfirmDialog(null,"Are you sure you want to exit the program?", "Exit Program?",JOptionPane.YES_NO_OPTION);
	    if (confirmed == JOptionPane.YES_OPTION) {
	    		System.exit(0);
	    }
	}
	

}