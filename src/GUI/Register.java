package GUI;

import java.awt.Button;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.TextField;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

	public class Register extends JFrame{
		TextField user,pass,repass,email,school;
		
		public Register(){
		setLayout(new GridLayout(6, 1));
		JButton submit=new JButton("Submit");
		JLabel userLabel=new JLabel("User Name:");
		JLabel passLabel=new JLabel("Password:");
		JLabel reLabel=new JLabel("Retype Password:");
		JLabel emaiLabel=new JLabel("Email:");
		JLabel schoLabel=new JLabel("University:");
		user=new TextField(10);
		pass=new TextField(10);
		pass.setEchoChar('*');
		repass=new TextField(10);
		repass.setEchoChar('*');
		email=new TextField(10);
		school=new TextField(10);
		JPanel userPanel=new JPanel();
		userPanel.add(userLabel);
		userPanel.add(user);
		
		JPanel passPanel=new JPanel();
		passPanel.add(passLabel);
		passPanel.add(pass);
		
		JPanel rePanel=new JPanel();
		rePanel.add(reLabel);
		rePanel.add(repass);
		
		JPanel emaiPanel=new JPanel();
		emaiPanel.add(emaiLabel);
		emaiPanel.add(email);
		
		JPanel schoPanel=new JPanel();
		schoPanel.add(schoLabel);
		schoPanel.add(school);
		
		JPanel buttPanel=new JPanel();
		buttPanel.add(submit);
		RegiButt regiButt = new RegiButt(this);
		submit.addActionListener(regiButt);
		
		userPanel.setLayout(new GridLayout(1, 2));
		passPanel.setLayout(new GridLayout(1, 2));
		rePanel.setLayout(new GridLayout(1, 2));
		emaiPanel.setLayout(new GridLayout(1, 2));
		schoPanel.setLayout(new GridLayout(1, 2));
		buttPanel.setLayout(new GridLayout(1, 2));
		
		add(userPanel);
		add(passPanel);
		add(rePanel);
		add(emaiPanel);
		add(schoPanel);
		add(buttPanel);
		pack();
		setBackground(Color.white);
		setLocationRelativeTo(null);
		setSize(600, 250);
		setVisible(true);
		}
	}



