package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Client.Client;

public class ForButt implements ActionListener{
	Forget forget;
	public ForButt(Forget forget){
		this.forget = forget;
	}
	public ForButt(){
		super();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String user= forget.user.getText();
		String email= forget.email.getText();
		int callback;
		try {
			callback = Client.getSinlgetonInstence().getService().retrivePassword(user, email);
			if(callback==0){
				JFrame parent = new JFrame();
				JOptionPane.showMessageDialog(parent, "No username matches");
			}else if(callback==1){
				JFrame parent = new JFrame();
				JOptionPane.showMessageDialog(parent, "The email address is wrong");
			}
			else if(callback==2){
				ResetPass pass = new ResetPass(user);

			}
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	} 

	}

