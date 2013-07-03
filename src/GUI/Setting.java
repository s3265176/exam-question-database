package GUI;

import java.awt.Button;
import java.awt.GridLayout;
import java.awt.TextField;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Setting extends JFrame{
	TextField addField,SerField,portField;
	public Setting() {
		setLayout(new GridLayout(4,1));
		JPanel SerPanel = new JPanel(new GridLayout(1,2));
		JPanel addPanel = new JPanel(new GridLayout(1,2));
		JPanel portPanel = new JPanel(new GridLayout(1,2));
		JPanel buttPanel = new JPanel(new GridLayout(1,1));
		JLabel SerLabel=new JLabel("ServicesName");
		JLabel addLabel = new JLabel("ADDRESS:");
		JLabel portLabel = new JLabel("PORT:");
		SerField=new TextField("Server");
		addField=new TextField("localhost");
		portField=new TextField("2005");
		JButton applButton = new JButton("Connect");
		//JButton backButton = new JButton("BACK");
		//apply
		SetButt setButt = new SetButt(this);
		applButton.addActionListener(setButt);
		//back
		
		add(SerPanel);
		add(addPanel);
		add(portPanel);
		add(buttPanel);
		SerPanel.add(SerLabel);
		SerPanel.add(SerField);
		addPanel.add(addLabel);
		addPanel.add(addField);
		portPanel.add(portLabel);
		portPanel.add(portField);
		buttPanel.add(applButton);
	//	buttPanel.add(backButton);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		setSize(500,150);
		
	}

}

