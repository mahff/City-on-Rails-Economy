package gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EditMenu extends JFrame{
	private static final long serialVersionUID = 1L;
	
	
	JMenuBar menuBar = new JMenuBar();
	JMenuItem menuItemSave, menuItemLoad, menuItemQuit;
	public JMenu menu = new JMenu(); 
	
	public EditMenu() throws HeadlessException {
		super();
	}
	
	public JMenuBar getMenu() {
		menu = new JMenu("File");
		
		menuItemSave = new JMenuItem("Save game",
                KeyEvent.VK_T);
		menu.add(menuItemSave);
		
		menuItemLoad = new JMenuItem("Load game",
                KeyEvent.VK_T);
		menu.add(menuItemLoad);
		
		menuItemQuit = new JMenuItem("Close",
                KeyEvent.VK_T);
		
		//Colors
		Color blue = new Color(0, 115, 230);
		menu.setForeground(blue);
		menuItemSave.setForeground(blue);
		menuItemLoad.setForeground(blue);
		menuItemQuit.setForeground(blue);
		
		
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
