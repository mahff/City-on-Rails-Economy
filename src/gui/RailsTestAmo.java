package gui;

import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import game.Town;

public class RailsTestAmo extends JFrame implements ActionListener {

	private JFrame frame;
	private JPanel card1;
	private JPanel card2;
	private JPanel cards;
	private JButton testButton;
	private CardLayout cardsLayout;
	private JTextField txtJopokjomj;
	private EditMenu menu;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RailsTestAmo window = new RailsTestAmo();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
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
		
		testButton = new JButton("Test");
		testButton.setBounds(181, 107, 57, 25);
		testButton.addActionListener(this);
		card1.add(testButton);
		cards.add(card2, "Panel2");
		
		
		frame.add(cards);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		frame.setJMenuBar(menu.getMenu());
		cardsLayout.next(cards);
	}

}
