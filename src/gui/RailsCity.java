package gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

import core.VariableRepository;
import game.Town;

public class RailsCity extends JFrame  {
	private static final long serialVersionUID = 1L;
	
	
	JFrame frame;
	private JPanel card1;
	private JPanel cards;
	private CardLayout cardsLayout;
	private EditMenu menu;
	
	private Town town;

	private JSplitPane sp, sp2;

	public static ParameterArea paramDistrict;
	public static ParameterArea paramCity;
	private InnerCanvas canvas;

	public RailsCity() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(0, 0, GUIParameters.WINDOW_WIDTH,GUIParameters.WINDOW_HEIGHT);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
        this.town = new Town(11);
        
        canvas = new InnerCanvas(this.town);
    	menu = new EditMenu();
    	paramCity = canvas.paramarea;
		paramDistrict = new ParameterArea();
		setLayout(new BorderLayout(0, 0));
		sp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, paramDistrict.summaryParamFrame(), canvas);
		sp2 = new JSplitPane(JSplitPane.VERTICAL_SPLIT, sp, EventInformation.setEnventInfo());
		
		sp.setDividerLocation(300*4/3);
		sp2.setDividerLocation(580*4/3);
		sp.setEnabled(false); 
		sp2.setEnabled(false);
		
		menu = new EditMenu();
		card1 = new JPanel();
		card1.setLayout(null);


		cardsLayout = new CardLayout();
		//Create the panel that contains the "cards".
		cards = new JPanel(cardsLayout);
		cards.add(card1, "Panel1");
		
		cards.add(sp2, "Panel2");
		
		frame.setJMenuBar(menu.getMenu());
		cardsLayout.next(cards);
		frame.add(cards);
		
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				closeFrame(); 
			}
		});
		VariableRepository repo = VariableRepository.getInstance();
		repo.register("mainframe",this);
	}
	
	public JFrame getFrame() {
		return frame;
	}
	
	public void closeFrame() {
    	int confirmed = JOptionPane.showConfirmDialog(null,"Are you sure you want to exit the program?", "Exit Program?",JOptionPane.YES_NO_OPTION);
	    if (confirmed == JOptionPane.YES_OPTION) {
	    		System.exit(0);
	    }
    }
	
	public Town getTown() {
		return town;
	}

    public Dimension getPreferredSize() {
        return new Dimension(GUIParameters.WINDOW_WIDTH,GUIParameters.WINDOW_HEIGHT);
    }

}