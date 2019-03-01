package gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EditMenu extends JFrame{
	private static final long serialVersionUID = 1L;
	
	
	private JMenuBar menuBar;
	private JMenuItem menuItemSave, menuItemLoad, menuItemQuit;
	private JMenu menu;
	
	
	public EditMenu() throws HeadlessException {
		super();
	}
	
	
	public JMenuBar getMenu() {
		menu = new JMenu("File");
		menuBar = new JMenuBar();
		
		menuItemSave = new JMenuItem("Save game",
                KeyEvent.VK_T);
		menu.add(menuItemSave);
		
		menuItemLoad = new JMenuItem("Load game",
                KeyEvent.VK_T);
		menu.add(menuItemLoad);
		
		menuItemQuit = new JMenuItem("Close",
                KeyEvent.VK_T);
		
		//Colors
		Color cyan = new Color(0, 179, 179);
		Color gray = new Color(20, 20, 20);
		
		menu.setForeground(gray);
		menuItemSave.setForeground(gray);
		menuItemLoad.setForeground(gray);
		menuItemQuit.setForeground(gray);
		
		
		menu.add(menuItemQuit);
		menuBar.add(menu);
		
		// listener
		menuItemQuit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//TODO : Save avant de quitter ?
				closeFrame();
			}
    	});
		
		
		return menuBar;
	}
	

	public void closeFrame() {
    	int confirmed = JOptionPane.showConfirmDialog(null,"Are you sure you want to exit the program?", "Exit Program?",JOptionPane.YES_NO_OPTION);
	    if (confirmed == JOptionPane.YES_OPTION) {
	    		System.exit(0);
	    }
    }
}
