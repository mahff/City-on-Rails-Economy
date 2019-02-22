package gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.*;

public class FinalView { //TODO: bouton OK redirection vers Menu
	JFrame frame;
	JLabel lblSuccess;
	JLabel lblInfo;
	JButton btnOk;
	
	public FinalView(boolean success) {
		frame = new JFrame();
		lblSuccess = new JLabel();
		lblInfo = new JLabel();
		btnOk = new JButton("OK");
		
		if(success) {
			lblSuccess.setText("Congratulations!");
			lblInfo.setText("You won the game!");
		}
		else {
			lblSuccess.setText("End of game!");
			lblInfo.setText("You lose the game!");
		}
		
		
		lblSuccess.setBounds(216, 42, 137, 16);
		lblInfo.setBounds(165, 71, 188, 16);
		btnOk.setBounds(165, 169, 97, 25);
		
		//Style
        Color blue = new Color(0, 115, 230);
        Color cyan = new Color(0, 179, 179);
		
		
		frame.getContentPane().add(lblSuccess);		
		frame.getContentPane().add(lblInfo);
		frame.getContentPane().add(btnOk);
		
		
		frame.getContentPane().setLayout(null);
        frame.setSize(594, 242);
        frame.setTitle("RailCity - End");
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //TODO : do nothing + confirm dialog
        frame.setVisible(true);
        frame.setResizable(false);
	}
	
	
	public static void main(String[] args) {
    	FinalView test = new FinalView(true);
    }
}
