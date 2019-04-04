package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

public class FinalView {
	private JFrame frame;
	private JLabel lblSuccess;
	private JLabel lblInfo;
	private JButton btnOk;
	
	
	public FinalView(boolean success) {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		
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
		
		
		lblSuccess.setBounds(120, 22, 188, 16);
		lblInfo.setBounds(120, 63, 188, 16);
		btnOk.setBounds(181, 115, 67, 25);
		
		//Style
        Color blue = new Color(0, 115, 230);
        Color purple = new Color(51, 102, 204);
        Font font = new Font("Tahoma", Font.BOLD, 12);
        
        btnOk.setForeground(Color.WHITE);
        lblSuccess.setForeground(purple);
        lblInfo.setForeground(purple);
        
        btnOk.setBackground(blue);
        
        lblSuccess.setFont(font);
        lblInfo.setFont(font);
        
        lblSuccess.setHorizontalAlignment(SwingConstants.CENTER);
        lblInfo.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		frame.getContentPane().add(lblSuccess);		
		frame.getContentPane().add(lblInfo);
		frame.getContentPane().add(btnOk);
		
		
		frame.getContentPane().setLayout(null);
        frame.setSize(442, 180);
        frame.setTitle("RailCity - End");
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);
        
        
        //Listener
        btnOk.addActionListener(new ActionListener() {
    	    public void actionPerformed(ActionEvent e) {
    	    	frame.dispose();
    	    	new FirstView().initializeMap();
    	    }
    	});
        
        frame.addWindowListener(new WindowAdapter() {
			  public void windowClosing(WindowEvent e) {
				  System.exit(0);
			  }
		});
	}
}
