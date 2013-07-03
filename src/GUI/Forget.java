package GUI;


import java.awt.Color;
import java.awt.GridLayout;
import java.awt.TextField;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Forget extends JFrame{
	TextField user, email;

	public Forget() {
		setLayout(new GridLayout(3, 1));
		JLabel userLabel = new JLabel("User Name:");
		JLabel emaiLabel = new JLabel("Email:");
		user = new TextField(10);
		email = new TextField(10);
		JPanel userPanel = new JPanel();
		userPanel.add(userLabel);
		userPanel.add(user);
		
		JPanel emaiPanel = new JPanel();
		emaiPanel.add(emaiLabel);
		emaiPanel.add(email);
		
		JPanel buttPanel = new JPanel();
		JButton submit = new JButton("Submit");
		ForButt forButt = new ForButt(this);
		submit.addActionListener(forButt);
		buttPanel.add(submit);
		
		
		userPanel.setLayout(new GridLayout(1, 2));
		emaiPanel.setLayout(new GridLayout(1, 2));
		buttPanel.setLayout(new GridLayout(1, 1));

		
		add(userPanel);
		add(emaiPanel);
		add(buttPanel);
		pack();
		setBackground(Color.white);
		setLocationRelativeTo(null);
		setVisible(true);
		setSize(500,150);

	}

}
