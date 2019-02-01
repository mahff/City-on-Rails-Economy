package gui;

import java.awt.HeadlessException;
import java.awt.MenuBar;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class EditMenu extends JFrame{
	JMenuBar menuBar = new JMenuBar();
	JMenuItem menuItem;
	public JMenu menu = new JMenu(); 
	
	public EditMenu() throws HeadlessException {
		super();
		
	}
	
	public JMenuBar getMenu() {
		menu = new JMenu("File");
		menuItem = new JMenuItem("Save game",
                KeyEvent.VK_T);
		menu.add(menuItem);
		menuItem = new JMenuItem("Load game",
                KeyEvent.VK_T);
		menu.add(menuItem);
		menuItem = new JMenuItem("Back",
                KeyEvent.VK_T);
		menu.add(menuItem);
		menuItem = new JMenuItem("Close",
                KeyEvent.VK_T);
		menu.add(menuItem);
		menuBar.add(menu);
		return menuBar;
	}
	

	
}
