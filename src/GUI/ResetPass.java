package GUI;
import java.awt.Button;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.TextField;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ResetPass extends JFrame{
	TextField newPassF,rePassF;
	public ResetPass(){

	}
	public ResetPass (String username) {
		JPanel myPanel = new JPanel();
		setLayout(new GridLayout(3,1));
		add(myPanel);
		
		JPanel passPanel = new JPanel(new GridLayout(1,2));
		JPanel repassPanel = new JPanel(new GridLayout(1,2));
		JPanel buttPanel = new JPanel(new GridLayout(1,1));
		
 		JButton submit=new JButton("Submit");
		//JLabel oldPassL=new JLabel("Old Password:");
		JLabel newPassL=new JLabel("New Password:");
		JLabel rePassL=new JLabel("Retype Password:");
		
	//	oldPassF=new TextField(10);
		newPassF = new TextField(10);
		rePassF = new TextField(10);
	//	oldPassF.setEchoChar('*');
		newPassF.setEchoChar('*');
		rePassF.setEchoChar('*');
		
	//	myPanel.add(oldPassL);
	//	myPanel.add(oldPassF);
		passPanel.add(newPassL);
		passPanel.add(newPassF);
		repassPanel.add(rePassL);
		repassPanel.add(rePassF);
		buttPanel.add(submit);
		myPanel.add(passPanel);
		myPanel.add(repassPanel);
		myPanel.add(buttPanel);

		ResetButt resetButt= new ResetButt(this,username);
		submit.addActionListener(resetButt);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		setSize(500,150);
	}

}
