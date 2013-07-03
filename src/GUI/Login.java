package GUI;

import java.awt.*;
import javax.swing.*;


public class Login extends JFrame {
	TextField userField, passField;

	public Login(){
		setLayout(new GridLayout(3, 1));
		JPanel userPanel = new JPanel();
		Panel passPanel = new Panel();
		Panel buttPanel = new Panel();
		userPanel.setLayout(new GridLayout(1, 2));
		passPanel.setLayout(new GridLayout(1, 2));
		buttPanel.setLayout(new GridLayout(1, 2));
		JLabel userLabel = new JLabel("USER NAME:");
		JLabel passLabel = new JLabel("PASSWORD:");
		userField = new TextField();
		passField = new TextField();
		passField.setEchoChar('*');
		JButton regiButton = new JButton("REGISTER");
		PopToReg popToReg = new PopToReg();
		regiButton.addActionListener(popToReg);
		
		JButton forgButton = new JButton("FORGET");
		PopToForg popToForg = new PopToForg();
		forgButton.addActionListener(popToForg);
		
		JButton setButton = new JButton("SETTING");
		PopToSet popToSet = new PopToSet();
		setButton.addActionListener(popToSet);
		
		JButton loginButton = new JButton("LOGIN");
		LoginButt loginButt = new LoginButt(this);
		loginButton.addActionListener(loginButt);
		
		add(userPanel);
		add(passPanel);
		add(buttPanel);
		
		userPanel.add(userLabel);
		userPanel.add(userField);
		userPanel.add(regiButton);
		passPanel.add(passLabel);
		passPanel.add(passField);
		passPanel.add(forgButton);
		buttPanel.add(setButton);
		buttPanel.add(loginButton);
		
		setBackground(Color.white);
		pack();
		setLocationRelativeTo(null);
		setSize(600, 150);
		setVisible(true);

	}

}

